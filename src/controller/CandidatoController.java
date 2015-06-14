/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CandidatoDao;
import DAO.PessoaJuridicaDao;
import br.com.estagio.model.Candidato;
import br.com.estagio.model.Curso;
import br.com.estagio.model.PessoaJuridica;
import java.util.List;

/**
 *
 * @author mazcarvalho
 */
public class CandidatoController {
    
    
    CandidatoDao c = new CandidatoDao();
    PessoaJuridicaDao pj = new PessoaJuridicaDao();
     
     public List<Curso> popularCursos(){        
           return c.listaCursos();           
     }  
     
     public List<PessoaJuridica> popularInstituicao(){
         return pj.listaInstituicaoEnsino();
     }    
     
     public void salvarCandidato(Candidato candidato) throws Exception{           
             c.salvar(candidato);             
     }
     
     
    
    
    
    
    
    
    
}
