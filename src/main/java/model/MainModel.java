package model;

import bean.Wagon;
import model.service.StockService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Класс - модель, отображающий бизнес-логику шаблона MVC*/
public class MainModel {
    private static Map<String, List<Wagon>> allStocks = new HashMap<>();
    private RollingStock currentStock = new RollingStock();
    private StockService stockService = new StockService();

    /*Получение карты всех составов по ключу - Направление*/
    public static Map<String, List<Wagon>> getAllStocks() {
        return allStocks;
    }

    /*Инициализация карты всех направлений из базы данных*/
    public void loadAllStocks() {
        allStocks = stockService.getTimetable();
    }

    /*Инициализация списка вагонов данного состава по направлению из общей карты*/
    public void loadStockByDirection(String direction) {
        currentStock.setRollingStock(allStocks.get(direction));
    }

    /*Получение общего количества пассажиров и багажа данного состава*/
    public int getTotalCountPassAndBaggs() {
        return currentStock.getTotalCount();
    }

    /*Получение сортированного по уровню комфорта списка вагонов данного состава*/
    public List<Wagon> sortStockByComfortLevel() {
        return currentStock.sortVansByComfortLevel();
    }

    /*Получение списка вагонов по интервалу количества пассажиров данного состава*/
    public List<Wagon> getCoachesByPassRange(int from, int to) {
        return currentStock.getVansByRange(from, to);
    }
}
