/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package korpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "korpaMB", eager = true)
@SessionScoped
public class korpaMB implements Serializable{
    List<Cart> listCart = new ArrayList<>();
    Map<Integer, Cart> mapCart = new HashMap<Integer, Cart>();
    int proizvodID;
      String boja;
    int cena;
    int komada;
    int total;
    int cartSize;

    public List<Cart> getListCart() {
        return listCart;
    }

    public int getCartSize() {
        return cartSize;
    }

    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }

    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getKomada() {
        return komada;
    }

    public void setKomada(int komada) {
        this.komada = komada;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<Integer, Cart> getMapCart() {
        return mapCart;
    }

    public void setMapCart(Map<Integer, Cart> mapCart) {
        this.mapCart = mapCart;
    }

  public String processCart(){
      Cart cart = new Cart();
      cart.setBoja(boja);
      cart.setCena(cena);
      cart.setKomada(komada);
      cart.setTotal(komada*cena);
      listCart.add(cart);
      mapCart.put(proizvodID, cart);
      cartSize=listCart.size();
  
  return null;
  }  

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }
}
