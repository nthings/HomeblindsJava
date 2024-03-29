package interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fer
 */
import Funciones.BasededatosManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class AgregarMuestrario extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarProducto
     */
    String idmuestrario,user,pass;
    BasededatosManager bd=new BasededatosManager();
    public AgregarMuestrario(String usuario, String password) {
        this.user=usuario;
        this.pass=password;
        initComponents();
        this.setClosable(true);
        jButton3.setVisible(false);
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        llenarCombos();
    }
    public AgregarMuestrario(String id, String usuario, String password){
        this.user=usuario;
        this.pass=password;
        this.idmuestrario=id;
        initComponents();
        this.setClosable(true);
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        llenarCombos();
        setTitle("Editar Tela");
        jButton1.setVisible(false);
        jButton3.setVisible(true);
        ResultSet consulta2=bd.consultar("SELECT * FROM Muestrario WHERE idmuestrario='"+idmuestrario+"';",user,pass);
        try {
            while(consulta2.next()){
                nombre.setText(consulta2.getString("nombremuestrario"));
                tipo.setSelectedItem(consulta2.getString("tipodepersianas"));
                precio.setText(consulta2.getString("precio"));
                proveedor.setSelectedIndex(consulta2.getInt("proveedor_idproveedor")-1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarMuestrario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarCombos(){
        ResultSet consulta=bd.consultar("SELECT nombreproveedor FROM Proveedor",user,pass);
        ResultSet consulta2=bd.consultar("SELECT DISTINCT tipodepersianas FROM Muestrario", user, pass);
        try {
            while(consulta.next()){
                proveedor.addItem(consulta.getObject("nombreproveedor"));
            }
            while(consulta2.next()){
                tipo.addItem(consulta2.getObject("tipodepersianas"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarMuestrario.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        proveedor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox();

        setTitle("Agregar Material A Inventario");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(20, 100, 246));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        nombre.setForeground(new java.awt.Color(20, 100, 246));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setForeground(new java.awt.Color(20, 100, 246));
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(20, 100, 246));
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(20, 100, 246));
        jLabel10.setText("Proveedor");

        precio.setBackground(new java.awt.Color(204, 204, 204));
        precio.setForeground(new java.awt.Color(20, 100, 246));
        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        proveedor.setBackground(new java.awt.Color(204, 204, 204));
        proveedor.setForeground(new java.awt.Color(20, 100, 246));

        jLabel4.setForeground(new java.awt.Color(20, 100, 246));
        jLabel4.setText("Tipo");

        jLabel3.setForeground(new java.awt.Color(20, 100, 246));
        jLabel3.setText("Precio");

        jLabel1.setForeground(new java.awt.Color(20, 100, 246));
        jLabel1.setText("Nombre Muestrario");

        tipo.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nombre)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(0, 271, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(0, 0, 0))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(154, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int opc=JOptionPane.showConfirmDialog(null, "¿Deseas agregar este muestrario?", "AGREGAR", JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            if(tipo.getSelectedIndex()==-1){
                
            }
            bd.ejecutar("INSERT INTO Muestrario (nombremuestrario,tipodepersianas,precio,proveedor_idproveedor) VALUES('" + nombre.getText() + "','" + tipo.getSelectedItem() + "','" + precio.getText() + "','"+ (proveedor.getSelectedIndex() + 1) + "');",user,pass);
            dispose();
        }
        if(opc==JOptionPane.NO_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int opc=JOptionPane.showConfirmDialog(null, "¿Deseas ACTUALIZAR este muestrario?", "ACTUALIZAR", JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            bd.ejecutar("UPDATE Muestrario SET nombremuestrario='"+nombre.getText()+"', tipodepersianas='"+tipo.getSelectedItem()+"',precio='"+precio.getText()+"', proveedor_idproveedor='"+(proveedor.getSelectedIndex() + 1)+"' WHERE idmuestrario='"+idmuestrario+"';",user,pass);
            dispose();
        }
        if(opc==JOptionPane.NO_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JComboBox proveedor;
    private javax.swing.JComboBox tipo;
    // End of variables declaration//GEN-END:variables
}
