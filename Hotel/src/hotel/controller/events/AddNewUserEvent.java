package hotel.controller.events;

import hotel.business.FacadeFactory;
import hotel.business.model.Korisnik;
import hotel.business.model.Privilegija;
import hotel.controller.Controller;
import hotel.controller.util.Message;
import hotel.gui.admin.UsersAdminPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Adds new User to the storage
 *
 * @author vboskovic
 */
public class AddNewUserEvent implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        UsersAdminPanel usersAdminPanel = Controller.getInstance().getAdminView().getUsersAdminPanel();
        
        String korIme = usersAdminPanel.getKorisnickoImeFld().getText();
        String lozinka = usersAdminPanel.getLozinkaFld().getText();
        String ime = usersAdminPanel.getImeFld().getText();
        String prezime = usersAdminPanel.getPrezimeFld().getText();
        Privilegija privilegija = usersAdminPanel.getPrivilegijaCb().getSelectionModel().getSelectedItem();
        
        if (korIme == null || korIme.isEmpty() || lozinka == null || lozinka.isEmpty() || ime == null || ime.isEmpty() || prezime == null || prezime.isEmpty() || privilegija == null) {
            Message.info("Sva polja u formi su obavezna.");
            usersAdminPanel.clearAllFields();
            return;
        }
        
        Korisnik k = FacadeFactory.getFacade().findKorisnikByKorisnickoIme(korIme);
        
        if (k != null) { // zauzeto korisnicko ime
            Message.info("Prosleđeno korisničko ime je zauzeto.");
            return;
        }
        
        try {
            FacadeFactory.getFacade().addNewUser(korIme, lozinka, ime, prezime, privilegija);
            Message.info("Novi korisnik je dodat.");
            usersAdminPanel.clearAllFields();
            usersAdminPanel.reloadTableData();
        } catch (Exception e) {
            Message.info("Došlo je do greške prilikom dodavanja korisnika.");
        }
        
    }
    
}
