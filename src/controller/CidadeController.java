/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CidadeDao;
import br.com.estagio.model.Cidade;
import java.util.List;

/**
 *
 * @author mazcarvalho
 */
public class CidadeController {
            
       CidadeDao c = new CidadeDao();
    
      public List<Cidade> popularCidades(){        
          return c.listaCidades();          
          
        
     }  
    
}
