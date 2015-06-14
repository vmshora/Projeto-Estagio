/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Candidato;
import br.com.estagio.model.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mazcarvalho
 */
public class CandidatoDao {
    
    public void salvar(Candidato candidato) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
           
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (candidato.getId() == null) {
                //Salva os dados da pessoa.
                em.persist(candidato);
            } else {
                //Atualiza os dados da pessoa.
                candidato = em.merge(candidato);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
       
    }
    
    public List<Curso> listaCursos() {
                
           List<Curso> cursos = new ArrayList<Curso>();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("select c from Curso c");
            cursos = q.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }           
           return cursos;
                
        }    
    
}
