package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.KdvTipiModel;
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
}


