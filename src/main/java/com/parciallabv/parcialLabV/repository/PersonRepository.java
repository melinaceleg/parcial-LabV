package com.parciallabv.parcialLabV.repository;

import com.parciallabv.parcialLabV.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PersonRepository extends JpaRepository<Persona,Integer> {
}
