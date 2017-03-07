package bean;

/*Класс сущность - Вагон как объект*/
public abstract class Wagon {
    int comfortLevel;   // можно задать как Enum
    int number;

    /*Получение уровня комфорта*/
    public int getComfortLevel() {
        return comfortLevel;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
