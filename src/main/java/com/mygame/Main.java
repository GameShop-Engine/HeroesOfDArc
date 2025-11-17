package com.mygame;

import com.gameshopcorp.heroes.app.App;

import com.gameshopcorp.heroes.level.Level;

import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
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



    boolean checked = false;
    float elapsed = 0f;

    int bakeTime = 0;

    Future<String> result;

    @Override
    public void simpleInitApp() {
        App app = new App(this);

        flyCam.setEnabled(false);

        getViewPort().setBackgroundColor(ColorRGBA.Black);

        //com.jme3.renderer.opengl.GLRenderer.
//        new Thread(() -> {
//            for (int i = 0; i < 64; i++) {
//                enqueue(() ->{
//                    Base b = new Base(5, new Vector4f(255,255,255,255));
//                    b.superMesh.bake();
//                    App.scene.attachChild(b.superMesh.node);
//                });
//
//            }
//            GeometryBatchFactory.optimize(App.scene,true);
//        }).start();
        // for (int i = 0; i < 25; i++) {
        Level levelOne = new Level();
        // }
        // GeometryBatchFactory.optimize(App.scene);
        rootNode.attachChild(App.scene);

        showRAM();


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
    public void simpleUpdate(float tpf) {
        super.simpleUpdate(tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }





}


