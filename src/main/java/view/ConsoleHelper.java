package view;

import controller.Controller;
import model.MainModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create by Roman Hayda on 08.03.2017.
 */
/*Вспомогательный класс для работы с консолью*/
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private UIView view = new UIView();
    private MainModel model = new MainModel();
    private Controller controller = new Controller();

    /*Инициализация Модели, Контролера и Отображения*/
    public void init() {     // не уверен, что этот метод д.б. здесь
        view.setController(controller);
        controller.setModel(model);
        controller.setView(view);
    }

    /*Представление меню команд*/
    public void showCommandsMenu() {
        while (true) {
            try {
                writeToConsole("Select command:\n\n" +
                        "0 - Show all rolling stock\n" +
                        "1 - Total count of passengers and baggage\n" +
                        "2 - Sort wagons by comfort level\n" +
                        "3 - Find wagons by count range of passengers\n" +
                        "4 - Exit\n");
                switch (Integer.parseInt(readString())) {
                    case 0:
                        view.fireEventShowStock();
                        break;
                    case 1:
                        view.fireEventTotalCount();
                        break;
                    case 2:
                        view.fireEventSortByCL();
                        break;
                    case 3:
                        view.fireEventFindByRange();
                        break;
                    case 4:
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                writeToConsole("Wrong command. Try again.");
            }
        }
    }

    /*Считывание данных из консоли и представление их в виде строки*/
    public static String readString() throws IOException {
        return reader.readLine();
    }

    /*Считывание с консоли нижней нраницы интервала*/
    public static int readFrom() {
        while (true) {
            writeToConsole("Input 'from' for range:");
            try {
                return Integer.parseInt(readString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                writeToConsole("Wrong number. Try again.");
            }
        }
    }

    /*Считывание с консоли верхней нраницы интервала*/
    public static int readTo() {
        while (true) {
            writeToConsole("Input 'to' for range:");
            try {
                return Integer.parseInt(readString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                writeToConsole("Wrong number. Try again.");
            }
        }
    }

    /*Отображение полученной строки в консоль*/
    public static void writeToConsole(String message) {
        System.out.println(message);
    }
}
