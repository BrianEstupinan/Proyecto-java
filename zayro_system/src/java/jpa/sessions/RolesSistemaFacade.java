/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.RolesSistema;

/**
 *
 * @author FAMILIA
 */
@Stateless
public class RolesSistemaFacade extends AbstractFacade<RolesSistema> {

    @PersistenceContext(unitName = "zayro_systemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesSistemaFacade() {
        super(RolesSistema.class);
    }
    
}
