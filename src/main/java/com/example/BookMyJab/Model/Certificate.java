package com.example.BookMyJab.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String certificateId;

    String confirmationMessage;

    @OneToOne
    @JoinColumn(name = "personId",referencedColumnName = "emailId")
    Person person;
}
