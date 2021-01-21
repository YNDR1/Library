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
@Table(name = "UYEKITAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uyekitap.findAll", query = "SELECT u FROM Uyekitap u")
    , @NamedQuery(name = "Uyekitap.findByAdi", query = "SELECT u FROM Uyekitap u WHERE u.adi = :adi")
    , @NamedQuery(name = "Uyekitap.findByYazar", query = "SELECT u FROM Uyekitap u WHERE u.yazar = :yazar")
    , @NamedQuery(name = "Uyekitap.findBySayfa", query = "SELECT u FROM Uyekitap u WHERE u.sayfa = :sayfa")
    , @NamedQuery(name = "Uyekitap.findByKitapid", query = "SELECT u FROM Uyekitap u WHERE u.kitapid = :kitapid")
    , @NamedQuery(name = "Uyekitap.findByUyeid", query = "SELECT u FROM Uyekitap u WHERE u.uyeid = :uyeid")})
public class Uyekitap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "YAZAR")
    private String yazar;
    @Column(name = "SAYFA")
    private Integer sayfa;
    @Id
    @Basic(optional = false)
    @Column(name = "KITAPID")
    private Integer kitapid;
    @Column(name = "UYEID")
    private Integer uyeid;

    public Uyekitap() {
    }

    public Uyekitap(String adi, String yazar, Integer sayfa, Integer kitapid, Integer uyeid) {
        this.adi = adi;
        this.yazar = yazar;
        this.sayfa = sayfa;
        this.kitapid = kitapid;
        this.uyeid = uyeid;
    }

    public Uyekitap(Integer kitapid) {
        this.kitapid = kitapid;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public Integer getSayfa() {
        return sayfa;
    }

    public void setSayfa(Integer sayfa) {
        this.sayfa = sayfa;
    }

    public Integer getKitapid() {
        return kitapid;
    }

    public void setKitapid(Integer kitapid) {
        this.kitapid = kitapid;
    }

    public Integer getUyeid() {
        return uyeid;
    }

    public void setUyeid(Integer uyeid) {
        this.uyeid = uyeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kitapid != null ? kitapid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uyekitap)) {
            return false;
        }
        Uyekitap other = (Uyekitap) object;
        if ((this.kitapid == null && other.kitapid != null) || (this.kitapid != null && !this.kitapid.equals(other.kitapid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kutuphane2.Uyekitap[ kitapid=" + kitapid + " ]";
    }
    
}
