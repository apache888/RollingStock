package bean;

/*Класс сущность - Локомотив*/
public class Locomotive extends Wagon {
    private static final int COMFORT_LEVEL = 15;
    private int countOfCrew;

    public Locomotive(int countOfCrew, int id) {
        this.countOfCrew = countOfCrew;
        this.comfortLevel = COMFORT_LEVEL;
        this.number = id;
    }

    /*Получение количества команды*/
    public int getCountOfCrew() {
        return countOfCrew;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "Crew = " + countOfCrew + " members" +
                '}';
    }
}
