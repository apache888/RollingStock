package rollingstock.main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RollingStock {
    private static Map<String, List<Wagon>> allStocks = new HashMap<>(); // направлени - состав. или
    // ключ - номер рейса, а само направление- объект с номером и названием
    static {
        // имитация инициализации карты (должна инициализироваться из внешнего ресурса)
        List<Wagon> list = new ArrayList<>();
        list.add(new Locomotive(5, 0));
        for (int i = 1; i < 11; i++) {
            list.add(new PassengerCoach((int) (Math.random() * 100 / 2), i));
        }
        for (int i = 11; i < 15; i++) {
            list.add(new BaggageVan((int) (Math.random() * 10 * i), i));
        }
        allStocks.put("Odessa-Kiev", list);

        list.clear();
        list.add(new Locomotive(3, 0));
        for (int i = 1; i < 10; i++) {
            list.add(new PassengerCoach((int) (Math.random() * 100 / 2), i));
        }
        for (int i = 10; i < 13; i++) {
            list.add(new BaggageVan((int) (Math.random() * 10 * i), i));
        }
        allStocks.put("Odessa-Lvov", list);

    }
    private List<Wagon> rollingStock; // конкретный состав текущего объекта, с к-рым мы работаем

    public RollingStock(String direction) {
        rollingStock = allStocks.get(direction); // получение состава по направлению (можно уложнить по выбору даты и времени)
    }

    public List<Wagon> getStock(){
        return rollingStock;
    }

    public static Map<String, List<Wagon>> getAllStocks() {
        return allStocks;
    }

//    @Override
//    public String toString() {
//        return "RollingStock{" +
//                "rollingStock=" + rollingStock +
//                '}';
//    }
}
