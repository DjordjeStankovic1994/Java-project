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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "gost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gost.findAll", query = "SELECT g FROM Gost g")
    , @NamedQuery(name = "Gost.findById", query = "SELECT g FROM Gost g WHERE g.id = :id")
    , @NamedQuery(name = "Gost.findByIme", query = "SELECT g FROM Gost g WHERE g.ime = :ime")
    , @NamedQuery(name = "Gost.findByPrezime", query = "SELECT g FROM Gost g WHERE g.prezime = :prezime")
    , @NamedQuery(name = "Gost.findByDokument", query = "SELECT g FROM Gost g WHERE g.dokument = :dokument")})
public class Gost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "dokument")
    private String dokument;
    @JoinTable(name = "rezervacija_gosti", joinColumns = {
        @JoinColumn(name = "id_gost", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rezervacija", referencedColumnName = "id")})
    @ManyToMany
    private List<Rezervacija> rezervacijaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gostId")
    private List<Rezervacija> rezervacijaList1;
    @JoinColumn(name = "adresa_id", referencedColumnName = "id")
    @ManyToOne
    private Adresa adresaId;

    public Gost() {
    }

    public Gost(Integer id) {
        this.id = id;
    }

    public Gost(Integer id, String ime) {
        this.id = id;
        this.ime = ime;
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

    public String getDokument() {
        return dokument;
    }

    public void setDokument(String dokument) {
        this.dokument = dokument;
    }

    @XmlTransient
    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }

    @XmlTransient
    public List<Rezervacija> getRezervacijaList1() {
        return rezervacijaList1;
    }

    public void setRezervacijaList1(List<Rezervacija> rezervacijaList1) {
        this.rezervacijaList1 = rezervacijaList1;
    }

    public Adresa getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Adresa adresaId) {
        this.adresaId = adresaId;
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
        if (!(object instanceof Gost)) {
            return false;
        }
        Gost other = (Gost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotel.business.model.Gost[ id=" + id + " ]";
    }
    
}
