/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import negocio.VentasControl;


/**
 *
 * @author axel
 */
public class CRUDVenta extends javax.swing.JFrame {

    /**
     * Creates new form CRUDVenta
     */
    private final VentasControl control;
    private int ids,cantidad,existencia;
    private double precio,descuento,total;
    private MenuPrincipal menuprincipal;
    public CRUDVenta(int id,int tap) {
        initComponents();
        control = new VentasControl();
        ids = id;
        txtIdRopa.setText(id+"");
        txtIva.setText("16");
        if(tap == 1)
        {
            paneles.setSelectedIndex(tap);
            cantidad = 0;
        }
        CargarTabla();
    }
    private void CargarTabla()
    {
        tablaVentas.setModel(control.listar());
        
        establecerAnchoColumnas(tablaVentas);
        
        TableRowSorter modeloOrdenado = new TableRowSorter(tablaVentas.getModel());
        tablaVentas.setRowSorter(modeloOrdenado);
        
        Registros.setText("Mostrados " + control.total());
    }
    private void establecerAnchoColumnas(JTable tabla){
         int idVenta = 10;
         int idRopa = 10;
         int FolioVenta = 80;
         int Fecha = 50;
         int Total = 20;
         int Descuento = 20;
         int IVA = 10;
         int Estado = 10;
         int Cantidad = 20;
         TableColumn columna;
         DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
         modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i=0; i<tabla.getColumnCount(); i++){
            switch(i){
                case 0: // ID esta oculto
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(idVenta);
                    //columna.setMaxWidth(tamEstatus);
                    columna.setMinWidth(idVenta);
                    break;
                    /*
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setMaxWidth(id);
                    columna.setMinWidth(id);
                    tabla.getTableHeader().getColumnModel().getColumn(i).setMaxWidth(0);
                    tabla.getTableHeader().getColumnModel().getColumn(i).setMinWidth(0);
                    break;*/
                case 1:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(idRopa);
                    //columna.setMaxWidth(tamNombre);
                    columna.setMinWidth(idRopa);
                    break;
                case 2:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(FolioVenta);
                    //columna.setMaxWidth(tamDescripcion);
                    columna.setMinWidth(FolioVenta);
                    break;
                case 3:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setCellRenderer(modelocentrar);  //table.getColumnModel().getColumn(col).setCellRenderer(modelocentrar);
                    columna.setPreferredWidth(Fecha);
                    //columna.setMaxWidth(tamConDescuento);
                    columna.setMinWidth(Fecha);
                    break;
                case 4:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(Total);
                    //columna.setMaxWidth(tamDescuento);
                    columna.setMinWidth(Total);
                    break;
                case 5:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(Descuento);
                    //columna.setMaxWidth(tamImagen);
                    columna.setMinWidth(Descuento);
                    break;
                case 6:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(IVA);
                    //columna.setMaxWidth(tamEstatus);
                    columna.setMinWidth(IVA);
                    break;
                case 7:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(Estado);
                    //columna.setMaxWidth(tamEstatus);
                    columna.setMinWidth(Estado);
                    break;
                case 8:
                    columna=tabla.getColumnModel().getColumn(i);
                    columna.setPreferredWidth(Cantidad);
                    //columna.setMaxWidth(tamEstatus);
                    columna.setMinWidth(Cantidad);
                    break;
            }
        }
        
        tabla.setRowHeight(30);
     }
    
    private void calcularDT(){
    precio = control.precio(Integer.parseInt(txtIdRopa.getText()));
        if (Cantidad.getText().isEmpty())
            Cantidad.setText("");
        else {
            cantidad = Integer.parseInt(Cantidad.getText());
            if (txtDescuento.getText().isEmpty()) {
                txtDescuento.setText("");
            } else {
                existencia = control.existencias(Integer.parseInt(txtIdRopa.getText()));
                if(txtDescuento.getText().equals("0")){
                    total = (1.16*(precio * cantidad));
                    txtTotal.setText(total+"");
                } else {
                    total = (precio * cantidad);
                    descuento = (Double.parseDouble(txtDescuento.getText())/100) * total;
                    total = 1.16*(total-descuento);
                    txtTotal.setText(total + "");
                    System.out.println(cantidad + ":" + total + "  " + descuento);
                }
            }
            
        }
    }
    private void limpiar(){
        id.setText("ID");
        txtIdRopa.setText("");
        txtDescuento.setText("");
        txtFecha.setText("");
        txtFolioVenta.setText("");
        txtIva.setText("");
        txtTotal.setText("");
        btnEstado.setSelected(true);
        Cantidad.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneles = new javax.swing.JTabbedPane();
        ListadoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbfiltro = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRestablecerTabla = new javax.swing.JButton();
        Registros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        OperacionesPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFolioVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEstado = new javax.swing.JRadioButton();
        txtIdRopa = new javax.swing.JTextField();
        btnRopa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("<Volver al menu");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Listado de Ventas");

        cmbfiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "idVenta", "idRopa", "folioVenta", "Fecha", "Total", "Descuento", "IVA", "Estado" }));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(0, 153, 153));
        btnNuevo.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRestablecerTabla.setBackground(new java.awt.Color(0, 153, 153));
        btnRestablecerTabla.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnRestablecerTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnRestablecerTabla.setText("Restablecer tabla");
        btnRestablecerTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerTablaActionPerformed(evt);
            }
        });

        Registros.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Registros.setForeground(new java.awt.Color(51, 51, 255));
        Registros.setText("Registros");

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idVenta", "idRopa", "FolioVenta", "Fecha", "Total", "Descuento", "IVA", "Estado", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);

        javax.swing.GroupLayout ListadoPanelLayout = new javax.swing.GroupLayout(ListadoPanel);
        ListadoPanel.setLayout(ListadoPanelLayout);
        ListadoPanelLayout.setHorizontalGroup(
            ListadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ListadoPanelLayout.createSequentialGroup()
                .addGroup(ListadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListadoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ListadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                            .addGroup(ListadoPanelLayout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRestablecerTabla)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(ListadoPanelLayout.createSequentialGroup()
                        .addGroup(ListadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(ListadoPanelLayout.createSequentialGroup()
                                .addComponent(cmbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(ListadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Registros, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListadoPanelLayout.setVerticalGroup(
            ListadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListadoPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ListadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRestablecerTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Registros)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        paneles.addTab("Listado", ListadoPanel);

        jLabel4.setText("Datos de Ventas");

        id.setText("ID");

        label.setText("ID-Ropa");

        jLabel7.setText("Folia Venta");

        jLabel8.setText("Fecha");

        txtFecha.setText("yy-mm-dd");

        jLabel9.setText("Descuento");

        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
        });

        jLabel10.setText("Total");

        jLabel11.setText("IVA");

        txtIva.setEditable(false);
        txtIva.setText("16");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnEstado.setSelected(true);
        btnEstado.setText("Activo");

        btnRopa.setText("...");
        btnRopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRopaActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad");

        Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CantidadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout OperacionesPanelLayout = new javax.swing.GroupLayout(OperacionesPanel);
        OperacionesPanel.setLayout(OperacionesPanelLayout);
        OperacionesPanelLayout.setHorizontalGroup(
            OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OperacionesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addGap(32, 32, 32))
            .addGroup(OperacionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(OperacionesPanelLayout.createSequentialGroup()
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRopa))
                    .addGroup(OperacionesPanelLayout.createSequentialGroup()
                        .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OperacionesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cantidad))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OperacionesPanelLayout.createSequentialGroup()
                                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFolioVenta)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(OperacionesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OperacionesPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescuento))
                            .addComponent(btnEstado))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        OperacionesPanelLayout.setVerticalGroup(
            OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperacionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(label)
                    .addComponent(txtIdRopa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRopa))
                .addGap(18, 18, 18)
                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEstado)))
                .addGap(24, 24, 24)
                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addGroup(OperacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        paneles.addTab("Operaciones", OperacionesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneles)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneles, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        paneles.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRestablecerTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerTablaActionPerformed
        CargarTabla();
    }//GEN-LAST:event_btnRestablecerTablaActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        DefaultTableModel modelotabla = (DefaultTableModel) tablaVentas.getModel();
        modelotabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        String busqueda = txtBuscar.getText();
        if (busqueda.trim().equals("")) {
            CargarTabla();
        } else {
            int columnas;
            int[] anchos = {30, 100, 150, 40, 30, 60, 40, 70, 80, 124};
            for (int i = 0; i < tablaVentas.getColumnCount(); i++) {
                tablaVentas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            try {
                Connection con = Conexion.getCon();
                String consultaSQL = "";
                String filtro = cmbfiltro.getSelectedItem().toString();
                if (filtro.equals("idVenta")) {
                    consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE idVenta ='" + busqueda + "' ";
                } else {
                    if (filtro.equals("idRopa")) {
                        consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE idRopa ='" + busqueda + "' ";
                    } else {
                        if (filtro.equals("folioVenta")) {
                            consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE folioVenta ='" + busqueda + "' ";
                        } else {
                            if (filtro.equals("Fecha")) {
                                consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE Fecha ='" + busqueda + "' ";
                            } else {
                                if (filtro.equals("Total")) {
                                    consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE Total ='" + busqueda + "' ";
                                } else {
                                    if (filtro.equals("Descuento")) {
                                        consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE Descuento ='" + busqueda + "' ";
                                    } else {
                                        if (filtro.equals("IVA")) {
                                            consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE IVA ='" + busqueda + "' ";
                                        } else {
                                            if (filtro.equals("Estado")) {
                                                consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado from Ventas WHERE Estado ='" + busqueda + "' ";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                ps = con.prepareStatement(consultaSQL);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();
                columnas = rsmd.getColumnCount();
                while (rs.next()) {
                    Object[] fila = new Object[columnas];
                    for (int indice = 0; indice < columnas; indice++) {
                        fila[indice] = rs.getObject(indice + 1);
                    }
                    modelotabla.addRow(fila);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String resp;
        if (txtFolioVenta.getText().isEmpty()) {
            txtFolioVenta.requestFocus();
            JOptionPane.showMessageDialog(null, "Debes ingresar el Folio de Venta");
        } else {
            if (txtFecha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes ingresar una fecha");
                txtFecha.requestFocus();
            } else {
                if (txtDescuento.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un Descuento");
                    txtDescuento.requestFocus();
                } else {

                    if (txtIdRopa.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar un id de alguna prenda");
                        txtIdRopa.requestFocus();
                    } else {
                        //precio = control.precio(Integer.parseInt(txtIdRopa.getText()));
                        //cantidad = Integer.parseInt(Cantidad.getText());
                        existencia = control.existencias(Integer.parseInt(txtIdRopa.getText()));
                        System.out.println(cantidad + "<" + existencia);
                        if (cantidad <= existencia) {
                            cantidad = existencia - cantidad;
                            System.out.println(txtTotal);
                            control.Modificar(cantidad, Integer.parseInt(txtIdRopa.getText()));
                            resp = control.insertar(Integer.parseInt(txtIdRopa.getText()), txtFolioVenta.getText(), txtFecha.getText(),
                                    Double.parseDouble(txtTotal.getText()), Double.parseDouble(txtDescuento.getText()),
                                    Double.parseDouble(txtIva.getText()), btnEstado.isSelected(), Integer.parseInt(Cantidad.getText()));
                            if (resp.equals("OK")) {
                                JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
                                limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al insertar");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo realizar la venta por cuestiones de existencias", "Ventas", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        paneles.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        //Este metodo es para que se le pueda hacer clic a la tabla
        try {
            int fila = tablaVentas.getSelectedRow();
            int id = Integer.parseInt(tablaVentas.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;
            Connection con = Conexion.getCon();
            String consultaSQL = "SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado,existencias from Ventas WHERE idVenta =?";

            ps = con.prepareStatement(consultaSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                this.id.setText(String.valueOf(id));
                txtIdRopa.setText(rs.getString(2));
                txtFolioVenta.setText(rs.getString(3));
                txtFecha.setText(rs.getString(4));
                txtTotal.setText(rs.getString(5));
                txtDescuento.setText(rs.getString(6));
                txtIva.setText(rs.getString(7));
                btnEstado.setSelected(rs.getBoolean(8));
                Cantidad.setText(rs.getString(9));
                DefaultTableModel modelotabla = (DefaultTableModel) tablaVentas.getModel();
                modelotabla.setRowCount(0);

                //Activar tab 0 y desactivar tab 1
                paneles.setSelectedIndex(1); // selecciona el tab(0)
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void btnRopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRopaActionPerformed
        RopaInf Jd = new RopaInf(null,true);
        Jd.setVisible(true);
        if(ids == 0){
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnRopaActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(menuprincipal == null)
        {
           menuprincipal = new MenuPrincipal();
           menuprincipal.setVisible(true);
           dispose();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void CantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadKeyReleased
        calcularDT();
    }//GEN-LAST:event_CantidadKeyReleased

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        calcularDT();
    }//GEN-LAST:event_txtDescuentoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int id = 0,tap = 0;
                new CRUDVenta(id,tap).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad;
    private javax.swing.JPanel ListadoPanel;
    private javax.swing.JPanel OperacionesPanel;
    private javax.swing.JLabel Registros;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JRadioButton btnEstado;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRestablecerTabla;
    private javax.swing.JButton btnRopa;
    private javax.swing.JComboBox<String> cmbfiltro;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTabbedPane paneles;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFolioVenta;
    private javax.swing.JTextField txtIdRopa;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
