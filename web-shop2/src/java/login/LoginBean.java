
package login;

import baza.Korisnik;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 

@Stateless
public class LoginBean implements LoginBeanLocal {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;
    
    @Override
    public Korisnik login(String name, String surname) {
        
        try {
            Query query = em.createNamedQuery("Korisnik.findByINameAndSurname");
            query.setParameter("ime", name);
            query.setParameter("prezime", surname);

            Korisnik result = (Korisnik) query.getSingleResult();

            return result;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        
        
    }

}
