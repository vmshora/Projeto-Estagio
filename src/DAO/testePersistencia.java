/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Candidato;
import br.com.estagio.model.Cidade;
import br.com.estagio.model.Curso;
import br.com.estagio.model.Endereco;
import br.com.estagio.model.Habilidade;
import br.com.estagio.model.Logradouro;
import br.com.estagio.model.PessoaJuridica;
import static java.lang.reflect.Array.set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author victor
 */
public class testePersistencia {
    
    public static void main(String[] args){
        
        EntityManager em = EntityManagerUtil.getEntityManager();
       
        em.getTransaction().begin();
        Candidato c = new Candidato();
        c = em.find(Candidato.class, 3L);
        
        for(Habilidade listaH:c.getHabilidades()){
            System.out.println(listaH.getDescricao());
        }
        System.out.println(c.getEndereco().getLogradouro().getBairro().getCidade().getNome());
       
        em.getTransaction().commit();
    }
    }
            
