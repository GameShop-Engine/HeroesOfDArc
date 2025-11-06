package com.gameshopcorp.heroes.animation.join;

import com.gameshopcorp.heroes.graphics.SuperSurface;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

public class SuperJoin {

    public SuperSurface[] superSurfaces;
    public Vector2f[] points;
    public Vector3f location;
    public SuperJoin(SuperSurface[] superSurfaces, Vector2f[] points){

        this.superSurfaces = superSurfaces;
        this.points = points;
        this.location = superSurfaces[0].currencyLines[(int) points[0].x].points[(int) points[0].y];//.moveSuperLine((byte) points[i].x, (byte) points[i].y, new Vector3f(move.x/scale.x, move.y/scale.y, move.z/scale.z));//.divide(scale));


    }

//    public void moveJoin(Vector3f move){
//
//        for (int i = 0; i < superSurfaces.length; i++){
//
//            superSurfaces[i].moveSuperLine((byte) points[i].x, (byte) points[i].y, new Vector3f(move));
//
//        }
//
//    }

    public void moveJoin(Vector3f move){
        for (int i = 0; i < superSurfaces.length; i++){

            Vector3f scale = superSurfaces[i].node.getLocalScale();
            superSurfaces[i].moveSuperLine((byte) points[i].x, (byte) points[i].y, new Vector3f(move.x/scale.x, move.y/scale.y, move.z/scale.z));//.divide(scale));

        }
        this.location = superSurfaces[0].currencyLines[(int) points[0].x].points[(int) points[0].y];//.moveSuperLine((byte) points[i].x, (byte) points[i].y, new Vector3f(move.x/scale.x, move.y/scale.y, move.z/scale.z));//.divide(scale));

    }
}
