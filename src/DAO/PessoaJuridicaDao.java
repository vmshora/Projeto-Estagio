/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
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
public class PessoaJuridicaDao {
   
    
      public void salvar(PessoaJuridica pj) throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
           
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (pj.getId() == null) {
                //Salva os dados da pessoa.
                em.persist(pj);
            } else {
                //Atualiza os dados da pessoa.
                pj = em.merge(pj);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }
       
    }
            
      public List<PessoaJuridica> listaEmpresas() {
                
           List<PessoaJuridica> listPJ = new ArrayList<PessoaJuridica>();
           
           EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            em.getTransaction().begin();
            Query q = em.createQuery("select p from PessoaJuridica p");
            listPJ = q.getResultList();
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
           
           return listPJ;
                
        }
 }    
