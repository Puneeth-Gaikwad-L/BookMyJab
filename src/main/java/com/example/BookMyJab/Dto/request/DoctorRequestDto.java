package com.example.BookMyJab.Dto.request;

import com.example.BookMyJab.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDto {
    String centerId;

    String name;

    int age;

    String emailId;

    Gender gender;
}
