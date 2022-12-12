package com.example.exem.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Zone  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String ref ;
    private float dimension ;


    @ManyToOne
    private Parking parking ;
    @OneToOne
    private Personnel personnel;

    @OneToMany
    private List<Personnel> personnels ;
}

