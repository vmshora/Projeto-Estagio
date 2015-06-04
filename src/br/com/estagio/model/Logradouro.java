package br.com.estagio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="logradouro")
public class Logradouro implements Serializable{

    public Logradouro(){
    }

    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="id_bairro",referencedColumnName="id",nullable=false)
    private Bairro bairro;
    @Column(name="ds_tipo", length=20, nullable=false)
    private String ds_tipo;
    @Column(name="ds_logradouro", length=50, nullable=false)
    private String ds_logradouro;
    @Column(name="cep", length=15, nullable=false)
    private String cep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getDs_tipo() {
        return ds_tipo;
    }

    public void setDs_tipo(String ds_tipo) {
        this.ds_tipo = ds_tipo;
    }

    public String getDs_logradouro() {
        return ds_logradouro;
    }

    public void setDs_logradouro_nome(String ds_logradouro) {
        this.ds_logradouro = ds_logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
        final Logradouro other = (Logradouro) obj;
        return true;
    }

}
