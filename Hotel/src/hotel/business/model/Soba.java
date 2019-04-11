/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.business.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vboskovic
 */
@Entity
@Table(name = "soba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soba.findAll", query = "SELECT s FROM Soba s")
    , @NamedQuery(name = "Soba.findById", query = "SELECT s FROM Soba s WHERE s.id = :id")
    , @NamedQuery(name = "Soba.findByOznaka", query = "SELECT s FROM Soba s WHERE s.oznaka = :oznaka")
    , @NamedQuery(name = "Soba.findByBrojMesta", query = "SELECT s FROM Soba s WHERE s.brojMesta = :brojMesta")
    , @NamedQuery(name = "Soba.findByCena", query = "SELECT s FROM Soba s WHERE s.cena = :cena")})
public class Soba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "oznaka")
    private String oznaka;
    @Basic(optional = false)
    @Column(name = "broj_mesta")
    private int brojMesta;
    @Basic(optional = false)
    @Column(name = "cena")
    private long cena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sobaId")
    private List<Rezervacija> rezervacijaList;

    public Soba() {
    }

    public Soba(Integer id) {
        this.id = id;
    }

    public Soba(Integer id, String oznaka, int brojMesta, long cena) {
        this.id = id;
        this.oznaka = oznaka;
        this.brojMesta = brojMesta;
        this.cena = cena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
    }

    @XmlTransient
    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotel.business.model.Soba[ id=" + id + " ]";
    }
    
}
