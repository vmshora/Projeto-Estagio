/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CursoDao;
import DAO.HabilidadeDao;
import DAO.PessoaJuridicaDao;
import DAO.VagaDao;
import br.com.estagio.model.Curso;
import br.com.estagio.model.Habilidade;
import br.com.estagio.model.PessoaJuridica;
import br.com.estagio.model.Vaga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victor
 */
public class VagaController {
    
      PessoaJuridicaDao pj = new PessoaJuridicaDao();
      CursoDao c = new CursoDao();
      HabilidadeDao h = new HabilidadeDao();
      List<PessoaJuridica> listPJ; //= new ArrayList<PessoaJuridica>();
      List<Curso> listC;
      List<Habilidade> listH; 
      VagaDao v = new VagaDao();  
        
        public List<PessoaJuridica> popularEmpresas(){
        listPJ = pj.listaEmpresas();
       
          return listPJ;  
        }
        
          
         public List<Curso> popularCursos(){
        
          listC = c.listaCursos();
          
          return listC;
        
         }  
         
         public List<Habilidade> pupulaHabilidades(){
             
             listH = h.listaHabilidades();
             
             return listH;
         }
         
         public void salvarVaga(Vaga vaga){
             
             
             v.salvar(vaga);
             
         }

    }
                 
    
         
       
  
