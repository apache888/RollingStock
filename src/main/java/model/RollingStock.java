package model;

import bean.BaggageVan;
import bean.Locomotive;
import bean.PassengerCoach;
import bean.Wagon;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Класс является сущностью - Подвижный состав*/
public class RollingStock {
    @JsonDeserialize(as=ArrayList.class)
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value= Locomotive.class, name="locom"),
            @JsonSubTypes.Type(value= PassengerCoach.class, name="coach"),
            @JsonSubTypes.Type(value= BaggageVan.class, name="van")
    })
    private List<Wagon> rollingStock; // список вагонов текущего состава, с к-рым мы работаем
//    private int id; //код рейса (train run)
//    private String tripName; //название по направлениям

    /*Инициализация подвижного состава*/
    public void setRollingStock(List<Wagon> rollingStock) {
        this.rollingStock = rollingStock;
    }

    /*Получение подвижного состава*/
    public List<Wagon> getStock(){
        return rollingStock;
    }

    /*Получение общего количества пассажиров и багажа подвижного состава*/
    public int getTotalCount() {
        int result = 0;
        for (Wagon wagon : rollingStock) {
            if (wagon instanceof PassengerCoach) {
                result += ((PassengerCoach) wagon).getCountOfPassengers();
            }
            if (wagon instanceof BaggageVan) {
                result += ((BaggageVan) wagon).getCountOfBaggage();
            }
        }
        return result;
    }

    /*Получение сортированного по уровню комфорта подвижного состава*/
    public List<Wagon> sortVansByComfortLevel() {
        List<Wagon> list = new ArrayList<>();
        for (Wagon wagon : rollingStock) {
            if (wagon instanceof PassengerCoach) {
                list.add(wagon);
            }
        }
        Collections.sort(list, new Comparator<Wagon>() {
            @Override
            public int compare(Wagon o1, Wagon o2) {
                return o2.getComfortLevel() - o1.getComfortLevel();
            }
        });
        return list;
    }

    /*Получение списка вагонов по интервалу количества пассажиров*/
    public List<Wagon> getVansByRange(int from, int to) {
        List<Wagon> list = new ArrayList<>();
        if (from < 0 || to < 0 || from > to) {
            System.out.println("Incorrect data");
            throw new IllegalArgumentException();
        }
        for (Wagon wagon : rollingStock) {
            if (wagon instanceof PassengerCoach) {
                if (((PassengerCoach) wagon).getCountOfPassengers() >= from
                        && ((PassengerCoach) wagon).getCountOfPassengers() <= to) {
                    list.add(wagon);
                }
            }
        }
        return list;
    }
}
