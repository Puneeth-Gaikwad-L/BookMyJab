package com.example.BookMyJab.Dto.request;

import com.example.BookMyJab.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddCenterRequestDto {

    String centerName;

    CenterType centerType;

    String address;

    int licenceNo;

}
