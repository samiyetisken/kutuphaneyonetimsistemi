/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;

/**
 *
 * @author Sami
 */
public class Kitap extends BaseKitap {

    private String kitapadi;
    private String yazar;
    private String kategori;
    private String sayfasayisi;

    public Kitap(String kitapadi, String yazar, String kategori,String sayfasayisi) {
        this.kitapadi = kitapadi;
        this.yazar = yazar;
        this.kategori = kategori;
        this.sayfasayisi=sayfasayisi;
    }

    public String getSayfasayisi() {
        return sayfasayisi;
    }

    public void setSayfasayisi(String sayfasayisi) {
        this.sayfasayisi = sayfasayisi;
    }

    @Override
    public String getKitapadi() {
        return kitapadi;
    }

    public void setKitapadi(String kitapadi) {
        this.kitapadi = kitapadi;
    }

    @Override
    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    @Override
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
