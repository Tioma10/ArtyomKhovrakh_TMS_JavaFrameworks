public class Musician {
    private Instrument instrument;

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() {
        System.out.print("Musician is playing: ");
        instrument.play();
    }
}