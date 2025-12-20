package com.hotel.booking.airbnb.exceptions;

public class EHTryCatchNesting {

    void execute(int a, int b,String s) {
        try {
            System.out.println("Statement 1");
            a = a + b;
            int result = a / b;
            try {
                System.out.println(s.length());
            } catch (NullPointerException e) {
                System.out.println("In Inner try");
            } finally {
                System.out.println("Inner finally");
            }
            System.out.println("Inner try terminated");
        }catch(ArithmeticException e){
            System.out.println("outer catch");
        }finally{
            System.out.println("Outer finally");
        }
        System.out.println("Outer try terminated");
    }

    public static void main(String[] args){
        EHTryCatchNesting eh = new EHTryCatchNesting();
        eh.execute(20,0,"abc");
    }
}


