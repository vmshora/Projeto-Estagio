/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CandidatoDao;
import DAO.CandidatoVagaDao;
import DAO.VagaDao;
import br.com.estagio.model.Candidato;
import br.com.estagio.model.CandidatoVaga;
import br.com.estagio.model.Curso;
import br.com.estagio.model.PessoaJuridica;
import br.com.estagio.model.Vaga;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class VagaCandidatoController {
    
   CandidatoVagaDao candVDao = new CandidatoVagaDao();
   CandidatoDao candDao = new CandidatoDao();
    VagaDao v = new VagaDao();  
    CandidatoVaga va = new CandidatoVaga();  
   
   public void excluirVagaCandidato(Long id_vaga, Candidato ca){
       
       candVDao.excluir(id_vaga, ca);
       
   }
   
   public Candidato buscaCandidato(Long id){
      
       return candVDao.buscaCandidato(id);
      
   }
   

        
}
