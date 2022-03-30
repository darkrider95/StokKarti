package com.app.models;

public class BirimKartiModel {
    private String birimKartiKodu;
    private String birimKartiAdi;
    private String birimKartiAciklama;

    public BirimKartiModel(){}

    public BirimKartiModel(String birimKartiKodu, String birimKartiAdi, String birimKartiAciklama) {
        this.birimKartiKodu = birimKartiKodu;
        this.birimKartiAdi = birimKartiAdi;
        this.birimKartiAciklama = birimKartiAciklama;
    }

    public String getBirimKartiKodu() {
        return birimKartiKodu;
    }

    public void setBirimKartiKodu(String birimKartiKodu) {
        this.birimKartiKodu = birimKartiKodu;
    }

    public String getBirimKartiAdi() {
        return birimKartiAdi;
    }

    public void setBirimKartiAdi(String birimKartiAdi) {
        this.birimKartiAdi = birimKartiAdi;
    }

    public String getBirimKartiAciklama() {
        return birimKartiAciklama;
    }

    public void setBirimKartiAciklama(String birimKartiAciklama) {
        this.birimKartiAciklama = birimKartiAciklama;
    }
}

