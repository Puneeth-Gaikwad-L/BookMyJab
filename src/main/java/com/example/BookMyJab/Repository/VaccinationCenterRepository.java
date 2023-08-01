package com.example.BookMyJab.Repository;

import com.example.BookMyJab.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
    VaccinationCenter findByLicenceNo(int licenceNo);

    VaccinationCenter findByCenterId(String centerId);
}
