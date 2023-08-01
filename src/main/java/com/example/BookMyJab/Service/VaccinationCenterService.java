package com.example.BookMyJab.Service;

import com.example.BookMyJab.Dto.request.AddCenterRequestDto;
import com.example.BookMyJab.Dto.responce.AddCenterResponceDto;
import com.example.BookMyJab.Model.VaccinationCenter;
import com.example.BookMyJab.Repository.VaccinationCenterRepository;
import com.example.BookMyJab.Transformers.AddCenterDtoToCenter;
import com.example.BookMyJab.Transformers.CenterToAddCenterResponceDto;
import com.example.BookMyJab.exception.CenterExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public AddCenterResponceDto addCenter(AddCenterRequestDto addCenterRequestDto) {
        VaccinationCenter center = vaccinationCenterRepository.findByLicenceNo(addCenterRequestDto.getLicenceNo());
        if (center != null){
            throw new CenterExistsException("Center already exists");
        }
        center = AddCenterDtoToCenter.addCenterDtoToCenter(addCenterRequestDto);
        center.setCenterId(String.valueOf(UUID.randomUUID()));
       vaccinationCenterRepository.save(center);

       return CenterToAddCenterResponceDto.CenterToResponce(center);
    }
}
