/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Clientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 57301
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    @Override
    public List<Clientes> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query cli = em.createQuery("SELECT c FROM Clientes c");
        return cli.getResultList();
    }

    @Override
    public boolean crearCliente(Clientes crecli) {
        try {
            Query cli = em.createNativeQuery("INSERT INTO personas (numeroCedula,primerNombre,segundoNombre,primerApellido,segundoApellido,correo,numeroCelular,fechaDeNacimiento,contrasenia) VALUES (?,?,?,?,?,?,?,?,?);");
            cli.setParameter(1, crecli.getPersonas().getNumeroCedula());
            cli.setParameter(2, crecli.getPersonas().getPrimerNombre());
            cli.setParameter(3, crecli.getPersonas().getSegundoNombre());
            cli.setParameter(4, crecli.getPersonas().getPrimerApellido());
            cli.setParameter(5, crecli.getPersonas().getSegundoApellido());
            cli.setParameter(6, crecli.getPersonas().getCorreo());
            cli.setParameter(7, crecli.getPersonas().getNumeroCelular());
            cli.setParameter(8, crecli.getPersonas().getFechaDeNacimiento());
            cli.setParameter(9, crecli.getPersonas().getContrasenia());
            cli.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}