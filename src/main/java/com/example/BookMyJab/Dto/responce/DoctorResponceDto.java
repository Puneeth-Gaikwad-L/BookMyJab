package com.example.BookMyJab.Dto.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponceDto {
    String name;

    String message;

    AddCenterResponceDto addCenterResponceDto;
}
