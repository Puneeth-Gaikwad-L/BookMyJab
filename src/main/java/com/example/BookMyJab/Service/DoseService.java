package com.example.BookMyJab.Service;

import com.example.BookMyJab.Dto.responce.AppointmentResponceDto;
import com.example.BookMyJab.Dto.responce.DoseResponceDTO;
import com.example.BookMyJab.Enum.Dosetype;
import com.example.BookMyJab.Model.Dose;
import com.example.BookMyJab.Model.Person;
import com.example.BookMyJab.Repository.DoctorRepository;
import com.example.BookMyJab.Repository.PersonRepository;
import com.example.BookMyJab.Transformers.DoseTransformer;
import com.example.BookMyJab.exception.PersonNotFoundException;
import com.example.BookMyJab.exception.PersonVaccinatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorRepository doctorRepository;
    public DoseResponceDTO getDose(String emailId, Dosetype doseType) {
       Person person = personRepository.findByEmailId(emailId);
       if (person == null){
           throw new PersonNotFoundException("Invalid emailId");
       }
        Dose dose = new Dose();
       if(!person.isDoseOnetaken()){
           dose.setDoseId(String.valueOf(UUID.randomUUID()));
           dose.setDoseType(doseType);
           dose.setPerson(person);
           person.getDosesTaken().add(dose);
           person.setDoseOnetaken(true);
           Person savedPerson = personRepository.save(person);
           AppointmentResponceDto appointmentResponceDto = appointmentService.bookAppointment(savedPerson.getEmailId(),doctorRepository.getRandomDoctor());
           return DoseTransformer.DoseToDoseResponceDto(savedPerson.getDosesTaken().get(0), appointmentResponceDto);
       }else if(!person.isDoseTwotaken()){
           dose.setDoseId(String.valueOf(UUID.randomUUID()));
           dose.setDoseType(person.getDosesTaken().get(0).getDoseType());
           dose.setPerson(person);
           person.getDosesTaken().add(dose);
           person.setDoseTwotaken(true);
           Person savedPerson = personRepository.save(person);
           AppointmentResponceDto appointmentResponceDto = appointmentService.bookAppointment(savedPerson.getEmailId(), doctorRepository.getRandomDoctor());
           return DoseTransformer.DoseToDoseResponceDto(savedPerson.getDosesTaken().get(1),appointmentResponceDto);
        }else {
           throw new PersonVaccinatedException("Congrats "+person.getName()+" you are already Vaccinated");
       }
    }
}
