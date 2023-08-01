package com.example.BookMyJab.Dto.responce;

import com.example.BookMyJab.Enum.Dosetype;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoseResponceDTO {

    String doseId;

    Dosetype doseType;

    Date vaccinationDate;

    int doseNumber;

    AppointmentResponceDto appointmentResponceDto;
}
