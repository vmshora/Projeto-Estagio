package br.com.estagio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_logradouro",referencedColumnName="id",nullable=false)
    private Logradouro logradouro;
    private Long numero;
 
    @Column(name="complemento", length=80)
    private String complemento;

}
