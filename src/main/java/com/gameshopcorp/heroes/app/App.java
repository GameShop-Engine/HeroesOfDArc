package com.gameshopcorp.heroes.app;

import com.jme3.app.SimpleApplication;
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
    
    public App(SimpleApplication app){
    
        this.app = app;
        MakeTarget makeTarget = new MakeTarget();
        SelectMouseListener selectMouseListener = new SelectMouseListener();
        App.app.getInputManager().addRawInputListener(selectMouseListener);

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
