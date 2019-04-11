package webshop.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import webshop.model.Proizvod;

/**
 *
 * @author Djorde Stankovic
 */
@Stateless
public class ProductBean implements ProductBeanLocal {

    
    @PersistenceContext(unitName = "WebShop2PU")
    private EntityManager em;
    
    @Override
    public List<Proizvod> listAllProducts() {
        try {
            Query namedQuery = em.createNamedQuery("Proizvod.findAll");
            List<Proizvod> result = namedQuery.getResultList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  
}
