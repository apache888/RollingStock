package rollingstock.main.model;

public abstract class Wagon {
    int comfortLevel;   // можно задать как Enum
    int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public int getNumber() {
        return number;
    }
}
