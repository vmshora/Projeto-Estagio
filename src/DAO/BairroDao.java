/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Bairro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mazcarvalho
 */
public class BairroDao {
    
    public static Bairro buscaBairroPorId(Integer codigo){
         List<Bairro> bairros = new ArrayList<Bairro>();
        
         EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("from Bairro b where b.id = :codigo");
            q.setParameter("codigo", codigo);
            bairros = q.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return bairros.get(0);
    }
    
    
}
