package view;

import controller.Controller;
import model.Wagon;

import java.util.List;

import static view.ConsoleHelper.writeToConsole;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Класс представления информации пользователю*/
public class UIView {
    private Controller controller;

    /*Назначение контролера данному вью*/
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /*Генерация события - отображение всех вагонов состава*/
    public void fireEventShowStock() {
        controller.onShowStock();
    }

    /*Генерация события - отображение общего количества пассажиров и багажа*/
    public void fireEventTotalCount() {
        controller.onTotalCountPassAndBaggs();
    }

    /*Генерация события - отображение списка вагонов по уровню комфорта*/
    public void fireEventSortByCL() {
        controller.onSortStockByComfortLevel();
    }

    /*Генерация события - отображение списка вагон по заданому интервалу количества пассажиров*/
    public void fireEventFindByRange() {
        controller.onFindByPassRange();
    }

    /*Представление общего количества пассажиров и багажа*/
    public void writeTotalCount(int count) {
        writeToConsole("\nTotal count of passengers and baggage: " + count + "\n");
    }

    /*Представление вагонов по уровню комфорта*/
    public void writeStockByCL(List<Wagon> stock) {
        writeToConsole("\nCoaches by comfort level:\n");
        for (Wagon wagon : stock) {
            writeToConsole(wagon.toString());
        }
        writeToConsole("\n");
    }

    /*Представление вагон по заданому интервалу количества пассажиров*/
    public void writeWagonsByRange(List<Wagon> stock) {
        writeToConsole("\nCoaches by count range:\n");
        if (stock.isEmpty()) {
            writeToConsole("There are no wagons for this rang\n");
        } else {
            for (Wagon wagon : stock) {
                writeToConsole(wagon.toString());
            }
            writeToConsole("\n");
        }
    }

    /*Представление списка вагонов*/
    public void writeAllStock(List<Wagon> stock) {
        writeToConsole("\nAll wagons of rolling stock:\n");
        for (Wagon wagon : stock) {
            writeToConsole(wagon.toString());
        }
        writeToConsole("\n");
    }
}
