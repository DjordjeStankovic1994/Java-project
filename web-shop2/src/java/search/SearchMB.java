/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import baza.Proizvod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "searchMB",eager = true)
@SessionScoped
public class SearchMB implements Serializable{
    private String bojaIme;
    private List<String> rezultat;
    private List<String> data;
    private String Display="";
    @EJB
  private   SearchSessionBeanLocal searchBean;
   
//
//    public void  searchList(){
//        List<Proizvod> listaSearch = new ArrayList<>();
//listaSearch= searchBean.searchProizvodBean(bojaIme);
//    
//     }
    
    @PostConstruct
    public void init(){
        Proizvod pr = new Proizvod();
    data = new ArrayList();
    rezultat = new ArrayList();
 
     
    }
    
    public void pretraga(){
    rezultat.clear();
    for(String country: data){
        if(country.startsWith(Display)){
        rezultat.add(country);
        }
    
    }
    
    
    }

    public String getBojaIme() {
        return bojaIme;
    }

    public void setBojaIme(String bojaIme) {
        this.bojaIme = bojaIme;
    }

    public SearchSessionBeanLocal getSearchBean() {
        return searchBean;
    }

    public void setSearchBean(SearchSessionBeanLocal searchBean) {
        this.searchBean = searchBean;
    }

    public List<String> getRezultat() {
        return rezultat;
    }

    public void setRezultat(List<String> rezultat) {
        this.rezultat = rezultat;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getDisplay() {
        return Display;
    }

    public void setDisplay(String Display) {
        this.Display = Display;
    }

 
}
