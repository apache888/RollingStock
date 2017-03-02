package rollingstock.main.model;

public class PassengerCoach extends Wagon {
    private int countOfPassengers;

    public PassengerCoach(int countOfPassengers, int id) {
        this.countOfPassengers = countOfPassengers;
        this.comfortLevel = (int) (Math.random() * 10 + 2);
        this.number = id;
    }
    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    @Override
    public String toString() {
        return "{" +
                "number №" + number +
                ", CL" + comfortLevel +

                ", passengers = " + countOfPassengers +
                '}';
    }
}
