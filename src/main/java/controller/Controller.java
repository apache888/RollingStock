package controller;

import model.MainModel;
import view.UIView;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Контроллер по шаблону MVC, обеспечивает взаимодействие пользователя с данными*/
public class Controller {
    private MainModel model;
    private UIView view;

    /*Предоставляет расписание составов для отображения пользователю*/
    public void onShowTimetable() {
        model.loadAllStocks();
        view.writeTimetable(MainModel.getAllStocks());
    }

    /*Инициализирует цепочку действий для инициализации состава по направлению у модели*/
    public void onLoadStockByDirection(String direction) {
        model.loadStockByDirection(direction);
    }

    /*Предоставление общего количества пассажиров и багажа для отображения пользователю*/
    public void onTotalCountPassAndBaggs() {
        view.writeTotalCount(model.getTotalCountPassAndBaggs());
    }

    /*Предоставление списка вагонов по уровню комфорта для отображения пользователю*/
    public void onSortStockByComfortLevel() {
        view.writeStockByCL(model.sortStockByComfortLevel());
    }

    /*Предоставление списка вагон по заданому интервалу количества пассажиров для отображения пользователю*/
    public void onCoachesByPassRange(int from, int to) {
        view.writeCoachesByRange(model.getCoachesByPassRange(from, to));
    }

    /*Назначение данному контролеру Отображения*/
    public void setView(UIView view) {
        this.view = view;
    }

    /*Назначение данному контролеру Модели*/
    public void setModel(MainModel model) {
        this.model = model;
    }
}
