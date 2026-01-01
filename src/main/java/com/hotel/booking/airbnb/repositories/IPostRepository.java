package com.hotel.booking.airbnb.repositories;

import com.hotel.booking.airbnb.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<PostEntity,Long> {
}
