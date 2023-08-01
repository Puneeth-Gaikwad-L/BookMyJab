package com.example.BookMyJab.Service;

import com.example.BookMyJab.Dto.request.addPersonDto;
import com.example.BookMyJab.Dto.responce.PersonResponceDTO;
import com.example.BookMyJab.MailSender.MailSender;
import com.example.BookMyJab.Model.Person;
import com.example.BookMyJab.Repository.PersonRepository;
import com.example.BookMyJab.Transformers.PersonTransformer;
import com.example.BookMyJab.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public PersonResponceDTO addPerson(addPersonDto addPersonDto) {
        Person person = new Person();
        person.setName(addPersonDto.getName());
        person.setAge(addPersonDto.getAge());
        person.setEmailId(addPersonDto.getEmailId());
        person.setGender(addPersonDto.getGender());
        Person savedPerson = personRepository.save(person);
        SimpleMailMessage simpleMailMessage = MailSender.personRegisteredMail(savedPerson);
        javaMailSender.send(simpleMailMessage);
        return PersonTransformer.PersonToPersonResponceDTO(savedPerson);
    }

    public String updateEmail(String oldEmail, String newEmail) {
        Person person = personRepository.findByEmailId(oldEmail);
        if(person==null){
            throw new PersonNotFoundException("Person doesn't exits");
        }
        person.setEmailId(newEmail);
        personRepository.save(person);
        return "Email updated successfully";
    }
}
