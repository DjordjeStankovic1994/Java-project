/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import baza.Korisnik;
import baza.Proizvod;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class SearchSessionBean implements SearchSessionBeanLocal {
 @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;
    @Override
    public List<Proizvod> searchProizvodBean(String b) {
         try {
            Query query = em.createNamedQuery("Proizvod.SearchByBoja");
            query.setParameter("name", b);
//             Proizvod p =(Proizvod)query.getSingleResult();
        List<Proizvod> rezultat =query.getResultList();
          

           return rezultat; 
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


       
    }

   
}
