package com.example.BookMyJab.Service;

import com.example.BookMyJab.Dto.request.DoctorRequestDto;
import com.example.BookMyJab.Dto.responce.AddCenterResponceDto;
import com.example.BookMyJab.Dto.responce.DoctorResponceDto;
import com.example.BookMyJab.Model.Doctor;
import com.example.BookMyJab.Model.VaccinationCenter;
import com.example.BookMyJab.Repository.DoctorRepository;
import com.example.BookMyJab.Repository.VaccinationCenterRepository;
import com.example.BookMyJab.Transformers.CenterToAddCenterResponceDto;
import com.example.BookMyJab.Transformers.DocterRequestToDocter;
import com.example.BookMyJab.Transformers.DoctorToDoctorResponceDto;
import com.example.BookMyJab.exception.CenterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    DoctorRepository doctorRepository;
    public DoctorResponceDto addDocter(DoctorRequestDto doctorRequestDto) {
        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findByCenterId(doctorRequestDto.getCenterId());
        if (vaccinationCenter == null){
            throw new CenterNotFoundException("Sorry! Wrong Center Id");
        }
        Doctor doctor = new Doctor();
//        doctor = DoctorRepository.findByEmailId(doctorRequestDto.getEmailId());

        doctor = DocterRequestToDocter.DocterRequestDtoToDocter(doctorRequestDto);
        doctor.setVaccinationCenter(vaccinationCenter);

        vaccinationCenter.getDocters().add(doctor);

        VaccinationCenter savedCenter = vaccinationCenterRepository.save(vaccinationCenter);

        List<Doctor> docters = savedCenter.getDocters();
        Doctor savedDocter = docters.get(docters.size()-1);

        DoctorResponceDto doctorResponceDto = DoctorToDoctorResponceDto.DocterToResponce(savedDocter);
        doctorResponceDto.setMessage("Congrats " + savedDocter.getName()+ " you have been registered");

        AddCenterResponceDto addCenterResponceDto = CenterToAddCenterResponceDto.CenterToResponce(savedCenter);
        doctorResponceDto.setAddCenterResponceDto(addCenterResponceDto);

        return doctorResponceDto;
    }

    public List<String> getbyAgeGreaterThan(int age) {

        List<Doctor> doctors = doctorRepository.getbyAgeGreaterThan(age);
        List<String> ans = new ArrayList<>();

        for (Doctor d : doctors){
            ans.add(d.getName());
        }
        return ans;
    }


}

