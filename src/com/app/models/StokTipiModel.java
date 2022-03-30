package com.app.models;

public class StokTipiModel {
    private String stokTipiKodu;
    private String stokTipiAdi;
    private String stokTipiAciklama;

    public StokTipiModel(){}

    public StokTipiModel(String stokTipiKodu, String stokTipiAdi, String stokTipiAciklama) {
        this.stokTipiKodu = stokTipiKodu;
        this.stokTipiAdi = stokTipiAdi;
        this.stokTipiAciklama = stokTipiAciklama;
    }

    public String getStokTipiKodu() {
        return stokTipiKodu;
    }

    public void setStokTipiKodu(String stokTipiKodu) {
        this.stokTipiKodu = stokTipiKodu;
    }

    public String getStokTipiAdi() {
        return stokTipiAdi;
    }

    public void setStokTipiAdi(String stokTipiAdi) {
        this.stokTipiAdi = stokTipiAdi;
    }

    public String getStokTipiAciklama() {
        return stokTipiAciklama;
    }

    public void setStokTipiAciklama(String stokTipiAciklama) {
        this.stokTipiAciklama = stokTipiAciklama;
    }
}
