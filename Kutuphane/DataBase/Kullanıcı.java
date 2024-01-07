/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kutuphane.DataBase;

/**
 *
 * @author Sami
 */
public class Kullanıcı {
    private String ad;
    private String soyad;
    private String userName;
    private String password;
    private String unvan;

    public Kullanıcı(String ad,String soyad,String userName,String password,String unvan)
    {
        this.ad = ad;
        this.soyad = soyad;
        this.userName = userName;
        this.password = password;
        this.unvan=unvan;
    }
}
