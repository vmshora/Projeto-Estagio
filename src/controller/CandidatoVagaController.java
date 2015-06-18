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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class CandidatoVagaController {
    
   CandidatoVagaDao candVDao = new CandidatoVagaDao();
   CandidatoDao candDao = new CandidatoDao();
   VagaDao v = new VagaDao();  
    CandidatoVaga va = new CandidatoVaga(); 
   
   public void salvaCandidatoVaga(Long id_vaga, Candidato ca){
       
       candVDao.salvar(id_vaga, ca);
       
   }
   
   public Candidato buscaCandidato(Long id){
      
       return candVDao.buscaCandidato(id);
      
   }
   
       public boolean pupularTabela(DefaultTableModel mTable,Long cod, Curso c, PessoaJuridica p, Long candId){
              
            if(cod == null || cod.equals("")){
             
               if(c != null || p != null){
                 for(CandidatoVaga va:candVDao.listaVagasCandidato(c,p,candId)){
                    
                 mTable.addRow(new Object[] {va.getVaga().getId(),va.getVaga().getEmpresa(),va.getVaga().getCurso(),va.getVaga().getTurno(),va.getVaga().getDt_cadastro(),va.getVaga().getStatus()});
                 } 
                 return true;   
               }else{
                   for(CandidatoVaga va:candVDao.listaVagasCandidato()){
                      mTable.addRow(new Object[] {va.getVaga().getId(),va.getVaga().getEmpresa(),va.getVaga().getCurso(),va.getVaga().getTurno(),va.getVaga().getDt_cadastro(),va.getVaga().getStatus()});
                   }
                     return true;   
                 } 
            }else if(cod != null){  
              va = candVDao.buscaPorId(cod);
                 mTable.addRow(new Object[] {va.getVaga().getId(),va.getVaga().getEmpresa(),va.getVaga().getCurso(),va.getVaga().getTurno(),va.getVaga().getDt_cadastro(),va.getVaga().getStatus()});
                return true; 
            } 
           return false;   
         }
       
 public void excluirVagaCandidato(Long id_vaga, Candidato ca){
       
       candVDao.excluir(id_vaga, ca);
       
   }
}
