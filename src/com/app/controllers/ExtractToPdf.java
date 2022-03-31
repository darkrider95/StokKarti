package com.app.controllers;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.lang.model.element.VariableElement;

public class ExtractToPdf {

        ArrayList list;
        String jasperPath;
        public ExtractToPdf(ArrayList list, String jasperPath){
                this.list = list;
                this.jasperPath = jasperPath;
        }


        public void print() throws JRException, FileNotFoundException {

                JasperReport jreport = JasperCompileManager.compileReport(jasperPath);
                JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(list);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, null, jcs);
                JasperViewer.viewReport(jprint, false);
        }


        public void start() {
                //Vector<Map<String, Object>>

                try {
                        FileInputStream fis = new FileInputStream("/home/haluk/Desktop/deneme.jasper");
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);

                        List<Map<String,?>> maps = new ArrayList<Map<String, ?>> ();
                        for (int i = 0; i < list.size(); i++) {
                                Map<String,Object> map = new HashMap<String, Object>();
                                //map.put("depoKodu", model.getDepoKodu);
                                // map.put("depoAdi", );
                                // map.put("depoAciklama", );
                                // maps.add(map);
                        }
                        JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(maps);

                        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);
                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), dataSource);

                        JasperViewer.viewReport(jasperPrint, false);

                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }


}