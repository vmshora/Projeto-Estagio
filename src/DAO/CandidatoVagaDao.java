/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Candidato;
import br.com.estagio.model.CandidatoVaga;
import br.com.estagio.model.Curso;
import br.com.estagio.model.PessoaJuridica;
import br.com.estagio.model.Vaga;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author victor
 */
public class CandidatoVagaDao {

    public CandidatoVagaDao() {
    
    }
    
      public void salvar(Long id_vaga, Candidato ca){
        
        Candidato cand = new Candidato(); 
        Vaga va = new Vaga();
        CandidatoVaga candV = new CandidatoVaga();
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
          
           em.getTransaction().begin();
           cand = em.find(Candidato.class, 3L);
           va = em.find(Vaga.class, id_vaga);
           candV.setCandidato(cand);
           candV.setVaga(va);
            em.persist(candV);
           
            em.getTransaction().commit();
      
       
       } catch (Exception ex) {
           em.getTransaction().rollback(); 
            ex.printStackTrace();
	   
        } finally {
            em.close();
        }
       
    }
     
     public Candidato buscaCandidato(Long id){
     
        Candidato cand = new Candidato(); 
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
          
            em.getTransaction().begin();
           cand = em.find(Candidato.class, id);
            em.getTransaction().commit();
       } catch (Exception ex) {
           em.getTransaction().rollback(); 
            ex.printStackTrace();
	   
        } finally {
            em.close();
           // em.clear();  
        }
       return cand;
    }
    
       public void excluir(Long id_vaga, Candidato ca){
        
        Candidato cand = new Candidato(); 
        Vaga va = new Vaga();
        CandidatoVaga candV = new CandidatoVaga();
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
          
           em.getTransaction().begin();
           cand = em.find(Candidato.class, 3L);
           va = em.find(Vaga.class, id_vaga);
           candV.setCandidato(cand);
           candV.setVaga(va);
            em.merge(candV);
           
            em.getTransaction().commit();
      
       
       } catch (Exception ex) {
           em.getTransaction().rollback(); 
            ex.printStackTrace();
	   
        } finally {
            em.close();
        }
       
    }
       
         public List<CandidatoVaga> listaVagasCandidato(Curso c, PessoaJuridica p, Long candId) {
                
           List<CandidatoVaga> vagas = new ArrayList<CandidatoVaga>();
           Candidato cand = new Candidato(); 
           String param = "where v.candidato = :cand and ";
          
          if (p != null && c != null){
              param = param + "v.empresa = :empresa and v.curso = :curso";
          }else if (c != null){ 
             param = param + "v.vaga.curso = :curso";
          }else{System.out.println("cheguei fim");
              param = param + "v.vaga.empresa = :empresa";    
         }
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
          
            em.getTransaction().begin();
            cand = em.find(Candidato.class, 3L);
            //param = param + "v. = :empresa";    
          Query q = em.createQuery("select v from CandidatoVaga v "+ param);
           
           q.setParameter("cand", cand);
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
      
          public CandidatoVaga buscaPorId(Long id) {
                
          CandidatoVaga vaga = new CandidatoVaga();
           String param = "where v.candidato = :cand and v.vaga.id = :id";
           Candidato cand = new Candidato();
          
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
           // vaga = em.find(CandidatoVaga.class, id);
             cand = em.find(Candidato.class, 3L);
            
          Query q = em.createQuery("select v from CandidatoVaga v "+ param);
           
           q.setParameter("cand", cand);
           q.setParameter("id", id);
           vaga = (CandidatoVaga)q.getSingleResult();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return vaga;
                
        }
      
       public List<CandidatoVaga> listaVagasCandidato() {
                
           List<CandidatoVaga> vagas = new ArrayList<CandidatoVaga>();
           Candidato cand = new Candidato();
           String param = "where v.candidato = :cand";
       
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
          
            em.getTransaction().begin();
            cand = em.find(Candidato.class, 3L);
            
          Query q = em.createQuery("select v from CandidatoVaga v "+ param);
           
           q.setParameter("cand", cand);
          
                      
            vagas = q.getResultList();
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return vagas;
                
        }
}
