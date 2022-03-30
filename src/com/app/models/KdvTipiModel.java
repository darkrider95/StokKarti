package com.app.models;

public class KdvTipiModel {
    private String kdvTipiKodu;
    private String kdvTipiAdi;
    private String kdvTipiAciklama;

    public KdvTipiModel() {
    }

    public KdvTipiModel(String kdvTipiKodu, String kdvTipiAdi, String kdvTipiAciklama) {
        this.kdvTipiKodu = kdvTipiKodu;
        this.kdvTipiAdi = kdvTipiAdi;
        this.kdvTipiAciklama = kdvTipiAciklama;
    }

    public String getKdvTipiKodu() {
        return kdvTipiKodu;
    }

    public void setKdvTipiKodu(String kdvTipiKodu) {
        this.kdvTipiKodu = kdvTipiKodu;
    }

    public String getKdvTipiAdi() {
        return kdvTipiAdi;
    }

    public void setKdvTipiAdi(String kdvTipiAdi) {
        this.kdvTipiAdi = kdvTipiAdi;
    }

    public String getKdvTipiAciklama() {
        return kdvTipiAciklama;
    }

    public void setKdvTipiAciklama(String kdvTipiAciklama) {
        this.kdvTipiAciklama = kdvTipiAciklama;
    }
}