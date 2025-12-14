package com.hotel.booking.airbnb.repositories;

import com.hotel.booking.airbnb.dtos.BloodGroupStats;
import com.hotel.booking.airbnb.dtos.CPatientInfo;
import com.hotel.booking.airbnb.dtos.IPatientInfo;
import com.hotel.booking.airbnb.entities.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findByEmailContaining(String d);

    @Query("select p.id as id , p.name as name , p.email as email from PatientEntity p")
    List<IPatientInfo> findByPatientInfo();

    @Query("select new com.hotel.booking.airbnb.dtos.CPatientInfo (p.name as name, p.email as email ) from PatientEntity p")
    List<CPatientInfo> findByPatiendInfoConcrete();

    @Query("select new com.hotel.booking.airbnb.dtos.BloodGroupStats (p.bloodGroup, COUNT(p)) " +
        "from PatientEntity p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStats> findCountsByBloodGroup();

    @Transactional
    @Modifying
    @Query("UPDATE PatientEntity p set p.name= :name where p.id = :id")
    int updatePatientsName(@Param("name") String name, @Param("id") Long id);
}
