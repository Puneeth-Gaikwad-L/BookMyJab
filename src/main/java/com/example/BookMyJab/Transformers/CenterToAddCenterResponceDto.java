package com.example.BookMyJab.Transformers;

import com.example.BookMyJab.Dto.responce.AddCenterResponceDto;
import com.example.BookMyJab.Model.VaccinationCenter;

public class CenterToAddCenterResponceDto {
    public static AddCenterResponceDto CenterToResponce(VaccinationCenter center){
        return AddCenterResponceDto.builder()
                .centerName(center.getCenterName())
                .centerType(center.getCenterType())
                .address(center.getAddress())
                .build();
    }
}
