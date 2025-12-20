package com.hotel.booking.airbnb.repositories;

import com.hotel.booking.airbnb.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
