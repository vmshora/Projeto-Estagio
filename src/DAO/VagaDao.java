/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author victor
 */

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Curso;
import br.com.estagio.model.PessoaJuridica;
import br.com.estagio.model.Vaga;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;




/**
 * 
 * @author Bisso
 *
 */
public class VagaDao {
        
       // private DaoHelper daoHelper;
        
        public VagaDao () {
                //daoHelper = new DaoHelper();
        }
        
        
    public void salvar(Vaga vaga){
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            System.out.println("Salvando a vaga.");
            
            if (vaga.getId() == null) {
             System.out.println("persistindo a vaga.");
            em.persist(vaga);
            } else {
            //Atualiza os dados da pessoa.
            vaga = em.merge(vaga);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
       } catch (Exception ex) {
           em.getTransaction().rollback(); 
            ex.printStackTrace();
	   
        } finally {
            em.close();
        }
       
    }
      
       
      public List<Vaga> listaVagas() {
                
           List<Vaga> vagas = new ArrayList<Vaga>();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("select v from Vaga v");
            vagas = q.getResultList();
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return vagas;
                
        }
       public Vaga buscaPorId(Long id) {
                
          Vaga vaga = new Vaga();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            vaga = em.find(Vaga.class, id);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return vaga;
                
        }
       
       public void excluir(Long id) {
       
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("delete from Vaga where id = :id_vaga");
            q.setParameter("id_vaga", id).executeUpdate();
            em.getTransaction().commit();
              
        } finally {
            em.close();
        }
          
                
        }
      
        public List<Vaga> listaVagas(Curso c, PessoaJuridica p) {
                
           List<Vaga> vagas = new ArrayList<Vaga>();
           String param = "where ";
           System.out.println("cheguei fim1");
          if (p != null && c != null){
              param = param + "v.empresa = :empresa and v.curso = :curso";
          }else if (c != null){ 
             param = param + "v.curso = :curso";
          }else{System.out.println("cheguei fim");
              param = param + "v.empresa = :empresa";    
         }
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
          
            em.getTransaction().begin();
            
            Query q = em.createQuery("select v from Vaga v "+ param);
          
           if (c != null){  
            q.setParameter("curso", c);
           }
           if (p != null){
               q.setParameter("empresa", p);
           }
                      
            vagas = q.getResultList();
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return vagas;
                
        }
      
 }    
              


