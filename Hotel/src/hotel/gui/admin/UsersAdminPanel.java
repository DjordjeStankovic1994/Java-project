package hotel.gui.admin;

import hotel.business.FacadeFactory;
import hotel.business.model.Korisnik;
import hotel.business.model.Privilegija;
import hotel.controller.Controller;
import hotel.controller.util.Message;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Panel used for Users administration.
 *
 * @author vboskovic
 */
public class UsersAdminPanel extends VBox {

    private Label titleLbl = new Label("Administracija korisnika");
    private TableView<Korisnik> usersTable = new TableView<>();
    private List<Korisnik> users = null;

    private TextField korisnickoImeFld = new TextField();
    private PasswordField lozinkaFld = new PasswordField();
    private TextField imeFld = new TextField();
    private TextField prezimeFld = new TextField();
    private ChoiceBox<Privilegija> privilegijaCb = new ChoiceBox<>();

    private Button dodajBtn = new Button("Dodaj");
    private Button obrisiBtn = new Button("Obriši");

    public UsersAdminPanel() {
        titleLbl.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));

        try {
            users = FacadeFactory.getFacade().getAllUsers();
        } catch (Exception ex) {
            Message.info("Došlo je do greške prilikom učitavanja korisnika.");
            users = new ArrayList<>();
        }

        TableColumn korisnickoImeCol = new TableColumn("Korisničko ime");
        korisnickoImeCol.setMinWidth(150);
        korisnickoImeCol.setCellValueFactory(
                new PropertyValueFactory<Korisnik, String>("korisnickoIme"));

        TableColumn imeCol = new TableColumn("Ime");
        imeCol.setMinWidth(100);
        imeCol.setCellValueFactory(new PropertyValueFactory<Korisnik, String>("ime"));

        TableColumn prezimeCol = new TableColumn("Prezime");
        prezimeCol.setMinWidth(100);
        prezimeCol.setCellValueFactory(new PropertyValueFactory<Korisnik, String>("prezime"));

        TableColumn privilegijaCol = new TableColumn("Privilegija");
        privilegijaCol.setMinWidth(150);
        privilegijaCol.setCellValueFactory(new PropertyValueFactory<Korisnik, String>("privilegijaId"));

        usersTable.setItems(FXCollections.observableArrayList(users));
        usersTable.getColumns().addAll(korisnickoImeCol, imeCol, prezimeCol, privilegijaCol);

        getChildren().addAll(titleLbl, usersTable, getFormData());
    }

    private HBox getFormData() {
        HBox hbox = new HBox();
        hbox.setSpacing(3);

        korisnickoImeFld.setMaxWidth(75);
        korisnickoImeFld.setPromptText("Kor. ime");

        lozinkaFld.setMaxWidth(75);
        lozinkaFld.setPromptText("Lozinka");

        imeFld.setMaxWidth(100);
        imeFld.setPromptText("Ime");

        prezimeFld.setMaxWidth(100);
        prezimeFld.setPromptText("Prezime");

        privilegijaCb.setItems(FXCollections.observableArrayList(FacadeFactory.getFacade().getAllPrivileges()));
        privilegijaCb.getSelectionModel().select(0);
        privilegijaCb.setMaxWidth(150);

        dodajBtn.setOnAction(Controller.getInstance().getEventManager().getAddNewUserEvent());

        hbox.getChildren().addAll(korisnickoImeFld, lozinkaFld, imeFld, prezimeFld, privilegijaCb, dodajBtn);

        return hbox;
    }

    public TextField getKorisnickoImeFld() {
        return korisnickoImeFld;
    }

    public PasswordField getLozinkaFld() {
        return lozinkaFld;
    }

    public TextField getImeFld() {
        return imeFld;
    }

    public TextField getPrezimeFld() {
        return prezimeFld;
    }

    public ChoiceBox<Privilegija> getPrivilegijaCb() {
        return privilegijaCb;
    }

    public void clearAllFields() {
        korisnickoImeFld.setText("");
        lozinkaFld.setText("");
        imeFld.setText("");
        prezimeFld.setText("");
        privilegijaCb.getSelectionModel().select(0);
    }

    public void reloadTableData() {
        try {
            users = FacadeFactory.getFacade().getAllUsers();
        } catch (Exception ex) {
            Message.info("Došlo je do greške prilikom učitavanja korisnika.");
            users = new ArrayList<>();
        }
        usersTable.setItems(FXCollections.observableArrayList(users));
    }

}
