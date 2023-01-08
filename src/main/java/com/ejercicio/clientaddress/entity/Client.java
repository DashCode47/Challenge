package com.ejercicio.clientaddress.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CLIENT_TB",uniqueConstraints = @UniqueConstraint(name = "cl_uq",columnNames ="numberId" ))
public class Client {

    @Id
    @GeneratedValue
    private int id;
    private String typeId;

    private String numberId;
    private String name;
    private String email;
    private String phone;
    private String mainCity;
    private String mainProvince;
    private String mainAddress;

    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ca_fk",referencedColumnName = "id")
    private List<Address> addresses;
}
