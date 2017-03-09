package controller;

import model.MainModel;
import view.ConsoleHelper;
import view.UIView;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Контроллер по шаблону MVC, обеспечивает взаимодействие пользователя с данными*/
public class Controller {
    private MainModel model;
    private UIView view;

    /*Предоставление общего количества пассажиров и багажа для отображения пользователю*/
    public void onTotalCountPassAndBaggs() {
        view.writeTotalCount(model.getTotalCountPassAndBaggs());
    }

    /*Предоставление списка вагонов по уровню комфорта для отображения пользователю*/
    public void onSortStockByComfortLevel() {
        view.writeStockByCL(model.sortStockByComfortLevel());
    }

    /*Предоставление списка вагон по заданому интервалу количества пассажиров для отображения пользователю*/
    public void onFindByPassRange() {
        while (true) {
            try {
                int from = ConsoleHelper.readFrom();
                int to = ConsoleHelper.readTo();
                if (from <= to) {
                    view.writeWagonsByRange(model.getWagonsByPassRange(from, to));
                    break;
                } else throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeToConsole("Wrong range. Try again.\n");
            }
        }
    }

    /*Предоставление списка вагонов*/
    public void onShowStock() {
        view.writeAllStock(model.getStock());
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
