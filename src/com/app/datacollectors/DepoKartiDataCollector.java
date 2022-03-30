package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.DepoKartiModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepoKartiDataCollector {
    public static ArrayList<DepoKartiModel> getDepoKartlariList() {
        ArrayList<DepoKartiModel> depoList = new ArrayList<>();
        String query = "SELECT * FROM Depo";
        DepoKartiModel obj;
        try {
            Statement st = JdbcUtil.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new DepoKartiModel();
                obj.setDepoKodu(rs.getString("depo_kodu"));
                obj.setDepoAdi(rs.getString("depo_adi"));
                obj.setDepoAciklama(rs.getString("depo_aciklama"));
                depoList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depoList;
    }

    public static boolean addDepoKarti(DepoKartiModel depoKartlari) {
        String query = "INSERT INTO Depo (depo_kodu, depo_adi, depo_aciklama) VALUES (?,?,?)";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, depoKartlari.getDepoKodu());
            pr.setString(2, depoKartlari.getDepoAdi());
            pr.setString(3, depoKartlari.getDepoAciklama());
            return pr.executeUpdate()  != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean deleteDepoKarti(String depoKodu){
        String query = "DELETE FROM Depo WHERE Depo_Kodu = ?";
        PreparedStatement pr = null;
        try {
            pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, depoKodu);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateDepoKarti(DepoKartiModel depoKartlari) {
        String query = "UPDATE Depo SET depo_kodu =?,depo_adi =?,depo_aciklama =? WHERE depo_kodu =?";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, depoKartlari.getDepoKodu());
            pr.setString(2, depoKartlari.getDepoAdi());
            pr.setString(3, depoKartlari.getDepoAciklama());
            pr.setString(4, depoKartlari.getDepoKodu());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
