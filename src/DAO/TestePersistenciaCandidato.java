/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Candidato;
import br.com.estagio.model.Curso;
import br.com.estagio.model.Endereco;
import br.com.estagio.model.Habilidade;
import br.com.estagio.model.Logradouro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author victor
 */
public class TestePersistenciaCandidato {
    
     public static void main(String[] args){
        
        EntityManager em = EntityManagerUtil.getEntityManager();
       
        em.getTransaction().begin();
        /* List<Habilidade> listHabilidade;
        Query q = em.createQuery("select h from Habilidade h");
        listHabilidade = q.getResultList();
        System.out.println(listHabilidade.size());
        
        for(Habilidade h:listHabilidade){
        
        System.out.println(h.getDescricao());
        }
       
       // em.persist(pj);*/
        Candidato ca = new Candidato();
        Curso c = new Curso();
        Endereco e = new Endereco();
        Logradouro l = new Logradouro();
        Habilidade ha = new Habilidade();
        List<Habilidade> list = new ArrayList<Habilidade>();
        
        l = em.find(Logradouro.class,217);
        e.setLogradouro(l);
        e.setComplemento("Apt 300");
        e.setNumero(new Long(220));
       
        ca.setEndereco(e);
        c = em.find(Curso.class, 1L);
        ca.setCurso(c);
        
       // ha = em.find(Habilidade.class, 1);
       // h.add(ha);
       // System.out.println(h.size());
        String hql = "FROM Habilidade H WHERE H.id in (1,5,10)";
        Query query = em.createQuery(hql);
       // query.setParameter("id","1,5,10");
        list = query.getResultList();
              
        for(Habilidade lista:list){
             System.out.println(lista.getDescricao());
        }
        
        ca.setHabilidades(list);
        ca.setCpf(new Long(01503672522));
        ca.setNome("Joao da SIlva");
        ca.setStatus("D");
        ca.setRg(new Long(123456789));
        ca.setNivel_escolaridade("Nivel Superior: 5° Semestre");
        ca.setEmail("joao@hotamial.com");
        ca.setSexo("M");
        em.persist(ca);
        
        em.getTransaction().commit();
    }
}
