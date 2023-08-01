package com.example.BookMyJab.Transformers;

import com.example.BookMyJab.Dto.request.AddCenterRequestDto;
import com.example.BookMyJab.Model.VaccinationCenter;

public class AddCenterDtoToCenter {

    public static VaccinationCenter addCenterDtoToCenter(AddCenterRequestDto addCenterRequestDto){
        return VaccinationCenter.builder()
                .licenceNo(addCenterRequestDto.getLicenceNo())
                .centerName(addCenterRequestDto.getCenterName())
                .centerType(addCenterRequestDto.getCenterType())
                .address(addCenterRequestDto.getAddress())
                .build();
    }
}
