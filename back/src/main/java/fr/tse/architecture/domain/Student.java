package fr.tse.architecture.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Student {
    private @Id @GeneratedValue Long id;

    private String firstname;

    private String lastname;

    private String promotion;


    public Student(String firstname, String lastname, String promotion) {
        this.firstname = firstname;
        this.lastname  = lastname;
        this.promotion = promotion;
    }

    public Student() {

    }
}
