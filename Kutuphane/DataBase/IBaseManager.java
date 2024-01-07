/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kutuphane.DataBase;

/**
 *
 * @author Sami
 */
public interface IBaseManager {
void insert(String ad,String yazar,String kategori,String userName,String sayfasayisi);
void delete(String ad);
void edit(String kitapadi, String yazar, String sayfasayisi, String kategori);
}
