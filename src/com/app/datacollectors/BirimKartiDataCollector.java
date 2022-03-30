package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.BirimKartiModel;
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
}