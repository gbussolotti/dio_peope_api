package com.gustavobussolotti.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)   //O item é not null
    private String firstName;

    @Column(nullable = false)   //O item é not null
    private String lastName;

    @Column(nullable = false, unique = true)   //O item é not null e unique
    private String cpf;


    private LocalDate birthDate;

    //@OneToMany (fetch = FetchType.LAZY, mappedBy = "person",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    //Se não especificar o mappedBy , será gerada uma tabela auxiliar
    private List<Phone> phones;
}
