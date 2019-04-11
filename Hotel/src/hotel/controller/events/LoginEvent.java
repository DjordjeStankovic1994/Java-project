package hotel.controller.events;

import hotel.business.FacadeFactory;
import hotel.business.FacadeImpl;
import hotel.business.model.Korisnik;
import hotel.controller.Controller;
import hotel.controller.constants.Constants;
import hotel.gui.admin.AdminView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 *
 * @author vboskovic
 */
public class LoginEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        String username = Controller.getInstance().getLoginView().getUsernameFld().getText();
        String password = Controller.getInstance().getLoginView().getPasswordFld().getText();

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            Controller.getInstance().getLoginView().showMessage("Morate uneti korisničko ime i lozinku.");
            return;
        }

        Korisnik korisnik = FacadeFactory.getFacade().login(username, password);

        if (korisnik == null) {
            Controller.getInstance().getLoginView().showMessage("Neuspešna prijava.");
            return;
        }
        
        Controller.getInstance().setLoggedInUser(korisnik.getIme()+" "+korisnik.getPrezime());

        if (Constants.ADMIN_PRIVILEGE.equalsIgnoreCase(korisnik.getPrivilegijaId().getNaziv())) {
            AdminView adminView = new AdminView();
            Controller.getInstance().setAdminView(adminView);
            
            Scene scene = new Scene(adminView, 850, 550);
            Controller.getInstance().getPrimaryStage().setTitle("Hotel Admin Panel");
            Controller.getInstance().getPrimaryStage().setScene(scene);
            return;
        } else if (Constants.USER_PRIVILEGE.equalsIgnoreCase(korisnik.getPrivilegijaId().getNaziv())) {
            // generisi user panel
            return;
        }

        Controller.getInstance().getLoginView().showMessage("Nepoznata privilegija korisnika.");
    }

}
