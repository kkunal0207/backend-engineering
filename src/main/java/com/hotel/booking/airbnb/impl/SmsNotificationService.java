package com.hotel.booking.airbnb.impl;

import com.hotel.booking.airbnb.INotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Qualifier("smsNotif")
@ConditionalOnProperty(name = "Notification.type",havingValue = "sms")
public class SmsNotificationService implements INotificationService {
    @Override
    public void send(String message) {
        System.out.println("sms send ..."+message);
    }
}
