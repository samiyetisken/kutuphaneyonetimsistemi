/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;

/**
 *
 * @author Sami
 */
public class BorrowKitap {
    private String kitapadi;
    private String yazar;
    private String sayfasayisi;
    private String kategori;
    private String username;
    

    public BorrowKitap(String kitapadi, String yazar,String sayfasayisi, String kategori, String username) {
        this.kitapadi = kitapadi;
        this.yazar = yazar;
        this.sayfasayisi=sayfasayisi;
        this.kategori = kategori;
        this.username = username;
        
    }

    public String getKitapadi() {
        return kitapadi;
    }

    public void setKitapadi(String kitapadi) {
        this.kitapadi = kitapadi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getSayfaSayisi(){
    return sayfasayisi;
    }
    public void setSayfaSayisi(String sayfasayisi){
    this.sayfasayisi=sayfasayisi;
    }
}
