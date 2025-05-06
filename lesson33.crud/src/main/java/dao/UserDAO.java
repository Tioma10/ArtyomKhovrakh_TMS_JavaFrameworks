package dao;


import model.User;
import java.sql.*;
import java.util.Optional;

public class UserDAO {
    private final String url = "jdbc:postgresql://localhost:5432/userdb";
    private final String user = "postgres";
    private final String password = "asu97ler";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL Driver not found", e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    public Optional<User> getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? Optional.of(new User(rs.getInt("id"), rs.getString("login"))) : Optional.empty();
        }
    }

    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (login) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getLogin());
            ps.executeUpdate();
        }
    }

    public void changeLogin(int id, String login) throws SQLException {
        String sql = "UPDATE users SET login = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}