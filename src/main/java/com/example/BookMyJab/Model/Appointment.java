package com.example.BookMyJab.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @Column(nullable = false)
    String appointmentId;

    @Column(nullable = false)
    @CreationTimestamp
    Date appointmentDate;

    int doseNumber;

    @ManyToOne
    @JoinColumn(name = "personId", referencedColumnName = "emailId")
    Person person;

    @ManyToOne
    @JoinColumn(name = "doctorId",referencedColumnName = "emailId")
    Doctor doctor;
}
