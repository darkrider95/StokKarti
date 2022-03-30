package com.app.Const;

public class Config {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/stok?autoReconnect=true&useSSL=false";
    public static final String DB_USERNAME = "haluk";
    public static final String DB_PASSWORD = "password";
    public static final Object[] COLUMN_STOK_LIST = {"Stok Kodu", "Stok Adı", "Stok Tipi", "Birimi", "Barkodu", "KDV Tipi", "Açıklama", "Oluşturma Tarihi"};
    public static final Object[] COLUMN_DEPO_LIST = {"Depo Kodu", "Depo Adı", "Açıklama"};
    public static final Object[] COLUMN_BIRIM_LIST = {"Birim Kodu", "Birim Adı", "Açıklama"};
    public static final Object[] COLUMN_KDV_LIST = {"Kdv Kodu", "Kdv Adı", "Açıklama"};
    public static final Object[] COLUMN_STOK_TIPI_LIST = {"Stok Tipi Kodu", "Stok Tipi Adı", "Açıklama"};

}
