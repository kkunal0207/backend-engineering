package com.hotel.booking.airbnb.exceptions;

public class EHThrowThrows {

   static  void calculate(int a, int b) throws ArithmeticException{
        System.out.println("Calculation started");
        try {
            int result = a / b;
            System.out.println(result);
//            return result;
        }catch(Exception e){
            System.out.println("Exception is caugth: "+e.getMessage());
//            throw e;
        }
        finally {
            System.out.println("calculation terminated");
        }
       System.out.println("calculation terminated after finally");
    }

    public static void main(String[] args){
        System.out.println("Inside main");
        try {
            calculate(10, 0);
        }catch(Exception e){
            System.out.println("Exception is caught in main:"+e);
        }
        System.out.println("Main terminated");
    }
}
