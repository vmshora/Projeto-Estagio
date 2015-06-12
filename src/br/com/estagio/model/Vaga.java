package br.com.estagio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author victor
 */
@Entity
@Table(name="vaga")
public class Vaga implements Serializable{

    public Vaga() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    @Column(name="descricao", length=200, nullable=false)
    private String descricao;
    private Date dt_cadastro;
    private Date dt_fim;
    @Column(name="turno", length=10, nullable=false)
    private String turno;

    @Column(name="status", length=1, nullable=false)
    private String status;
    private Integer valor_bolsa;
    @ManyToOne
    @JoinColumn(name="id_curso",referencedColumnName="id",nullable=false)
    private Curso curso;
    @Column(name="ds_beneficio", length=200, nullable=false)
    private String ds_beneficio;
    @ManyToOne
    @JoinColumn(name="id_pessoa_juridica",referencedColumnName="id",nullable=false)
    private PessoaJuridica empresa;
    @OneToMany(mappedBy = "id")
    private List<Candidato> candidatos;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="vaga_habilidade", joinColumns={@JoinColumn(name="id_vaga")}, inverseJoinColumns={@JoinColumn(name="id_habilidade")})
    private List<Habilidade> habilidades;

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

      public List<Candidato> getCandidatos() {
    return candidatos;
    }
    
    public void setCandidatos(List<Candidato> candidatos) {
    this.candidatos = candidatos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public Date getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(Date dt_fim) {
        this.dt_fim = dt_fim;
    }

    public Integer getValor_bolsa() {
        return valor_bolsa;
    }

    public void setValor_bolsa(Integer valor_bolsa) {
        this.valor_bolsa = valor_bolsa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getDs_beneficio() {
        return ds_beneficio;
    }

    public void setDs_beneficio(String ds_beneficio) {
        this.ds_beneficio = ds_beneficio;
    }

    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public void setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
    }

   
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        final Vaga other = (Vaga) obj;
        return true;
    }

}
