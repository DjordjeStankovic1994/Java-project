
package login;


import baza.Korisnik;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginMB", eager = true)
@SessionScoped
public class ManagedLogin implements Serializable{
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
            // bez message ako se ne pozove u index-u return failure nece raditi vec ce se pozivati success.
            message = "Neispravna kombinacija korisničkog imena i lozinke.";   
          return "failure";
        }

        this.loggedInKorisnik = korisnik;
           if(korisnik.getIdPrivilegija().getIdPrivilegija().equals(1)){
            return "admin";
            }
        
  return "success";
    }
     public boolean isLoggedIn() {
        return (loggedInKorisnik != null);
    }

      public void logout() {
        loggedInKorisnik = null;
    }

    public Korisnik getLoggedInKorisnik() {
        return loggedInKorisnik;
    }

    public void setLoggedInKorisnik(Korisnik loggedInKorisnik) {
        this.loggedInKorisnik = loggedInKorisnik;
    }

    public LoginBeanLocal getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBeanLocal loginBean) {
        this.loginBean = loginBean;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
