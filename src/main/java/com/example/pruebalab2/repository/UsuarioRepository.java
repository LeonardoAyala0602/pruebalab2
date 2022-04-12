package com.example.pruebalab2.repository;

import com.example.pruebalab2.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,String> {

    List<UsuarioEntity> findByIdarea(int idarea);

    @Query(value = "select * from idarea where idarea = ?1",nativeQuery = true)
    List<UsuarioEntity> buscarUsuarioPorIdArea(int idarea);
}
