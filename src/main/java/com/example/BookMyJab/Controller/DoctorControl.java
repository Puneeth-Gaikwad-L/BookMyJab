package com.example.BookMyJab.Controller;

import com.example.BookMyJab.Dto.request.DoctorRequestDto;
import com.example.BookMyJab.Dto.responce.DoctorResponceDto;
import com.example.BookMyJab.Service.DoctorService;
import com.example.BookMyJab.exception.CenterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docter")
public class DoctorControl {

    @Autowired
    DoctorService doctorService;
    @PostMapping("/add-Docter")
    public ResponseEntity addDocter(@RequestBody DoctorRequestDto doctorRequestDto){
        try{
            DoctorResponceDto doctorResponceDto = doctorService.addDocter(doctorRequestDto);
            return new ResponseEntity(doctorResponceDto, HttpStatus.ACCEPTED);
        }catch (CenterNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getByAge")
    public ResponseEntity getbyAgeGreaterThan(@RequestParam("a") int age){

        List<String> doctors = doctorService.getbyAgeGreaterThan(age);
        return new ResponseEntity<>(doctors,HttpStatus.ACCEPTED);
    }
}
