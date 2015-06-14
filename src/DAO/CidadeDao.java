/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Cidade;
import br.com.estagio.model.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mazcarvalho
 */
public class CidadeDao {
    
    public static Cidade buscaCidadePorId(Integer codigo){
        
         List<Cidade> cidades = new ArrayList<Cidade>();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("from Cidade c where c.id = :codigo");
            q.setParameter("codigo", codigo);
            cidades = q.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }           
           return cidades.get(0);
    }
    
    public List<Cidade> listaCidades() {
                
           List<Cidade> cidades = new ArrayList<Cidade>();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("select c from Cidade c");
            cidades = q.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }           
           return cidades;
                
        }  
    
}
