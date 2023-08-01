package com.example.BookMyJab.Transformers;

import com.example.BookMyJab.Dto.responce.AddCenterResponceDto;
import com.example.BookMyJab.Dto.responce.AppointmentResponceDto;
import com.example.BookMyJab.Model.Appointment;
import com.example.BookMyJab.Model.Doctor;
import com.example.BookMyJab.Model.Person;

public class AppointmentToAppointmentResponce {
    public static AppointmentResponceDto appointmentToResponceDto(Appointment appointment, Person person, Doctor doctor, AddCenterResponceDto addCenterResponceDto){
        return AppointmentResponceDto.builder()
                .personName(person.getName())
                .docterNmae(doctor.getName())
                .appointmentId(appointment.getAppointmentId())
                .appointmentDate(appointment.getAppointmentDate())
                .addCenterResponceDto(addCenterResponceDto)
                .doseNumer(appointment.getDoseNumber())
                .build();
    }
}
