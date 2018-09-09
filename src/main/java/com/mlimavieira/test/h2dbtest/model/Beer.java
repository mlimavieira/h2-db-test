package com.mlimavieira.test.h2dbtest.model;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;

    public Beer() {
     super();
    }
    public Beer(String name, String type) {
        this.name = name;
        this.type = type;
    }



}
