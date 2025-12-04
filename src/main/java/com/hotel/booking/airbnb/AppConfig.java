package com.hotel.booking.airbnb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    PaymentServiceWithBean paymentServiceWithBean(){
        return new PaymentServiceWithBean();
    }
}
