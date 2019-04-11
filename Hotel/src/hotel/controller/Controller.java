package hotel.controller;

import hotel.controller.events.EventManager;
import hotel.gui.LoginView;
import hotel.gui.admin.AdminView;
import javafx.stage.Stage;

/**
 *
 * @author vboskovic
 */
public class Controller {

    private static Controller instance = null;

    private Stage primaryStage = null;
    private LoginView loginView = null;
    private AdminView adminView = null;

    private String loggedInUser = "";

    private EventManager eventManager = new EventManager();

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {

    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
