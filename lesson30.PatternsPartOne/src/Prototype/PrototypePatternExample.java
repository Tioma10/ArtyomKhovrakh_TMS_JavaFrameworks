package Prototype;

public class PrototypePatternExample {

    interface Prototype {
        Prototype clone();
    }

    static class Phone implements Prototype {
        private String brand;
        private String model;
        private int storage;
        private String color;

        public Phone(String brand, String model, int storage, String color) {
            this.brand = brand;
            this.model = model;
            this.storage = storage;
            this.color = color;
        }

        public void display() {
            System.out.println("Phone: " + brand + " " + model + " " + storage + "GB " + color);
        }


        public Prototype clone() {
            return new Phone(this.brand, this.model, this.storage, this.color);
        }
    }

    public static void main(String[] args) {

        Phone originalPhone = new Phone("Apple", "iPhone 14", 128, "Black");


        Phone clonedPhone1 = (Phone) originalPhone.clone();
        Phone clonedPhone2 = (Phone) originalPhone.clone();


        clonedPhone1.storage = 256;
        clonedPhone2.color = "White";

        System.out.println("Original Phone:");
        originalPhone.display();

        System.out.println("\nCloned Phone 1:");
        clonedPhone1.display();

        System.out.println("\nCloned Phone 2:");
        clonedPhone2.display();
    }
}