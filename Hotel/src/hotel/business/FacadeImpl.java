package hotel.business;

import hotel.business.model.Korisnik;
import hotel.business.model.Privilegija;
import hotel.business.model.Soba;
import hotel.controller.constants.Constants;
import hotel.controller.util.Message;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Business logic of the application. All communication from frontend should go
 * through this class. Facade communicates with database via Hibernate.
 *
 * @author vboskovic
 */
public class FacadeImpl implements Facade {

    @Override
    public Korisnik login(String username, String password) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        Query namedQuery = em.createNamedQuery("Korisnik.findByKorisnickoImeLozinka");
        namedQuery.setParameter("korisnickoIme", username);
        namedQuery.setParameter("lozinka", password);

        Korisnik result = null;
     

        try {
            result = (Korisnik) namedQuery.getSingleResult();
        } catch (NoResultException nre) {
            result = null;
        } catch (NonUniqueResultException nue) {
            System.err.println("[NonUniqueResultException] " + nue.getMessage());
        }

        em.getTransaction().commit();

        return result;
    }

    @Override
    public List<Korisnik> getAllUsers() {
        EntityManager em = getEntityManager();

        List<Korisnik> users = null;

        em.getTransaction().begin();

        Query namedQuery = em.createNamedQuery("Korisnik.findAll");
        users = (List<Korisnik>) namedQuery.getResultList();
        em.getTransaction().commit();

        return users;
    }

    @Override
    public List<Soba> getAllRooms() {
        EntityManager em = getEntityManager();

        List<Soba> rooms = null;

        em.getTransaction().begin();

        Query namedQuery = em.createNamedQuery("Soba.findAll");
        rooms = (List<Soba>) namedQuery.getResultList();
        em.getTransaction().commit();

        return rooms;
    }

    @Override
    public List<Privilegija> getAllPrivileges() {
        EntityManager em = getEntityManager();

        List<Privilegija> privileges = null;

        em.getTransaction().begin();

        Query namedQuery = em.createNamedQuery("Privilegija.findAll");

        privileges = (List<Privilegija>) namedQuery.getResultList();
        em.getTransaction().commit();

        return privileges;
    }

    @Override
    public Korisnik findKorisnikByKorisnickoIme(String korisnickoIme) {
        EntityManager em = getEntityManager();
        Korisnik result = null;

        em.getTransaction().begin();

        Query namedQuery = em.createNamedQuery("Korisnik.findByKorisnickoIme");
        namedQuery.setParameter("korisnickoIme", korisnickoIme);

        try {
            result = (Korisnik) namedQuery.getSingleResult();
        } catch (NoResultException nre) {

        } catch (NonUniqueResultException nue) {
            System.err.println("[NonUniqueResultException] " + nue.getMessage());
            Message.info("Postoji više korisnika sa prosleđenim korisničkim imenom.");
            System.exit(0);
        }

        em.getTransaction().commit();

        return result;
    }

    @Override
    public Korisnik addNewUser(String username, String password, String name, String surname, Privilegija privilege) {
        Korisnik newKorisnik = null;

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        newKorisnik = new Korisnik();
        newKorisnik.setKorisnickoIme(username);
        newKorisnik.setLozinka(password);
        newKorisnik.setIme(name);
        newKorisnik.setPrezime(surname);
        newKorisnik.setPrivilegijaId(privilege);

        em.persist(newKorisnik);

        em.getTransaction().commit();
        
        return newKorisnik;

    }

    /**
     * @return new instance of EntityManager
     */
    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME).createEntityManager();
    }
}
