package com.example.BookMyJab.Dto.responce;

import com.example.BookMyJab.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AddCenterResponceDto {
    String centerName;

    CenterType centerType;

    String address;
}
