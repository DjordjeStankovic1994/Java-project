
package dodajProizvod;

import baza.Korisnik;
import baza.Proizvod;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.model.UploadedFile;


@Stateless
public class ProizvodBean implements ProizvodBeanLocal {
    
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

    @Override
    public boolean dodajProizvod(String boja,int kolicina,int cena, String slika) {
      
  
    

    

try {

            Proizvod noviProizvod = new Proizvod();
            noviProizvod.setBoja(boja);       
            noviProizvod.setCena(cena);
            noviProizvod.setKomada(kolicina);
            noviProizvod.setSlika(slika);
            
           
            
            em.persist(noviProizvod);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        return false;
        }

    
}

    @Override
    public Proizvod uploadImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}