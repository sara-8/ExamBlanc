package com.example.exem.Repository;

import com.example.exem.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepo extends JpaRepository<Parking,Integer> {

}
