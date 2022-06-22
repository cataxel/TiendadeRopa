/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import database.Conexion;
import datos.interfaces.crud_ventasInterface;
import entidades.Ventas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author axel
 */
public class ventasDAO implements crud_ventasInterface<Ventas> {
    private final Conexion Con;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ventasDAO() {
        Con = Conexion.getinstancia();
    }
    
    @Override
    public List<Ventas> listar() {
        List<Ventas> registros = new ArrayList();
        try
        {
            ps =Con.getConexion().prepareStatement("SELECT idVenta, idRopa, folioVenta,Fecha,Total ,Descuento ,IVA ,Estado, existencias from Ventas;");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Ventas(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getDate(4).toString(), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7),
                        rs.getBoolean(8), rs.getInt(9)));
            }
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            rs = null;
            Con.Desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Ventas obj) {
        resp = false;
        String consultaSQL = "INSERT INTO Ventas(idRopa,folioVenta,Fecha,Total,Descuento,IVA,Estado,existencias) "
                + "VALUES(?,?,?,?,?,?,?,?);";
        try
        {
          ps=Con.getConexion().prepareStatement(consultaSQL);
          ps.setInt(1, obj.getIdRopa());
          ps.setString(2,obj.getFolioVenta());
          ps.setString(3,obj.getFecha());
          ps.setDouble(4, obj.getTotal());
          ps.setDouble(5, obj.getDescuento());
          ps.setDouble(6, obj.getIva());
          ps.setBoolean(7, obj.isEstado());
          ps.setInt(8, obj.getCantidad());
          if(ps.executeUpdate()>0)
              resp=true;
          ps.close();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            Con.Desconectar();
        }
        return resp;
    }
    
    public double precio(int id){
        double precio = 0;
        try {
            ps = Con.getConexion().prepareStatement("SELECT precio_venta from ropa where idropa =  ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                precio = rs.getDouble(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
        }
        
        return precio;
    }

    @Override
    public int total() {
        int numeroderegistros = 0;
        try{
            ps = Con.getConexion().prepareStatement("SELECT COUNT(*) FROM Ventas");
            rs = ps.executeQuery();
            while(rs.next()){    
                numeroderegistros=rs.getInt(1); // getString(String);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
        }
        
        return numeroderegistros;
    }
    
}
