package com.example.BookMyJab.Dto.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponceDto {

    String personName;

    String docterNmae;

    String appointmentId;

    Date appointmentDate;

    int doseNumer;

    AddCenterResponceDto addCenterResponceDto;
}
