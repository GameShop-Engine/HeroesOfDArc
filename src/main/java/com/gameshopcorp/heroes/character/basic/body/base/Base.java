package com.gameshopcorp.heroes.character.basic.body.base;

//import com.gameshopcorp.heroes.supermesh.SuperCube;

import com.gameshopcorp.heroes.animation.join.SuperJoin;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.SuperMesh;
import com.gameshopcorp.heroes.graphics.SuperSurface;
import com.gameshopcorp.heroes.supermesh.SuperCube;
import com.gameshopcorp.heroes.supermesh.SuperSquare;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.Node;

import java.util.ArrayList;

public class Base {

    public SuperMesh superMesh;


    public Base(int numPoints, Vector4f baseColor) {

        ATMS atmsTop = new ATMS("Top", 128, 128);
        atmsTop.layer.drawCircle(64, 64, 128, baseColor);
        ATMS atmsBottom = new ATMS("Top", 128, 128);
        atmsBottom.layer.drawCircle(64, 64, 128, baseColor);
        ATMS atmsLeft = new ATMS("Top", 128, 128);
        atmsLeft.layer.drawCircle(64, 64, 128, baseColor);
        ATMS atmsRight = new ATMS("Top", 128, 128);
        atmsRight.layer.drawCircle(64, 64, 128, baseColor);
        ATMS atmsFront = new ATMS("Top", 128, 128);
        atmsFront.layer.drawCircle(64, 64, 128, baseColor);
        ATMS atmsBack = new ATMS("Top", 128, 128);
        atmsBack.layer.drawCircle(64, 64, 128, baseColor);


        SuperSquare sTop = new SuperSquare("top", atmsTop, new Node("top"), numPoints, new Vector3f(0, 1, 0), new Vector3f(1, 1, 0), new Vector3f(0, 1, 1), new Vector3f(1, 1, 1));
        SuperSquare sBottom = new SuperSquare("bottom", atmsBottom, new Node("bottom"), numPoints, new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 0, 1), new Vector3f(1, 0, 1));
        SuperSquare sFront = new SuperSquare("front", atmsFront, new Node("front"), numPoints, new Vector3f(0, 0, 1), new Vector3f(1, 0, 1), new Vector3f(0, 1, 1), new Vector3f(1, 1, 1));
        SuperSquare sBack = new SuperSquare("back", atmsBack, new Node("back"), numPoints, new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), new Vector3f(1, 1, 0));
        SuperSquare sLeft = new SuperSquare("left", atmsLeft, new Node("left"), numPoints, new Vector3f(0, 0, 0), new Vector3f(0, 0, 1), new Vector3f(0, 1, 0), new Vector3f(0, 1, 1));
        SuperSquare sRight = new SuperSquare("right", atmsRight, new Node("right"), numPoints, new Vector3f(1, 0, 0), new Vector3f(1, 0, 1), new Vector3f(1, 1, 0), new Vector3f(1, 1, 1));

        SuperCube superCube = new SuperCube(sTop, sBottom, sFront, sBack, sLeft, sRight);

        superMesh = superCube.superMesh;
    }

    public SuperSurface get(String side) {

        return superMesh.superMesh.get(side);
    }

    public SuperJoin findJoin(SuperSurface superSurface, Vector2f point){

        return this.superMesh.findJoin(superSurface, point);
    }

    public void moveCorners(Vector3f volume){

        findJoin(get("front"), new Vector2f(0,0)).moveJoin(new Vector3f(-volume.x, -volume.y, volume.z));
        findJoin(get("front"), new Vector2f(3,0)).moveJoin(new Vector3f(-volume.x, volume.y, volume.z));
        findJoin(get("front"), new Vector2f(0,3)).moveJoin(new Vector3f(volume.x, -volume.y, volume.z));
        findJoin(get("front"), new Vector2f(3,3)).moveJoin(new Vector3f(volume.x, volume.y, volume.z));

        findJoin(get("back"), new Vector2f(0,0)).moveJoin(new Vector3f(-volume.x, -volume.y, -volume.z));
        findJoin(get("back"), new Vector2f(3,0)).moveJoin(new Vector3f(-volume.x, volume.y, -volume.z));
        findJoin(get("back"), new Vector2f(0,3)).moveJoin(new Vector3f(volume.x, -volume.y, -volume.z));
        findJoin(get("back"), new Vector2f(3,3)).moveJoin(new Vector3f(volume.x, volume.y, -volume.z));


    }

    public void moveCorners(String join, float directionAwayFromCenter){

        SuperJoin corner00 = findJoin(get(join), new Vector2f(0,0));
        SuperJoin corner30 = findJoin(get(join), new Vector2f(3,0));
        SuperJoin corner03 = findJoin(get(join), new Vector2f(0,3));
        SuperJoin corner33 = findJoin(get(join), new Vector2f(3,3));

        Vector3f average = new Vector3f(corner00.location.add(corner30.location.add(corner03.location.add(corner33.location)))).divide(4);

        corner00.moveJoin(corner00.location.subtract(average).mult(directionAwayFromCenter));
        corner30.moveJoin(corner30.location.subtract(average).mult(directionAwayFromCenter));
        corner03.moveJoin(corner03.location.subtract(average).mult(directionAwayFromCenter));
        corner33.moveJoin(corner33.location.subtract(average).mult(directionAwayFromCenter));

    }

    public void moveCorners(String join, Vector3f volume){

        findJoin(get(join), new Vector2f(0,0)).moveJoin(volume);
        findJoin(get(join), new Vector2f(3,0)).moveJoin(volume);
        findJoin(get(join), new Vector2f(0,3)).moveJoin(volume);
        findJoin(get(join), new Vector2f(3,3)).moveJoin(volume);


    }

    /*
    public void moveInner(String join,  Vector3f volume){

        findJoin(get(join), new Vector2f(1,1)).moveJoin(volume);
        findJoin(get(join), new Vector2f(2,1)).moveJoin(volume);
        findJoin(get(join), new Vector2f(1,2)).moveJoin(volume);
        findJoin(get(join), new Vector2f(2,2)).moveJoin(volume);


    }

    public void moveEdge(String join, Vector2f a, Vector2f b, Vector3f volume){

        boolean horizontal = false;
        boolean greater = false;

        if (a.x == b.x){
            horizontal = true;

            if (b.y > a.y){
                greater = true;
            } else {
                greater = false;
            }
        } else if (a.y == b.y){
            horizontal = false;
            if (b.x > a.x){
                greater = true;
            } else {
                greater = false;
            }
        } else {
            System.out.println("invalid");
            return;
        }

        findJoin(get(join), a).moveJoin(volume);

        if (horizontal) {
            if (greater) {
                findJoin(get(join), a.add(new Vector2f(0, 1))).moveJoin(volume);
                findJoin(get(join),a.add(new Vector2f(0, 2))).moveJoin(volume);
            } else{
                findJoin(get(join), a.subtract(new Vector2f(0, 1))).moveJoin(volume);
                findJoin(get(join),a.subtract(new Vector2f(0, 2))).moveJoin(volume);
            }
        } else {

            if (greater) {
                findJoin(get(join), a.add(new Vector2f(1, 0))).moveJoin(volume);
                findJoin(get(join),a.add(new Vector2f(2, 0))).moveJoin(volume);
            } else{
                findJoin(get(join), a.subtract(new Vector2f(1, 0))).moveJoin(volume);
                findJoin(get(join),a.subtract(new Vector2f(2, 0))).moveJoin(volume);
            }
        }
        findJoin(get(join), b).moveJoin(volume);


    }

     */

    public void moveRange(String join, Vector2f a, Vector2f b, Vector3f volume){

        int incrX = 1;
        int incrY = 1;

        if (a.x > b.x){
            incrX = -1;
        }
        if (a.y > b.y){
            incrY = -1;
        }
        for (int ax = (int) a.x; ax <= b.x; ax += incrX){

            for (int ay = (int) a.y; ay <= b.y; ay += incrY){

                findJoin(get(join), new Vector2f(ax, ay)).moveJoin(volume);

            }
        }

    }

    public void moveRange(String join, Vector2f a, Vector2f b, float directionAwayFromCenter){

        int incrX = 1;
        int incrY = 1;

        if (a.x > b.x){
            incrX = -1;
        }
        if (a.y > b.y){
            incrY = -1;
        }

        ArrayList<Vector3f> averageArray = new ArrayList<Vector3f>();


        for (int ax = (int) a.x; ax <= b.x; ax += incrX){

            for (int ay = (int) a.y; ay <= b.y; ay += incrY){

                averageArray.add(findJoin(get(join), new Vector2f(ax, ay)).location);

            }
        }

        Vector3f average = new Vector3f();

        for (Vector3f averages: averageArray){

            average = average.add(averages);
        }

        average = average.divide(averageArray.size());

        System.out.println(average);
        for (int ax = (int) a.x; ax <= b.x; ax += incrX){

            for (int ay = (int) a.y; ay <= b.y; ay += incrY){

               // averageArray.add(findJoin(get(join), new Vector2f(ax, ay)).location);

                findJoin(get(join), new Vector2f(ax, ay)).moveJoin(findJoin(get(join), new Vector2f(ax, ay)).location.subtract(average).mult(directionAwayFromCenter));

            }
        }
    }



}
