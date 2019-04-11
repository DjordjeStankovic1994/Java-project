/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "dodatna_oprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DodatnaOprema.findAll", query = "SELECT d FROM DodatnaOprema d")
    , @NamedQuery(name = "DodatnaOprema.findById", query = "SELECT d FROM DodatnaOprema d WHERE d.id = :id")
    , @NamedQuery(name = "DodatnaOprema.findByNaziv", query = "SELECT d FROM DodatnaOprema d WHERE d.naziv = :naziv")
    , @NamedQuery(name = "DodatnaOprema.findByCena", query = "SELECT d FROM DodatnaOprema d WHERE d.cena = :cena")})
public class DodatnaOprema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cena")
    private String cena;
    @JoinColumn(name = "id_akcija", referencedColumnName = "id")
    @ManyToOne
    private Akcija idAkcija;
    @JoinColumn(name = "id_komentar", referencedColumnName = "idkomentar")
    @ManyToOne
    private Komentar idKomentar;
    @JoinColumn(name = "id_model", referencedColumnName = "id")
    @ManyToOne
    private Specifikacija idModel;

    public DodatnaOprema() {
    }

    public DodatnaOprema(Integer id) {
        this.id = id;
    }

    public DodatnaOprema(Integer id, String naziv, String cena) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Akcija getIdAkcija() {
        return idAkcija;
    }

    public void setIdAkcija(Akcija idAkcija) {
        this.idAkcija = idAkcija;
    }

    public Komentar getIdKomentar() {
        return idKomentar;
    }

    public void setIdKomentar(Komentar idKomentar) {
        this.idKomentar = idKomentar;
    }

    public Specifikacija getIdModel() {
        return idModel;
    }

    public void setIdModel(Specifikacija idModel) {
        this.idModel = idModel;
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
        if (!(object instanceof DodatnaOprema)) {
            return false;
        }
        DodatnaOprema other = (DodatnaOprema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.DodatnaOprema[ id=" + id + " ]";
    }
    
}
