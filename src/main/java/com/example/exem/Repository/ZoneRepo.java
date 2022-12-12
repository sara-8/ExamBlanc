package com.example.exem.Repository;

import com.example.exem.entities.Personnel;
import com.example.exem.entities.Poste;
import com.example.exem.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepo extends JpaRepository<Zone,Integer> {
    List<Zone> findByParkingId(int idparking) ;
    List<Zone> findAllByPersonnelsPoste(Poste poste);
}
