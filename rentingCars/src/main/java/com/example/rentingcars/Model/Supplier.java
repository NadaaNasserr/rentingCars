package com.example.rentingcars.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Supplier {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "please enter name ")
    @Column(columnDefinition = "varchar(35) not null")
    private String name;
    private String username;
    private String password;

    @NotEmpty(message = "please enter phone number ")
    @Column(columnDefinition = "varchar(35) not null unique")
    private String phone_number;






//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier")
//    private Set<Rental> rentals;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier")
    private Set<Car> cars;



//    @ManyToOne
//    @JoinColumn(name = "admin_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private Admin admin;


}
