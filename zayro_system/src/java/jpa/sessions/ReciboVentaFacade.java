/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ReciboVenta;

/**
 *
 * @author FAMILIA
 */
@Stateless
public class ReciboVentaFacade extends AbstractFacade<ReciboVenta> {

    @PersistenceContext(unitName = "zayro_systemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReciboVentaFacade() {
        super(ReciboVenta.class);
    }
    
}
