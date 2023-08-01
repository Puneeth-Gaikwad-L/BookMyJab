package com.example.BookMyJab.Service;

import com.example.BookMyJab.Dto.responce.AddCenterResponceDto;
import com.example.BookMyJab.Dto.responce.AppointmentResponceDto;
import com.example.BookMyJab.MailSender.MailSender;
import com.example.BookMyJab.Model.Appointment;
import com.example.BookMyJab.Model.Doctor;
import com.example.BookMyJab.Model.Person;
import com.example.BookMyJab.Model.VaccinationCenter;
import com.example.BookMyJab.Repository.AppointmentRepository;
import com.example.BookMyJab.Repository.DoctorRepository;
import com.example.BookMyJab.Repository.PersonRepository;
import com.example.BookMyJab.Transformers.AppointmentToAppointmentResponce;
import com.example.BookMyJab.Transformers.CenterToAddCenterResponceDto;
import com.example.BookMyJab.exception.DoctorNotFoundException;
import com.example.BookMyJab.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    JavaMailSender javaMailSender;
    public AppointmentResponceDto bookAppointment(String personEmailId, String doctorEmailId) {
        Person person = personRepository.findByEmailId(personEmailId);
        Doctor doctor = doctorRepository.findByEmailId(doctorEmailId);

        if (person == null){
            throw new PersonNotFoundException("Invalid personId");
        }
        if (doctor == null){
            throw new DoctorNotFoundException("Invalid DoctorId");
        }

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setDoctor(doctor);
        appointment.setPerson(person);
        appointment.setDoseNumber(person.getDosesTaken().size());

        Appointment savedAppointment = appointmentRepository.save(appointment);

        doctor.getAppointment().add(savedAppointment);
        person.getAppointment().add(savedAppointment);

        Doctor savedDoctor = doctorRepository.save(doctor);
        Person savedPerson = personRepository.save(person);

        VaccinationCenter center = savedDoctor.getVaccinationCenter();
        AddCenterResponceDto addCenterResponceDto = CenterToAddCenterResponceDto.CenterToResponce(center);

        SimpleMailMessage simpleMailMessage = MailSender.appointmentMail(savedPerson,savedAppointment,center,savedDoctor);
        javaMailSender.send(simpleMailMessage);

        return AppointmentToAppointmentResponce.appointmentToResponceDto(savedAppointment,savedPerson,savedDoctor,addCenterResponceDto);
    }
}
