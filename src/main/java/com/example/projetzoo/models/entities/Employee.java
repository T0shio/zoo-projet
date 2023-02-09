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
public class Employee extends BaseEntity {
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String jobName;
    @ManyToMany(mappedBy = "employees")
    private List<Area> areas;
    @ManyToMany(mappedBy = "employees")
    private List<Animal> animals;
}
