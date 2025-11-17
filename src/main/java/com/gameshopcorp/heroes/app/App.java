package com.gameshopcorp.heroes.app;

//import com.gameshopcorp.heroes.graphics.cloud.ATMSCloud;
//import com.gameshopcorp.heroes.graphics.cloud.SuperMeshCloud;
//import com.gameshopcorp.heroes.parallel.SuperThreadPool;
import com.jme3.app.SimpleApplication;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.mygame.gameshopengine.os.MakeTarget;
import com.mygame.gameshopengine.ui.SelectMouseListener;

public class App {

    public static SimpleApplication app;
    public static Node target;
    public static Node camNode;
    
    public static Node xAxisLeftTarget;
    public static Node xAxisRightTarget;
    public static Node yAxisUpTarget;
    public static Node yAxisDownTarget;

    public static Node scene;

   // public static ATMS defaultATMS;

//    public static ArrayList<SuperMeshCloud> superMeshCloud;
//    public static ArrayList<ATMSCloud> atmsCloud;
//
//    public static SuperThreadPool superThreadPool;
//
//    public static SuperThreadPool startup;

    //public static ArrayList<Player> player;

    public App(SimpleApplication app) {

        this.app = app;
        MakeTarget makeTarget = new MakeTarget();
        SelectMouseListener selectMouseListener = new SelectMouseListener();
        App.app.getInputManager().addRawInputListener(selectMouseListener);
        //player = new ArrayList<>();
        //superMeshCloud = new ArrayList<>();

        //superThreadPool = new SuperThreadPool();
        //startup = new SuperThreadPool();
        scene = new Node("Scene");
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

    public static Vector3f sign(Vector3f center, Vector3f other){

        float x = 1;
        float y = 1;
        float z = 1;

        if (center.x < other.x){
            x = -1;
        }
        if (center.y < other.y){
            y = -1;
        }
        if (center.z < other.z){
            z = -1;
        }

        return new Vector3f(x,y,z);
    }

    public static Vector3f calculateUnitNormal(Vector3f v){

        float highestValue = v.x;

        if (FastMath.abs(v.y) >= FastMath.abs(v.x)){
            highestValue = v.y;
            if (FastMath.abs(v.z) >= FastMath.abs(v.y)){
                highestValue = v.z;
            }
        }



        return new Vector3f(v).divide(highestValue);
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
