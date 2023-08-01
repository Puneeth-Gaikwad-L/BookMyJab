package com.example.BookMyJab.Transformers;

import com.example.BookMyJab.Dto.responce.AppointmentResponceDto;
import com.example.BookMyJab.Dto.responce.DoseResponceDTO;
import com.example.BookMyJab.Model.Dose;

public class DoseTransformer {

    public static DoseResponceDTO DoseToDoseResponceDto(Dose dose, AppointmentResponceDto appointmentResponceDto){
        return DoseResponceDTO.builder()
                .doseId(dose.getDoseId())
                .doseType(dose.getDoseType())
                .vaccinationDate(dose.getVaccinationDate())
                .doseNumber(appointmentResponceDto.getDoseNumer())
                .appointmentResponceDto(appointmentResponceDto)
                .build();
    }
}
