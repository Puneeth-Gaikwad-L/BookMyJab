package com.example.BookMyJab.Dto.request;

import com.example.BookMyJab.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class addPersonDto {

    String name;

    int age;

    String emailId;

    Gender gender;
}
