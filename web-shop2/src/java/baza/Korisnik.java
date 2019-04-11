/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findById", query = "SELECT k FROM Korisnik k WHERE k.id = :id")
    , @NamedQuery(name = "Korisnik.findByINameAndSurname", query = "SELECT k FROM Korisnik k WHERE k.ime = :ime and k.prezime = :prezime ")
    , @NamedQuery(name = "Korisnik.findByIme", query = "SELECT k FROM Korisnik k WHERE k.ime = :ime")
    , @NamedQuery(name = "Korisnik.findByPrezime", query = "SELECT k FROM Korisnik k WHERE k.prezime = :prezime")
    , @NamedQuery(name = "Korisnik.findByAdresa", query = "SELECT k FROM Korisnik k WHERE k.adresa = :adresa")
    , @NamedQuery(name = "Korisnik.findByBrojKartice", query = "SELECT k FROM Korisnik k WHERE k.brojKartice = :brojKartice")
    , @NamedQuery(name = "Korisnik.findByBrojTelefona", query = "SELECT k FROM Korisnik k WHERE k.brojTelefona = :brojTelefona")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prezime")
    private String prezime;
    @Size(max = 45)
    @Column(name = "adresa")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "broj_kartice")
    private int brojKartice;
    @Column(name = "broj_telefona")
    private Integer brojTelefona;
    @OneToMany(mappedBy = "idKorisnika")
    private List<Kupovina> kupovinaList;
    @OneToMany(mappedBy = "idKorisnik")
    private List<Pitanja> pitanjaList;
    @JoinColumn(name = "id_privilegija", referencedColumnName = "id_privilegija")
    @ManyToOne(optional = false)
    private Privilegija idPrivilegija;

    public Korisnik() {
    }

    public Korisnik(Integer id) {
        this.id = id;
    }

    public Korisnik(Integer id, String ime, String prezime, int brojKartice) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.brojKartice = brojKartice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(int brojKartice) {
        this.brojKartice = brojKartice;
    }

    public Integer getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(Integer brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @XmlTransient
    public List<Kupovina> getKupovinaList() {
        return kupovinaList;
    }

    public void setKupovinaList(List<Kupovina> kupovinaList) {
        this.kupovinaList = kupovinaList;
    }

    @XmlTransient
    public List<Pitanja> getPitanjaList() {
        return pitanjaList;
    }

    public void setPitanjaList(List<Pitanja> pitanjaList) {
        this.pitanjaList = pitanjaList;
    }

    public Privilegija getIdPrivilegija() {
        return idPrivilegija;
    }

    public void setIdPrivilegija(Privilegija idPrivilegija) {
        this.idPrivilegija = idPrivilegija;
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
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Korisnik[ id=" + id + " ]";
    }
    
}
