package com.example.exem.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Parking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String designation ;
    private  String adresse  ;
    private int capacite ;


    @OneToMany(mappedBy = "parking",cascade = CascadeType.ALL)
    private List<Zone> zones ;




}
