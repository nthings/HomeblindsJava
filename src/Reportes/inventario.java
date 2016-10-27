/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Funciones.BasededatosManager;
import Funciones.FileChuser;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MauricioNTHINGs
 */
public class inventario {
    String directorio, user,pass;
    FileChuser dir=new FileChuser();
    BasededatosManager bd=new BasededatosManager();
    public inventario(String usuario, String contra){
        this.user=usuario;
        this.pass=contra;
        int opc=JOptionPane.showOptionDialog(null, "Seleccione el reporte de inventario que desea generar:",
                "REPORTE INVENTARIO",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"TELAS EXISTENTES", "TELAS SIN EXISTENCIAS","CANCELAR"}, // null para YES, NO y CANCEL
                "PRODUCTO EXISTENTE");
        if(opc==JOptionPane.YES_OPTION){
            generarReporte("Telas Existentes","SELECT COUNT(*) FROM Telas T, Proveedor P WHERE stock != 0 AND T.proveedor_idproveedor=P.idproveedor;","SELECT T.idtela, T.nombretela, T.precioalmacen, T.tipopersiana, T.color, T.ubicacion, T.stock, P.nombreproveedor FROM Telas T, Proveedor P WHERE stock != 0 AND T.proveedor_idproveedor=P.idproveedor;");
        }
        if(opc==JOptionPane.NO_OPTION){
            generarReporte("Telas Sin Existencias", "SELECT COUNT(*) FROM Telas T, Proveedor P WHERE stock = 0 AND T.proveedor_idproveedor=P.idproveedor;", "SELECT T.idtela, T.nombretela, T.precioalmacen, T.tipopersiana, T.color, T.ubicacion, T.stock, P.nombreproveedor FROM Telas T, Proveedor P WHERE stock = 0 AND T.proveedor_idproveedor=P.idproveedor;");
        }
    }
    
    void generarReporte(String tipo, String sql1, String sql2){
        try {
            // TODO add your handling code here:
            this.directorio=dir.obtenerDirectorio(".pdf");
            File archivo=new File(directorio);
            Document documento=new Document(PageSize.A4.rotate());
            FileOutputStream ficheroPdf=new FileOutputStream(archivo);
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            documento.setMargins(0,0,1,0);
            documento.open();
            
            PdfPTable tablaheader=new PdfPTable(1);
            Font c=new Font(Font.FontFamily.HELVETICA,22,Font.BOLD,BaseColor.BLACK);
            PdfPCell celda1=new PdfPCell(new Paragraph("Reporte De Inventario:"+tipo,c));
            celda1.setBackgroundColor(BaseColor.BLUE);
            tablaheader.addCell(celda1);
            ResultSet consultanombreempresa=bd.consultar("SELECT nombreempresa FROM configuracion;", user, pass);
            if(consultanombreempresa.next()){
                PdfPCell celda2=new PdfPCell(new Paragraph(consultanombreempresa.getString("nombreempresa").toUpperCase(),c));
                tablaheader.addCell(celda2);
            }
            documento.add(tablaheader);
            
            PdfPTable tablareporte=new PdfPTable(8);
            PdfPCell celdaid=new PdfPCell(new Paragraph("ID"));
            tablareporte.addCell(celdaid);
            PdfPCell celdacajero=new PdfPCell(new Paragraph("Nombre Tela"));
            tablareporte.addCell(celdacajero);
            PdfPCell celdatotalventa=new PdfPCell(new Paragraph("Precio Almacen"));
            tablareporte.addCell(celdatotalventa);
            PdfPCell celdafecha=new PdfPCell(new Paragraph("Tipo Persiana"));
            tablareporte.addCell(celdafecha);
            PdfPCell celdacolor=new PdfPCell(new Paragraph("Color"));
            tablareporte.addCell(celdacolor);
            PdfPCell celdaubicacion=new PdfPCell(new Paragraph("Ubicacion"));
            tablareporte.addCell(celdafecha);
            PdfPCell celdastock=new PdfPCell(new Paragraph("Stock"));
            tablareporte.addCell(celdastock);
            PdfPCell celdaprov=new PdfPCell(new Paragraph("Nombre Proveedor"));
            tablareporte.addCell(celdaprov);
            int filas=0;
            ResultSet contarfilas=bd.consultar(sql1, user, pass);
            while(contarfilas.next()){
                filas=contarfilas.getInt(1);
            }
            ResultSet reporteconsulta=bd.consultar(sql2, user, pass);
            while (reporteconsulta.next()) {
                PdfPCell celdaa = new PdfPCell(new Paragraph(reporteconsulta.getString("idtela")));
                tablareporte.addCell(celdaa);
                PdfPCell celdab = new PdfPCell(new Paragraph(reporteconsulta.getString("nombretela")));
                tablareporte.addCell(celdab);
                PdfPCell celdac = new PdfPCell(new Paragraph(reporteconsulta.getString("precioalmacen")));
                tablareporte.addCell(celdac);
                PdfPCell celdad = new PdfPCell(new Paragraph(reporteconsulta.getString("tipopersiana")));
                tablareporte.addCell(celdad);
                PdfPCell celdae = new PdfPCell(new Paragraph(reporteconsulta.getString("color")));
                tablareporte.addCell(celdae);
                PdfPCell celdaf = new PdfPCell(new Paragraph(reporteconsulta.getString("ubicacion")));
                tablareporte.addCell(celdaf);
                PdfPCell celdag = new PdfPCell(new Paragraph(reporteconsulta.getString("stock")));
                tablareporte.addCell(celdag);
                PdfPCell celdah = new PdfPCell(new Paragraph(reporteconsulta.getString("nombreproveedor")));
                tablareporte.addCell(celdah);
            }
            documento.add(tablareporte);
            documento.close();
            ejecutarPDF();
        } catch (DocumentException ex) {
            Logger.getLogger(ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ejecutarPDF(){
        String d = "";
        try {

            if ("/".equals(directorio.substring(0, 1))) {
                Runtime.getRuntime().exec("evince " + directorio);
            }
            if (":".equals(directorio.substring(1, 2))) {
                char signo = (char) 92;
                String[] arreglo = directorio.split("\\\\");
                for (int a = 0; a < arreglo.length; a++) {
                    d = d + arreglo[a] + "\\\\\\\\";
                }
                Desktop.getDesktop().open(new File(d));
            }
        } catch (IOException ex) {
            Logger.getLogger(inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
