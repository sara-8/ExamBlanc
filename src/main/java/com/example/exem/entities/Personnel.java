package com.example.exem.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nom ;
    private String prenom ;
    private int age ;
    @Temporal(TemporalType.DATE)
    private Date dateDeRecrutement ;
    private String login ;
    private String password  ;


    @Enumerated(EnumType.STRING)
    private Poste poste ;

    @OneToOne(mappedBy = "personnel")
    private Zone zone ;

}
