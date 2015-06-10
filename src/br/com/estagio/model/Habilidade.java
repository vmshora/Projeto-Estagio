/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author victor
 */
@Entity
@Table(name="habilidade")
public class Habilidade implements Serializable{
  
    public Habilidade() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Integer id;
    @Column(name="descricao", length=20, nullable=false)
    private String descricao;
    
   public Integer getId() {
        return id;
    }

   public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
       
        this.descricao = descricao;
       
    }

     @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Habilidade other = (Habilidade) obj;
        return true;
    }
    
    @Override
    public String toString() {
        return this.descricao;
    }

       
}
