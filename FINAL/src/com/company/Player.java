package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Player extends Thread {
    private SharedData e1;
    private int p;
    Player(SharedData c, int p){
        e1=c;
        this.p=p;

    }
    //can use array also but by using set reference it will create distinct number list
    Set<Integer> set= new HashSet<Integer>();

    public void createRandom() {
        Object[] arr= new Object[10];

        while(set.size()!=10) {
            Random rand_no = new Random();
            int n = rand_no.nextInt(50);

            set.add(n);

        }
        Iterator iterator = set.iterator();
        for(int i=0;i<10;i++){
            arr[i]=iterator.next();

        }
    }
    public void printList(){
        System.out.println(" Player " + p +": "+ set);

    }
    public void run(){
        int val;
        int cnt=0;
        for(int i=0;i<10;i++){
            if(p==1) {
                val = e1.get1();
            }
            else{
                val=e1.get2();
            }
            if(set.contains(val)){
                // for ensuring that if moderator generates same number more than 1 time
                // than it will be counted as 1 time only
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    int next = iterator.next();
                    if (next==val) {
                        iterator.remove();
                    }
                }


                cnt++;
            }
            if(cnt==3){
                System.out.println("The winner is player:" + p);
                System.exit(0);

            }

        }

    }
}
