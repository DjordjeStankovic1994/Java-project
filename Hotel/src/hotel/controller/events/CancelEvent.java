package hotel.controller.events;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author vboskovic
 */
public class CancelEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Platform.exit();
    }

}
