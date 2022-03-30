package com.app.models;

public class DepoKartiModel {
    private String depoKodu;
    private String depoAdi;
    private String depoAciklama;

    public DepoKartiModel(){}

    public DepoKartiModel(String depoKodu, String depoAdi, String depoAciklama) {
        this.depoKodu = depoKodu;
        this.depoAdi = depoAdi;
        this.depoAciklama = depoAciklama;
    }

    public String getDepoKodu() {
        return depoKodu;
    }

    public void setDepoKodu(String depoKodu) {
        this.depoKodu = depoKodu;
    }

    public String getDepoAdi() {
        return depoAdi;
    }

    public void setDepoAdi(String depoAdi) {
        this.depoAdi = depoAdi;
    }

    public String getDepoAciklama() {
        return depoAciklama;
    }

    public void setDepoAciklama(String depoAciklama) {
        this.depoAciklama = depoAciklama;
    }
}
