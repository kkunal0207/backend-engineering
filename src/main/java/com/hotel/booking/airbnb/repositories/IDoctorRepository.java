package com.hotel.booking.airbnb.repositories;

import com.hotel.booking.airbnb.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<DoctorEntity,Long> {
}
