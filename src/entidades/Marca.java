/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author andreaas
 */
public class Marca 
{
    public Marca() {
    }
    private int id;
    private int codigomarca;
    private String nombremarca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigomarca() {
        return codigomarca;
    }

    public void setCodigomarca(int codigomarca) {
        this.codigomarca = codigomarca;
    }

    public String getNombremarca() {
        return nombremarca;
    }

    public void setNombremarca(String nom_marca) {
        this.nombremarca = nom_marca;
    }

    public Marca(int codigomarca, String nombremarca) {
        this.codigomarca = codigomarca;
        this.nombremarca = nombremarca;
    }

}
