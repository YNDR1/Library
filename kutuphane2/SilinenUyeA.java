/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane2;

/**
 *
 * @author KÜRŞAD
 */
public class SilinenUyeA {
      String isim, soyisim, no, tc, tarih;
    int  ID;

    public SilinenUyeA(String isim, String soyisim, String no, String tc, String tarih, int ID) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.no = no;
        this.tc = tc;
        this.tarih = tarih;
        this.ID = ID;
    }

    public SilinenUyeA(int ID) {
        this.ID = ID;
    }
    
    
}
