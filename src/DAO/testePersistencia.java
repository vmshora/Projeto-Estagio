/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Cidade;
import javax.persistence.EntityManager;

/**
 *
 * @author victor
 */
public class testePersistencia {
    
    public static void main(String[] args){
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        Cidade c = new Cidade();
        c.setNome("teste");
        c.setUf("te");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    }
            
