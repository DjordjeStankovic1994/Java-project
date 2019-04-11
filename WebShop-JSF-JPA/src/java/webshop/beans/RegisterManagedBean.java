package webshop.beans;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import webshop.business.RegisterBeanLocal;

/**
 *
 * @author Djorde Stankovic
 */
@ManagedBean(name = "register", eager = true)
@SessionScoped
public class RegisterManagedBean implements Serializable {

    private String username;
    private String password;
    private String name;
    private String surname;
    
    private String message = "";
    
    @EJB
    private RegisterBeanLocal registerBean;

    public String register() {
        
        boolean result = registerBean.register(username, password, name, surname);
        
        if (!result) {
            message = "Greška prilikom registracije. Prosleđeno korisničko ime je verovatno zauzeto.";
            return "failure";
        }
        
        message = "";
        return "success";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

}
