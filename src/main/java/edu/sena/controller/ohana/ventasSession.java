/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.ohana;


import edu.sena.entity.ohana.Estadodeenvios;
import edu.sena.entity.ohana.Ventas;
import edu.sena.facade.ohana.EstadodeenviosFacadeLocal;
import edu.sena.facade.ohana.VentasFacadeLocal;
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
@Named(value = "ventasSession")
@SessionScoped
public class ventasSession implements Serializable {
@EJB
VentasFacadeLocal ventasFacadeLocal;
EstadodeenviosFacadeLocal estadodeenviosFacadeLocal;
    /**
     * Creates a new instance of ventasSession
     */
    public ventasSession() {
    }
    
    public List<Ventas> leerTodo(){
        return ventasFacadeLocal.leerTodo();
    }
    
            public void cambiarEstado(Estadodeenvios cliE){
        try {
            if(cliE.getIdEstadoDeEnvios().toString().equals("1")){
                cliE.setIdEstadoDeEnvios(Integer.parseInt("2"));
            }else if(cliE.getIdEstadoDeEnvios().toString().equals("2")){
                cliE.setIdEstadoDeEnvios(Integer.parseInt("3"));
            }else if(cliE.getIdEstadoDeEnvios().toString().equals("3")){
                cliE.setIdEstadoDeEnvios(Integer.parseInt("4"));
            }
            estadodeenviosFacadeLocal.edit(cliE);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "'Usuario',"
                    + "'Actualizado con exito !!!'"
                    + "'Error'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "'Usuario',"
                    + "'No se pudo actualizar, intente de nuevo'"
                    + "'Error'"
                    + ")");
        }
    }
}
