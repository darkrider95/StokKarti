package com.app.Model;
import java.util.Date;

public class StokKartlari {
    private String stokKodu;
    private String stokAdi;
    private Integer stokTipi;
    private String birimi;
    private String barkodu;
    private Double kdvTipi;
    private String aciklama;
    private Date olusturmaTarihi;

    public StokKartlari(){}

    public StokKartlari(String stokKodu, String stokAdi, Integer stokTipi, String birimi, String barkodu, Double kdvTipi, String aciklama, Date olusturmaTarihi) {
        this.stokKodu = stokKodu;
        this.stokAdi = stokAdi;
        this.stokTipi = stokTipi;
        this.birimi = birimi;
        this.barkodu = barkodu;
        this.kdvTipi = kdvTipi;
        this.aciklama = aciklama;
        this.olusturmaTarihi = olusturmaTarihi;
    }

    public String getStokKodu() {
        return stokKodu;
    }

    public void setStokKodu(String stokKodu) {
        this.stokKodu = stokKodu;
    }

    public String getStokAdi() {
        return stokAdi;
    }

    public void setStokAdi(String stokAdi) {
        this.stokAdi = stokAdi;
    }

    public Integer getStokTipi() {
        return stokTipi;
    }

    public void setStokTipi(Integer stokTipi) {
        this.stokTipi = stokTipi;
    }

    public String getBirimi() {
        return birimi;
    }

    public void setBirimi(String birimi) {
        this.birimi = birimi;
    }

    public String getBarkodu() {
        return barkodu;
    }

    public void setBarkodu(String barkodu) {
        this.barkodu = barkodu;
    }

    public Double getKdvTipi() {
        return kdvTipi;
    }

    public void setKdvTipi(Double kdvTipi) {
        this.kdvTipi = kdvTipi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getOlusturmaTarihi() {
        return olusturmaTarihi;
    }

    public void setOlusturmaTarihi(Date olusturmaTarihi) {
        this.olusturmaTarihi = olusturmaTarihi;
    }
}
