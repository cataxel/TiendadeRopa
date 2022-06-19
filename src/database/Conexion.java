/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String DB="tiendaRopaP"; 
    private final String URL="jdbc:mysql://localhost:3306/" + DB;
    private final String USER="root";
    private final String PASSWORD="2002";
    private Connection con = null;
    public static Conexion instancia;
            
    public Connection getConexion()
    {
        try
        {
            Class.forName(DRIVER);
            this.con = DriverManager.getConnection(URL,USER,PASSWORD);
            
        }catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return this.con;
    }
    
    public void Desconectar()
    {
        try
        {
         this.con.close();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static Connection getCon()
    {
        String DRIVER="com.mysql.cj.jdbc.Driver";
        String DB="tiendaRopaP"; 
        String URL="jdbc:mysql://localhost:3306/" + DB;
        String USER="root";
        String PASSWORD="2002";
        /*String url = "jdbc:mysql://localhost:3307/"
                + "database=tiendaropa;"
                + "user=root;";
        String password = "";*/
        try
        {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            return con;
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e.toString());
            return null;
        }
    }
    public static Conexion getinstancia()
    {
        if(instancia==null)
            instancia = new Conexion();
        return instancia;
    }
}
