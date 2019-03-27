/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sissy
 */
@Entity
@Table(name = "cuenta")
@Setter
@Getter
@EqualsAndHashCode
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String clave;
    @Column(length = 100)
    private String token;
    private Boolean estado = true;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn (name = "id_persona", nullable = false, referencedColumnName = "id")
    private Persona persona;
    @Column(length = 90)
    private String external_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;    
    private Integer tipo = 2;//1 para administrador, 2 para usuario
    @Override
    public String toString() {
        return "com.vinos.modelo.Cuenta[ id=" + id + " ]";
    }
    
}
