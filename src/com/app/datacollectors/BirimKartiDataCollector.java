package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.BirimKartiModel;
import com.app.models.DepoKartiModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BirimKartiDataCollector {
    public static ArrayList<BirimKartiModel> getBirimKartiList() {
        ArrayList<BirimKartiModel> birimKartiList = new ArrayList<>();
        String query = "SELECT * FROM BirimKarti";
        BirimKartiModel obj;
        try {
            Statement st = JdbcUtil.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new BirimKartiModel();
                obj.setBirimKartiKodu(rs.getString("birim_karti_kodu"));
                obj.setBirimKartiAdi(rs.getString("birim_karti_adi"));
                obj.setBirimKartiAciklama(rs.getString("birim_karti_aciklama"));
                birimKartiList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return birimKartiList;
    }

    public static boolean addBirimKarti(BirimKartiModel birimKartlari) {
        String query = "INSERT INTO BirimKarti (birim_karti_kodu, birim_karti_adi, birim_karti_aciklama) VALUES (?,?,?)";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, birimKartlari.getBirimKartiKodu());
            pr.setString(2, birimKartlari.getBirimKartiAdi());
            pr.setString(3, birimKartlari.getBirimKartiAciklama());
            return pr.executeUpdate()  != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean deleteBirimKarti(String birimKodu){
        String query = "DELETE FROM BirimKarti WHERE birim_karti_kodu = ?";
        PreparedStatement pr = null;
        try {
            pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, birimKodu);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateBirimKarti(BirimKartiModel birimKartlari) {
        String query = "UPDATE BirimKarti SET birim_karti_kodu =?,birim_karti_adi =?,birim_karti_aciklama =? WHERE birim_karti_kodu =?";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, birimKartlari.getBirimKartiKodu());
            pr.setString(2, birimKartlari.getBirimKartiAdi());
            pr.setString(3, birimKartlari.getBirimKartiAciklama());
            pr.setString(4, birimKartlari.getBirimKartiKodu());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}