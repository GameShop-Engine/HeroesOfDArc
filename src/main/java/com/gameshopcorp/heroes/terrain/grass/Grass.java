package com.gameshopcorp.heroes.terrain.grass;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.SuperLine;
import com.gameshopcorp.heroes.graphics.SuperMesh;
import com.gameshopcorp.heroes.supermesh.SuperSquare;
import com.gameshopcorp.heroes.terrain.Terrain;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Grass extends Terrain {


    public SuperSquare plane;
    public ATMS atms;
    public Grass(){

        node.setName("Grass");
        atms = new ATMS("Grass", 128,128);
        atms.layer.drawSquare(64,64,64,new Vector4f(0,255,0,255));
        plane = new SuperSquare("Grass", atms, node, 2, new Vector3f(0,0,0), new Vector3f(0,0,1), new Vector3f(1,0,0), new Vector3f(1,0,1));
        plane.superMesh.bake();
        node.attachChild(plane.superMesh.geom);
        //node.attachChild(plane.superMesh.node);
        App.scene.attachChild(node);
    }
}
