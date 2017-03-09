import view.ConsoleHelper;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Главный класс, с которого запускается програма*/
public class Program {

    public static void main(String[] args) {

        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.init();
        consoleHelper.showCommandsMenu();
    }
}
