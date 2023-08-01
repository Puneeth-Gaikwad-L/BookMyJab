package com.example.BookMyJab.Controller;

import com.example.BookMyJab.Dto.request.AddCenterRequestDto;
import com.example.BookMyJab.Dto.responce.AddCenterResponceDto;
import com.example.BookMyJab.Service.VaccinationCenterService;
import com.example.BookMyJab.exception.CenterExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("/add-center")
    public ResponseEntity addCenter(@RequestBody AddCenterRequestDto addCenterRequestDto){
        try{
            AddCenterResponceDto addCenterResponceDto = vaccinationCenterService.addCenter(addCenterRequestDto);
            return new ResponseEntity(addCenterResponceDto, HttpStatus.ACCEPTED);
        }catch (CenterExistsException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
