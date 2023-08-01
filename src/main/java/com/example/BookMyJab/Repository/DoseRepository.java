package com.example.BookMyJab.Repository;

import com.example.BookMyJab.Enum.Dosetype;
import com.example.BookMyJab.Model.Doctor;
import com.example.BookMyJab.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {


//    Doctor findByEmailId(String emailId);
}
