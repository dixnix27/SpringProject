package com.example.studentstest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "facultati")
@Data
public class Facultate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "facultate")
    private String facultate;

    @JsonIgnore
    @OneToOne(mappedBy = "facultate")
    private Student student;
}
