# StokKarti

### Study Case 
Java programlama dili ile geliştirilecek bir masaüstü uygulaması.

Veritabanı bağlantısı için mysql-connector,

Arayüz için Java Swing kullanılacak.

Uygulamada olması gereken fonksiyonlar;
* Ekle
* Sil
* Güncelle
* Kopyala
* Listele
* Stok kartına ait bütün bilgilerin componentlerde görünmesi
* Arama

# Veritabanı İşlemleri


* MySQL Kurulumu
```
sudo apt install mysql-server
sudo mysql_secure_installation
```
* Veritabanı ve kullanıcı oluşturma
```
mysql -u root -p

mysql> CREATE DATABASE stok CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
    -> CREATE USER 'haluk'@'localhost' IDENTIFIED BY 'PASSWORD';
    -> GRANT ALL ON stok.* TO 'haluk'@'localhost'; FLUSH PRIVILEGES;
    -> EXIT;
```
* Kullanıcı girişi yapıp veritabanında istenen özelliklerde tablo oluşturma
```sql
mysql -u haluk -p
mysql> USE stok;
mysql> CREATE TABLE StokKartlari(
    -> stok_kodu VARCHAR(50) PRIMARY KEY NOT NULL,
    -> stok_adi VARCHAR(100) NOT NULL,
    -> stok_tipi INT(2) NOT NULL,
    -> birimi VARCHAR(10) NOT NULL,
    -> barkodu VARCHAR(30) NOT NULL,
    -> kdv_tipi DOUBLE NOT NULL,
    -> aciklama TEXT,
    -> olusturma_tarihi DATETIME);
```
* Java - MySQL bağlantısı için izlenecek adımlar;

[install mysql-connector](https://www.mysql.com/products/connector/)

[Java mysql veritabanı bağlantısı nasıl yapılır](https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database/)


* Veritabanı işlemleri için aşağıdaki siteden istediğimiz özelliklerde sahte veri oluşturabiliriz.
  https://www.mockaroo.com/

