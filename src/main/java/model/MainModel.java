package model;

import dao.WagonDao;

import java.util.List;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Класс - модель, отображающий бизнес-логику шаблона MVC*/
public class MainModel {
    private RollingStock rollingStock = new RollingStock(); //??
    private WagonDao wagonDao = new WagonDao();

    /*Получение общего количества пассажиров и багажа данного состава*/
    public int getTotalCountPassAndBaggs() {
        return wagonDao.getTotalCount();
    }

    /*Получение сортированного по уровню комфорта списка вагонов*/
    public List<Wagon> sortStockByComfortLevel() {
        return wagonDao.getSortStockByCL();
    }

    /*Получение списка вагонов по интервалу количества пассажиров*/
    public List<Wagon> getWagonsByPassRange(int from, int to) {
        return wagonDao.getStockByCountRange(from, to);
    }

    /*Получение списка вагонов данного состава*/
    public List<Wagon> getStock() {
        return wagonDao.getAllWagons();
    }
}
