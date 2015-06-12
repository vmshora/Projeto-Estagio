package br.com.estagio.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="pessoa_juridica")
public class PessoaJuridica implements Serializable{

    public PessoaJuridica() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    @Column(name="nome", length=50, nullable=false)
    private String nome;
    @Column(name="cnpj", length=20, nullable=false)
    private String cnpj;
    @Column(name="razao_social", length=50)
    private String razao_social;
    @Column(name="telefone", length=12)
    private String telefone;
    @Column(name="ds_tipo", length=12)
    private String ds_tipo;
    @Column(name="email", length=20)
    private String email;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="id_endereco",referencedColumnName="id",nullable=false)
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDs_tipo() {
        return ds_tipo;
    }

    public void setDs_tipo(String ds_tipo) {
        this.ds_tipo = ds_tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco id_endereco) {
        this.endereco = id_endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return this.nome;
    }
    
}
