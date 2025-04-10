public class LiskovSubstitutionPrinciple {
    public class Bird {
        public void fly() {
            System.out.println("Bird is flying");
        }
    }

    public class Sparrow extends Bird {
        @Override
        public void fly() {
            System.out.println("Sparrow is flying");
        }
    }
}
