package com.phenom.flat_mate.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HouseImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id")
    private House house;
}
