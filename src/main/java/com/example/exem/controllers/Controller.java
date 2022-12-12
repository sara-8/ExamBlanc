package com.example.exem.controllers;


import com.example.exem.Repository.ParkingRepo;
import com.example.exem.Repository.PersonnelRepo;
import com.example.exem.Repository.ZoneRepo;
import com.example.exem.entities.Parking;
import com.example.exem.entities.Personnel;
import com.example.exem.entities.Poste;
import com.example.exem.entities.Zone;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Exam")

public class Controller {
    @Autowired
    ParkingRepo parkingRepo ;
    @Autowired
    PersonnelRepo personnelRepo ;
    @Autowired
    ZoneRepo zoneRepo;


    @PostMapping("/addPersonnel")
    Personnel ajouterPersonnel(@RequestBody Personnel personnel){
        return personnelRepo.save(personnel) ;
    }
    @PostMapping("/addParking")
    @Transactional
    void ajoutParkingZones(@RequestBody Parking parking){
        List<Zone> zones =new ArrayList<>() ;
        zones =  parking.getZones() ;

        if(zones==null )
        { parkingRepo.save(parking) ; }
            else {
            parkingRepo.save(parking) ;
            for(Zone zone : zones){

              zoneRepo.save(zone) ;
        }
            }}




@PutMapping("/affPZ/{idZone}/{idGarde}")
void affecterPersonnelZone(@PathVariable int idZone ,@PathVariable int idGarde){
Zone zone=zoneRepo.findById(idZone).orElse(null) ;
Personnel personnel=personnelRepo.findById(idGarde).orElse(null) ;
if (zone!=null && personnel!=null) {

    zone.setPersonnel(personnel);
    personnel.setZone(zone);
    zoneRepo.save(zone);
    personnelRepo.save(personnel);
}}


@PutMapping("/getAlPerbyParkin")
List<Personnel> getAllPersoByPar(@RequestBody Parking parking){
        List<Zone> zones=new  ArrayList<>() ;
        List<Personnel> personnels=new  ArrayList<>() ;

        zones=zoneRepo.findByParkingId(parking.getId()) ;
        for(Zone zone : zones){
            personnels.add((Personnel) zone.getPersonnels()) ;

        }
        return personnels;
}
@GetMapping("/{startDate}/{endDate}")
public List<Personnel> getPersonnalByDate(@PathVariable  Date startDate ,@PathVariable Date endDate){
    List<Personnel> personnels = null;
    for(Personnel personnel : personnelRepo.findAll()){
            if(personnel.getDateDeRecrutement().after(startDate) && personnel.getDateDeRecrutement().before(endDate)){
                personnels.add(personnel) ;

            }}
    return personnels ;
}


    @Scheduled(fixedRate = 20000)
public void getNbrGardesByZone(){

        List<Zone> zones ;
        zones=zoneRepo.findAllByPersonnelsPoste (Poste.GARGE_JOUR);
        int nb=0 ;
                nb = zones.size() ;
        log.info("nbbbbbbbbbbb" + nb );
}




}
