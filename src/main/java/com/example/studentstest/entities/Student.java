package com.example.studentstest.entities;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "telefon")
    private String telefon;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "facultate_id" , referencedColumnName = "id")
    private Facultate facultate;
}

