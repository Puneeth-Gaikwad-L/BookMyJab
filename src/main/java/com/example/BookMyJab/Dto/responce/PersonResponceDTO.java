package com.example.BookMyJab.Dto.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonResponceDTO {

    String name;

    int age;

    String emailId;
}
