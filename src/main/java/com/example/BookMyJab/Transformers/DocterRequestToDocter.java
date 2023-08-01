package com.example.BookMyJab.Transformers;

import com.example.BookMyJab.Dto.request.DoctorRequestDto;
import com.example.BookMyJab.Model.Doctor;

public class DocterRequestToDocter {
    public static Doctor DocterRequestDtoToDocter(DoctorRequestDto doctorRequestDto){
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .emailId(doctorRequestDto.getEmailId())
                .gender(doctorRequestDto.getGender())
                .build();
    }
}
