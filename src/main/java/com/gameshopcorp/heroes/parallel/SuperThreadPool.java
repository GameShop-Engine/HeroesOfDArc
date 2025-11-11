package com.gameshopcorp.heroes.parallel;

import java.util.ArrayList;

public class SuperThreadPool {

    public boolean halt;

    public boolean done;
    public ArrayList<SuperThread> threads;

    public SuperThreadPool(){
        halt = false;
        threads = new ArrayList<>();
    }

    public void addThread(SuperThread thread){

        if (!halt){
            threads.add(thread);
        }
    }

    public void startThreads(){
        //if (!halt){
            for (SuperThread s: threads){
                if (s.getState() == Thread.State.NEW) {
                    s.start();
                }
            }
       // }
    }

    public boolean isDone(){

        int d = 0;
        for (SuperThread s: threads){
            if (s.done){
                d++;
            }
        }

        if (d == threads.size()){
            return true;
        }

        return false;
    }


    public void cleanup(){

        halt = true;

//        for (SuperThread s: threads){
//            if (s.done){
//                try {
//                    s.join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
        ArrayList<SuperThread> temp = new ArrayList<>();

        for (SuperThread s: threads){
            if (!s.done){
               temp.add(s);
            }
        }

//        for(SuperThread s: threads){
//            s = null;
//        }
//        Runtime.getRuntime().gc();
        threads.clear();
        threads.addAll(temp);
    }

}
