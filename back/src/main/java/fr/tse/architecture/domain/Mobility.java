package fr.tse.architecture.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Data
@Entity
public class Mobility {

    @Id @GeneratedValue
    private Long id;

    private String country;

    private String city;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate creationDate;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate startDate;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate endDate;

    @ManyToOne
    private Student student;

    public Mobility(String country, String city, LocalDate startDate, LocalDate endDate, Student student) {
        this.country = country;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.student = student;
        this.creationDate = LocalDate.now();
    }

    public Mobility() {
        this.creationDate = LocalDate.now();
    }
}
