/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.interfaces;

import java.util.List;

/**
 *
 * @author axel
 */
public interface crud_ventasInterface<T> {
    public List<T> listar();
    public boolean insertar(T obj);
    public int total();
}
