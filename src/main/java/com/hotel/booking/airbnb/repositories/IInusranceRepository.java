package com.hotel.booking.airbnb.repositories;

import com.hotel.booking.airbnb.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInusranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
