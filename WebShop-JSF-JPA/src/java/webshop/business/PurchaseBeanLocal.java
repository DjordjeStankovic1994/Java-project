package webshop.business;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import webshop.beans.model.ShoppingCartItem;
import webshop.model.Korisnik;
import webshop.model.Proizvod;

/**
 *
 * @author Djorde Stankovic
 */
@Local
public interface PurchaseBeanLocal {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean addPurchase(Korisnik korisnik, List<ShoppingCartItem> proizvodi, final String brojKartice);

}
