/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.estagio.factory.EntityManagerUtil;
import javax.persistence.EntityManager;

import java.sql.Connection;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author victor
 */
public class Teste {
    
    public static void main(String[] args) throws SQLException {
      //EntityManager em = EntityManagerUtil.getEntityManager();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstagiandoPU");
        EntityManager em = emf.createEntityManager();
    }
}
