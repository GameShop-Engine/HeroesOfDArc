package com.mygame;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.basic.Player;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector4f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;

import jme3tools.optimize.GeometryBatchFactory;
import jme3tools.optimize.TextureAtlas;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

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

//        Quad q = new Quad(1,1);
//        Geometry geom = new Geometry("Quad", q);
//
//        ATMS bigTexture = new ATMS("Big", 16384, 16384);
//        bigTexture.layer.drawCircle(bigTexture.width/2, bigTexture.height/2, bigTexture.width, new Vector4f(255,255,255,255));
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setTexture("ColorMap", new Texture2D(bigTexture.makeATMS()));
//        geom.setMaterial(mat);
//        rootNode.attachChild(geom);
//        geom.rotate(0,180,0);
//        Box b = new Box(1, 1, 1);
//        Geometry geom = new Geometry("Box", b);
//
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Blue);
//        geom.setMaterial(mat);
//
//        rootNode.attachChild(geom);
        App app = new App(this);

        flyCam.setEnabled(false);

//        for (int i = 0; i < 2; i++) {
//            Sphere s = new Sphere(30, 30, 1);
//            Geometry geom = new Geometry("Sphere", s);
//
//           // geom.move(App.random(-10, 10), App.random(-10, 10), App.random(-10, 10));
//            Material mat = new Material(App.app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
//            ATMS random = App.defaultATMS;
//            //random.layer.drawCircle((int) App.random(0,20), (int) App.random(0,20), 5, new Vector4f(255,0,0,255));
//            mat.setTexture("ColorMap", new Texture2D(random.makeATMS()));
//            geom.setMaterial(mat);
//
//            rootNode.attachChild(geom);
//        }
        //getViewPort().setBackgroundColor(ColorRGBA.White);
//        for (int i = 0; i < 2; i++) {
            Player player = new Player();
////
//        }

//        Runtime runtime = Runtime.getRuntime();
//
//        // Run garbage collector to get a more accurate picture of current memory usage
//        runtime.gc();
//
//        // Get total memory allocated to the JVM
//        long totalMemory = runtime.totalMemory(); // in bytes
//
//        // Get free memory available within the allocated total memory
//        long freeMemory = runtime.freeMemory(); // in bytes
//
//        // Calculate used memory
//        long usedMemory = totalMemory - freeMemory; // in bytes
//
//        // Convert bytes to megabytes for easier readability
//        long totalMemoryMB = totalMemory / (1024 * 1024);
//        long freeMemoryMB = freeMemory / (1024 * 1024);
//        long usedMemoryMB = usedMemory / (1024 * 1024);
//
//        // Print the memory information
//        System.out.println("JVM Memory Usage:");
//        System.out.println("  Total Memory: " + totalMemoryMB + " MB");
//        System.out.println("  Free Memory:  " + freeMemoryMB + " MB");
//        System.out.println("  Used Memory:  " + usedMemoryMB + " MB");
//
//        System.out.println(settings.isVSync());
//        System.out.println(settings.getFrameRate());
//        System.out.println(settings.getFrequency());

       //GeometryBatchFactory.optimize(rootNode, true);
        //Geometry geom = TextureAtlas.makeAtlasBatch(rootNode, assetManager, 4096);

        //rootNode.detachAllChildren();
    }

    boolean checked = false;
    float elapsed = 0f;
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code

        elapsed+=tpf;
        if (elapsed > 5 && !checked){
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

            checked = true;
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}

