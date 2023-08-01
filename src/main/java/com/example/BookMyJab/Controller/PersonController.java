package com.example.BookMyJab.Controller;

import com.example.BookMyJab.Dto.request.addPersonDto;
import com.example.BookMyJab.Dto.responce.PersonResponceDTO;
import com.example.BookMyJab.Model.Person;
import com.example.BookMyJab.Service.PersonService;
import com.example.BookMyJab.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody addPersonDto addPersonDto){
        try{
            PersonResponceDTO personeResponce = personService.addPerson(addPersonDto);
            return new ResponseEntity(personeResponce, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity("Person already Exits", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/updateEmail")
    public ResponseEntity updateEmail(@RequestParam("oldEmail") String oldEmail, @RequestParam("newEmail")String newEmail){
        try{
            String updateEmail = personService.updateEmail(oldEmail,newEmail);
            return new ResponseEntity(updateEmail,HttpStatus.ACCEPTED);
        }catch (PersonNotFoundException p){
            return new ResponseEntity<>(p.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
