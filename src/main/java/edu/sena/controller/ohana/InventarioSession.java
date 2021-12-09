/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;

import edu.sena.entity.ohana.Inventario;
import edu.sena.facade.ohana.InventarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author 57301
 */
@Named(value = "inventarioSession")
@SessionScoped
public class InventarioSession implements Serializable {
@EJB
InventarioFacadeLocal inventarioFacadeLocal;

private Inventario stockTem = new Inventario();
private Inventario stockAgr = new Inventario();
    /**
     * Creates a new instance of InventarioSession
     */
    public InventarioSession() {
    }
    
    public List<Inventario> leerTodo(){
        return inventarioFacadeLocal.findAll();
    }
    
        public void agregarStock() {
        if (inventarioFacadeLocal.agregarStock(stockAgr)) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'Agregado con exito', "
                    + " 'success'"
                    + ")");;
        } else {
            PrimeFaces.current().executeScript("Swal.fire("
                    + " 'Producto',"
                    + " 'No se pudo agregar', "
                    + " 'error'"
                    + ")");
        }

    }
    
    public String cargarStock(Inventario invIn){
        stockTem = invIn;
        return "areatrabajo-inventario_stock-editar";
    }
    
    public void editarStock(){
        try {
            inventarioFacadeLocal.edit(stockTem);
        } catch (Exception e) {
        }
    }
    
    public void removerStock(Inventario invIn){
        try {
            inventarioFacadeLocal.remove(invIn);
        } catch (Exception e) {
        }
    }

    public Inventario getStockTem() {
        return stockTem;
    }

    public void setStockTem(Inventario stockTem) {
        this.stockTem = stockTem;
    }

    public Inventario getStockAgr() {
        return stockAgr;
    }

    public void setStockAgr(Inventario stockAgr) {
        this.stockAgr = stockAgr;
    }
    
}
