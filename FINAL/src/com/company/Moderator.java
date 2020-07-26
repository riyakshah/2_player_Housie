package com.company;

import java.util.ArrayList;
import java.util.Random;

//Proxy Design Pattern

interface Executer {
    void create_no(String access) ;
}
    public class Moderator extends Thread implements Executer {
    ArrayList<Integer> arrli= new ArrayList<Integer>();
        private SharedData c1;
        private int n;

        public Moderator(SharedData c, int n){
            c1=c;
            this.n=n;
        }

        public void create_no(String access){}

        public void run() {

            for(int i=0;i<10;i++) {
                Random rand_no= new Random();
                int n= rand_no.nextInt(50);
                arrli.add(n);
                System.out.println("Moderator generated: " + n);

                c1.put(n);

                try {
                    sleep(1000);
                }
                catch(InterruptedException e){
                    System.out.println(e);
                }


            }
        }

    }
    //Proxy design pattern
    class Proxy implements Executer{
        boolean ifAccess;

        Moderator mod;
        public Proxy (String name, String password, SharedData s) {
            if(name.equals("Moderator") && password.equals("mod@123")) {
                ifAccess=true;
                mod = new Moderator(s,1);
            }
        }
        public  Moderator getObject(){
            return mod;

        }
        public void create_no(String access) {
            if(!ifAccess) {
                System.out.println("Wrong Password");
                System.exit(0);

            }

        }
    }


