package model;

import java.util.List;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Класс является сущностью - Подвижный состав*/
public class RollingStock {

    private List<Wagon> wagons; // список вагонов текущего состава, с к-рым мы работаем
//    private int id; //код рейса (train run)
//    private String tripName; //название по направлениям

    /*Инициализация подвижного состава*/
    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    /*Получение подвижного состава*/
    public List<Wagon> getWagons(){
        return wagons;
    }



//    /*Получение общего количества пассажиров и багажа подвижного состава*/
//    public int getTotalCount() {
//        int result = 0;
//        for (Wagon wagon1 : wagons) {
//            if (wagon1 instanceof PassengerCoach) {
//                result += ((PassengerCoach) wagon1).getCountOfPassengers();
//            }
//            if (wagon1 instanceof BaggageVan) {
//                result += ((BaggageVan) wagon1).getCountOfBaggage();
//            }
//        }
//        return result;
//    }
//
//    /*Получение сортированного по уровню комфорта подвижного состава*/
//    public List<Wagon> sortVansByComfortLevel() {
//        List<Wagon> list = new ArrayList<>();
//        for (Wagon wagon1 : wagons) {
//            if (wagon1 instanceof PassengerCoach) {
//                list.add(wagon1);
//            }
//        }
//        Collections.sort(list, new Comparator<Wagon>() {
//            @Override
//            public int compare(Wagon o1, Wagon o2) {
//                return o2.getComfortLevel() - o1.getComfortLevel();
//            }
//        });
//        return list;
//    }
//
//    /*Получение списка вагонов по интервалу количества пассажиров*/
//    public List<Wagon> getVansByRange(int from, int to) {
//        List<Wagon> list = new ArrayList<>();
//        if (from < 0 || to < 0 || from > to) {
//            System.out.println("Incorrect data");
//            throw new IllegalArgumentException();
//        }
//        for (Wagon wagon1 : wagons) {
//            if (wagon1 instanceof PassengerCoach) {
//                if (((PassengerCoach) wagon1).getCountOfPassengers() >= from
//                        && ((PassengerCoach) wagon1).getCountOfPassengers() <= to) {
//                    list.add(wagon1);
//                }
//            }
//        }
//        return list;
//    }
}
