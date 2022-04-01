package com.app.models;

import java.util.Date;

public class BaseDataModel {

    private String masterField;
    private String adi;
    private Integer tipi;
    private String birimi;
    private String barkodu;
    private Double kdvTipi;
    private String aciklama;
    private Date olusturmaTarihi;

    public BaseDataModel(){
    }

    public Integer getTipi() {
        return tipi;
    }

    public void setTipi(Integer tipi) {
        this.tipi = tipi;
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

    public String getAdi(){
     return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getMasterField(){
        return masterField;

    }

    public void setMasterField(String masterField) {
        this.masterField = masterField;
    }
}
