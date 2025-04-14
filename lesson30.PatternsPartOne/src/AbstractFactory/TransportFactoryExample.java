package AbstractFactory;

public class TransportFactoryExample {


    interface Car {
        void drive();
    }

    interface Bike {
        void ride();
    }


    static class CityCar implements Car {
        public void drive() {
            System.out.println("Driving a small city car.");
        }
    }

    static class CityBike implements Bike {
        public void ride() {
            System.out.println("Riding a city bike.");
        }
    }

    
    static class CountryCar implements Car {
        public void drive() {
            System.out.println("Driving a big off-road car.");
        }
    }

    static class CountryBike implements Bike {
        public void ride() {
            System.out.println("Riding a mountain bike.");
        }
    }


    interface TransportFactory {
        Car createCar();
        Bike createBike();
    }


    static class CityTransportFactory implements TransportFactory {
        public Car createCar() {
            return new CityCar();
        }

        public Bike createBike() {
            return new CityBike();
        }
    }


    static class CountryTransportFactory implements TransportFactory {
        public Car createCar() {
            return new CountryCar();
        }

        public Bike createBike() {
            return new CountryBike();
        }
    }


    public static void main(String[] args) {
        System.out.println("City transport:");
        TransportFactory cityFactory = new CityTransportFactory();
        cityFactory.createCar().drive();
        cityFactory.createBike().ride();

        System.out.println("\nCountry transport:");
        TransportFactory countryFactory = new CountryTransportFactory();
        countryFactory.createCar().drive();
        countryFactory.createBike().ride();
    }
}