package Facade;

class WaterHeater {
    void boilWater() {
        System.out.println("Boiling water");
    }
}

class CoffeeMaker {
    void addCoffee() {
        System.out.println("Adding coffee");
    }
}

class Stirrer {
    void stir() {
        System.out.println("Stirring coffee");
    }
}

class CoffeeFacade {
    private WaterHeater heater = new WaterHeater();
    private CoffeeMaker maker = new CoffeeMaker();
    private Stirrer stirrer = new Stirrer();

    public void makeCoffee() {
        heater.boilWater();
        maker.addCoffee();
        stirrer.stir();
        System.out.println("Coffee is ready!");
    }
}

public class CoffeeFacadeExample {
    public static void main(String[] args) {
        CoffeeFacade coffeeMachine = new CoffeeFacade();
        coffeeMachine.makeCoffee();
    }
}
