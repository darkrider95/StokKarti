package com.app.face;
import com.app.models.BaseDataModel;

import java.sql.SQLException;

public interface BaseInternalFrame {
    void setSearchedField(BaseDataModel masterModel);
    BaseDataModel prepareNewModel(int b) throws SQLException;
    BaseDataModel getCurrentDataModel();
}
