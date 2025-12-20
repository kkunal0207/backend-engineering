package com.hotel.booking.airbnb.repositories;

import com.hotel.booking.airbnb.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
}
