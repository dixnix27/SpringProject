package com.example.studentstest.repositories;

import com.example.studentstest.entities.Facultate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultateRepository extends JpaRepository<Facultate,Long> {
}
