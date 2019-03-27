/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "persona")
@Setter
@Getter
@EqualsAndHashCode
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10)
    private String cedula;
    @Column(length = 50)
    private String apellidos;
    @Column(length = 50)
    private String nombres;
    @Column(length = 20)
    private String telefono;
    @Column(length = 200)
    private String direccion;
    private Boolean estado = true;
    @Column(length = 90)
    private String external_id;
    @JsonbTransient
    @OneToOne(mappedBy = "persona")
    private Cuenta cuenta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @Override
    public String toString() {
        return apellidos + " " + nombres;
    }

}
