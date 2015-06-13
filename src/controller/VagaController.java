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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class VagaController {
    
      PessoaJuridicaDao pj = new PessoaJuridicaDao();
      CursoDao c = new CursoDao();
      HabilidadeDao h = new HabilidadeDao();
      VagaDao v = new VagaDao();  
        
        public List<PessoaJuridica> popularEmpresas(){
      
          return pj.listaEmpresas(); 
        }
        
          
         public List<Curso> popularCursos(){
        
          return c.listaCursos();
        
         }  
         
         public List<Habilidade> pupulaHabilidades(){
            
             return h.listaHabilidades();
         }
         
         public void salvarVaga(Vaga vaga){
             
             
             v.salvar(vaga);
             
         }
        
          public void exluirVaga(Long id){
             
             
             v.excluir(id);
             
         }
         public void pupularTabela(DefaultTableModel mTable, Long cod){
             
             if(cod == null){
                 
                 for(Vaga va:v.listaVagas()){
                     mTable.addRow(new Object[] {va.getId(),va.getEmpresa(),va.getCurso(),va.getTurno(),va.getDt_cadastro(),va.getStatus()});
                 }
             }
         }
         
         public Vaga preencherCampos(Long id){
           
            return v.buscaPorId(id);
         }
    }
                 
    
         
       
  
