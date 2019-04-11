/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "pitanja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pitanja.findAll", query = "SELECT p FROM Pitanja p")
    , @NamedQuery(name = "Pitanja.findById", query = "SELECT p FROM Pitanja p WHERE p.id = :id")
    , @NamedQuery(name = "Pitanja.findByDatum", query = "SELECT p FROM Pitanja p WHERE p.datum = :datum")})
public class Pitanja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "text")
    private String text;
    @JoinColumn(name = "id_korisnik", referencedColumnName = "id")
    @ManyToOne
    private Korisnik idKorisnik;

    public Pitanja() {
    }

    public Pitanja(Integer id) {
        this.id = id;
    }

    public Pitanja(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Korisnik getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Korisnik idKorisnik) {
        this.idKorisnik = idKorisnik;
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
        if (!(object instanceof Pitanja)) {
            return false;
        }
        Pitanja other = (Pitanja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Pitanja[ id=" + id + " ]";
    }
    
}
