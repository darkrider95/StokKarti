package com.app.controllers;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ExtractToPdf {
        ArrayList list;
        public ExtractToPdf(ArrayList list){
                this.list = list;
        }

        public void print() throws JRException {

                JasperReport jreport = JasperCompileManager.compileReport("/home/haluk/Desktop/deneme.jrxml");

                JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(list);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, null, jcs);

                JasperViewer.viewReport(jprint, false);
        }
    }