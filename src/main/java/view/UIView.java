package view;

import bean.Wagon;
import controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Класс представления информации пользователю*/
public class UIView {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Controller controller;

    /*Назначение контролера данному вью*/
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /*Генерация события отображение расписания и передача инструкций контроллеру*/
    public void showTimetable() {
        controller.onShowTimetable();
    }

    /*Генерация события отображение информации по данному поезду.
    * внутри метода передаются соответствующие инструкции контролеру для получения данных*/
    public void showInfoByDirection() {
        while (true) {
            try {
                writeToConsole("Input targeted direction (print 'exit' to end):");
                String direction = readString();
                if (direction.equalsIgnoreCase("exit")) {
                    return;
                }
                controller.onLoadStockByDirection(direction);
                int from;
                int to;
                while (true) {
                    try {
                        writeToConsole("Input range of count of passengers 'from' - 'to': (both inclusive)");
                        from = Integer.parseInt(readString());
                        to = Integer.parseInt(readString());
                        if (from < 0 || to < 0 || from > to) {
                            writeToConsole("Incorrect range. Try again.");
                        } else break;
                    } catch (NumberFormatException e) {
                        writeToConsole("Incorrect range. Try again.");
                    }
                }

                controller.onTotalCountPassAndBaggs();
                controller.onSortStockByComfortLevel();
                controller.onCoachesByPassRange(from, to);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*Представление расписания*/
    public void writeTimetable(Map map) {
        writeToConsole("Current timetable of trains:\n" +
                map.keySet() + "\n");
    }

    /*Представление общего количества пассажиров и багажа*/
    public void writeTotalCount(int count) {
        writeToConsole("\nTotal count of passengers and baggage: " + count + "\n");
    }

    /*Представление вагонов по уровню комфорта*/
    public void writeStockByCL(List<Wagon> stock) {
        writeToConsole("Coaches by comfort level:\n" + stock + "\n");
    }

    /*Представление вагон по заданому интервалу количества пассажиров*/
    public void writeCoachesByRange(List<Wagon> stock) {
        writeToConsole("Coaches by count range:\n" + stock + "\n");
    }

    /*Считывание данных из консоли и представление их в виде строки*/
    public static String readString() throws IOException {
        return reader.readLine();
    }
    /*Отображение полученной строки в консоль*/
    public void writeToConsole(String message) {
        System.out.println(message);
    }
}
