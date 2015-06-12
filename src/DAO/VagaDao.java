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
import br.com.estagio.model.Habilidade;
import br.com.estagio.model.Vaga;
import java.sql.SQLException;
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
       
       public void excluir(Vaga vaga) {
       
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            em.remove(vaga);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
          
                
        }
      
 }    
              


