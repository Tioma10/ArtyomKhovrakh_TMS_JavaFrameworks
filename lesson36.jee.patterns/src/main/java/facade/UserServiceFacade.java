package facade;

public class UserServiceFacade {
    public User getUserInfo(String username) {
        if ("admin".equalsIgnoreCase(username)) {
            return new User("Administrator", 42);
        } else {
            return new User("Guest", 0);
        }
    }
}