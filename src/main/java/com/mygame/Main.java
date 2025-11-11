package com.mygame;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.basic.Player;
import com.gameshopcorp.heroes.graphics.cloud.SuperMeshCloud;
import com.gameshopcorp.heroes.parallel.SuperCallable;
import com.gameshopcorp.heroes.parallel.SuperLoadable;
import com.gameshopcorp.heroes.parallel.SuperLoader;
import com.gameshopcorp.heroes.parallel.SuperThread;
import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;

import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import jme3tools.optimize.GeometryBatchFactory;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication { //implements SuperLoadable {

    //SuperMeshCloud superMeshCloud;

    int xThreads = 128;
    int sThreads = 4;

    int j = 0;

    //public ArrayList<SuperLoadable> loadables;

    public static void main(String[] args) {
        Main app = new Main();
//        AppSettings appSettings = new AppSettings(true);
//        appSettings.setFrameRate(60);
//        appSettings.setVSync(false);
//        appSettings.setFrequency(0);
//        app.setSettings(appSettings);
        app.start();
    }

    @Override
    public void simpleInitApp() {


        AppSettings appSettings = new AppSettings(true);
        appSettings.setFrameRate(60);
        appSettings.setVSync(false);
        //appSettings.setFrequency(0);
        setSettings(appSettings);

        App app = new App(this);

//        for (int i = 0; i < 64; i++){
//            App.player.add(new Player());
//        }

        loadLevel();

        flyCam.setEnabled(false);

        rootNode.attachChild(App.scene);

    }

    boolean checked = false;
    float elapsed = 0f;

    int bakeTime = 0;

    Future<String> result;

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code

        if (elapsed >= 5 && !checked) {
            loadLevel();

            checked = true;
        }
        elapsed += tpf;
        //System.out.println(tpf);

        //loadLevel();

//        if (result != null){
//            if (result.isDone()){
//
//                load();
//            }
//        }
        // load();

//        elapsed+=tpf;
//        if (elapsed > 1 && !checked){
//            checked = true;
//            loadLevel();
//
//        }

    }

    public void showRAM() {
        //GeometryBatchFactory.optimize(App.scene);
        Runtime runtime = Runtime.getRuntime();

        // Run garbage collector to get a more accurate picture of current memory usage
        runtime.gc();

        // Get total memory allocated to the JVM
        long totalMemory = runtime.totalMemory(); // in bytes

        // Get free memory available within the allocated total memory
        long freeMemory = runtime.freeMemory(); // in bytes

        // Calculate used memory
        long usedMemory = totalMemory - freeMemory; // in bytes

        // Convert bytes to megabytes for easier readability
        long totalMemoryMB = totalMemory / (1024 * 1024);
        long freeMemoryMB = freeMemory / (1024 * 1024);
        long usedMemoryMB = usedMemory / (1024 * 1024);

        // Print the memory information
        System.out.println("JVM Memory Usage:");
        System.out.println("  Total Memory: " + totalMemoryMB + " MB");
        System.out.println("  Free Memory:  " + freeMemoryMB + " MB");
        System.out.println("  Used Memory:  " + usedMemoryMB + " MB");

        System.out.println(settings.isVSync());
        System.out.println(settings.getFrameRate());
        System.out.println(settings.getFrequency());

        //elapsed = 0f;

        //bakeTime++;

    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }


    public void loadLevel() {

        if (App.superMeshCloud.size() < xThreads){
            App.superMeshCloud.add(new SuperMeshCloud());
        }

        if (j < xThreads) {
            if (App.superMeshCloud.get(j) != null) {
                for (int i = 0; i < sThreads; i++) {
                    App.superMeshCloud.get(j).allPlayers.add(new Player());

                }
                App.superMeshCloud.get(j).bake();
            }
            j++;
        }
        /*
        System.out.println("processors " + Runtime.getRuntime().availableProcessors());

//        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors());
//
//        SuperCallable loop = new SuperCallable() {
//
//            @Override
//            public String call() {
//                try {
//                    super.call();
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//                while ( j < xThreads ) {

                    showRAM();
                    //SuperCallable x = new SuperCallable() {

//                        @Override
//                        public String call() throws Exception {
//                            super.call();


//                    try {
//                        Thread.sleep(2000); // Simulate some work
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                            System.out.println("X");
                           // for (int i = 0; i < sThreads; i++) {
                                SuperCallable s = new SuperCallable() {

                                    @Override
                                    public String call() throws Exception {
                                        super.call();
//                                try {
//                                    Thread.sleep(2000); // Simulate some work
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
                                        System.out.println("s");
                                        App.superMeshCloud.add(new SuperMeshCloud());
                                       App.superMeshCloud.get(j).allPlayers.add(new Player());
                                       App.superMeshCloud.get(j).bake();
                                        j++;
                                        //done = true;
                                        //showRAM();
                                        return "";
                                    }
                                };

                                Future<String> result = App.app.enqueue(s);
                                //App.superThreadPool.addThread(s);

                            //}
                            // done = true;


                            return "";
                        }


                   // };

                    //Future<String> result = executor.submit(x);


                    //Executor.(x);
                    //App.startup.addThread(x);


                //}
                return "";
            }

        };

        this.result = executor.submit(loop);

        rootNode.attachChild(App.scene);

         */
    }

}
//    int loadNum = 0;
//    @Override
//    public void load() {

//        if (loadNum < App.player.size()){
//            App.player.get(loadNum).load();
//            if (App.player.get(loadNum).loadNum == App.player.get(loadNum).loadables.size()) {
//                //GeometryBatchFactory.optimize(App.scene);
//                loadNum++;
//            }
//        }
//
//    }
//}

