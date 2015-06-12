package br.com.estagio.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable{

    public Curso() {
    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Id
    private Long id;
    @Column(name="ds_curso", length=20, nullable=false)
    private String ds_curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDs_curso() {
        return ds_curso;
    }

    public void setDs_curso(String ds_curso) {
        this.ds_curso = ds_curso;
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return this.ds_curso;
    }
}
