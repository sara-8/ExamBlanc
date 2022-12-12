package com.example.exem.Repository;

import com.example.exem.entities.Personnel;
import com.example.exem.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelRepo extends JpaRepository<Personnel,Integer> {
List<Personnel > findByPoste(Poste poste);
}
