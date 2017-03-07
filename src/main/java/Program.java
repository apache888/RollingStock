import controller.Controller;
import model.MainModel;
import view.UIView;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Главный класс, с которого запускается програма*/
public class Program {

    public static void main(String[] args) {
        MainModel model = new MainModel();
       Controller controller = new Controller();
        UIView view = new UIView();

        view.setController(controller);
        controller.setModel(model);
        controller.setView(view);

        view.showTimetable();
        view.showInfoByDirection();
    }
}
