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
public class KitapA {
       
    String isim, yazar;
    int sayfa, ID;

    public KitapA() {
    }

    
    public KitapA(int ID,String isim, String yazar, int sayfa) {
        this.isim = isim;
        this.yazar = yazar;
        this.sayfa = sayfa;
        this.ID=ID;
    }
    
    
    
}
