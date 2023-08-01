package com.example.BookMyJab.exception;

public class DoctorNotFoundException extends  RuntimeException{
    public DoctorNotFoundException(String message){
        super(message);
    }
}
