package com.example.BookMyJab.Transformers;

import com.example.BookMyJab.Dto.responce.PersonResponceDTO;
import com.example.BookMyJab.Model.Person;

public class PersonTransformer {
    public static PersonResponceDTO PersonToPersonResponceDTO(Person person){
       return  PersonResponceDTO.builder()
               .name(person.getName())
               .emailId(person.getEmailId())
               .age(person.getAge())
               .build();
    }
}
