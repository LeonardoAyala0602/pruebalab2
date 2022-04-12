package com.example.pruebalab2.repository;

import com.example.pruebalab2.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ActividadRepository extends JpaRepository<Actividad, Integer> {

    List<Actividad> findByIdproyecto (int idproyecto);
    @Query(nativeQuery = true,value="select * from actividades where idproyecto = ?1")
    List<Actividad> listaActividadesporProyecto (int idproyecto);
}
