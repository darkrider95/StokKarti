package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.StokTipiModel;
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
}
