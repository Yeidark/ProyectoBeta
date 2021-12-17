/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Productos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface ProductosFacadeLocal {

    void create(Productos productos);

    void edit(Productos productos);

    void remove(Productos productos);

    Productos find(Object id);

    List<Productos> findAll();

    List<Productos> findRange(int[] range);

    int count();

    public List<Productos> leerTodo();
    
    public boolean agregarProducto(Productos prodagr, int idProducto, int idTipoProducto);
    
}
