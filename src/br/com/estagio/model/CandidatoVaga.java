/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "candidato_vaga")
@IdClass(CandidatoVagaId.class)
public class CandidatoVaga implements Serializable{

    public CandidatoVaga() {
    }
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_candidato")
    private Candidato candidato;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_vaga")
    private Vaga vaga;
    
    @Column(name="statusSelecionado", length=1)
    private String statusSelecionado;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public String getStatusSelecionado() {
        return statusSelecionado;
    }

    public void setStatusSelecionado(String statusSelecionado) {
        this.statusSelecionado = statusSelecionado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CandidatoVaga other = (CandidatoVaga) obj;
        return true;
    }

  

       
}
