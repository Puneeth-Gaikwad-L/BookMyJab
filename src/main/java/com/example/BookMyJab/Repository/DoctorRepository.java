package com.example.BookMyJab.Repository;

import com.example.BookMyJab.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    Doctor findByEmailId(String emailId);

    @Query(value = "Select * from doctor where age > :age",nativeQuery = true)
    List<Doctor> getbyAgeGreaterThan(int age);

    @Query(value = "Select email_id from doctor ORDER BY RAND() Limit 1",nativeQuery = true)
    String getRandomDoctor();

}
