/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Logradouro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mazcarvalho
 */
public class LogradouroDao {
    
    
    public static Logradouro buscaPorCep(String cep){
        
        cep = cep.replace(".","");
        cep = cep.replace("-","");
        
       List<Logradouro> logradouros = new ArrayList<Logradouro>();
        
         EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("from Logradouro l where l.cep = :cep");
            q.setParameter("cep", cep);
            logradouros = q.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return logradouros.get(0);
    }
    
}
