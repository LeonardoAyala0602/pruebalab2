package com.example.pruebalab2.repository;

import com.example.pruebalab2.entity.AreaEntity;
import com.example.pruebalab2.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity,Integer> {

    @Query(value = "select * from areas",nativeQuery = true)
    List<AreaEntity> listaAreas(int idarea);

}
