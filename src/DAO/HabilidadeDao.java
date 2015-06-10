/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Habilidade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author victor
 */
public class HabilidadeDao {

      public void salvar(Habilidade h) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
           
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (h.getId() == null) {
                //Salva os dados da pessoa.
                em.persist(h);
            } else {
                //Atualiza os dados da pessoa.
                h = em.merge(h);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
       
    }
            
      public List<Habilidade> listaHabilidades() {
                
           List<Habilidade> listH = new ArrayList<Habilidade>();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("select h from Habilidade h");
            listH = q.getResultList();
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return listH;
                
        }
 }    

