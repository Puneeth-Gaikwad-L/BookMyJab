package com.example.BookMyJab.Controller;

import com.example.BookMyJab.Dto.responce.AppointmentResponceDto;
import com.example.BookMyJab.Service.AppointmentService;
import com.example.BookMyJab.exception.DoctorNotFoundException;
import com.example.BookMyJab.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestParam("p") String personEmailId, @RequestParam("d") String doctorEmailId){
       try {
           AppointmentResponceDto appointmentResponceDto = appointmentService.bookAppointment(personEmailId, doctorEmailId);
           return new ResponseEntity(appointmentResponceDto, HttpStatus.ACCEPTED);
       }catch (PersonNotFoundException | DoctorNotFoundException p ){
           return new ResponseEntity(p.getMessage(),HttpStatus.BAD_REQUEST);
       }

    }
}
