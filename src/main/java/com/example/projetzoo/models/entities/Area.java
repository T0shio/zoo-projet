package com.example.projetzoo.models.entities;

import com.example.projetzoo.models.forms.PaddockCreateForm;
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
public class Area extends BaseEntity {
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String environment;
    @OneToMany(mappedBy = "areas")
    private List<Animal> animals;
    @ManyToMany
    private List<Employee> employees;
    @ManyToOne
    private Zoo zoo;
    @ManyToOne
    @JoinColumn(name = "paddock_id")
    private Paddock paddock;

}
