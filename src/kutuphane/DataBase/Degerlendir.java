/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;
import javax.swing.DefaultListModel;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Sami
 */
public class Degerlendir {
    private String kitap_adi;
    private String degerlendirme;
    private String puan;
    private String kullanici_adi;
    
    public Degerlendir(String kitap_adi, String degerlendirme, String puan,String kullanici_adi) {
        this.kitap_adi = kitap_adi;
        this.degerlendirme = degerlendirme;
        this.puan = puan;
        this.kullanici_adi=kullanici_adi;
    }
    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

   
    public String getDegerlendirme() {
        return degerlendirme;
    }

    public void setDegerlendirme(String degerlendirme) {
        this.degerlendirme = degerlendirme;
    }

    
    public String getPuan() {
        return puan;
    }

    public void setPuan(String puan) {
        this.puan = puan;
    }

    
    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }
    
}
