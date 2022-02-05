package com.app.Model;

import com.app.Helper.jdbc;
import com.sun.source.tree.WhileLoopTree;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StokKartlari {
    private String stok_kodu;
    private String stok_adi;
    private Integer stok_tipi;
    private String birimi;
    private String barkodu;
    private Double kdv_tipi;
    private String aciklama;
    private Date olusturma_tarihi;

    public StokKartlari(){}

    public StokKartlari(String stok_kodu, String stok_adi, Integer stok_tipi, String birimi, String barkodu, Double kdv_tipi, String aciklama, Date olusturma_tarihi) {
        this.stok_kodu = stok_kodu;
        this.stok_adi = stok_adi;
        this.stok_tipi = stok_tipi;
        this.birimi = birimi;
        this.barkodu = barkodu;
        this.kdv_tipi = kdv_tipi;
        this.aciklama = aciklama;
        this.olusturma_tarihi = olusturma_tarihi;
    }

    public String getStok_kodu() {
        return stok_kodu;
    }

    public void setStok_kodu(String stok_kodu) {
        this.stok_kodu = stok_kodu;
    }

    public String getStok_adi() {
        return stok_adi;
    }

    public void setStok_adi(String stok_adi) {
        this.stok_adi = stok_adi;
    }

    public Integer getStok_tipi() {
        return stok_tipi;
    }

    public void setStok_tipi(Integer stok_tipi) {
        this.stok_tipi = stok_tipi;
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

    public Double getKdv_tipi() {
        return kdv_tipi;
    }

    public void setKdv_tipi(Double kdv_tipi) {
        this.kdv_tipi = kdv_tipi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getOlusturma_tarihi() {
        return olusturma_tarihi;
    }

    public void setOlusturma_tarihi(Date olusturma_tarihi) {
        this.olusturma_tarihi = olusturma_tarihi;
    }



    public static ArrayList<StokKartlari> getList() {
        ArrayList<StokKartlari> stokList = new ArrayList<>();
        String query = "SELECT * FROM StokKartlari";
        StokKartlari obj;
        try {
            Statement st = jdbc.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new StokKartlari();
                obj.setStok_kodu(rs.getString("stok_kodu"));
                obj.setStok_adi(rs.getString("stok_adi"));
                obj.setStok_tipi(rs.getInt("stok_tipi"));
                obj.setBirimi(rs.getString("birimi"));
                obj.setBarkodu(rs.getString("barkodu"));
                obj.setKdv_tipi(rs.getDouble("kdv_tipi"));
                obj.setAciklama(rs.getString("aciklama"));
                obj.setOlusturma_tarihi(rs.getDate("olusturma_tarihi"));
                stokList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stokList;
    }

}
