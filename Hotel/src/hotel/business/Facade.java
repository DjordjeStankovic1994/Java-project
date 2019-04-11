package hotel.business;

import hotel.business.model.Korisnik;
import hotel.business.model.Privilegija;
import hotel.business.model.Soba;
import java.util.List;

/**
 * Application business logic
 *
 * @author vboskovic
 */
public interface Facade {

    /**
     * Finds Korisnik instance for provided username and password
     *
     * @param username
     * @param password
     * @return found Korisnik instance if exists, in case of
     * NonUniqueResultException or user does not exist, null value is returned
     */
    public Korisnik login(String username, String password);

    /**
     * @return all Korisnk instances
     */
    public List<Korisnik> getAllUsers();

    /**
     * @return list of all rooms in the hotel
     */
    public List<Soba> getAllRooms();

    /**
     * @return list of all privileges
     */
    public List<Privilegija> getAllPrivileges();

    /**
     * Finds user by username value
     *
     * @param korisnickoIme
     * @return
     */
    public Korisnik findKorisnikByKorisnickoIme(final String korisnickoIme);
    
    /**
     * 
     * @param username
     * @param password
     * @param name
     * @param surname
     * @param privilege
     * @return 
     */
    public Korisnik addNewUser(final String username, final String password, final String name, final String surname, Privilegija privilege);

}
