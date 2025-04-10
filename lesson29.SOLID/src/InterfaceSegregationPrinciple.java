public class InterfaceSegregationPrinciple {
    public interface Runnable {
        void run();
    }

    public interface Swimmable {
        void swim();
    }

    public interface Flyable {
        void fly();
    }

    public class Tiger implements Runnable, Swimmable {
        @Override
        public void run() {
            System.out.println("Tiger runs fast through the jungle.");
        }

        @Override
        public void swim() {
            System.out.println("Tiger swims across the river.");
        }
    }

    public class Eagle implements Flyable {
        @Override
        public void fly() {
            System.out.println("Eagle soars high in the sky.");
        }
    }
}
