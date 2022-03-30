package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.DepoKartiModel;
import com.app.models.KdvTipiModel;
import com.app.views.KdvTipiFrame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KdvTipiDataCollector {
    public static ArrayList<KdvTipiModel> getKdvTipiList() {
        ArrayList<KdvTipiModel> kdvTipiList = new ArrayList<>();
        String query = "SELECT * FROM KdvTipi";
        KdvTipiModel obj;
        try {
            Statement st = JdbcUtil.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new KdvTipiModel();
                obj.setKdvTipiKodu(rs.getString("kdv_tipi_kodu"));
                obj.setKdvTipiAdi(rs.getString("kdv_tipi_adi"));
                obj.setKdvTipiAciklama(rs.getString("kdv_tipi_aciklama"));
                kdvTipiList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kdvTipiList;
    }

    public static boolean addKdvTipiKarti(KdvTipiModel kdvTipiKartlari) {
        String query = "INSERT INTO KdvTipi (kdv_tipi_kodu, kdv_tipi_adi, kdv_tipi_aciklama) VALUES (?,?,?)";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, kdvTipiKartlari.getKdvTipiKodu());
            pr.setString(2, kdvTipiKartlari.getKdvTipiAdi());
            pr.setString(3, kdvTipiKartlari.getKdvTipiAciklama());
            return pr.executeUpdate()  != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean deleteKdvTipiKarti(String kdvTipiKodu){
        String query = "DELETE FROM KdvTipi WHERE Kdv_Tipi_Kodu = ?";
        PreparedStatement pr = null;
        try {
            pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, kdvTipiKodu);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateKdvTipiKarti(KdvTipiModel kdvTipiKartlari) {
        String query = "UPDATE KdvTipi SET kdv_tipi_kodu =?,kdv_tipi_adi =?,kdv_tipi_aciklama =? WHERE kdv_tipi_kodu =?";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, kdvTipiKartlari.getKdvTipiKodu());
            pr.setString(2, kdvTipiKartlari.getKdvTipiAdi());
            pr.setString(3, kdvTipiKartlari.getKdvTipiAciklama());
            pr.setString(4, kdvTipiKartlari.getKdvTipiKodu());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}


