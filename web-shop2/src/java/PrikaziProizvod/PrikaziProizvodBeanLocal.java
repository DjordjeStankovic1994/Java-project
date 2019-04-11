/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrikaziProizvod;

import baza.Proizvod;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Asus
 */
@Local
public interface PrikaziProizvodBeanLocal {
       @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Proizvod> listAllProducts();
    

}
