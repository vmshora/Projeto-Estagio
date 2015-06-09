/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Endereco;
import br.com.estagio.model.Logradouro;
import br.com.estagio.model.PessoaJuridica;
import javax.persistence.EntityManager;

/**
 *
 * @author victor
 */
public class TestePersistenciaPessoaJuridica {
  
     public static void main(String[] args){
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        PessoaJuridica pj = new PessoaJuridica();
        Endereco e = new Endereco();
        Logradouro l = new Logradouro();
        l = em.find(Logradouro.class,217);
        System.out.println(l.getDs_logradouro());
        e.setLogradouro(l);
        e.setComplemento("Apt 290");
        e.setNumero(new Long(120));
        pj.setEndereco(e);
        pj.setCnpj("33.372.251/0001-56");
        pj.setDs_tipo("Empresa");
        pj.setEmail("ibm@ibm.com.br");
        pj.setNome("IBM");
        pj.setRazao_social("IBM Brasil Indústria de Máquinas e Serviços Ltda");
        em.getTransaction().begin();
        em.persist(pj);
        em.getTransaction().commit();
    }
}
