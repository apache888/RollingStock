package rollingstock.main.model;

public class BaggageVan extends Wagon {
    private static final int COMFORT_LEVEL = 0;
    private int countOfBaggage;

    public BaggageVan(int countOfBaggage, int id) {
        this.countOfBaggage = countOfBaggage;
        this.comfortLevel = COMFORT_LEVEL;
        this.number = id;
    }

    public int getCountOfBaggage() {
        return countOfBaggage;
    }

    @Override
    public String toString() {
        return "{" +
                "number №" + number +
                ", baggage = " + countOfBaggage + " pcs" +
                '}';
    }
}
