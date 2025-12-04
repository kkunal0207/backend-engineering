package com.hotel.booking.airbnb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelBookingApplication implements CommandLineRunner {

    @Autowired
    PaymentServiceWithBean paymentServiceWithBean;

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApplication.class, args);

//        PaymentServiceWithoutBean paymentServiceObj = new PaymentServiceWithoutBean();
//        paymentServiceObj.pay();


    }

    @Override
    public void run(String... args) throws Exception {
        paymentServiceWithBean.pay();

    }
}
