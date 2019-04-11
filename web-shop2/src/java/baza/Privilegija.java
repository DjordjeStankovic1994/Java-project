/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "privilegija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegija.findAll", query = "SELECT p FROM Privilegija p")
    , @NamedQuery(name = "Privilegija.findByIdPrivilegija", query = "SELECT p FROM Privilegija p WHERE p.idPrivilegija = :idPrivilegija")
    , @NamedQuery(name = "Privilegija.findByNaziv", query = "SELECT p FROM Privilegija p WHERE p.naziv = :naziv")})
public class Privilegija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_privilegija")
    private Integer idPrivilegija;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrivilegija")
    private List<Korisnik> korisnikList;

    public Privilegija() {
    }

    public Privilegija(Integer idPrivilegija) {
        this.idPrivilegija = idPrivilegija;
    }

    public Privilegija(Integer idPrivilegija, String naziv) {
        this.idPrivilegija = idPrivilegija;
        this.naziv = naziv;
    }

    public Integer getIdPrivilegija() {
        return idPrivilegija;
    }

    public void setIdPrivilegija(Integer idPrivilegija) {
        this.idPrivilegija = idPrivilegija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<Korisnik> getKorisnikList() {
        return korisnikList;
    }

    public void setKorisnikList(List<Korisnik> korisnikList) {
        this.korisnikList = korisnikList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivilegija != null ? idPrivilegija.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegija)) {
            return false;
        }
        Privilegija other = (Privilegija) object;
        if ((this.idPrivilegija == null && other.idPrivilegija != null) || (this.idPrivilegija != null && !this.idPrivilegija.equals(other.idPrivilegija))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Privilegija[ idPrivilegija=" + idPrivilegija + " ]";
    }
    
}
