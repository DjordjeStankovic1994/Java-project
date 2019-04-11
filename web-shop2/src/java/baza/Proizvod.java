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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "proizvod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proizvod.findAll", query = "SELECT p FROM Proizvod p")
    , @NamedQuery(name = "Proizvod.findById", query = "SELECT p FROM Proizvod p WHERE p.id = :id")
    , @NamedQuery(name = "Proizvod.findcenaBojaKolicina", query = "SELECT p FROM Proizvod p WHERE p.id = :id and p.cena = :cena and p.komada = :komada")
    , @NamedQuery(name = "Proizvod.findByCena", query = "SELECT p FROM Proizvod p WHERE p.cena = :cena")
    , @NamedQuery(name = "Proizvod.findByBoja", query = "SELECT p FROM Proizvod p WHERE p.boja = :boja")
    , @NamedQuery(name = "Proizvod.SearchByBoja", query = "SELECT p.boja FROM Proizvod p where p.boja = 'name' ")
    , @NamedQuery(name = "Proizvod.findByKomada", query = "SELECT p FROM Proizvod p WHERE p.komada = :komada")
    , @NamedQuery(name = "Proizvod.findBySlika", query = "SELECT p FROM Proizvod p WHERE p.slika = :slika")})
public class Proizvod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private int cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "boja")
    private String boja;
    @Column(name = "komada")
    private Integer komada;
    @Size(max = 45)
    @Column(name = "slika")
    private String slika;
    @ManyToMany(mappedBy = "proizvodList")
    private List<Kupovina> kupovinaList;
    @JoinColumn(name = "id_akcija", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Akcija idAkcija;
    @JoinColumn(name = "id_komentar", referencedColumnName = "idkomentar")
    @ManyToOne
    private Komentar idKomentar;
    @JoinColumn(name = "id_model", referencedColumnName = "id")
    @ManyToOne
    private Specifikacija idModel;
    @JoinColumn(name = "id_nazivproizvoda", referencedColumnName = "id_vrstaproizvoda")
    @ManyToOne(optional = false)
    private VrstaProizvoda idNazivproizvoda;

    public Proizvod() {
    }

    public Proizvod(Integer id) {
        this.id = id;
    }

    public Proizvod(Integer id, int cena, String boja) {
        this.id = id;
        this.cena = cena;
        this.boja = boja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public Integer getKomada() {
        return komada;
    }

    public void setKomada(Integer komada) {
        this.komada = komada;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @XmlTransient
    public List<Kupovina> getKupovinaList() {
        return kupovinaList;
    }

    public void setKupovinaList(List<Kupovina> kupovinaList) {
        this.kupovinaList = kupovinaList;
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

    public VrstaProizvoda getIdNazivproizvoda() {
        return idNazivproizvoda;
    }

    public void setIdNazivproizvoda(VrstaProizvoda idNazivproizvoda) {
        this.idNazivproizvoda = idNazivproizvoda;
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
        if (!(object instanceof Proizvod)) {
            return false;
        }
        Proizvod other = (Proizvod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Proizvod[ id=" + id + " ]";
    }
    
}
