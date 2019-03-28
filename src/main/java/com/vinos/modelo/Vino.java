/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinos.modelo;

import com.vinos.modelo.enums.TipoVino;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sissy
 */
@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Vino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private String nombre;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_marca", nullable = false, referencedColumnName = "id")
    private Marca marca;
    @Enumerated(EnumType.STRING)
    private TipoVino tipo;
    private Double precio;
    private Integer anio;
    @Column(length = 75)
    private String pais;
    @Column(length = 90)
    private String external_id;
    @Column(length = 200)
    private String foto;
    @Override
    public String toString() {
        return "com.vinos.modelo.Vino[ id=" + id + " ]";
    }    
}
