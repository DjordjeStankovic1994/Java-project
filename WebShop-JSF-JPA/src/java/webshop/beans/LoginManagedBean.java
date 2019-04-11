
package webshop.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import webshop.business.LoginBeanLocal;
import webshop.model.Korisnik;

/**
 *
 * @author vboskovic
 */
@ManagedBean(name = "loginMB", eager = true)
@SessionScoped
public class LoginManagedBean implements Serializable {

    private String username;
    private String password;

    private String message = "";

    private Korisnik loggedInKorisnik = null;

    @EJB
    private LoginBeanLocal loginBean;
    
    

    public String login() {

        if (loggedInKorisnik != null) {
            return "success";
        }

        Korisnik korisnik = loginBean.login(username, password);

        if (korisnik == null) {
            message = "Neispravna kombinacija korisničkog imena i lozinke.";
            return "failure";
        }

        this.loggedInKorisnik = korisnik;

        return "success";
    }

    public void logout() {
        loggedInKorisnik = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Korisnik getLoggedInKorisnik() {
        return loggedInKorisnik;
    }

    public void setLoggedInKorisnik(Korisnik loggedInKorisnik) {
        this.loggedInKorisnik = loggedInKorisnik;
    }
    
    public boolean isLoggedIn() {
        return (loggedInKorisnik != null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
