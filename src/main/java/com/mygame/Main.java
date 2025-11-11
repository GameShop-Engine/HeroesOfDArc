package com.mygame;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.basic.Player;
import com.gameshopcorp.heroes.character.basic.body.base.Base;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.cloud.SuperMeshCloud;
import com.gameshopcorp.heroes.parallel.SuperThread;
import com.gameshopcorp.heroes.parallel.SuperThreadPool;
import com.gameshopcorp.heroes.supermesh.SuperSquare;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import jme3tools.optimize.GeometryBatchFactory;
import jme3tools.optimize.TextureAtlas;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    //SuperMeshCloud superMeshCloud;

    int xThreads = 1;
    int sThreads = 1;

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

        //int n = 10;
        //ArrayList<Vector3f> arrayList = new ArrayList<>(100000000);
//        int j = 0;
//        for (SuperMeshCloud cloud: App.superMeshCloud){
//            for (int i = 0; i < 8; i++) {
//                cloud.allSuperMeshes.add(new Base(5, new Vector4f(255, 255, 255, 255)).superMesh);
//
//            }
//            cloud.texture = App.atmsCloud.get(j).texture2D();
//
//            cloud.create();
//            cloud.applyRegistry();
//            cloud.render();
//            cloud.attachToScene();
//            j++;
//        }
        // App.superMeshCloud.allSuperMeshes.clear();
       // for (int i = 0; i < 1000; i++) {
            //SuperSquare superSquare = new SuperSquare("Square", App.defaultATMS, new Node(" "), 2, new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), new Vector3f(1, 1, 0));

            //superSquare.superMesh.bake();
        //}
        //rootNode.attachChild(superSquare.superMesh.node);

        //        for (int i = 0; i < 10000; i++) {
//            Quad q = new Quad(1,1);
//            Geometry geom = new Geometry("Quad", q);
////
//// ATMS bigTexture = new ATMS("Big", 128, 128);
////            //bigTexture.layer.drawCircle(bigTexture.width/2, bigTexture.height/2, bigTexture.width, new Vector4f(255,255,255,255));
//            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//            mat.setTexture("ColorMap", new Texture2D(App.defaultATMS.makeATMS()));
//            geom.setMaterial(mat);
//            rootNode.attachChild(geom);
//            geom.rotate(0, 180, 0);
//        }
//        Box b = new Box(1, 1, 1);
//        Geometry geom = new Geometry("Box", b);
//
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Blue);
//        geom.setMaterial(mat);
//
  //       rootNode.attachChild(geom);


        flyCam.setEnabled(false);



        for (int j = 0; j < xThreads; j++) {
            SuperThread x = new SuperThread() {

                @Override
                public void run() {
                    super.run();
                    App.app.enqueue(() ->{
                        System.out.println("X");
                        for (int i = 0; i < sThreads; i++) {

                            SuperThread s = new SuperThread() {

                                @Override
                                public void run() {
                                    super.run();
                                    System.out.println("s");
                                    App.app.enqueue(() -> {

                                        Player player = new Player();

                                        done = true;
                                        showRAM();
                                    });

                                }
                            };
                            App.superThreadPool.addThread(s);

                        }
                        done = true;
                    });
                }
            };

            App.startup.addThread(x);
        }



        //superMeshCloud.allPlayers.add(new Player());

        //App.superThreadPool.startThreads();

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
//         superMeshCloud = new SuperMeshCloud();
//
//        superMeshCloud.allPlayers.add(new Player());
//        superMeshCloud.bake();
       // superMeshCloud.bake();
//        for (int i = 0; i < 300; i++) {
//            System.out.println(i);
//       Player player = new Player();
//       player.node.move(0,0,i);
//
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

       //GeometryBatchFactory.optimize(rootNode);
        //Geometry geom = TextureAtlas.makeAtlasBatch(rootNode, assetManager, 4096);

        //rootNode.detachAllChildren();
        rootNode.attachChild(App.scene);
    }

    boolean checked = false;
    float elapsed = 0f;

    int bakeTime = 0;

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        App.startup.startThreads();
        App.superThreadPool.startThreads();
      //  App.superThreadPool.startThreads();
//        if (App.startup.isDone()){
//            System.out.println("Elapsed " + elapsed);
//            App.superThreadPool.startThreads();
//            showRAM();
//        }
//
//        if (App.superThreadPool.isDone()){
//            //rootNode.attachChild(App.scene);
//            showRAM();
//           // App.superThreadPool.cleanup();
//            //App.startup.cleanup();
//           // App.superThreadPool.cleanup();
//        }


//        enqueue(new Callable<Void>() {
//            public Void call() throws Exception {
//                //mySpatial.setLocalTranslation(newPosition); // Scene graph modification on the main thread
//                Player player = new Player();
//                return null;
//            }
//        });





        elapsed+=tpf;
        if (elapsed > 5 && !checked){



            checked = true;
        }

//        if (bakeTime > 4){
//            System.out.println("Bake");
//            rootNode.attachChild(App.scene);
//        }
    }

    public void showRAM(){
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
}

