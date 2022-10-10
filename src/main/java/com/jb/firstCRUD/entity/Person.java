package com.jb.firstCRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_PERSON")
public class Person {
    @Id
    @GeneratedValue
    int id;
    String firstName;
    String lastName;
    String address;
    @Column(name = "phone")
    String mobile;
}
