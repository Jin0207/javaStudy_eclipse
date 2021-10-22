package com.sist.exam01;

public class FinallyTest {
    public static String print(){
        try{
            return "Value";
        }finally {
            System.out.println("finally clause");
        }
    }

    public static void main(String[] args) {
        System.out.println(print());
    }

}
