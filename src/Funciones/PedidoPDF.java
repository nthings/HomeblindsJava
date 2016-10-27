/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.AlphaComposite;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author MauricioNTHINGs
 */
public class PedidoPDF {
    File archivo;
    FileChuser dir=new FileChuser();
    String directorio;
    Font f=new Font(FontFamily.HELVETICA,8,Font.NORMAL,BaseColor.BLACK);
    String idpedido;
    String cliente[];
    String vendedor;
    String lineas[][];
    int cantidadlineas;
    String subtotal,iva,total,anticipo, user, pass;
    public PedidoPDF(String id, String[]datoscliente,String vend,int cant,String [][]lin,String sub,String iv,String tota,String anticip,String us,String password) throws FileNotFoundException, DocumentException, IOException{
        try {
            this.idpedido=id;
            this.cliente=datoscliente;
            this.vendedor=vend;
            this.cantidadlineas=cant;
            this.lineas=lin;
            this.subtotal=sub;
            this.iva=iv;
            this.total=tota;
            this.anticipo=anticip;
            this.user=us;
            this.pass=password;
            this.directorio=dir.obtenerDirectorio(".pdf");
            this.archivo=new File(directorio);
            Document documento=new Document(PageSize.A4.rotate());
            FileOutputStream ficheroPdf=new FileOutputStream(archivo);
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            documento.setMargins(0,0,1,0);
            documento.open();
            
            documento.add(tablaHeader());
            documento.add(tablaSucursal());
            documento.add(tablaCliente());
            documento.add(tablaLineas());
            documento.add(tablaFooter());
            documento.close();
            FileInputStream pdf=new FileInputStream(archivo);
            int len = (int)archivo.length();
            String query = ("UPDATE Pedido SET pdf=? WHERE numpedido='"+idpedido+"';");
            BasededatosManager bd=new BasededatosManager();
            PreparedStatement pstmt = bd.getConexion("homeblinds",user,pass).prepareStatement(query);
            //method to insert a stream of bytes
            pstmt.setBinaryStream(1,pdf);
            pstmt.executeUpdate();
            
            ejecutarPDF();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    PdfPTable tablaCliente(){
        PdfPTable tablacliente=new PdfPTable(2);
        tablacliente.setTotalWidth(500);
        PdfPCell celdanombrecliente=new PdfPCell(new Paragraph("Nombre Del Cliente: "+cliente[0]));
        tablacliente.addCell(celdanombrecliente);
        PdfPCell celdavendedor=new PdfPCell(new Paragraph("Vendedor: "+vendedor));
        tablacliente.addCell(celdavendedor);
        PdfPCell celdadireccion=new PdfPCell(new Paragraph("Direccion: "+cliente[1]));
        celdadireccion.setColspan(2);
        tablacliente.addCell(celdadireccion);
        PdfPCell celdatelefono=new PdfPCell(new Paragraph("Teléfono: "+cliente[2]));
        celdatelefono.setColspan(2);
        tablacliente.addCell(celdatelefono);
        PdfPCell celdaciudad=new PdfPCell(new Paragraph("Ciudad: "+cliente[3]));
        celdaciudad.setColspan(2);
        tablacliente.addCell(celdaciudad);
        PdfPCell celdaestado=new PdfPCell(new Paragraph("Estado: "+cliente[4]));
        celdaestado.setColspan(2);
        tablacliente.addCell(celdaestado);
        return tablacliente;
    }
    
    PdfPTable tablaLineas(){
        PdfPTable tablalineas=new PdfPTable(15);
        PdfPCell celdacantidad=new PdfPCell(new Paragraph("Cant.",f));
        tablalineas.addCell(celdacantidad);
        PdfPCell celdaancho=new PdfPCell(new Paragraph("Ancho",f));
        tablalineas.addCell(celdaancho);
        PdfPCell celdaalto=new PdfPCell(new Paragraph("Alto",f));
        tablalineas.addCell(celdaalto);
        PdfPCell celdam2=new PdfPCell(new Paragraph("M2",f));
        tablalineas.addCell(celdam2);
        PdfPCell celdalinea=new PdfPCell(new Paragraph("Linea",f));
        tablalineas.addCell(celdalinea);
        PdfPCell celdamodelo=new PdfPCell(new Paragraph("Modelo",f));
        tablalineas.addCell(celdamodelo);
        PdfPCell celdacolor=new PdfPCell(new Paragraph("Color",f));
        tablalineas.addCell(celdacolor);
        PdfPCell celdasistema=new PdfPCell(new Paragraph("Sistema",f));
        tablalineas.addCell(celdasistema);
        PdfPCell celdagaleria=new PdfPCell(new Paragraph("Galeria",f));
        tablalineas.addCell(celdagaleria);
        PdfPCell celdacadena=new PdfPCell(new Paragraph("Cadena",f));
        tablalineas.addCell(celdacadena);
        PdfPCell celdabarra=new PdfPCell(new Paragraph("Barra",f));
        tablalineas.addCell(celdabarra);
        PdfPCell celdainstalacion=new PdfPCell(new Paragraph("Instalación",f));
        tablalineas.addCell(celdainstalacion);
        PdfPCell celdacontrol=new PdfPCell(new Paragraph("Control",f));
        tablalineas.addCell(celdacontrol);
        PdfPCell celdapreciounitario=new PdfPCell(new Paragraph("$ Unitario",f));
        tablalineas.addCell(celdapreciounitario);
        PdfPCell celdatotallinea=new PdfPCell(new Paragraph("Total",f));
        tablalineas.addCell(celdatotallinea);
        for(int a=0;a<cantidadlineas;a++){
            for(int b=0;b<15;b++){
                PdfPCell celda=new PdfPCell(new Paragraph(lineas[a][b],f));
                tablalineas.addCell(celda);
            }
        }
        if(cantidadlineas<10){
            for (int a = 0; a < 10-cantidadlineas; a++) {
                for (int b = 0; b < 15; b++) {
                    PdfPCell celda = new PdfPCell(new Paragraph(""));
                    tablalineas.addCell(celda);
                }
            }
        }
        return tablalineas;
    }
    
    PdfPTable tablaFooter(){
        PdfPTable tablafooter=new PdfPTable(3);
        
        Paragraph contrato=new Paragraph("Reconozco y me obligo a pagar a la orden de --- En la Ciudad de Durango, Dgo. la fecha: "+LocalDate.now()+" la cantidad de $----- Valor de la mercancía arriba especificada y que he recibido a mi entera satisfacción, este pagaré es mercantil y esta regido por la ley de títulos de créditos en sus anuncios 170, 174 y relativos, de no verificarse el pago de la cantidad que este pagare exprese el día de su vencimiento abonare el crédito de ____% mensual por todo el tiempo que permanezca insoluto.",f);        
        PdfPCell celdacontrato=new PdfPCell(contrato);
        celdacontrato.setBorderColor(BaseColor.RED);
        tablafooter.addCell(celdacontrato);
        
        PdfPCell celdaobservaciones=new PdfPCell(new Paragraph("Observaciones:"));
        celdaobservaciones.setBorderColor(BaseColor.BLUE);
        tablafooter.addCell(celdaobservaciones);
        
        PdfPTable cantidades=new PdfPTable(2);
        PdfPCell celdasubtotal=new PdfPCell(new Paragraph("Subtotal",f));
        cantidades.addCell(celdasubtotal);
        PdfPCell subtotalcantidad=new PdfPCell(new Paragraph("$"+subtotal,f));
        cantidades.addCell(subtotalcantidad);
        PdfPCell celdaiva=new PdfPCell(new Paragraph("I.V.A.",f));
        cantidades.addCell(celdaiva);
        PdfPCell ivacantidad=new PdfPCell(new Paragraph("$"+iva,f));
        cantidades.addCell(ivacantidad);
        PdfPCell celdatotal=new PdfPCell(new Paragraph("Total",f));
        cantidades.addCell(celdatotal);
        PdfPCell totalcantidad=new PdfPCell(new Paragraph("$"+total,f));
        cantidades.addCell(totalcantidad);
        PdfPCell celdaanticipo=new PdfPCell(new Paragraph("Anticipo",f));
        cantidades.addCell(celdaanticipo);
        PdfPCell anticipocantidad=new PdfPCell(new Paragraph("$"+anticipo,f));
        cantidades.addCell(anticipocantidad);
        PdfPCell celdacantidades=new PdfPCell(cantidades);
        celdacantidades.setBorderColor(BaseColor.WHITE);
        tablafooter.addCell(celdacantidades);
        return tablafooter;
    }
    static java.awt.Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }
    PdfPTable tablaHeader() throws IOException, BadElementException{
            PdfPTable tablaheader=new PdfPTable(6);
            BasededatosManager bd=new BasededatosManager();
            try {
                ResultSet consulta=bd.consultar("SELECT logoempresa FROM configuracion", "mauricio","54321");
                byte[] arreglo=null;
                while(consulta.next()){
                    arreglo=consulta.getBytes("logoempresa");
                }
                Image logo=Image.getInstance(arreglo);
                logo.scalePercent(50);
                PdfPCell celdalogo=new PdfPCell(logo);
                celdalogo.setBorderColor(BaseColor.WHITE);
                tablaheader.addCell(celdalogo);
                Font a=new Font(FontFamily.HELVETICA,36,Font.BOLD,BaseColor.BLACK);
                PdfPCell celdatitulo = new PdfPCell(new Paragraph("PEDIDO Y CONTRATO DE PERSIANAS",a));
                celdatitulo.setBorderColor(BaseColor.WHITE);
                celdatitulo.setColspan(3);
                tablaheader.addCell(celdatitulo);
                PdfPCell celdafecha = new PdfPCell(new Paragraph("Fecha: "+LocalDate.now()));
                celdafecha.setBorderColor(BaseColor.WHITE);
                tablaheader.addCell(celdafecha);
                PdfPCell celdapedido= new PdfPCell(new Paragraph("N° Pedido: "+idpedido));
                celdapedido.setBorderColor(BaseColor.WHITE);
                tablaheader.addCell(celdapedido);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablaheader;
    }
    
    PdfPTable tablaSucursal(){
        PdfPTable tablasucursal=new PdfPTable(3);
        PdfPCell celdadireccion=new PdfPCell(new Paragraph("Blvd. Durango 400-A Lomas del Guadiana Durango, Dgo."));
        celdadireccion.setBorderColor(BaseColor.WHITE);
        tablasucursal.addCell(celdadireccion);
        PdfPCell celdatelefono=new PdfPCell(new Paragraph("Tel/Fax:(01618) 8-12-71-79  Cel:(618)122-47-60"));
        celdatelefono.setBorderColor(BaseColor.WHITE);
        tablasucursal.addCell(celdatelefono);
        PdfPCell celdaemail=new PdfPCell(new Paragraph("E-mail: homeblinds@hotmail.com"));
        celdaemail.setBorderColor(BaseColor.WHITE);
        tablasucursal.addCell(celdaemail);
        return tablasucursal;
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
            Logger.getLogger(PedidoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
