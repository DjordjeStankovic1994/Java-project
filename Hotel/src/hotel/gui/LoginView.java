package hotel.gui;

import hotel.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * Application login screen.
 *
 * @author vboskovic
 */
public class LoginView extends GridPane {

    private Label usernameLbl = new Label("Koirsničko ime:");
    private Label passwordLbl = new Label("Lozinka:");

    private TextField usernameFld = new TextField();
    private PasswordField passwordFld = new PasswordField();

    private Button loginBtn = new Button("Prijava");
    private Button cancelBtn = new Button("Odustani");

    private Label messageLbl = new Label();

    public LoginView() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        setAlignment(Pos.CENTER);
       
        add(usernameLbl, 0, 0);
        add(usernameFld, 1, 0);

        add(passwordLbl, 0, 1);
        add(passwordFld, 1, 1);

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.getChildren().addAll(cancelBtn, loginBtn);

        add(flowPane, 1, 2);
        add(messageLbl, 1, 3);

        cancelBtn.setOnAction(Controller.getInstance().getEventManager().getCancelEvent());
        loginBtn.setOnAction(Controller.getInstance().getEventManager().getLoginEvent());
    }

    public TextField getUsernameFld() {
        return usernameFld;
    }

    public PasswordField getPasswordFld() {
        return passwordFld;
    }

    public void showMessage(final String text) {
        messageLbl.setText(text);
    }

    public void clearMessage() {
        messageLbl.setText("");
    }

}
