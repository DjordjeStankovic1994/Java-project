package hotel;

import hotel.controller.Controller;
import hotel.gui.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vboskovic
 */
public class Hotel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        LoginView root = new LoginView();
        Controller.getInstance().setLoginView(root);
        Controller.getInstance().setPrimaryStage(primaryStage);
        
        Scene scene = new Scene(root, 600, 250);
        
        primaryStage.setTitle("Prijava");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
