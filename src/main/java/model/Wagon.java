package model;

/*Класс сущность - Вагон как объект*/
public class Wagon {
    private int id;
    private int comfortLevel;   // можно задать как Enum
    private int countPass; //кол-во пассажиров
    private int countBaggs; //кол-ко багажа

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*Получение уровня комфорта*/
    public int getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public int getCountPass() {
        return countPass;
    }

    public void setCountPass(int countPass) {
        this.countPass = countPass;
    }

    public int getCountBaggs() {
        return countBaggs;
    }

    public void setCountBaggs(int countBaggs) {
        this.countBaggs = countBaggs;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "id=" + id +
                ", comfortLevel=" + comfortLevel +
                ", countPass=" + countPass +
                ", countBaggs=" + countBaggs +
                '}';
    }
}
