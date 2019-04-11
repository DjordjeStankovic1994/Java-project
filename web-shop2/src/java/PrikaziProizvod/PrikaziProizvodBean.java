/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrikaziProizvod;

import baza.Proizvod;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class PrikaziProizvodBean implements PrikaziProizvodBeanLocal {
  @PersistenceContext(unitName = "WebApplication2PU")
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
