/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author KÜRŞAD
 */
public class UyeA implements Serializable {
    ArrayList<KitapA> UyeKitaplar = new ArrayList<>();
    
    String isim, soyisim, no, tc;
    int  ID;
   

    public UyeA(int ID, String isim, String soyisim, String no, String tc) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.no = no;
        this.tc = tc;
        this.ID=ID;
    }
}
