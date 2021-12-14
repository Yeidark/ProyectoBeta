/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Personas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 57301
 */
@Stateless
public class PersonasFacade extends AbstractFacade<Personas> implements PersonasFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonasFacade() {
        super(Personas.class);
    }

    @Override
    public Personas inicioSesion(String correoIn, String contraseniaIn) {
        try {
            Query p = em.createQuery("SELECT p FROM Personas p WHERE p.correo = :correoIn AND p.contrasenia = :contraseniaIn");
            p.setParameter("correoIn", correoIn);
            p.setParameter("contraseniaIn", contraseniaIn);
            return (Personas) p.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
 
    @Override
    public Personas recuperarContraseña(String correoIn) {
        try {
            Query p = em.createQuery("select p from personas p, roles_personas p where personas.correo = :correoIn;");
            p.setParameter("correoIn", correoIn);
            return (Personas) p.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    } 
    
}
