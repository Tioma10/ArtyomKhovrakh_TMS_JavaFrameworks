public class OpenClosePrinciple {
    public interface Greeter {
        void greet();
    }


    public class EnglishGreeter implements Greeter {
        public void greet() {
            System.out.println("Hello!");
        }
    }


    public class SpanishGreeter implements Greeter {
        public void greet() {
            System.out.println("¡Hola!");
        }
    }
}
