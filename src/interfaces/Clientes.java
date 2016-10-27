package interfaces;


import Funciones.RendererTabla;
import java.awt.Color;
import Funciones.BasededatosManager;
import Funciones.PedidoPDF;
import com.itextpdf.text.DocumentException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menii
 */
public class Clientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form Proveedores
     */
    String user, pass;
    double[]anchos;
    double[]altos;
    int[]cantidades;
    String[]modelos;
    String[]colores;
    String []tipos;
    String subtotal;
    int idpedido;
    public Clientes(String usuario, String password, double[] anch, double[] alt,int[]cant,String[]mod,String[]color,String[]tip,String subtot) {
        this.user=usuario;
        this.pass=password;
        this.anchos=anch;
        this.altos=alt;
        this.subtotal=subtot;
        this.cantidades=cant;
        this.modelos=mod;
        this.colores=color;
        this.tipos=tip;
        initComponents();
        actualizar();
        jTable1.getColumnModel().getColumn(0).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(1).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(2).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(3).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(4).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(5).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(6).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(7).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(8).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.getColumnModel().getColumn(9).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204,204,204)));
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new Color (20,100,246));
        jTable1.setSelectionForeground(Color.BLACK);
    }
    
    public void actualizar(){
        BasededatosManager bd=new BasededatosManager();
        String[]columnas={"ID","Nombre Cliente","Calle","Colonia","CP","Telefono","E-mail","Ciudad","RFC","Estado"};
        ResultSet consulta=bd.consultar("SELECT * FROM Cliente", user, pass);
        DefaultTableModel modelo=bd.llenarTabla(10, columnas, consulta);
        jTable1.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setClosable(true);
        setMaximizable(true);
        setTitle("Clientes");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensitas/impresora.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 100, 246));
        jLabel2.setText("Buscar cliente por su ID");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(20, 100, 246));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensitas/lupa.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setForeground(new java.awt.Color(20, 100, 246));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre material", "Descripcion", "Precio Almacen", "Precio Publico", "Tipo", "Color", "Ubicacion", "Stock", "fecha Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("re");
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("ACTUALIZAR TABLA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("REALIZAR PEDIDO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 124, Short.MAX_VALUE))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Opciones");

        jMenuItem4.setText("Borrar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setText("Agregar Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Editar Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exportar a Excel");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AgregarCliente agregar=new AgregarCliente(user,pass);
        Principal.desktopPane.add(agregar);
        agregar.toFront();
        agregar.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        String id=JOptionPane.showInputDialog(null, "Ingresa el ID del cliente que desea actualizar");
        AgregarCliente agregar=new AgregarCliente(id, user, pass);
        Principal.desktopPane.add(agregar);
        agregar.toFront();
        agregar.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //Borrar material de la base de datos 
        String id=JOptionPane.showInputDialog(null, "Ingresa el ID del cliente que desea borrar","BORRAR",JOptionPane.WARNING_MESSAGE);
        int opc=JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar al cliente?","CONFIRMA",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            BasededatosManager bd=new BasededatosManager();
            if(bd.ejecutar("DELETE FROM Cliente WHERE idcliente='"+id+"';", user, pass)==false){
                JOptionPane.showMessageDialog(null,"El ID que ingresaste no existe, ingresa un ID válido","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            String id = jTextField1.getText();
            BasededatosManager bd=new BasededatosManager();
            ResultSet result=bd.consultar("SELECT idcliente FROM Cliente WHERE idcliente='"+id+"';", user, pass);
            if(result.first()){
                AgregarCliente agregar=new AgregarCliente(id, user, pass);
                Principal.desktopPane.add(agregar);
                agregar.toFront();
                agregar.show();
            }else{
                JOptionPane.showMessageDialog(null, "El ID: "+id+" NO EXISTE","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id=JOptionPane.showInputDialog(null, "Ingresa el ID del cliente que desea hacer un pedido","PEDIDO",JOptionPane.WARNING_MESSAGE);
        int opc=JOptionPane.showConfirmDialog(null, "¿Estas seguro de que el cliente "+id+" es el correcto?","CONFIRMA",JOptionPane.YES_NO_OPTION);
        if(opc==JOptionPane.YES_OPTION){
            try {
                dispose();
                BasededatosManager bd=new BasededatosManager();
                double iva=Double.parseDouble(subtotal)*0.16;
                double totalneto=Double.parseDouble(subtotal)+iva;
                double anticipo=totalneto*0.10;
                bd.ejecutar("INSERT INTO Pedido (fechapedido, ivapedido, subtotal, totalneto,anticipo,cliente_idcliente) VALUES('"+LocalDate.now()+"','"+iva+"','"+subtotal+"','"+totalneto+"','"+anticipo+"','"+id+"')", user, pass);
                ResultSet consulta=bd.consultar("SELECT numpedido From Pedido WHERE fechapedido='"+LocalDate.now()+"' AND totalneto='"+totalneto+"' AND cliente_idcliente='"+id+"';", user, pass);
                while(consulta.next()){
                    idpedido=consulta.getInt("numpedido");
                }
                int idsucursal=1;
                bd.ejecutar("INSERT INTO Ventas (pedido_numpedido, sucursales_id_sucursal,cajeros_id_cajero,fecha) VALUES('"+idpedido+"','"+idsucursal+"',(SELECT id_cajero FROM Cajeros WHERE empleado_id_empleado=(SELECT id_empleado FROM Empleado WHERE usuariosistema='"+user+"' AND contrasenasistema='"+pass+"')),'"+LocalDate.now()+"')", user, pass);
                JInternalFrame internalframe=new JInternalFrame();
                internalframe.setClosable(false);
                JPanel panel=new JPanel();
                panel.setLayout(new BorderLayout());
                JTable tabla = new JTable();
                DefaultTableModel dft = new DefaultTableModel();
                dft.addColumn("Sistema");
                dft.addColumn("Galeria");
                dft.addColumn("Cadena");
                dft.addColumn("Barra");
                dft.addColumn("Instalacion");
                dft.addColumn("Control");
                tabla.setSelectionBackground(new Color(20, 100, 246));
                tabla.setSelectionForeground(Color.BLACK);
                tabla.setModel(dft);
                tabla.getColumnModel().getColumn(0).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204, 204, 204)));
                tabla.getColumnModel().getColumn(1).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204, 204, 204)));
                tabla.getColumnModel().getColumn(2).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204, 204, 204)));
                tabla.getColumnModel().getColumn(3).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204, 204, 204)));
                tabla.getColumnModel().getColumn(4).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204, 204, 204)));
                tabla.getColumnModel().getColumn(5).setHeaderRenderer(new RendererTabla(Color.darkGray, new Color(204, 204, 204)));
                tabla.setOpaque(false);
                for(int i=0;i<cantidades.length;i++){
                    int filas = 1;
                    dft.addRow(new Object[filas]);
                }
                panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
                for(int i=0;i<tabla.getRowCount();i++){
                    tabla.setValueAt("PREDETERMINADO", i,0);
                    tabla.setValueAt("SI", i, 1);
                    tabla.setValueAt("SI", i, 2);
                    tabla.setValueAt("NO", i, 3);
                    tabla.setValueAt("A TECHO", i, 4);
                    tabla.setValueAt("DERECHO", i, 5);
                }
                JButton aceptar=new JButton("GUARDAR");
                aceptar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            String lineas[][]=new String[tabla.getRowCount()][15];
                            String stockinsuficiente="";
                            boolean insuficiencia=false;
                            for(int a=0;a<tabla.getRowCount();a++){
                                try {
                                    double preciounitario=0;
                                    double stock=0;
                                    ResultSet consulta = bd.consultar("SELECT preciopublico,stock FROM Telas WHERE nombretela='" + modelos[a] + "' AND color='" + colores[a] + "';", user, pass);
                                    while (consulta.next()) {
                                        preciounitario = consulta.getDouble("preciopublico");
                                        stock=consulta.getDouble("stock");
                                    }
                                    lineas[a][0]=Integer.toString(cantidades[a]);
                                    lineas[a][1]=Double.toString(anchos[a]);
                                    lineas[a][2]=Double.toString(altos[a]);
                                    lineas[a][3]=Double.toString((anchos[a]*altos[a]));
                                    lineas[a][4]=tipos[a];
                                    lineas[a][5]=modelos[a];
                                    lineas[a][6]=colores[a];
                                    lineas[a][7]=tabla.getValueAt(a, 0).toString().toUpperCase();
                                    lineas[a][8]=tabla.getValueAt(a, 1).toString().toUpperCase();
                                    lineas[a][9]=tabla.getValueAt(a, 2).toString().toUpperCase();
                                    lineas[a][10]=tabla.getValueAt(a, 3).toString().toUpperCase();
                                    lineas[a][11]=tabla.getValueAt(a, 4).toString().toUpperCase();
                                    lineas[a][12]=tabla.getValueAt(a, 5).toString().toUpperCase();
                                    lineas[a][13]=Double.toString(preciounitario);
                                    lineas[a][14]=Double.toString(((anchos[a]*altos[a])*preciounitario)*cantidades[a]);
                                    stock=((Double.parseDouble(lineas[a][3]))*Double.parseDouble(lineas[a][0]));
                                    Connection cn = bd.getConexion("homeblinds", user, pass);
                                    CallableStatement cst = cn.prepareCall("{call descontarStock(?,?,?,?)}");
                                    if(stock > 0){
                                        cst.setString(1, lineas[a][4]);
                                        cst.setString(2, lineas[a][5]);
                                        cst.setString(3, lineas[a][6]);
                                        cst.setDouble(4, stock);
                                        cst.execute();
                                        cn.close();
                                    }else{
                                        stockinsuficiente+="Insuficiencia de: "+(stock*-1)+" m2 de: \nLinea:"+lineas[a][4]+"\nModelo:"+lineas[a][4]+"\nColor:"+lineas[a][4]+"\n\n";
                                        insuficiencia=true;
                                        cst.setString(1, lineas[a][4]);
                                        cst.setString(2, lineas[a][5]);
                                        cst.setString(3, lineas[a][6]);
                                        cst.setDouble(4, 0);
                                        cst.execute();
                                        cn.close();
                                    }
                                    bd.ejecutar("INSERT INTO Lineas (numlinea,cantidad,ancho,alto,m2,linea,modelo,color,sistema,galeria,cadena,barra,instalacion,control,preciounitario,totallinea,pedido_numpedido) VALUES('" + (a + 1) + "','" + cantidades[a] + "','" + anchos[a] + "','" + altos[a] + "','" + (anchos[a] * altos[a]) + "','" + tipos[a] + "','" + modelos[a] + "','" + colores[a] + "','" + tabla.getValueAt(a, 0).toString().toUpperCase() + "','" + tabla.getValueAt(a, 1).toString().toUpperCase() + "','" + tabla.getValueAt(a, 2).toString().toUpperCase() + "','" + tabla.getValueAt(a, 3).toString().toUpperCase() + "','" + tabla.getValueAt(a, 4).toString().toUpperCase() + "','" + tabla.getValueAt(a, 5).toString().toUpperCase() + "','" + preciounitario + "','" + (((anchos[a] * altos[a]) * preciounitario) * cantidades[a]) + "','" + idpedido + "')", user, pass);
                                } catch (SQLException ex) {
                                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            String mensaje="Pedido insertado correctamente en la base de datos";
                            if(insuficiencia==true){
                                mensaje=mensaje+", pero hay algunos materiales que se deben pedir:\n"+stockinsuficiente;
                            }
                            internalframe.dispose();
                            JOptionPane.showMessageDialog(null, mensaje);
                            String cliente[] = new String[5];
                            ResultSet consulta2 = bd.consultar("SELECT nombre,CONCAT(calle,' ',colonia,' CP:',cp) AS direccion, telefono,ciudad,estado FROM Cliente WHERE idcliente='" + id + "';", user, pass);
                            while (consulta2.next()) {
                                cliente[0] = consulta2.getString("nombre");
                                cliente[1] = consulta2.getString("direccion");
                                cliente[2] = consulta2.getString("telefono");
                                cliente[3] = consulta2.getString("ciudad");
                                cliente[4] = consulta2.getString("estado");
                            }
                            String vendedor="";
                            ResultSet consulta3=bd.consultar("SELECT nombre FROM empleado WHERE usuariosistema='"+user+"' AND contrasenasistema='"+pass+"';", user, pass);
                            while(consulta3.next()){
                                vendedor=consulta3.getString("nombre");
                            }
                            PedidoPDF pedido = new PedidoPDF(Integer.toString(idpedido), cliente,vendedor,tabla.getRowCount(),lineas,subtotal,Double.toString(iva),Double.toString(totalneto),Double.toString(anticipo),user,pass);
                        } catch (SQLException ex) {
                            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
                            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                });
                panel.add(aceptar,BorderLayout.SOUTH);
                internalframe.setContentPane(panel);
                internalframe.pack();
                internalframe.setTitle("Especificaciones");
                internalframe.setResizable(true);
                internalframe.setClosable(true);
                Principal.desktopPane.add(internalframe);
                internalframe.toFront();
                internalframe.show();
            } catch (SQLException ex) {    
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
