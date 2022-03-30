package com.app.controllers;
import com.app.views.StokKartiFrame;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExtractToExcel extends Component {

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StokKartiFrame app;
    public ExtractToExcel(StokKartiFrame app) throws IOException {
        this.app = app;
    }

    public void integrate(){

        try {
            JFileChooser excelFileChooser = new JFileChooser();
            excelFileChooser.showSaveDialog(this);
            File saveFile = excelFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new HSSFWorkbook();
                Sheet sheet = wb.createSheet("Stok Kartı");
                Row rowCol = sheet.createRow(0);

                for (int i = 0; i < app.tableStokKartlari.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(1);
                    cell.setCellValue(app.tableStokKartlari.getColumnName(i));
                }

                for (int j = 0; j < app.tableStokKartlari.getRowCount(); j++) {
                    Row row = sheet.createRow(j);
                    for (int k = 0; k < app.tableStokKartlari.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (app.tableStokKartlari.getValueAt(j, k) != null) {
                            cell.setCellValue(app.tableStokKartlari.getValueAt(j, k).toString());
                        }
                    }
                }

                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());

            } else {
                JOptionPane.showMessageDialog(null, "Kayıt Hatası");
            }
        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}