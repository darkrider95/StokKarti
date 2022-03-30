package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.DepoKartiModel;
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
}
