package br.com.estagio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    @OneToOne
    @JoinColumn(name="id_curso",referencedColumnName="id",nullable=false)
    private Curso curso;
    @Column(name="ds_beneficio", length=200, nullable=false)
    private String ds_beneficio;
    @ManyToMany
    @JoinTable(name="vaga_habilidade", joinColumns={@JoinColumn(name="id_vaga")}, inverseJoinColumns={@JoinColumn(name="id_habilidade")})
    private Set<Habilidade> habilidades;

    public Set<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<Habilidade> habilidades) {
        this.habilidades = habilidades;
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

    @Transient
    public StatusTipoEnum getStatusTipoEnum() {
        return StatusTipoEnum.fromValue(status);
    }

    public void setStatusTipoEnum(StatusTipoEnum statusEnum) {
        this.status = statusEnum.toValue();
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
