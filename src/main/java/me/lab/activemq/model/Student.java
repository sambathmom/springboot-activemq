package me.lab.activemq.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
}
