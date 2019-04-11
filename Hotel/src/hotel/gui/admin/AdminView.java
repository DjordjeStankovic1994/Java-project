package hotel.gui.admin;

import hotel.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author vboskovic
 */
public class AdminView extends BorderPane {

    private final ToggleButton usersTb = new ToggleButton("Koisnici");
    private final ToggleButton roomsTb = new ToggleButton("Sobe");
    private final Button logoutBtn = new Button("Odjava");

    private UsersAdminPanel usersAdminPanel;
    private RoomsAdminPanel roomsAdminPanel;

    public AdminView() {
        usersAdminPanel = new UsersAdminPanel();
        setCenter(usersAdminPanel);

        ToggleGroup toggleGroup = new ToggleGroup();
        usersTb.setToggleGroup(toggleGroup);
        roomsTb.setToggleGroup(toggleGroup);

        usersTb.setSelected(true);

        HBox mainMenu = new HBox();
        mainMenu.setSpacing(5);
        mainMenu.setPadding(new Insets(10, 10, 10, 10));

        logoutBtn.setOnAction(Controller.getInstance().getEventManager().getLogoutEvent());
        
        logoutBtn.setText("Odjava ("+Controller.getInstance().getLoggedInUser()+")");
        mainMenu.getChildren().addAll(usersTb, roomsTb);
        
        
        usersTb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                usersAdminPanel = new UsersAdminPanel();
                setCenter(usersAdminPanel);
            }
        });
        
        roomsTb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                roomsAdminPanel = new RoomsAdminPanel();
                setCenter(roomsAdminPanel);
            }
        });
        
        HBox logoutBox = new HBox(logoutBtn);
        logoutBox.setAlignment(Pos.CENTER_RIGHT);
        logoutBox.setPadding(new Insets(10, 10, 10, 10));
        
        GridPane topPane = new GridPane();
        topPane.add(mainMenu, 0, 0);
        topPane.add(logoutBox, 1, 0);
        
        setTop(topPane);

    }

    public UsersAdminPanel getUsersAdminPanel() {
        return usersAdminPanel;
    }

    public void setUsersAdminPanel(UsersAdminPanel usersAdminPanel) {
        this.usersAdminPanel = usersAdminPanel;
    }

    public RoomsAdminPanel getRoomsAdminPanel() {
        return roomsAdminPanel;
    }

    public void setRoomsAdminPanel(RoomsAdminPanel roomsAdminPanel) {
        this.roomsAdminPanel = roomsAdminPanel;
    }

}
