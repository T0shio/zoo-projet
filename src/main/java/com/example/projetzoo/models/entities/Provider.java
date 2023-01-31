package com.example.projetzoo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Provider extends BaseEntity {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nameProviders;
    @Column(nullable = false)
    private Integer phoneNumber;
    @Column(nullable = false)
    private String productsProvided;
}
