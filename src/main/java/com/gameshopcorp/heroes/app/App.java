package com.gameshopcorp.heroes.app;

import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.cloud.ATMSCloud;
import com.gameshopcorp.heroes.graphics.cloud.SuperMeshCloud;
import com.jme3.app.SimpleApplication;
import com.jme3.math.FastMath;
import com.jme3.math.Vector4f;
import com.jme3.scene.Node;
import com.mygame.gameshopengine.os.MakeTarget;
import com.mygame.gameshopengine.ui.SelectMouseListener;

import java.util.ArrayList;

public class App {

    public static SimpleApplication app;
    public static Node target;
    public static Node camNode;
    
    public static Node xAxisLeftTarget;
    public static Node xAxisRightTarget;
    public static Node yAxisUpTarget;
    public static Node yAxisDownTarget;

   // public static ATMS defaultATMS;

    public static ArrayList<SuperMeshCloud> superMeshCloud;
    public static ArrayList<ATMSCloud> atmsCloud;
    public App(SimpleApplication app) {

        this.app = app;
        MakeTarget makeTarget = new MakeTarget();
        SelectMouseListener selectMouseListener = new SelectMouseListener();
        App.app.getInputManager().addRawInputListener(selectMouseListener);

        // defaultATMS = new ATMS("default", 16384,16384);
        // defaultATMS.layer.drawCircle(defaultATMS.width /2, defaultATMS.height/2,defaultATMS.width,new Vector4f(255,255,255,255));

//        atmsCloud = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            atmsCloud.add(new ATMSCloud("Cloud" + i, 4096, 4096));
//
//        }
//        for (ATMSCloud clouds : atmsCloud) {
//            clouds.layer.drawCircle(clouds.width / 2, clouds.height / 2, clouds.width, new Vector4f(255, 255, 255, 255));
//        }
//        superMeshCloud = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            superMeshCloud.add(new SuperMeshCloud());
//        }

    }

    public static float random(float min, float max){
        return min + (max - min) * FastMath.nextRandomFloat();
    }
//    private static App _instance;
//
//    private App(){
//
//    }
//
//    public static App getInstance(){
//
//        if (_instance == null){
//            _instance = new App();
//        }
//        return _instance;
//    }

}
