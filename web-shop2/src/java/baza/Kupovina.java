/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "kupovina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kupovina.findAll", query = "SELECT k FROM Kupovina k")
    , @NamedQuery(name = "Kupovina.findById", query = "SELECT k FROM Kupovina k WHERE k.id = :id")
    , @NamedQuery(name = "Kupovina.findByNazivProizvoda", query = "SELECT k FROM Kupovina k WHERE k.nazivProizvoda = :nazivProizvoda")
    , @NamedQuery(name = "Kupovina.findByCena", query = "SELECT k FROM Kupovina k WHERE k.cena = :cena")
    , @NamedQuery(name = "Kupovina.findByDatum", query = "SELECT k FROM Kupovina k WHERE k.datum = :datum")})
public class Kupovina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv_proizvoda")
    private String nazivProizvoda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cena")
    private String cena;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @JoinTable(name = "kupovina_proizvod", joinColumns = {
        @JoinColumn(name = "id_kupovina", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_proizvod", referencedColumnName = "id")})
    @ManyToMany
    private List<Proizvod> proizvodList;
    @JoinColumn(name = "id_korisnika", referencedColumnName = "id")
    @ManyToOne
    private Korisnik idKorisnika;

    public Kupovina() {
    }

    public Kupovina(Integer id) {
        this.id = id;
    }

    public Kupovina(Integer id, String nazivProizvoda, String cena) {
        this.id = id;
        this.nazivProizvoda = nazivProizvoda;
        this.cena = cena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @XmlTransient
    public List<Proizvod> getProizvodList() {
        return proizvodList;
    }

    public void setProizvodList(List<Proizvod> proizvodList) {
        this.proizvodList = proizvodList;
    }

    public Korisnik getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Korisnik idKorisnika) {
        this.idKorisnika = idKorisnika;
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
        if (!(object instanceof Kupovina)) {
            return false;
        }
        Kupovina other = (Kupovina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Kupovina[ id=" + id + " ]";
    }
    
}
