package com.gameshopcorp.heroes.graphics;

import com.gameshopcorp.heroes.animation.join.SuperJoin;
import com.gameshopcorp.heroes.app.App;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SuperMesh {

    public HashMap<String, SuperSurface> superMesh;
    public ArrayList<SuperJoin> superJoins;
    public Node node;
    public SuperMesh(String[] names, SuperSurface[] superSurfaces){

        superMesh = new HashMap<>();
        superJoins = new ArrayList<>();
//        linkNames = new HashMap<>();
//        linkValues = new HashMap<>();

        node = new Node("SuperMesh");
        int i = 0;
        for (String s: names){

            superMesh.put(s, superSurfaces[i]);
            node.attachChild(superSurfaces[i].node);
            i++;

        }

        App.getInstance().app.getRootNode().attachChild(node);


    }

    public SuperJoin findJoin(SuperSurface superSurface, Vector2f point){

        for (SuperJoin sj: superJoins){
            for (SuperSurface ss: sj.superSurfaces){
                if (ss.equals(superSurface)){
                    for (Vector2f p: sj.points){
                        if (p.equals(point)){
                            return sj;
                        }
                    }
                }
            }
        }

        return null;
    }


     

}
