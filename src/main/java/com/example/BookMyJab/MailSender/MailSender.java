package com.example.BookMyJab.MailSender;

import com.example.BookMyJab.Model.Appointment;
import com.example.BookMyJab.Model.Doctor;
import com.example.BookMyJab.Model.Person;
import com.example.BookMyJab.Model.VaccinationCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender {

    @Autowired
    JavaMailSender javaMailSender;

    public static SimpleMailMessage appointmentMail(Person savedPerson, Appointment savedAppointment, VaccinationCenter center, Doctor savedDoctor){
        String text = "Congrats!! "+savedPerson.getName()+" your appointment has been booked.\n"+"\n"
                +"Appointment Details\n"+"\n"
                +"Name : "+savedPerson.getName()+"\n"
                +"Appointment Id : "+savedAppointment.getAppointmentId()+"\n"
                +"Center name : "+center.getCenterName() + "\n"
                +"Center address : "+center.getAddress()+"\n"
                +"Doctor name : "+savedDoctor.getName()+"\n"
                +"Dose number : "+savedPerson.getDosesTaken().size()+"\n"
                +"Dose type : "+savedPerson.getDosesTaken().get(0).getDoseType()+"\n"
                +"Appointment date and time : "+savedAppointment.getAppointmentDate()+"\n"+"\n"
                +"Thank You \n Puneeth Gaikwad L";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("bookmyjab2023@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Congrats!! "+savedPerson.getName()+" Appointment booked");
        simpleMailMessage.setText(text);

        return simpleMailMessage;
    }

    public static SimpleMailMessage personRegisteredMail(Person person){
        String text = "Congrats "+person.getName()+" you are registered on BookMyJab"+"\n"
                +"Registered Name : "+person.getName()+"\n"
                +"Registered email : "+person.getEmailId()+"\n";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("bookmyjab2023@gmail.com");
        simpleMailMessage.setTo(person.getEmailId());
        simpleMailMessage.setSubject("Congrats!! "+person.getName()+" you are registered");
        simpleMailMessage.setText(text);

        return simpleMailMessage;
    }
}
