package hotel.controller.events;

import hotel.controller.Controller;
import hotel.gui.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vboskovic
 */
public class LogoutEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        LoginView root = new LoginView();
        Controller.getInstance().setLoginView(root);
        Stage stage = Controller.getInstance().getPrimaryStage();
        
        Scene scene = new Scene(root, 600, 250);
        
        stage.setTitle("Prijava");
        stage.setScene(scene);
    }

}
