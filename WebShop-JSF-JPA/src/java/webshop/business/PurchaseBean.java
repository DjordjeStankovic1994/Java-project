package webshop.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import webshop.beans.model.ShoppingCartItem;
import webshop.model.Korisnik;
import webshop.model.Kupovina;
import webshop.model.KupovinaProizvodi;

/**
 *
 * @author Djorde Stankovic
 */
@Stateless
public class PurchaseBean implements PurchaseBeanLocal {

    @PersistenceContext(unitName = "WebShop2PU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean addPurchase(Korisnik korisnik, List<ShoppingCartItem> cartItems, final String brojKartice) {
        if (korisnik == null || cartItems == null || cartItems.size() == 0) {
            return false;
        }

        Kupovina kupovina = new Kupovina();
        kupovina.setBrojKartice(brojKartice);
        kupovina.setIme(korisnik.getIme());
        kupovina.setPrezime(korisnik.getPrezime());
        kupovina.setIdKorisnik(korisnik);

        List<KupovinaProizvodi> kpList = new ArrayList<KupovinaProizvodi>();
        int totalPrice = 0;
        for (ShoppingCartItem item : cartItems) {
            KupovinaProizvodi kp = new KupovinaProizvodi();
            kp.setProizvodId(item.getProduct());
            kp.setKolicina(item.getProductNum());
            kp.setKupovinaId(kupovina);
            totalPrice += (item.getProductNum() * item.getProduct().getCena());
            kpList.add(kp);
        }

        kupovina.setKupovinaProizvodiList(kpList);
        kupovina.setCena(totalPrice);

        try {
            em.persist(kupovina);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
