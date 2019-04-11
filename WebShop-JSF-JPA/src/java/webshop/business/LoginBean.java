package webshop.business;

import javafx.scene.image.Image;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import webshop.model.Korisnik;
/**
 *
 * @author Djorde Stankovic
 */
@Stateless
public class LoginBean implements LoginBeanLocal {

    @PersistenceContext(unitName = "WebShop2PU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Korisnik login(String username, String password) {

        try {
            Query query = em.createNamedQuery("Korisnik.findByKorisnickoImeLozinka");
            query.setParameter("korisnickoIme", username);
            query.setParameter("lozinka", password);

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
