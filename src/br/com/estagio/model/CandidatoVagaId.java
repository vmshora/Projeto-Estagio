/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.model;

import java.io.Serializable;

/**
 *
 * @author victor
 */
public class CandidatoVagaId implements Serializable{

    public CandidatoVagaId() {
    }
    
    private Long candidato;
    private Long vaga;

    public Long getCandidato() {
        return candidato;
    }

    public void setCandidato(Long candidato) {
        this.candidato = candidato;
    }

    public Long getVaga() {
        return vaga;
    }

    public void setVaga(Long vaga) {
        this.vaga = vaga;
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
        final CandidatoVagaId other = (CandidatoVagaId) obj;
        return true;
    }
    
}
