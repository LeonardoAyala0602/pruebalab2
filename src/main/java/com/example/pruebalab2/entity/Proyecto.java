package com.example.pruebalab2.entity;

import javax.persistence.*;

@Entity
@Table(name="proyectos")
public class Proyecto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idproyecto")
    private Integer idproyecto;
    @Column(name="nombreproyecto")
    private String nombreproyecto;
    @Column(name="usuario_owner")
    private String usuario_owner;



    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getUsuario_owner() {
        return usuario_owner;
    }

    public void setUsuario_owner(String usuario_owner) {
        this.usuario_owner = usuario_owner;
    }






}
