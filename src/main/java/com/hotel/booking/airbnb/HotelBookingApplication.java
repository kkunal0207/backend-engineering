package com.hotel.booking.airbnb;

import com.hotel.booking.airbnb.impl.EmailNotificationService;
import com.hotel.booking.airbnb.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelBookingApplication implements CommandLineRunner {

//    @Autowired
//    PaymentServiceWithBean paymentServiceWithBean;
//    @Autowired
    INotificationService notifService;

    public HotelBookingApplication (
//            @Qualifier("smsNotif")INotificationService notificationService){ // Note: this qualifer checks from qualifier name in the class and then injects that class
            INotificationService notificationService){
        this.notifService = notificationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApplication.class, args);

//        PaymentServiceWithoutBean paymentServiceObj = new PaymentServiceWithoutBean();
//        paymentServiceObj.pay();


    }

    @Override
    public void run(String... args) throws Exception {
//        paymentServiceWithBean.pay();

//        INotificationService notificationService = new EmailNotificationService();
//        INotificationService smsNotificationService = new SmsNotificationService();
//        notificationService.send("hello");
//        smsNotificationService.send("hi");

        notifService.send("helloo..");

    }
}
