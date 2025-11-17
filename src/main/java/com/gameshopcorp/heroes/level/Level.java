package com.gameshopcorp.heroes.level;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.basic.LowPolyPlayer;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.cloud.PlayerCloud;
import com.gameshopcorp.heroes.terrain.grass.Grass;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.util.SkyFactory;

import java.util.ArrayList;

public class Level {

    Node level;

    //PlayerCloud[] playerClouds;
    //ArrayList<PlayerCloud> playerClouds;
    public Level(){

        level = new Node("Level");
       // for (int i = 0; i < 50; i++) {
        for (int i = 0; i < 32; i++) {
            Grass grass = new Grass();
            grass.node.move(-50f, -10f, -50f);
            grass.node.scale(100, 1, 100);
        }
          //  level.attachChild(grass.node);
        //}
        createSkybox();

//        playerClouds = new ArrayList<>();
//       // playerClouds = new PlayerCloud[4];
//
//        for (int i = 0; i < 1; i++){
//            playerClouds.add(new PlayerCloud());
//
//            for (int j = 0; j < 16; j++) {
//            System.out.println("ITERATION: " + j);
//            LowPolyPlayer lowPolyPlayer = new LowPolyPlayer();
//            playerClouds.get(i).players.add(lowPolyPlayer);
//        }
//            playerClouds.get(i).bake();
//        }
        for (int i = 0; i < 32; i++) {
            System.out.println("ITERATION: " + i);
            LowPolyPlayer lowPolyPlayer = new LowPolyPlayer();
        }
        //PlayerCloud playerCloud = new PlayerCloud();

//        for (int n = 0; n < 4; n++) {
//            for (int i = 0; i < 16; i++) {
//                playerClouds[n] = new PlayerCloud();
//                playerClouds[n].players[i] = new LowPolyPlayer((byte) 4);
//            }
//            playerClouds[n].bake();
//        }
        //playerCloud.bake();



        //App.scene.attachChild(level);

    }

    public void createSkybox(){
        ATMS west  = new ATMS("West", 128,128);
        ATMS east  = new ATMS("East", 128,128);
        ATMS north  = new ATMS("North", 128,128);
        ATMS south  = new ATMS("South", 128,128);
        ATMS up  = new ATMS("Up", 128,128);
        ATMS down  = new ATMS("Down", 128,128);

        west.layer.drawSquare(64,64,64,new Vector4f(0,255,255,255));
        east.layer.drawSquare(64,64,64,new Vector4f(0,255,255,255));
        north.layer.drawSquare(64,64,64,new Vector4f(0,255,255,255));
        south.layer.drawSquare(64,64,64,new Vector4f(0,255,255,255));
        up.layer.drawSquare(64,64,64,new Vector4f(0,255,255,255));
        down.layer.drawSquare(64,64,64,new Vector4f(0,255,255,255));

        north.layer.drawCircle(64,64, 16, new Vector4f(255,255,0,255));
        final Vector3f normalScale = new Vector3f(-1, 1, 1);
        Spatial skySpatial = SkyFactory.createSky(
                App.app.getAssetManager(),
                west.texture2D(),
                east.texture2D(),
                north.texture2D(),
                south.texture2D(),
                up.texture2D(),
                down.texture2D(),
                normalScale);
        App.app.getRootNode().attachChild(skySpatial);

    }
}
