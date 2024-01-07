# Proje Başlığı

:information_source: **Dersin Kodu:** [16303](https://ebp.klu.edu.tr/Ders/dersDetay/YAZ16303/716026/tr)  
:information_source: **Dersin Adı:** [YAZILIM MİMARİSİ VE TASARIMI](https://ebp.klu.edu.tr/Ders/dersDetay/YAZ16303/716026/tr)  
:information_source: **Dersin Öğretim Elemanı:** Öğr. Gör. Dr. Fatih BAL  [Github](https://github.com/balfatih)   |    [Web Sayfası](https://balfatih.github.io/)
   
---

## Grup Bilgileri

|  Öğrenci No |       Adı Soyadı       |        Bölüm          		| Proje Grup No | Grup Üyelerinin Github Profilleri                 |
|-------------|------------------------|--------------------------|---------------|---------------------------------------------------|
| 1210505068  | Sami Yetişken			     | Yazılım Mühendisliği     | PROJE_5       | [Github](https://github.com/samiyetisken/)        |
| 1210505033  | Muhammed Eren Yüksel   | Yazılım Mühendisliği     | PROJE_5       | [Github](https://github.com/Eren075/)             |


---

## Proje Açıklaması


Projemiz Java Swing ve mySQL kullanılarak geliştirilmiş bir kütüphane yönetim sistemidir. Projemizde farklı tasarım desenleri kullanılmıştır. Projemizin amacı kütüphaneye kullanıcı ekleme, kaldırma, düzenleme; kitap ekleme, silme, düzenleme; ödünç alınan kitapları kimin aldığını görme, değerlendirme silme gibi adminlere has özellikler bulunur. Bir de herkesin erişebileceği kitap sayısı, kullanıcı sayını görme; kitap ödünç alma, iade etme, değerlendirme ekleme, ödünç aldığın kitapları görme, genel kitapları görme gibi özellikleri vardır.
---

## Proje Dosya Yapısı

Projenizin dosya yapısını açıklayan bir bölüm ekleyebilirsiniz. Örneğin:
- **/Kutuphane**
  - **/DataBase**
  - **/build/classes**
  - **/nbproject**
  - **/src/kutuphane/DataBase**
  - **/Kutuphane.java**
  - **/build.xml**
  - **/manifest.xml**
- **/mySQL**
    - `library.sql`

- `README.md`



---

## Kurulum

 Projemizi çalıştırmak için öncelikle verdiğimiz mySQL dosyasının içinde bulunan library.sql dosyasını çalıştırmanız gerekiyor. Sonra kullandığınız IDE ye Kutuphane projemizi eklemeniz gerekmektedir. ardından ise mySQL hesap bilgilerinizi projenin içinde yer alan DatabaseManeger kısmında düzenlemeniz gerekiyor. En önemlisi ise mysql-connector kullanmanız gerekiyor. 

---

## Kullanım

Projemizi kullanabilmeniz için öncelikle login.java dosyasını çalıştırıp "Admin" "123456" bilgileriyle giriş yapabilirsiniz. Daha sonra kullanıcı ayarları kısmından kullanıcı ekle tuşuna basarak farklı kullanıcılar ekleyerek giriş yapabilirsiniz. Projemizde bir kritik nokta var çıkış yaparken mutlaka çıkış yap tuşuna basılarak çıkılmalıdır. Aksi halde unutulursa bu library veritabanından giris tablosunun içindekileri "delete from giris;" koduyla silerek rahatlıkla kullanmaya devam edebilirsiniz.

---

## Katkılar

Projeyi yaparken ChatGPT, çeşitli youtube ve forum sayfaları, ders materyallerini ve çeşitli kütüphane yönetim sistemlerinden yararlandık.

---

## İletişim

Sami Yetişken = samiyetisken@gmail.com

Muhammed Eren Yüksel = m.eren003@hotmail.com  / instagram.com/muhammederenyuksel
