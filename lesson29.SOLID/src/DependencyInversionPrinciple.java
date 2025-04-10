public class DependencyInversionPrinciple {
    public interface Switchable {
        void turnOn();
        void turnOff();
    }

    public class LightBulb implements Switchable {
        @Override
        public void turnOn() {
            System.out.println("LightBulb is ON");
        }

        @Override
        public void turnOff() {
            System.out.println("LightBulb is OFF");
        }
    }

    public class Switch {
        private final Switchable device;
        private boolean isOn = false;

        public Switch(Switchable device) {
            this.device = device;
        }

        public void press() {
            if (isOn) {
                device.turnOff();
                isOn = false;
            } else {
                device.turnOn();
                isOn = true;
            }
        }
    }


}


