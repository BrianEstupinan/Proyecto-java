/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EstadoComprobante;

/**
 *
 * @author FAMILIA
 */
@Stateless
public class EstadoComprobanteFacade extends AbstractFacade<EstadoComprobante> {

    @PersistenceContext(unitName = "zayro_systemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoComprobanteFacade() {
        super(EstadoComprobante.class);
    }
    
}
