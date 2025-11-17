//package com.gameshopcorp.heroes;
//
//import com.gameshopcorp.heroes.app.App;
//import com.gameshopcorp.heroes.level.Level;
//import com.jme3.app.SimpleApplication;
//import com.jme3.math.ColorRGBA;
//
//import de.lessvoid.nifty.Nifty;
//
//public final class MyGame extends SimpleApplication {
//
//
//    private Nifty nifty;
//
//
//    @Override
//    public void simpleInitApp() {
//        App app = new App(this);
//
//        flyCam.setEnabled(false);
//
//        getViewPort().setBackgroundColor(ColorRGBA.Black);
//
//        //com.jme3.renderer.opengl.GLRenderer.
////        new Thread(() -> {
////            for (int i = 0; i < 64; i++) {
////                enqueue(() ->{
////                    Base b = new Base(5, new Vector4f(255,255,255,255));
////                    b.superMesh.bake();
////                    App.scene.attachChild(b.superMesh.node);
////                });
////
////            }
////            GeometryBatchFactory.optimize(App.scene,true);
////        }).start();
//       // for (int i = 0; i < 25; i++) {
//            Level levelOne = new Level();
//       // }
//       // GeometryBatchFactory.optimize(App.scene);
//        rootNode.attachChild(App.scene);
//
//        showRAM();
//
//
//    }
//
//        public void showRAM() {
//        //GeometryBatchFactory.optimize(App.scene);
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
//
//        //elapsed = 0f;
//
//        //bakeTime++;
//
//    }
//
//}
