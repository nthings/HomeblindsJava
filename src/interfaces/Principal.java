package interfaces;


import Funciones.BasededatosManager;
import Funciones.DesktopConFondo;
import Reportes.clientes;
import Reportes.inventario;
import Reportes.ventas;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menii
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     * @param usuario
     * @param pass
     */
    //Dependiendo del cargo del empleado se le muestran las funciones que solo necesita y se mandan sus datos para usos posteriores para no pedirlos nuevamente
    String user, pass, tipouser;
    public Principal(String usuario, String password, String tipo) {
        this.user=usuario;
        this.pass=password;
        this.tipouser=tipo;
        initComponents();
        JLabel logo=new JLabel();
        BasededatosManager bd=new BasededatosManager();
        logo.setIcon(bd.getLogo(user, pass));
        desktopPane.add(logo);
        nuevaventabutton.setOpaque(false);
        nuevaventabutton.setBackground(null);
        nuevaventabutton.setContentAreaFilled(false);
        nuevaventabutton.setBorderPainted(false);
        nuevaventabutton.setFocusPainted(false);
        inventariobutton.setOpaque(false);
        inventariobutton.setBackground(null);
        inventariobutton.setContentAreaFilled(false);
        inventariobutton.setBorderPainted(false);
        inventariobutton.setFocusPainted(false);
        proveedoresbutton.setOpaque(false);
        proveedoresbutton.setBackground(null);
        proveedoresbutton.setContentAreaFilled(false);
        proveedoresbutton.setBorderPainted(false);
        proveedoresbutton.setFocusPainted(false);
        checadorbutton.setContentAreaFilled(false);
        checadorbutton.setBorderPainted(false);
        checadorbutton.setFocusPainted(false);
        checadorbutton.setOpaque(false);
        checadorbutton.setBackground(null);
        pedidosbutton.setContentAreaFilled(false);
        pedidosbutton.setBorderPainted(false);
        pedidosbutton.setFocusPainted(false);
        pedidosbutton.setOpaque(false);
        pedidosbutton.setBackground(null);
        cerrarsesion.setContentAreaFilled(false);
        cerrarsesion.setBorderPainted(false);
        cerrarsesion.setFocusPainted(false);
        cerrarsesion.setOpaque(false);
        cerrarsesion.setBackground(null);
        paneladmin.setContentAreaFilled(false);
        paneladmin.setBorderPainted(false);
        paneladmin.setFocusPainted(false);
        paneladmin.setOpaque(false);
        paneladmin.setBackground(null);
        reportes.setContentAreaFilled(false);
        reportes.setBorderPainted(false);
        reportes.setFocusPainted(false);
        reportes.setOpaque(false);
        reportes.setBackground(null);
        if(tipo.equals("Instalador")){
            nuevaventabutton.setEnabled(false);
            inventariobutton.setEnabled(false);
            proveedoresbutton.setEnabled(false);
            checadorbutton.setEnabled(true);
            pedidosbutton.setEnabled(true);
            paneladmin.setEnabled(false);
            reportes.setEnabled(false);
        }
        if(tipo.equals("CEO")){
            nuevaventabutton.setEnabled(true);
            inventariobutton.setEnabled(true);
            proveedoresbutton.setEnabled(true);
            checadorbutton.setEnabled(true);
            pedidosbutton.setEnabled(true);
            paneladmin.setEnabled(true);
            reportes.setEnabled(true);
        }
        if(tipo.equals("Cajera")){
            nuevaventabutton.setEnabled(true);
            inventariobutton.setEnabled(false);
            proveedoresbutton.setEnabled(false);
            checadorbutton.setEnabled(true);
            pedidosbutton.setEnabled(false);
            paneladmin.setEnabled(false);
            reportes.setEnabled(false);
        }
        if(tipo.equals("Inventario")){
            nuevaventabutton.setEnabled(false);
            inventariobutton.setEnabled(true);
            proveedoresbutton.setEnabled(true);
            checadorbutton.setEnabled(true);
            pedidosbutton.setEnabled(false);
            paneladmin.setEnabled(false);
            reportes.setEnabled(false);
        }
        setIconImage(iconToImage(bd.getLogo(user, pass)));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    static Image iconToImage(Icon icon) {
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        desktopPane = new DesktopConFondo("/imagensitas/fondo.png");
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevaventabutton = new javax.swing.JMenuItem();
        inventariobutton = new javax.swing.JMenuItem();
        proveedoresbutton = new javax.swing.JMenuItem();
        checadorbutton = new javax.swing.JMenuItem();
        pedidosbutton = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        paneladmin = new javax.swing.JMenuItem();
        cerrarsesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE INFORMACION HOMEBLINDS");

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));
        desktopPane.setPreferredSize(new java.awt.Dimension(960, 330));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 905, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 476, Short.MAX_VALUE))
        );
        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );

        jMenu1.setText("Ventanas");

        nuevaventabutton.setText("Nueva Venta");
        nuevaventabutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaventabuttonActionPerformed(evt);
            }
        });
        jMenu1.add(nuevaventabutton);

        inventariobutton.setText("Inventario");
        inventariobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventariobuttonActionPerformed(evt);
            }
        });
        jMenu1.add(inventariobutton);

        proveedoresbutton.setText("Proveedores");
        proveedoresbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedoresbuttonActionPerformed(evt);
            }
        });
        jMenu1.add(proveedoresbutton);

        checadorbutton.setText("Checador");
        checadorbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checadorbuttonActionPerformed(evt);
            }
        });
        jMenu1.add(checadorbutton);

        pedidosbutton.setText("Pedidos");
        pedidosbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosbuttonActionPerformed(evt);
            }
        });
        jMenu1.add(pedidosbutton);

        reportes.setText("Reportes");
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });
        jMenu1.add(reportes);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones");

        paneladmin.setText("Administración");
        paneladmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paneladminActionPerformed(evt);
            }
        });
        jMenu2.add(paneladmin);

        cerrarsesion.setText("Cerrar Sesión");
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });
        jMenu2.add(cerrarsesion);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inventariobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventariobuttonActionPerformed
        // TODO add your handling code here:
        Inventario inventario = new Inventario(user, pass);
        desktopPane.add(inventario);
        inventario.show();
    }//GEN-LAST:event_inventariobuttonActionPerformed

    private void checadorbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checadorbuttonActionPerformed
        // TODO add your handling code here:
        Checador checador = new Checador(user, pass);
        desktopPane.add(checador);
        checador.show();
    }//GEN-LAST:event_checadorbuttonActionPerformed

    private void nuevaventabuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaventabuttonActionPerformed
        // TODO add your handling code here:
        NuevaCompra compra = new NuevaCompra(user, pass);
        desktopPane.add(compra);
        compra.show();
    }//GEN-LAST:event_nuevaventabuttonActionPerformed

    private void proveedoresbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresbuttonActionPerformed
        // TODO add your handling code here:
        Proveedores proveedores = new Proveedores(user, pass);
        desktopPane.add(proveedores);
        proveedores.show();
    }//GEN-LAST:event_proveedoresbuttonActionPerformed

    private void pedidosbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosbuttonActionPerformed
        // TODO add your handling code here:
        Pedidos pedidos = new Pedidos(user, pass);
        desktopPane.add(pedidos);
        pedidos.show();
    }//GEN-LAST:event_pedidosbuttonActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        // TODO add your handling code here
        int opc = JOptionPane.showOptionDialog(
                null,
                "Eliga el tipo de reporte desea",
                "REPORTES",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"VENTAS", "INVENTARIO", "CLIENTES"}, // null para YES, NO y CANCEL
                "VENTAS");
        if(opc==JOptionPane.YES_OPTION){
            ventas V=new ventas(user,pass);
            desktopPane.add(V);
            V.show();
        }
        if(opc==JOptionPane.NO_OPTION){
            //inventario
            inventario inv=new inventario(user,pass);
        }
        if(opc==JOptionPane.CANCEL_OPTION){
            //clientes
            clientes cliente=new clientes(user,pass);
        }
    }//GEN-LAST:event_reportesActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        // TODO add your handling code here:
        int opc=JOptionPane.showConfirmDialog(null, "¿Seguro que deseas cerrar sesión?","CONFIRMA",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            dispose();
            HomeblindsGUI login=new HomeblindsGUI();
            login.show();
        }
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void paneladminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paneladminActionPerformed
        // TODO add your handling code here:
        PanelAdministracion admin=new PanelAdministracion(user,pass);
        desktopPane.add(admin);
        admin.show();
    }//GEN-LAST:event_paneladminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cerrarsesion;
    private javax.swing.JMenuItem checadorbutton;
    public static DesktopConFondo desktopPane;
    private javax.swing.JMenuItem inventariobutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem nuevaventabutton;
    private javax.swing.JMenuItem paneladmin;
    private javax.swing.JMenuItem pedidosbutton;
    private javax.swing.JMenuItem proveedoresbutton;
    private javax.swing.JMenuItem reportes;
    // End of variables declaration//GEN-END:variables

}
