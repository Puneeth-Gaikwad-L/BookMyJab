package com.example.BookMyJab.Transformers;

import com.example.BookMyJab.Dto.responce.DoctorResponceDto;
import com.example.BookMyJab.Model.Doctor;

public class DoctorToDoctorResponceDto {
    public static DoctorResponceDto DocterToResponce(Doctor doctor){
        return DoctorResponceDto.builder()
                .name(doctor.getName())
                .build();
    }
}
