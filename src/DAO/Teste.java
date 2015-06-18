/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Candidato;
import br.com.estagio.model.CandidatoVaga;
import br.com.estagio.model.PessoaJuridica;
import br.com.estagio.model.Vaga;
import br.com.estagio.view.MyCheckBox;
import controller.VagaController;
import javax.persistence.EntityManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author victor
 */
public class Teste {
    
    public static void main(String[] args) throws SQLException {
        Candidato c = new Candidato();
        CandidatoVaga cV = new CandidatoVaga();
        List<CandidatoVaga> listaVa = new ArrayList<>();
        Vaga v = new Vaga();
        Candidato cand = new Candidato(); 
        List<Vaga> listaV = new ArrayList<>();
        
        EntityManager em = EntityManagerUtil.getEntityManager();
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstagiandoPU");
        //EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
       // v = em.find(Vaga.class, 3L);
        //MyCheckBox myCheckBox = new MyCheckBox();
        /* c = em.find(Candidato.class, 3L);
        cV.setCandidato(c);
        cV.setVaga(v);
        em.persist(cV);
        em.getTransaction().commit();
        em.close();*/
         cand = em.find(Candidato.class, 3L);
          Query q = em.createQuery("select v from CandidatoVaga v where v.candidato.id = 3 and v.vaga.empresa = :empresa and v.vaga.curso = :curso");
        // Query q = em.createQuery("select v from Vaga v");
        // listaV = q.getResultList();
         listaVa =  q.getResultList();
         em.getTransaction().commit();
         em.close();
          for (CandidatoVaga obj : listaVa ) {        
              
              System.out.println(obj.getCandidato());
       
          }
              
    }
}
