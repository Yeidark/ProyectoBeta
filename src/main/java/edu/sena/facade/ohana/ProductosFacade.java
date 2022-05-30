/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josea
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
        @Override
    public List<Productos> leerTodo() {

        em.getEntityManagerFactory().getCache().evictAll();
        Query prod = em.createQuery("SELECT u FROM Productos u");
        return prod.getResultList();
    }

    @Override
    public boolean agregarProducto(Productos prodagr, int idProducto, int idTipoProducto) {
        try {
            Query prod = em.createNativeQuery("INSERT INTO productos (idTipoProducto,Nombres,Foto,Descripcion,Precio,Stock) VALUES (?,?,?,?,?,?);");
            prod.setParameter(1, idTipoProducto);
            prod.setParameter(2, prodagr.getNombres());
            prod.setParameter(3, prodagr.getFoto());
            prod.setParameter(4, prodagr.getDescripcion());
            prod.setParameter(5, prodagr.getPrecio());
            prod.setParameter(6, prodagr.getStock());
            prod.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }

    }
    
}