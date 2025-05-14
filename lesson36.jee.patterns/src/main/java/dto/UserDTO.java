package dto;

public class UserDTO {
    private String name;
    private String email;
    private int age;

    public UserDTO() {}

    public UserDTO(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}