package com.example.projetzoo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Zoo extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Provider> providers;
    @OneToMany(mappedBy = "zoo")
    private List<Animal> animals;
    @ManyToOne
    private Area areas;
}