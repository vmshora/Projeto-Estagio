package br.com.estagio.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "candidato")
public class Candidato implements Serializable{

    public Candidato() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    @Column(name="nome", length=80, nullable=false)
    private String nome;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_endereco",referencedColumnName="id",nullable=false)
    private Endereco endereco;

   

    @ManyToOne
    @JoinColumn(name="id_curso",referencedColumnName="id",nullable=false)
    private Curso curso;
   
    @Temporal(TemporalType.DATE)
    private Calendar dt_nascimento;
   
    @Column(name="nivel_escolaridade", length=50, nullable=false)
    private String nivel_escolaridade;

    private Integer ano_ingresso;

    private Integer ano_conclusao;
    
    @Column(name="sexo", length=1, nullable=false)
    private String sexo;

    @Column(name="status", length=1, nullable=false)
    private String status;

    @Column(name="rg", length=20, nullable=false)
    private Long rg;

    @Column(name="cpf", length=20, nullable=false)
    private Long cpf;

    @Column(name="email", length=20, nullable=false)
    private String email;

    @Column(name="telefone", length=12)
    private String telefone;
    
    @OneToMany(mappedBy = "id")
    private List<Vaga> vagas;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="candidato_habilidade", joinColumns={@JoinColumn(name="id_candidato")}, inverseJoinColumns={@JoinColumn(name="id_habilidade")})
    private List<Habilidade> habilidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Calendar getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Calendar dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getNivel_escolaridade() {
        return nivel_escolaridade;
    }

    public void setNivel_escolaridade(String nivel_escolaridade) {
        this.nivel_escolaridade = nivel_escolaridade;
    }

    public Integer getAno_ingresso() {
        return ano_ingresso;
    }

    public void setAno_ingresso(Integer ano_ingresso) {
        this.ano_ingresso = ano_ingresso;
    }

    public Integer getAno_conclusao() {
        return ano_conclusao;
    }

    public void setAno_conclusao(Integer ano_conclusao) {
        this.ano_conclusao = ano_conclusao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Candidato other = (Candidato) obj;
        return true;
    }
    
}
