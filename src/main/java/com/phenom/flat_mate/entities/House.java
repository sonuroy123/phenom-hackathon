package com.phenom.flat_mate.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String location;
    private int bhk;
    private boolean furnished;

    private String status;
    private String roomType;
    private Double rent;
    private Integer roomCount;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<HouseImages> images = new ArrayList<>();
}
