/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import database.Conexion;
import datos.ventasDAO;
import entidades.Ropa;
import entidades.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axel
 */
public class VentasControl extends Conexion {
    Connection con = getConexion();
    private final ventasDAO datos;
    private Ventas obj;
    private DefaultTableModel modelotabla;
    private int registrosMostrados;

    public VentasControl() {
        this.datos = new ventasDAO();
        this.obj = new Ventas();
        this.registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(){
        List<Ventas> lista = new ArrayList();
        lista.addAll(datos.listar());
        String titulos[] = {"idV","idR","FolioVenta","Fecha","Total","Descuento","IVA"
                ,"Estado","Cantidad"
        };
        modelotabla = new DefaultTableModel(null, titulos);
        String registros[] = new String[9];
        registrosMostrados = 0;
        for(Ventas item:lista){
            registros[0] = Integer.toString(item.getIdRopa());
            registros[1] = Integer.toString(item.getIdVenta());
            registros[2] = item.getFolioVenta();
            registros[3] = item.getFecha();
            registros[4] = Double.toString(item.getTotal());
            registros[5] = Double.toString(item.getDescuento());
            registros[6] = Double.toString(item.getIva());
            registros[7] = Boolean.toString(item.isEstado());
            registros[8] = Integer.toString(item.getCantidad());
            modelotabla.addRow(registros);
            registrosMostrados += 1;
        }
        return modelotabla;
    }
    public String insertar(int idRopa,String folioventa, String Fecha,double Total,double Descuento
    ,double IVA,boolean Estado,int Cantidad){
        obj.setIdRopa(idRopa);
        obj.setFolioVenta(folioventa);
        obj.setFecha(Fecha);
        obj.setDescuento(Descuento);
        obj.setIva(IVA);
        obj.setEstado(Estado);
        obj.setCantidad(Cantidad);
        if(datos.insertar(obj))
            return "OK";
        else
            return "Error al insertar";
    }
    public boolean Modificar(int existencia,int idropa){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String consultaSQL = "UPDATE ropa SET existencias=? WHERE idropa = ?";
        try
        {
          ps=con.prepareStatement(consultaSQL);
          ps.setInt(1, existencia);
          ps.setInt(2, idropa);
          ps.executeUpdate();
          return true;
        }catch(SQLException ex)
        {
            Logger.getLogger(SQL_Usuarios.class.getName()).log(Level.SEVERE, null,ex);
            return false;
        }
    }
    public int existencias(int id)
    {
        PreparedStatement ps;
        ResultSet rs;
        int result = 0;
        try{
            ps = con.prepareStatement("select existencias from ropa where idropa = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){    
                result=rs.getInt(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
        }
        return result;
    }
    public int total(){
        return datos.total();
    }
}
