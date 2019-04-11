package webshop.business;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Djorde Stankovic
 */
@Local
public interface RegisterBeanLocal {

    /**
     * Registers new user.
     *
     * @param username
     * @param password
     * @param name
     * @param surname
     * @return true if user was successfully registered, otherwise or in case of
     * some exceptions false is returned
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean register(final String username, final String password, final String name, final String surname);

}
