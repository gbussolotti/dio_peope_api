package com.gustavobussolotti.personapi.entity;

import com.gustavobussolotti.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data       //Getter and Setters
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)   //O item é not null
    private PhoneType type;

    @Column(nullable = false)
    private String number;

    /*
    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person person;

     */
}
