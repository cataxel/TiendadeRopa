/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author axel
 */
public class Ventas {
    int idVenta,idRopa,cantidad;
    double total, Descuento, Iva;
    boolean Estado;
    String folioVenta,fecha;
    int preciov,existencias;

    public Ventas(){    
    }
    public Ventas(int preciov, int existencias){
        this.preciov = preciov;
        this.existencias = existencias;
    }
    public Ventas(int idVenta,int idRopa,String folioventa, String Fecha,double Total,double Descuento
    ,double IVA,boolean Estado,int Cantidad){
        this.idVenta = idVenta;
        this.idRopa = idRopa;
        this.folioVenta = folioventa;
        this.fecha = Fecha;
        this.total = Total;
        this.Descuento = Descuento;
        this.Iva = IVA;
        this.Estado = Estado;
        this.cantidad = Cantidad;
    }

    public int getPreciov() {
        return preciov;
    }

    public void setPreciov(int preciov) {
        this.preciov = preciov;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(int idRopa) {
        this.idRopa = idRopa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getIva() {
        return Iva;
    }

    public void setIva(double Iva) {
        this.Iva = Iva;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public String getFolioVenta() {
        return folioVenta;
    }

    public void setFolioVenta(String folioVenta) {
        this.folioVenta = folioVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
