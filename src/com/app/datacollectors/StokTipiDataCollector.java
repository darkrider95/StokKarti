package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.KdvTipiModel;
import com.app.models.StokTipiModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StokTipiDataCollector {
    public static ArrayList<StokTipiModel> getStokTipiList() {
        ArrayList<StokTipiModel> stokTipiList = new ArrayList<>();
        String query = "SELECT * FROM StokTipi";
        StokTipiModel obj;
        try {
            Statement st = JdbcUtil.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new StokTipiModel();
                obj.setStokTipiKodu(rs.getString("stok_tipi_kodu"));
                obj.setStokTipiAdi(rs.getString("stok_tipi_adi"));
                obj.setStokTipiAciklama(rs.getString("stok_tipi_aciklama"));
                stokTipiList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stokTipiList;
    }

    public static boolean addStokTipiKarti(StokTipiModel stokTipiKartlari) {
        String query = "INSERT INTO StokTipi (stok_tipi_kodu, stok_tipi_adi, stok_tipi_aciklama) VALUES (?,?,?)";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, stokTipiKartlari.getStokTipiKodu());
            pr.setString(2, stokTipiKartlari.getStokTipiAdi());
            pr.setString(3, stokTipiKartlari.getStokTipiAciklama());
            return pr.executeUpdate()  != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean deleteStokTipiKarti(String stokTipiKodu){
        String query = "DELETE FROM StokTipi WHERE Stok_Tipi_Kodu = ?";
        PreparedStatement pr = null;
        try {
            pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, stokTipiKodu);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean updateStokTipiKarti(StokTipiModel stokTipiKartlari) {
        String query = "UPDATE StokTipi SET stok_tipi_kodu =?,stok_tipi_adi =?,stok_tipi_aciklama =? WHERE stok_tipi_kodu =?";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, stokTipiKartlari.getStokTipiKodu());
            pr.setString(2, stokTipiKartlari.getStokTipiAdi());
            pr.setString(3, stokTipiKartlari.getStokTipiAciklama());
            pr.setString(4, stokTipiKartlari.getStokTipiKodu());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
