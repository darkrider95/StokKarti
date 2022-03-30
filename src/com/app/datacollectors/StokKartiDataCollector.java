package com.app.datacollectors;
import com.app.dataaccess.JdbcUtil;
import com.app.models.StokKartiModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class StokKartiDataCollector {

    public static ArrayList<StokKartiModel> getStokKartiList() {
        ArrayList<StokKartiModel> stokList = new ArrayList<>();
        String query = "SELECT * FROM StokKartlari";
        StokKartiModel obj;
        try {
            Statement st = JdbcUtil.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new StokKartiModel();
                obj.setStokKodu(rs.getString("stok_kodu"));
                obj.setStokAdi(rs.getString("stok_adi"));
                obj.setStokTipi(rs.getInt("stok_tipi"));
                obj.setBirimi(rs.getString("birimi"));
                obj.setBarkodu(rs.getString("barkodu"));
                obj.setKdvTipi(rs.getDouble("kdv_tipi"));
                obj.setAciklama(rs.getString("aciklama"));
                obj.setOlusturmaTarihi(rs.getDate("olusturma_tarihi"));
                stokList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stokList;
    }

    public static boolean addStokKarti(StokKartiModel stokKartlari) {
        String query = "INSERT INTO StokKartlari (stok_kodu, stok_adi, stok_tipi, birimi, barkodu, kdv_tipi, aciklama, olusturma_tarihi) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, stokKartlari.getStokKodu());
            pr.setString(2, stokKartlari.getStokAdi());
            pr.setInt(3, stokKartlari.getStokTipi());
            pr.setString(4, stokKartlari.getBirimi());
            pr.setString(5, stokKartlari.getBarkodu());
            pr.setDouble(6, stokKartlari.getKdvTipi());
            pr.setString(7, stokKartlari.getAciklama());
            //pr.setDate(8, new java.sql.Date(stokKartlari.getOlusturmaTarihi().getTime()));
            pr.setDate(8, new java.sql.Date( new Date().getTime()));
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static boolean updateStokKarti(StokKartiModel stokKartlari) {
        String query = "UPDATE StokKartlari SET stok_kodu =?,stok_adi =?,stok_tipi =?,birimi =?,barkodu =?,kdv_tipi =?,aciklama =?,olusturma_tarihi =? WHERE stok_kodu =?";
        try {
            PreparedStatement pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, stokKartlari.getStokKodu());
            pr.setString(2, stokKartlari.getStokAdi());
            pr.setInt(3, stokKartlari.getStokTipi());
            pr.setString(4, stokKartlari.getBirimi());
            pr.setString(5, stokKartlari.getBarkodu());
            pr.setDouble(6, stokKartlari.getKdvTipi());
            pr.setString(7, stokKartlari.getAciklama());
            //pr.setDate(8, new java.sql.Date(stokKartlari.getOlusturmaTarihi().getTime()));
            pr.setDate(8, new java.sql.Date( new Date().getTime()));
            pr.setString(9, stokKartlari.getStokKodu());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean deleteStokKarti(String stokKodu){
        String query = "DELETE FROM StokKartlari WHERE Stok_Kodu = ?";
        PreparedStatement pr = null;
        try {
            pr = JdbcUtil.getInstance().prepareStatement(query);
            pr.setString(1, stokKodu);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
