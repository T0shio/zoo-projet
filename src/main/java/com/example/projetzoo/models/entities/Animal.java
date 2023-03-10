package com.example.projetzoo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Animal extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String species;
    @Column(nullable = false)
    private String sex;
    @ManyToOne
    private Area areas;
    @ManyToMany
    @JoinTable(name = "animal_healer")
    private List<Employee> employees;
    @ManyToOne
    private Zoo zoo;
    @ManyToOne
    private Paddock paddocks;
}
