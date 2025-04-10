public class SingleResponsibilityPrinciple {

    public class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public class UserPrinter {
        public void printUser(User user) {
            System.out.println("User: " + user.getName());
        }
    }
}
