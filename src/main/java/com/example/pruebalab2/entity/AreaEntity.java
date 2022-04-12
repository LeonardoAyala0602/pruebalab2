package com.example.pruebalab2.entity;

import javax.persistence.*;

@Entity
@Table(name="areas")
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarea")
    private int idarea;

    @Column(name="nombrearea")
    private String nombrearea;

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public String getNombreArea() {
        return nombrearea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombrearea = nombreArea;
    }
}
