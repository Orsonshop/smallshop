package com.example.smallshop.api.bean;

import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForZonedDateTime;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;



    @Column
    private String password;

    public User(){

    }



    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(Integer id, String name, String password) {
        this.id=id;
        this.name = name;
        this.password=password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}