package com.hotel.booking.airbnb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component // Note: Have Commented this @Component annotation because now for Bean we have defined config class
public class PaymentServiceWithBean {
    public void pay(){
        System.out.println("paying....");
    }

    @PostConstruct
    public void beforeBean() {
        System.out.println("will pay...");
    }

    @PreDestroy
    public void afterBean(){
        System.out.println("Payment done..");
    }
}
