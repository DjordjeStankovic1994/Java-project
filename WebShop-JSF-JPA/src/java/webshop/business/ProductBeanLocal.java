package webshop.business;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import webshop.model.Proizvod;

@Local
public interface ProductBeanLocal {
    

    /**
     * 
     * @return 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Proizvod> listAllProducts();
    
}
