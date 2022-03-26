package com.app.Controller;

import com.app.Model.DepoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepoDataCollector {
    public static ArrayList<DepoModel> getDepoList() {
        ArrayList<DepoModel> depoList = new ArrayList<>();
        String query = "SELECT * FROM Depo";
        DepoModel obj;
        try {
            Statement st = JdbcUtil.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new DepoModel();
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
