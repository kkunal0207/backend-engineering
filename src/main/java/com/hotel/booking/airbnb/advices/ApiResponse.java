package com.hotel.booking.airbnb.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {


    private LocalDateTime localDate;
    private T data;
    private ApiError error;

    ApiResponse(){
        super();
        localDate = LocalDateTime.now();
    }

    ApiResponse(T data){
        super();
        this.data = data;
        this.localDate = LocalDateTime.now();
    }

    ApiResponse(ApiError error){
        super();
        this.error = error;
        this.localDate = LocalDateTime.now();
    }

}
