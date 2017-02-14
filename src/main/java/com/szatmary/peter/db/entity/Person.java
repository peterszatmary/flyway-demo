package com.szatmary.peter.db.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="person")
public @Data class Person {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
}
