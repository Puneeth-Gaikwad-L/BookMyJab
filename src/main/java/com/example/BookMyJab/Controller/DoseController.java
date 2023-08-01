package com.example.BookMyJab.Controller;

import com.example.BookMyJab.Dto.responce.DoseResponceDTO;
import com.example.BookMyJab.Enum.Dosetype;
import com.example.BookMyJab.Service.DoseService;
import com.example.BookMyJab.exception.PersonVaccinatedException;
import com.example.BookMyJab.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;
    @PostMapping("/get-dose")
    public ResponseEntity getDose(@RequestParam("Id") String emailId,@RequestParam("Type") Dosetype doseType ){
        try{
           DoseResponceDTO doseResponceDTO = doseService.getDose(emailId, doseType);
            return new ResponseEntity(doseResponceDTO, HttpStatus.CREATED);
        }catch (PersonVaccinatedException | PersonNotFoundException D){
            return new ResponseEntity(D.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
