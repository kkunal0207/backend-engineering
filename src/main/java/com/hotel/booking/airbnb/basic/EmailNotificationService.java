package com.hotel.booking.airbnb.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailNotif")
@ConditionalOnProperty(name = "Notification.type",havingValue = "email")
public class EmailNotificationService implements INotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email sent.."+message);
    }
}
