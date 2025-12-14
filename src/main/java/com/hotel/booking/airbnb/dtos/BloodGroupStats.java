package com.hotel.booking.airbnb.dtos;

import com.hotel.booking.airbnb.entities.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BloodGroupStats {

    private final BloodGroupType bloodGroup;
    private final Long count;
}
