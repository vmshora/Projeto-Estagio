/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Curso;
import br.com.estagio.model.Habilidade;
import br.com.estagio.model.Vaga;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author victor
 */
public class CursoDao {
     
        
    public void salvar(Curso curso) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
           
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (curso.getId() == null) {
                //Salva os dados da pessoa.
                em.persist(curso);
            } else {
                //Atualiza os dados da pessoa.
                curso = em.merge(curso);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
       
    }
            
      public List<Curso> listaCursos() {
                
           List<Curso> vagas = new ArrayList<Curso>();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("select v from Curso v");
            vagas = q.getResultList();
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return vagas;
                
        }
 }    
              



