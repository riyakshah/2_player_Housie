package com.company;

//Singleton Design Pattern

public class SharedData {

    private static SharedData instance;


     public static SharedData getInstance(){
         if(instance==null){
             instance = new SharedData();
         }
         return instance;
     }
    private int numb;
    private int flag = 1;

    synchronized void put(int value) {
        while (flag!=1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        flag = 2;
        numb = value;
        notifyAll();
    }


    synchronized int get1() {
        while (flag!=2 ) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);

            }
        }

        flag=3;
        notifyAll();
        return numb;
    }
    synchronized int get2() {
        while (flag!=3) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        flag =1;
        notifyAll();
        return numb;
    }


}
