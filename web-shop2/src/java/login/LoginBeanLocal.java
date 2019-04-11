/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import baza.Korisnik;
import javax.ejb.Local;

/**
 *
 * @author Asus
 */
@Local
public interface LoginBeanLocal {
    public Korisnik login(String name, String surname);
    
}
