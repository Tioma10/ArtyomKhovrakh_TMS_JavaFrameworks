package Adapter;

class MetricLength {
    private double meters;

    public MetricLength(double meters) {
        this.meters = meters;
    }

    public double getLengthInMeters() {
        return meters;
    }
}

interface ImperialLength {
    double getLengthInFeet();
}

class MetricToImperialAdapter implements ImperialLength {
    private MetricLength metricLength;

    public MetricToImperialAdapter(MetricLength metricLength) {
        this.metricLength = metricLength;
    }

    public double getLengthInFeet() {
        return metricLength.getLengthInMeters() * 3.28084;
    }
}

public class LengthConverter {
    public static void main(String[] args) {
        MetricLength lengthInMeters = new MetricLength(10);
        ImperialLength imperialLength = new MetricToImperialAdapter(lengthInMeters);

        System.out.printf("Length in feet: " + imperialLength.getLengthInFeet() + " ft");
    }
}