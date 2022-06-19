/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

public class Ropa 
{
    private int idropa;
    private String nombre,nombretalla,nombreCprenda;
    private String descripcion;
    private double precio_costo;
    private double precio_venta;
    private double ganancia;
    private String genero;
    private String marca;
    private String imagen;
    private int idtipoprenda,existencias;

    public Ropa() {
    }

    
    public Ropa(int idropa,String nombre,String decripcion,Double precio_costo
                ,Double precio_venta,Double ganancia,String genero,String marca,int existencia
                ,String nombretalla,String nombreCprenda){
        this.idropa = idropa;
        this.nombre = nombre;
        this.descripcion = decripcion;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_costo;
        this.ganancia = ganancia;
        this.genero = genero;
        this.marca = marca;
        this.existencias = existencia;
        this.nombretalla = nombretalla;
        this.nombreCprenda = nombreCprenda;
    }

    public String getNombretalla() {
        return nombretalla;
    }

    public void setNombretalla(String nombretalla) {
        this.nombretalla = nombretalla;
    }

    public String getNombreCprenda() {
        return nombreCprenda;
    }

    public void setNombreCprenda(String nombreCprenda) {
        this.nombreCprenda = nombreCprenda;
    }
    
    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdropa() {
        return idropa;
    }

    public void setIdropa(int idropa) {
        this.idropa = idropa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdtipoprenda() {
        return idtipoprenda;
    }

    public void setIdtipoprenda(int idtipoprenda) {
        this.idtipoprenda = idtipoprenda;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }
    
    
}
