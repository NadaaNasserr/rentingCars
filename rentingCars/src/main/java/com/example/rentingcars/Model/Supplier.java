package com.example.rentingcars.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;
    private String phone_number;
    private Integer numberOfCrs;




    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private Set<Car> cars;

}
