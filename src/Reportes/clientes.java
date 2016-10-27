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
public class clientes {
    String directorio, user,pass;
    FileChuser dir=new FileChuser();
    BasededatosManager bd=new BasededatosManager();
    public clientes(String usuario, String contra){
        this.user=usuario;
        this.pass=contra;
        int opc=JOptionPane.showConfirmDialog(null, "¿Desea generar un reporte de clientes?","CONFIRMA",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            generarReporte("SELECT COUNT(*) FROM Cliente;","SELECT idcliente, nombre, CONCAT(calle,' ', colonia,' CP:',cp) AS direccion,telefono, email, ciudad, rfc, estado FROM Cliente;");
        }
    }
    void generarReporte(String sql1, String sql2){
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
            PdfPCell celda1=new PdfPCell(new Paragraph("Reporte De Clientes",c));
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
            PdfPCell celdanombre=new PdfPCell(new Paragraph("Nombre"));
            tablareporte.addCell(celdanombre);
            PdfPCell celdacalle=new PdfPCell(new Paragraph("Direccion"));
            tablareporte.addCell(celdacalle);
            PdfPCell celdatelefono=new PdfPCell(new Paragraph("Teléfono"));
            tablareporte.addCell(celdatelefono);
            PdfPCell celdaemail=new PdfPCell(new Paragraph("E-mail"));
            tablareporte.addCell(celdaemail);
            PdfPCell celdaciudad=new PdfPCell(new Paragraph("Ciudad"));
            tablareporte.addCell(celdaciudad);
            PdfPCell celdarfc=new PdfPCell(new Paragraph("RFC"));
            tablareporte.addCell(celdarfc);
            PdfPCell celdaestado=new PdfPCell(new Paragraph("Estado"));
            tablareporte.addCell(celdaestado);
            int filas=0;
            ResultSet contarfilas=bd.consultar(sql1, user, pass);
            while(contarfilas.next()){
                filas=contarfilas.getInt(1);
            }
            ResultSet reporteconsulta=bd.consultar(sql2, user, pass);
            while (reporteconsulta.next()) {
                PdfPCell celdaa = new PdfPCell(new Paragraph(reporteconsulta.getString("idcliente")));
                tablareporte.addCell(celdaa);
                PdfPCell celdab = new PdfPCell(new Paragraph(reporteconsulta.getString("nombre")));
                tablareporte.addCell(celdab);
                PdfPCell celdac = new PdfPCell(new Paragraph(reporteconsulta.getString("direccion")));
                tablareporte.addCell(celdac);
                PdfPCell celdaf = new PdfPCell(new Paragraph(reporteconsulta.getString("telefono")));
                tablareporte.addCell(celdaf);
                PdfPCell celdag = new PdfPCell(new Paragraph(reporteconsulta.getString("email")));
                tablareporte.addCell(celdag);
                PdfPCell celdah = new PdfPCell(new Paragraph(reporteconsulta.getString("ciudad")));
                tablareporte.addCell(celdah);
                PdfPCell celdai = new PdfPCell(new Paragraph(reporteconsulta.getString("rfc")));
                tablareporte.addCell(celdai);
                PdfPCell celdaj = new PdfPCell(new Paragraph(reporteconsulta.getString("estado")));
                tablareporte.addCell(celdaj);
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
            Logger.getLogger(ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
