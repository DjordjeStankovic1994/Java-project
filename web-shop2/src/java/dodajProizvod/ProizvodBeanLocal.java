/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodajProizvod;

import baza.Proizvod;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Asus
 */
@Local
public interface ProizvodBeanLocal {
      @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
      public boolean dodajProizvod(String boja,int kolicina,int cena,String slika);
      
      public Proizvod uploadImage();
}
