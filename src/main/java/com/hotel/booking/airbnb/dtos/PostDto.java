package com.hotel.booking.airbnb.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostDto {

    private Long id;
    private String title;
    private String description;
}
