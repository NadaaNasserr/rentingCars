package com.example.rentingcars.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;
    private Integer phone_number;
    private Integer age;
    private String username;
    private String password;
    private String license;
    private double balance;
    private LocalDate day=LocalDate.now();


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Rental> rentals;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Car> cars;
}
