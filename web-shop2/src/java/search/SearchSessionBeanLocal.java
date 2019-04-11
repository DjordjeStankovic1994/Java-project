
package search;

import baza.Proizvod;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Local
public interface SearchSessionBeanLocal {
    
     
    public List<Proizvod> searchProizvodBean(String boja);
    
}
