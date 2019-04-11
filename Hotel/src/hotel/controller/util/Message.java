package hotel.controller.util;

import hotel.controller.constants.Constants;
import javafx.scene.control.Alert;

/**
 * Displays alert messages.
 *
 * @author vboskovic
 */
public class Message {

    /**
     * Displays information alert message (without header and with default
     * title).
     *
     * @param message
     */
    public static void info(final String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Constants.INFO_TITLE);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

}
