package com.example.pruebalab2.entity;


import javax.persistence.*;

@Entity
@Table(name="actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="idactividad")
    private Integer idactividad;
    @Column(name="nombreactividad")
    private String nombreactividad;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="idproyecto")
    private Integer idproyecto;
    @Column(name="usuario_owner")
    private String usuario_owner;
    @Column(name="peso")
    private Double peso;
    @Column(name="estado")
    private boolean estado;

    public Integer getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public String getNombreactividad() {
        return nombreactividad;
    }

    public void setNombreactividad(String nombreactividad) {
        this.nombreactividad = nombreactividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getUsuario_owner() {
        return usuario_owner;
    }

    public void setUsuario_owner(String usuario_owner) {
        this.usuario_owner = usuario_owner;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
