package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    public static void main(String[] args) throws IOException {

       System.out.println("Moderator please enter the password");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pass= reader.readLine();
        //Singleton design pattern is used in SharedData.java
        SharedData s=SharedData.getInstance();
        //password for moderator is set as mod@123, otherwise it will give output as "wrong password"
        //used proxy design pattern in moderator.java to control access
        Proxy prox= new Proxy ("Moderator",pass,s);
        prox.create_no("Moderator");


        System.out.println("Game Started");
        Player pla1= new Player(s,1);
        Player pla2= new Player(s,2);
        pla1.createRandom();
        pla2.createRandom();
        pla1.printList();
        pla2.printList();

        Moderator mod= prox.getObject();

        mod.start();
        pla1.start();
        pla2.start();
        try{
            pla2.join();
            pla1.join();
            mod.join();

        }
        catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("NOBODY WINS");


    }

}
