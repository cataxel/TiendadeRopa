/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.ropaDAO;
import entidades.Ropa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axel
 */
public class RopaControl {
    private final ropaDAO datos;
    private Ropa obj;
    private DefaultTableModel modelotabla;
    private int registrosMostrados;

    public RopaControl() {
        this.datos = new ropaDAO();
        this.obj = new Ropa();
        this.registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(){
        List<Ropa> lista = new ArrayList();
        lista.addAll(datos.listar());
        String titulos[] = {"id","Nombre","Descripcion","P.Costo","P.Venta","Genero",
        "Marca","Ganancia","Existencia","Clase","Tipo"};
        modelotabla = new DefaultTableModel(null,titulos);
        String registro[] = new String[11];
        registrosMostrados = 0;
        for(Ropa item:lista){
            registro[0] = Integer.toString(item.getIdropa());
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();
            registro[3] = Double.toString(item.getPrecio_costo());
            registro[4] = Double.toString(item.getPrecio_venta());
            registro[5] = item.getGenero();
            registro[6] = item.getMarca();
            registro[7] = Double.toString(item.getGanancia());
            registro[8] = Integer.toString(item.getExistencias());
            registro[9] = item.getNombretalla();
            registro[10] = item.getNombreCprenda();
            
            modelotabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modelotabla;
    }
    public List Marcas(){
        return datos.marcas();
    }
    public List Tallas(int tipo){
        return datos.tallas(tipo);
    }
    public String insertar(String nombre, String descripcion, double precio_costo, double precio_venta,
            double ganancia, String genero, String marca, String imagen,
            int idtipoprenda, int existencias) {
        obj.setNombre(nombre);
        obj.setDescripcion(descripcion);
        obj.setPrecio_costo(precio_costo);
        obj.setPrecio_venta(precio_venta);
        obj.setGanancia(ganancia);
        obj.setGenero(genero);
        obj.setMarca(marca);
        obj.setImagen(imagen);
        obj.setIdtipoprenda(idtipoprenda);
        obj.setExistencias(existencias);
        if (datos.insertar(obj)) {
            return "OK";
        } else {
            return "Error al insertar";
        }
    }
    
    public String actualizar(int id,String nombre, String descripcion, double precio_costo, double precio_venta,
            double ganancia, String genero, String marca, String imagen,
            int idtipoprenda, int existencias){
        obj.setIdropa(id);
        obj.setNombre(nombre);
        obj.setDescripcion(descripcion);
        obj.setPrecio_costo(precio_costo);
        obj.setPrecio_venta(precio_venta);
        obj.setGanancia(ganancia);
        obj.setGenero(genero);
        obj.setMarca(marca);
        obj.setImagen(imagen);
        obj.setIdtipoprenda(idtipoprenda);
        obj.setExistencias(existencias);
        if(datos.actualizar(obj))
            return "OK";
        else
            return "Error al actualizar";
    }

    public int total() {
        return datos.total();
    }
}
