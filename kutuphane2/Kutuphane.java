/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane2;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
//import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;

/**
 *
 * @author KÜRŞAD
 */
public class Kutuphane implements Serializable {

    public ArrayList<UyeA> uyeler = new ArrayList<>();
    public ArrayList<KitapA> kitaplar = new ArrayList<>();
    public ArrayList<SilinenUyeA> SilinenUyeler = new ArrayList<>();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KutuphaneSonPU");
    EntityManager em = emf.createEntityManager();

    public void UyeEkle(UyeA uye) {

        uyeler.add(uye);

    }

    public void ArraylisteVeriEkle() {

        Query q = em.createQuery("SELECT u FROM Uye u");
        List<Uye> uyelerDB = q.getResultList();
        for (Uye uye : uyelerDB) {
            uyeler.add(new UyeA(uye.getId(), uye.getAdi(), uye.getSoyisim(), uye.getTelno(), uye.getTcno()));
        }

        Query w = em.createQuery("select k from Kitap k");
        List<Kitap> kitaplarDB = w.getResultList();
        for (Kitap kitap : kitaplarDB) {
            kitaplar.add(new KitapA(kitap.getNumara(), kitap.getAdi(), kitap.getYazari(), kitap.getSayfasayisi()));
        }
        Query e = em.createQuery("select uk from Uyekitap uk");
        List<Uyekitap> uyekitaplarDB = e.getResultList();
        for (int i = 0; i < uyeler.size(); i++) {
            System.out.println(" uyekitap ilk döngü");
            for (Uyekitap kitap : uyekitaplarDB) {
                System.out.println(" uyekitap ikinci döngü");
                if (kitap.getUyeid() == uyeler.get(i).ID) {
                    uyeler.get(i).UyeKitaplar.add(new KitapA(kitap.getKitapid(), kitap.getAdi(), kitap.getYazar(), kitap.getSayfa()));
                    System.out.println("uye databaseden kitap ekleme işlemi başarılı" + uyeler.get(i).isim + " " + kitap.getKitapid());
                }

            }

        }
        Query r = em.createQuery("select s from Silinenuye s");
        List<Silinenuye> silinenuyelerdb = r.getResultList();
        for (Silinenuye uye : silinenuyelerdb) {
            SilinenUyeler.add(new SilinenUyeA(uye.getAdi(), uye.getSoyadi(), uye.getTelno(), uye.getTcno(), uye.getTarih(), uye.getId()));
        }
    }

    public boolean DBuyeEkle(int ıd, String isim, String soyisim, String uyetel, String uyeTc) {
        boolean sonuc = false;
        boolean sonuc2 = false;

        Query uyeq = em.createQuery("select u from Uye u");
        List<Uye> uyelerDB = uyeq.getResultList();
        for (Uye uye : uyelerDB) {
            System.out.println(" döngü dbkitapekle");
            if (uye.getId() == ıd) {
                JOptionPane.showMessageDialog(null, "Bu ID'ye sahip bir Uye bulunuyor bu uyeyi ekleyemezsiniz.");
                sonuc2 = true;
                break;
            }
        }
        if (sonuc2 == false) {

            em.getTransaction().begin();
            Uye uye = new Uye(ıd, isim, soyisim, uyetel, uyeTc);
            em.persist(uye);
            em.getTransaction().commit();

            sonuc = true;
        }
        return sonuc;
    }

    public void DBkitapSil(int kitapID) {

        Query q = em.createQuery(" Delete From  Kitap k where k.numara=:pkitapID");
        q.setParameter("pkitapID", kitapID);
        
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();

    }

    public boolean DBkitapEkle(int ıd, String isim, String yazar, int sayfa) {
        boolean sonuc = false;
        boolean sonuc2 = false;

        Query w = em.createQuery("select k from Kitap k");
        List<Kitap> kitaplarDB = w.getResultList();
        for (Kitap kitap : kitaplarDB) {
            System.out.println(" döngü dbkitapekle");
            if (kitap.getNumara() == ıd) {
                JOptionPane.showMessageDialog(null, "Bu ID'ye sahip bir kitap bulunuyor bu kitabi ekleyemezsiniz.");
                sonuc2 = true;
                break;
            }
        }
        if (sonuc2 == false) {
            em.getTransaction().begin();
            Kitap kitapa = new Kitap(ıd, isim, yazar, sayfa);
            em.persist(kitapa);
            em.getTransaction().commit();

            sonuc = true;

        }
        return sonuc;
    }

    public boolean UyeyeKitapVer(int id, int kitapId) {
        boolean islem = false;
        for (int i = 0; i < uyeler.size(); i++) {
            if (id == (uyeler.get(i).ID)) {
                System.out.println("ilk if");
                if (uyeler.get(i).UyeKitaplar.size() == 0) {
                    System.out.println("ikinci if");
                    for (int j = 0; j < kitaplar.size(); j++) {
                        if (kitapId == (kitaplar.get(j).ID)) {
                            System.out.println("3 . if");
                            uyeler.get(i).UyeKitaplar.add(kitaplar.get(j));
                            islem = true;
                            JOptionPane.showMessageDialog(null, " Kitap ekleme işlemi başarılı ", " Uyarı ", JOptionPane.INFORMATION_MESSAGE);

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, " Uyede kitap bulunuyor", " Uyarı ", JOptionPane.WARNING_MESSAGE);
                }
            }

        }
        return islem;
    }

    public boolean UyedenKitapSil(int id) {
        boolean sonuc = false;
        for (int i = 0; i < uyeler.size(); i++) {

            if (id == uyeler.get(i).ID) {
                System.out.println("s ilk if");

                if (uyeler.get(i).UyeKitaplar.size() == 0) {
                    System.out.println(" s ikinci if");
                    JOptionPane.showMessageDialog(null, "Uye daha once kitap almamış", " Uyarı ", JOptionPane.WARNING_MESSAGE);
                    break;
                } else {

                    int a = JOptionPane.showConfirmDialog(null, " Uyeden kitap silinsin mi ? ", " Kitap Silme", JOptionPane.YES_NO_OPTION);
                    if (a == 0) {
                        uyeler.get(i).UyeKitaplar.removeAll(uyeler.get(i).UyeKitaplar);
                        sonuc = true;
                        JOptionPane.showMessageDialog(null, " Kitap Silme İşlemi Başarılı ", " Kitap Silindi", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return sonuc;
    }

    public boolean UyeSil(int id) {

        boolean sonuc = false;
        for (int i = 0; i < uyeler.size(); i++) {

            if (uyeler.get(i).ID == id) {
                if (uyeler.get(i).UyeKitaplar.size() != 0) {
                    JOptionPane.showMessageDialog(null, " Uyede Kitap bulunuyor uyeyi silemezsiniz  ", " Uyarı ", JOptionPane.WARNING_MESSAGE);
                } else {
                    uyeler.remove(uyeler.get(i));
                    sonuc = true;
                }
            }
        }
        return sonuc;
    }

    public void KitapEkle(KitapA k) {

        kitaplar.add(k);

    }

    public boolean KitapSil(int ıd) {
        boolean sonuc = false;

        for (int j = 0; j < kitaplar.size(); j++) {
            if (ıd == (kitaplar.get(j).ID)) {

                for (int i = 0; i < uyeler.size(); i++) {
                    if (uyeler.get(i).UyeKitaplar.contains(kitaplar.get(j))) {
                        JOptionPane.showMessageDialog(null, " Bu kitap Şu an bir uyede bulunuyor. Kitabı silemezsiniz.", " Kitap Uyede bulunuyor", JOptionPane.WARNING_MESSAGE);
                        sonuc = true;
                        break;
                    }
                }
                if (sonuc == false) {
                    kitaplar.remove(kitaplar.get(j));
                }
            }
        }
        System.out.println(sonuc);
        return sonuc;
    }

    public boolean KitapBaskasındaVarmı(int ıd) {
        boolean sonuc = true;

        for (KitapA kitap : kitaplar) {
            if (ıd == (kitap.ID)) {
                System.out.println(kitap.isim);
                System.out.println("Kitapbaşkasında varmı ilk if");
                for (UyeA uye : uyeler) {
                    System.out.println("Kitapbaşkasında varmı ilk for");
                    System.out.println(uye.UyeKitaplar.size());
                    if (uye.UyeKitaplar.size() != 0) {
                        if ((uye.UyeKitaplar.get(0).ID) == (kitap.ID)) {
                            System.out.println("Kitapbaşkasında varmı ikinci if");
                            JOptionPane.showMessageDialog(null, "Sectiginiz Kitap Daha once bir Uyeye verilmiş. Kitabı Uyeye veremezsiniz.", " Kitap Uyede bulunuyor", JOptionPane.WARNING_MESSAGE);
                            sonuc = false;
                            break;
                        }
                    }
                }

            }

        }
        System.out.println("Sonuc degeri = " + sonuc);
        return sonuc;

    }

    public void DBuyeKitapEkle(int Kitapid, String Kitapisim, String kitapyazar, int kitapsayfa, int uyeid) {

        em.getTransaction().begin();
        Uyekitap uyekitap = new Uyekitap(Kitapisim, kitapyazar, kitapsayfa, Kitapid, uyeid);
        em.persist(uyekitap);
        em.getTransaction().commit();

    }

    public void DBuyedenKitapSil(int Uyeid) {
        Query q = em.createQuery("delete from Uyekitap uk where uk.uyeid=:pUyeid");
        q.setParameter("pUyeid", Uyeid);
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();
    }
/*
    public boolean kitapsayısıyaz(int id) {
        boolean sonuc = false;
        for (int i = 0; i < uyeler.size(); i++) {
            if (id == (uyeler.get(i).ID)) {
                if (uyeler.get(i).UyeKitaplar.size() != 0) {
                    sonuc = true;
                }
            }
        }
        return sonuc;
    }
    */

    public void DBuyeSil(int id) {

        Query q = em.createQuery("Delete  From Uye u where u.id=:pUyeId");
        q.setParameter("pUyeId", id);
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();

    }

    public void DbSilinenUyeYaz(int id) {
        SimpleDateFormat bicim3 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        GregorianCalendar gcalender = new GregorianCalendar();
        String tarih = bicim3.format(gcalender.getTime());
        try {

            for (UyeA uyea : uyeler) {
                if (id == uyea.ID) {
                    em.getTransaction().begin();
                    Silinenuye uye = new Silinenuye(uyea.ID, uyea.isim, uyea.soyisim, uyea.tc, uyea.no, tarih);
                    em.persist(uye);
                    em.getTransaction().commit();

                }
            }
        } catch (RollbackException e) {
            JOptionPane.showMessageDialog(null, "Bu Tc Numarasına sahip bir uye daha once silinmiş. Ters Giden bişeyler var.", "Uyari", JOptionPane.WARNING_MESSAGE);

        }

    }

    

    public void DbSilinenuyeListedenSil(int id) {

        Query q = em.createQuery("Delete From Silinenuye s where s.id=:pUyeId");
        q.setParameter("pUyeId", id);
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();

    }
}
/*

 */
