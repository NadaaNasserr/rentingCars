package com.example.rentingcars.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "int not null")
    private Integer id;

    @Column(columnDefinition = "int not null")
    private Integer duration;

    @Pattern(regexp = "^(day|week|Month)$")
    @Column(columnDefinition = "varchar(225) not null")
    private String dur;

    private double total_price;



//    @ManyToOne
//    @JoinColumn(name = "supplier_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;


    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @JsonIgnore
    private Car car;

}
