package webshop.business;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import webshop.model.Korisnik;

/**
 *
 * @author Djorde Stankovic
 */
@Local
public interface LoginBeanLocal {

    /**
     * Checks whether user with provided credential exists.
     *
     * @param username
     * @param password
     * @return found user if exists, otherwise or in case of any exceptions null
     * value is returned
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Korisnik login(final String username, final String password);

}
