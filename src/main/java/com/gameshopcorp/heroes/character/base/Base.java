package com.gameshopcorp.heroes.character.base;

//import com.gameshopcorp.heroes.supermesh.SuperCube;

import com.gameshopcorp.heroes.animation.join.SuperJoin;
import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.SuperMesh;
import com.gameshopcorp.heroes.graphics.SuperSurface;
//import com.gameshopcorp.heroes.parallel.SuperLoadable;
import com.gameshopcorp.heroes.supermesh.SuperCube;
import com.gameshopcorp.heroes.supermesh.SuperSquare;
import com.jme3.math.FastMath;
import com.jme3.math.Matrix3f;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.Node;

import java.util.ArrayList;

public class Base{//} implements SuperLoadable {

    //ArrayList<SuperLoadable> loadables;

    public SuperMesh superMesh;

    public Vector3f center;


    public Base(int numPoints, Vector4f baseColor) {

        int size = 128;
        ATMS atmsTop = new ATMS("Top", size, size);
        atmsTop.layer.drawCircle(size / 2, size/2, size, baseColor);
        ATMS atmsBottom = new ATMS("Top", size, size);
        atmsBottom.layer.drawCircle(size /2, size/2, size, baseColor);
        ATMS atmsLeft = new ATMS("Top", size, size);
        atmsLeft.layer.drawCircle(size / 2, size/2, size, baseColor);
        ATMS atmsRight = new ATMS("Top", size, size);
        atmsRight.layer.drawCircle(size / 2, size/2, size, baseColor);
        ATMS atmsFront = new ATMS("Top", size, size);
        atmsFront.layer.drawCircle(size / 2, size/2, size, baseColor);
        ATMS atmsBack = new ATMS("Top", size, size);
        atmsBack.layer.drawCircle(size / 2, size/2, size, baseColor);

        SuperSquare sTop = new SuperSquare("top", atmsTop, new Node("top"), numPoints, new Vector3f(0, 1, 0), new Vector3f(1, 1, 0), new Vector3f(0, 1, 1), new Vector3f(1, 1, 1));
        SuperSquare sBottom = new SuperSquare("bottom", atmsBottom, new Node("bottom"), numPoints, new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 0, 1), new Vector3f(1, 0, 1));
        SuperSquare sFront = new SuperSquare("front", atmsFront, new Node("front"), numPoints, new Vector3f(0, 0, 1), new Vector3f(1, 0, 1), new Vector3f(0, 1, 1), new Vector3f(1, 1, 1));
        SuperSquare sBack = new SuperSquare("back", atmsBack, new Node("back"), numPoints, new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), new Vector3f(1, 1, 0));
        SuperSquare sLeft = new SuperSquare("left", atmsLeft, new Node("left"), numPoints, new Vector3f(0, 0, 0), new Vector3f(0, 0, 1), new Vector3f(0, 1, 0), new Vector3f(0, 1, 1));
        SuperSquare sRight = new SuperSquare("right", atmsRight, new Node("right"), numPoints, new Vector3f(1, 0, 0), new Vector3f(1, 0, 1), new Vector3f(1, 1, 0), new Vector3f(1, 1, 1));


//        SuperSquare sTop = new SuperSquare("top", App.atmsCloud.get(0), new Node("top"), numPoints, new Vector3f(0, 1, 0), new Vector3f(1, 1, 0), new Vector3f(0, 1, 1), new Vector3f(1, 1, 1));
//        SuperSquare sBottom = new SuperSquare("bottom", App.atmsCloud.get(0), new Node("bottom"), numPoints, new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 0, 1), new Vector3f(1, 0, 1));
//        SuperSquare sFront = new SuperSquare("front", App.atmsCloud.get(0), new Node("front"), numPoints, new Vector3f(0, 0, 1), new Vector3f(1, 0, 1), new Vector3f(0, 1, 1), new Vector3f(1, 1, 1));
//        SuperSquare sBack = new SuperSquare("back", App.atmsCloud.get(0), new Node("back"), numPoints, new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), new Vector3f(1, 1, 0));
//        SuperSquare sLeft = new SuperSquare("left", App.atmsCloud.get(0), new Node("left"), numPoints, new Vector3f(0, 0, 0), new Vector3f(0, 0, 1), new Vector3f(0, 1, 0), new Vector3f(0, 1, 1));
//        SuperSquare sRight = new SuperSquare("right", App.atmsCloud.get(0), new Node("right"), numPoints, new Vector3f(1, 0, 0), new Vector3f(1, 0, 1), new Vector3f(1, 1, 0), new Vector3f(1, 1, 1));

        SuperCube superCube = new SuperCube(sTop, sBottom, sFront, sBack, sLeft, sRight);

        superMesh = superCube.superMesh;
        center = new Vector3f();
        center = average();

        draw();
    }

    public ATMS atms(String side){

        return superMesh.superMesh.get(side).atms;
    }
    public SuperSurface get(String side) {

        return superMesh.superMesh.get(side);
    }

    public SuperJoin findJoin(SuperSurface superSurface, Vector2f point){

        return this.superMesh.findJoin(superSurface, point);
    }

    public void translate(Vector3f v){

        moveRange("front", new Vector2f(0,0), new Vector2f(3,3), v);
        moveRange("back", new Vector2f(0,0), new Vector2f(3,3), v);
        moveRange("left", new Vector2f(1,1), new Vector2f(2,2), v);
        moveRange("right", new Vector2f(1,1), new Vector2f(2,2), v);
        moveRange("top", new Vector2f(1,0), new Vector2f(2,3), v);
        moveRange("bottom", new Vector2f(1,0), new Vector2f(2,3), v);

        center = center.add(v);
    }

    //DEGREES
    public void rotate(Vector3f v){

        Vector3f angleInRadians = new Vector3f(FastMath.DEG_TO_RAD * v.x, FastMath.DEG_TO_RAD * v.y,FastMath.DEG_TO_RAD * v.z);

        Vector3f m = new Vector3f(FastMath.cos(angleInRadians.x)  , FastMath.cos(angleInRadians.y)  , FastMath.cos(angleInRadians.z)   );


        for (int y = 0; y <= 3; y++){
            for (int x = 0; x <= 3; x++){

                SuperJoin join = findJoin(get("front"), new Vector2f(x,y));

                Quaternion rotation = new Quaternion();
                rotation.fromAngles(angleInRadians.x, angleInRadians.y, angleInRadians.z);

//                //System.out.println("START " + join.location);
               Vector3f mCenter = join.location.subtract(center);
               Vector3f rotatedVector = rotation.mult(mCenter);
               Vector3f finalVector = rotatedVector.add(center);

                join.moveJoin(join.location.mult(-1f));
                //join.moveJoin(center());
                join.moveJoin(finalVector);

                //System.out.println("LOCATION " + join.location);

            }
        }

        for (int y = 0; y <= 3; y++) {
            for (int x = 0; x <= 3; x++) {

                SuperJoin join = findJoin(get("back"), new Vector2f(x, y));

                Quaternion rotation = new Quaternion();
                rotation.fromAngles(angleInRadians.x, angleInRadians.y, angleInRadians.z);

//                //System.out.println("START " + join.location);
                Vector3f mCenter = join.location.subtract(center);
                Vector3f rotatedVector = rotation.mult(mCenter);
                Vector3f finalVector = rotatedVector.add(center);

                join.moveJoin(join.location.mult(-1f));
                //join.moveJoin(center());
                join.moveJoin(finalVector);
                //join.moveJoin(rotatedVector);

                //System.out.println("LOCATION " + join.location);
            }
        }
        for (int y = 0; y <= 3; y++){
            for (int x = 1; x <= 2; x++){

                SuperJoin join = findJoin(get("top"), new Vector2f(x,y));

                Quaternion rotation = new Quaternion();
                rotation.fromAngles(angleInRadians.x, angleInRadians.y, angleInRadians.z);

//                //System.out.println("START " + join.location);
                Vector3f mCenter = join.location.subtract(center);
                Vector3f rotatedVector = rotation.mult(mCenter);
                Vector3f finalVector = rotatedVector.add(center);

                join.moveJoin(join.location.mult(-1f));
                //join.moveJoin(center());
                join.moveJoin(finalVector);

                //System.out.println("LOCATION " + join.location);
            }
        }

        for (int y = 0; y <= 3; y++){
            for (int x = 1; x <= 2; x++){

                SuperJoin join = findJoin(get("bottom"), new Vector2f(x,y));

                Quaternion rotation = new Quaternion();
                rotation.fromAngles(angleInRadians.x, angleInRadians.y, angleInRadians.z);

//                //System.out.println("START " + join.location);
                Vector3f mCenter = join.location.subtract(center);
                Vector3f rotatedVector = rotation.mult(mCenter);
                Vector3f finalVector = rotatedVector.add(center);

                join.moveJoin(join.location.mult(-1f));
                //join.moveJoin(center());
                join.moveJoin(finalVector);

                //System.out.println("LOCATION " + join.location);
            }
        }

        for (int y = 1; y <= 2; y++) {
            for (int x = 1; x <= 2; x++) {

                SuperJoin join = findJoin(get("left"), new Vector2f(x, y));

                Quaternion rotation = new Quaternion();
                rotation.fromAngles(angleInRadians.x, angleInRadians.y, angleInRadians.z);

//                //System.out.println("START " + join.location);
                Vector3f mCenter = join.location.subtract(center);
                Vector3f rotatedVector = rotation.mult(mCenter);
                Vector3f finalVector = rotatedVector.add(center);

                join.moveJoin(join.location.mult(-1f));
                //join.moveJoin(center());
                join.moveJoin(finalVector);

                //System.out.println("LOCATION " + join.location);
            }
        }
        for (int y = 1; y <= 2; y++){
            for (int x = 1; x <= 2; x++){

                SuperJoin join = findJoin(get("right"), new Vector2f(x,y));

                Quaternion rotation = new Quaternion();
                rotation.fromAngles(angleInRadians.x, angleInRadians.y, angleInRadians.z);

//                //System.out.println("START " + join.location);
                Vector3f mCenter = join.location.subtract(center);
                Vector3f rotatedVector = rotation.mult(mCenter);
                Vector3f finalVector = rotatedVector.add(center);

                join.moveJoin(join.location.mult(-1f));
                //join.moveJoin(center());
                join.moveJoin(finalVector);

                //System.out.println("LOCATION " + join.location);
            }
        }

    }

    public void scale(Vector3f v){

        if (v.x == 0 || v.y == 0 || v.z == 0){
            //System.out.println("INVALID SCALE");
            return;
        }
        for (int y = 0; y <= 3; y++){
            for (int x = 0; x <= 3; x++){

                SuperJoin join = findJoin(get("front"), new Vector2f(x,y));
                join.moveJoin((join.location.subtract(average())).mult(v));
            }
        }

        for (int y = 0; y <= 3; y++){
            for (int x = 0; x <= 3; x++){

                SuperJoin join = findJoin(get("back"), new Vector2f(x,y));
                join.moveJoin((join.location.subtract(average())).mult(v));
            }
        }

        for (int y = 0; y <= 3; y++){
            for (int x = 1; x <= 2; x++){

                SuperJoin join = findJoin(get("top"), new Vector2f(x,y));
                join.moveJoin((join.location.subtract(average())).mult(v));
            }
        }

        for (int y = 0; y <= 3; y++){
            for (int x = 1; x <= 2; x++){

                SuperJoin join = findJoin(get("bottom"), new Vector2f(x,y));
                join.moveJoin((join.location.subtract(average())).mult(v));
            }
        }

        for (int y = 1; y <= 2; y++){
            for (int x = 1; x <= 2; x++){

                SuperJoin join = findJoin(get("left"), new Vector2f(x,y));
                join.moveJoin((join.location.subtract(average())).mult(v));
            }
        }

        for (int y = 1; y <= 2; y++){
            for (int x = 1; x <= 2; x++){

                SuperJoin join = findJoin(get("right"), new Vector2f(x,y));
                join.moveJoin((join.location.subtract(average())).mult(v));
            }
        }


    }

    public Vector3f average(){

        Vector3f point = new Vector3f();

        for (int i = 0; i < 6; i++) {
            for (int y = 0; y <= 3; y++) {
                for (int x = 0; x <= 3; x++) {

                    if (i == 0){
                        point = point.add(findJoin(get("front"), new Vector2f(x,y)).location);
                    } else if (i == 1){
                        point = point.add(findJoin(get("back"), new Vector2f(x,y)).location);

                    } else if (i == 2){
                        point = point.add(findJoin(get("left"), new Vector2f(x,y)).location);

                    } else if (i == 3){
                        point = point.add(findJoin(get("right"), new Vector2f(x,y)).location);

                    } else if (i == 4){
                        point = point.add(findJoin(get("top"), new Vector2f(x,y)).location);

                    } else if (i == 5){
                        point = point.add(findJoin(get("bottom"), new Vector2f(x,y)).location);

                    }
                }
            }
        }

        return point.divide(96);
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

        ////System.out.println(average);
        for (int ax = (int) a.x; ax <= b.x; ax += incrX){

            for (int ay = (int) a.y; ay <= b.y; ay += incrY){

               // averageArray.add(findJoin(get(join), new Vector2f(ax, ay)).location);

                findJoin(get(join), new Vector2f(ax, ay)).moveJoin(findJoin(get(join), new Vector2f(ax, ay)).location.subtract(average).mult(directionAwayFromCenter));

            }
        }
    }

    public void moveOne(String join, Vector2f a, Vector3f volume){

        findJoin(get(join), a).moveJoin(volume);
    }

    public void draw(){
        drawSkin();


    }
    public void drawSkin(){

        atms("front").layer.drawSquare(atms("front").width/2, atms("front").height/2, atms("front").width, new Vector4f(247,193,155,255));
        atms("back").layer.drawSquare(atms("back").width/2, atms("back").height/2, atms("back").width, new Vector4f(247,193,155,255));
        atms("left").layer.drawSquare(atms("left").width/2, atms("left").height/2, atms("left").width, new Vector4f(247,193,155,255));
        atms("right").layer.drawSquare(atms("right").width/2, atms("right").height/2, atms("right").width, new Vector4f(247,193,155,255));
        atms("top").layer.drawSquare(atms("top").width/2, atms("top").height/2, atms("top").width, new Vector4f(247,193,155,255));
        atms("bottom").layer.drawSquare(atms("bottom").width/2, atms("bottom").height/2, atms("bottom").width, new Vector4f(247,193,155,255));

    }

//    int loadNum = 0;
//    @Override
//    public void load() {
//        if (loadNum < loadables.size()) {
//            loadables.get(loadNum).load();
//            //System.out.println(loadNum);
//            loadNum++;
//        }
//    }
}
