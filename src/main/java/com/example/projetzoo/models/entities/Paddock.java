package com.example.projetzoo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Paddock extends BaseEntity {
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaddock;
    @Column(nullable = false)
    private int maxCapacity;
    @ManyToOne
    private Area areas;
    @OneToMany(mappedBy = "paddocks")
    private List<Animal> animals;
}
