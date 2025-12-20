package com.hotel.booking.airbnb.exceptions;

class UnderAgeException extends Exception{
    public UnderAgeException(String message){
        super(message);
    }
}

class OverAgeException extends Exception{
    public OverAgeException(String message){
        super(message);
    }
}

class Applicant {
    public void verify(int age) throws UnderAgeException , OverAgeException{
        if(age>=18 && age<=60){
            System.out.println("You can proceed !");
        }else if(age<18){
            throw new UnderAgeException("Yo are Under Age, wait for another "+ (18-age) + " years");
        }else{
            throw new OverAgeException("You are overAge and should take rest now !");
        }
    }
}

class Rto{
    public void initiate(int age){
        Applicant applicant = new Applicant();
        try {
            applicant.verify(age);
        }catch(UnderAgeException | OverAgeException exception){
            System.out.println(exception.getMessage());
        }
    }
}

public class CustomException{
    public static void main(String[] args){
        Rto rto = new Rto();
        rto.initiate(65);
    }

}
