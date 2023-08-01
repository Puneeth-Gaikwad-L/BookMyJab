package com.example.BookMyJab.Model;

import com.example.BookMyJab.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true,nullable = false)
    int licenceNo;

    String centerId;   //uuid

    @Column(nullable = false)
    String centerName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    CenterType centerType;

    @Column(nullable = false)
    String address;

    @OneToMany(mappedBy = "vaccinationCenter", cascade = CascadeType.ALL)
    List<Doctor> docters = new ArrayList<>();

}
