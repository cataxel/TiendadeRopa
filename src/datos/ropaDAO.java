/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import datos.interfaces.crud_ropainterface;
import entidades.*;
import java.util.List;
import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author axel
 */
public class ropaDAO implements crud_ropainterface<Ropa>{
    private final Conexion Con;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ropaDAO(){
        Con = Conexion.getinstancia();
    }
    @Override
    public List<Ropa> listar() {
        List<Ropa> registros = new ArrayList();
        try{
            ps = Con.getConexion().prepareStatement("SELECT DISTINCT r.idropa, r.nombre, r.descripcion, r.precio_costo, r.precio_venta, r.ganancia, r.genero, r.marca, r.existencias, cp.nombre, tp.nombre FROM ropa r INNER JOIN ropa_talla rp ON r.idropa = rp.idropa INNER JOIN Tallas t ON rp.idtalla=t.idtalla INNER JOIN ClasePrenda cp ON t.idclasePrenda=cp.idClasePrenda INNER JOIN TipoPrenda tp ON r.idtipoprenda = tp.idTipoPrenda");
            rs = ps.executeQuery();
            while(rs.next())
            {
                registros.add(new Ropa(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4)
                ,rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getInt(9)
                ,rs.getString(10),rs.getString(11)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            rs = null;
            Con.Desconectar();
        }
        return registros;
    }
    public List<Ropa_Tallas> tallas(int tipo){
        List nombre = new ArrayList();
        try{
            ps = Con.getConexion().prepareStatement("select t.nombre from Tallas t inner join ClasePrenda cp on t.idclasePrenda  = cp.idClasePrenda  where cp.idclasePrenda=?;");
            ps.setInt(1, tipo);
            rs = ps.executeQuery();
            while(rs.next()){
                nombre.add(rs.getString(1));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("datos.ropaDAO.tallas()");
        }finally{
            ps=null;
            rs=null;
            Con.Desconectar();
        }
        return nombre;
    }
    public List<Marca> marcas(){
        List nombre = new ArrayList();
        try{
            ps = Con.getConexion().prepareStatement("SELECT nombreMarca FROM Marca WHERE 1 ORDER BY nombreMarca ASC  ");
            rs= ps.executeQuery();
            while(rs.next()){
                nombre.add(rs.getString(1));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            rs=null;
            Con.Desconectar();
        }
        return nombre;
    }
    @Override
    public boolean insertar(Ropa obj) {
        resp = false;
        String consultaSQL = "INSERT INTO ropa(nombre, descripcion, precio_costo, precio_venta, ganancia, genero, marca, imagen, idtipoprenda, existencias)";
        consultaSQL += "VALUES(?,?,?,?,?,?,?,?,?,?) ;";
        try
        {
          ps=Con.getConexion().prepareStatement(consultaSQL);
          ps.setString(1, obj.getNombre());
          ps.setString(2,  obj.getDescripcion());
          ps.setDouble(3, obj.getPrecio_costo());
          ps.setDouble(4, obj.getPrecio_venta());
          ps.setDouble(5, obj.getGanancia());
          ps.setString(6, obj.getGenero());
          ps.setString(7, obj.getMarca());
          ps.setString(8, obj.getImagen());
          ps.setInt(9, obj.getIdtipoprenda());
          ps.setInt(10, obj.getExistencias());
          if(ps.executeUpdate() > 0){
              resp=true;
          }
          ps.close();
        }catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            Con.Desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Ropa obj) {
        resp = false;      
        String consultaSQL = "UPDATE ropa SET nombre = ?, descripcion = ?, precio_costo = ?, precio_venta = ?, ganancia = ?, genero = ?, marca = ?,imagen = ?, idtipoprenda = ?, existencias = ? WHERE idropa = ?";
        try{
            ps = Con.getConexion().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setDouble(3, obj.getPrecio_costo());
            ps.setDouble(4, obj.getPrecio_venta());
            ps.setDouble(5, obj.getGanancia());
            ps.setString(6, obj.getGenero());
            ps.setString(7, obj.getMarca());
            ps.setString(8, obj.getImagen());
            ps.setInt(9, obj.getIdtipoprenda());
            ps.setInt(10, obj.getExistencias());
            ps.setInt(11, obj.getIdropa());
            
            if ( ps.executeUpdate() > 0){
                resp=true;
            }
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            Con.Desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int numeroderegistros = 0;
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = Con.getConexion().prepareStatement("SELECT COUNT(*) FROM ropa");
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
