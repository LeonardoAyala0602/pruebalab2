package com.example.pruebalab2.repository;

import com.example.pruebalab2.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity,Integer> {

}
