/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KÜRŞAD
 */
@Entity
@Table(name = "KITAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitap.findAll", query = "SELECT k FROM Kitap k")
    , @NamedQuery(name = "Kitap.findByNumara", query = "SELECT k FROM Kitap k WHERE k.numara = :numara")
    , @NamedQuery(name = "Kitap.findByAdi", query = "SELECT k FROM Kitap k WHERE k.adi = :adi")
    , @NamedQuery(name = "Kitap.findByYazari", query = "SELECT k FROM Kitap k WHERE k.yazari = :yazari")
    , @NamedQuery(name = "Kitap.findBySayfasayisi", query = "SELECT k FROM Kitap k WHERE k.sayfasayisi = :sayfasayisi")})
public class Kitap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMARA")
    private Integer numara;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "YAZARI")
    private String yazari;
    @Column(name = "SAYFASAYISI")
    private Integer sayfasayisi;

    public Kitap() {
    }

    public Kitap(Integer numara, String adi, String yazari, Integer sayfasayisi) {
        this.numara = numara;
        this.adi = adi;
        this.yazari = yazari;
        this.sayfasayisi = sayfasayisi;
    }
    

    public Kitap(Integer numara) {
        this.numara = numara;
    }

    public Integer getNumara() {
        return numara;
    }

    public void setNumara(Integer numara) {
        this.numara = numara;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getYazari() {
        return yazari;
    }

    public void setYazari(String yazari) {
        this.yazari = yazari;
    }

    public Integer getSayfasayisi() {
        return sayfasayisi;
    }

    public void setSayfasayisi(Integer sayfasayisi) {
        this.sayfasayisi = sayfasayisi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numara != null ? numara.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitap)) {
            return false;
        }
        Kitap other = (Kitap) object;
        if ((this.numara == null && other.numara != null) || (this.numara != null && !this.numara.equals(other.numara))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kutuphane2.Kitap[ numara=" + numara + " ]";
    }
    
}
