package com.gameshopcorp.heroes.character.basic;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.base.Player;
import com.gameshopcorp.heroes.character.basic.body.Arm;
import com.gameshopcorp.heroes.character.basic.body.Body;
import com.gameshopcorp.heroes.character.basic.body.Foot;
import com.gameshopcorp.heroes.character.basic.body.Hand;
import com.gameshopcorp.heroes.character.basic.body.Head;
import com.gameshopcorp.heroes.character.basic.body.Leg;
import com.gameshopcorp.heroes.character.base.Base;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.texture.Texture2D;

import java.util.ArrayList;

public class LowPolyPlayer extends Player {//implements SuperLoadable {

    //public ArrayList<SuperLoadable> loadables;

//    public Node node;
//    public ArrayList<Base> parts;
//
//    public ATMS atms;
//    ////
//
//    public Vector3f[] vertices;
//    public Vector2f[] texCoord;
//
//    public int[] indexes;
//    public Mesh m;
//
//    public Geometry geom;
//
//    public Material mat;
//
//    public Texture2D texture;
    public LowPolyPlayer(){
        super();

//        node = new Node("Player");
//        parts = new ArrayList<>();

        int n = 2;

        Head head = new Head(n + 2 , new Vector4f(255,255,255,255));
       // head.translate(new Vector3f(0,0,0));
        head.rotate(new Vector3f(0,180,0));
        for (int i = 0; i < 32; i++){
            parts.add(head);
        }
       // head.scale(new Vector3f(2,2,2));

        /*

        Head head1 = new Head(n + 2 , new Vector4f(255,255,255,255));
        head1.translate(new Vector3f(-2,0,0));
        head1.rotate(new Vector3f(0,180,0));
        parts.add(head1);

        // head.scale(new Vector3f(2,2,2));


        Head head2 = new Head(n + 2 , new Vector4f(255,255,255,255));
        head2.translate(new Vector3f(2,0,0));
        head2.rotate(new Vector3f(0,180,0));
        parts.add(head2);

        // head.scale(new Vector3f(2,2,2));


        Head head3 = new Head(n + 2 , new Vector4f(255,255,255,255));
        parts.add(head3);

        // head.scale(new Vector3f(2,2,2));
        head3.translate(new Vector3f(4,0,0));
        head3.rotate(new Vector3f(0,180,0));

        */
        /*
        Body body = new Body(n, new Vector4f(255,255,255,255));
        parts.add(body);

        head.translate(new Vector3f(0,-2,0));
       // body.superMesh.node.move(0,-3.75f,-0.25f);
        body.superMesh.node.scale(1f,3,1);
        //body.superMesh.node.scale(0.75f);

        Arm leftArm = new Arm(n, new Vector4f(255,255,255,255));
        parts.add(leftArm);


        leftArm.superMesh.node.move(-4.25f,-1.75f,-0.25f);
        leftArm.superMesh.node.scale(3.75f, 1,1);

        Arm rightArm = new Arm(n, new Vector4f(255,255,255,255));
        parts.add(rightArm);

        rightArm.superMesh.node.rotate(0, FastMath.DEG_TO_RAD * 180f,0);
        rightArm.superMesh.node.move( 5f,-1.75f,0.25f);
        rightArm.superMesh.node.scale(3.75f, 1,1);
//        rightArm.superMesh.node.move(4.25f,-1.75f,-0.25f);


        Leg leftLeg = new Leg(n, new Vector4f(255,255,255,255));
        parts.add(leftLeg);

        leftLeg.superMesh.node.move(-0.5f,-8.5f,0);
        leftLeg.superMesh.node.scale(1,4,1);


        Leg rightLeg = new Leg(n, new Vector4f(255,255,255,255));
        parts.add(rightLeg);

        rightLeg.superMesh.node.move(0.5f,-8.5f,0);
        rightLeg.superMesh.node.scale(1,4,1);



        Hand leftHand = new Hand(n, new Vector4f(255,255,255,255));
        parts.add(leftHand);

        leftHand.superMesh.node.move(-3.5f,-0.75f,-0.5f);

        Hand rightHand = new Hand(n, new Vector4f(255,255,255,255));
        parts.add(rightHand);
        rightHand.superMesh.node.rotate(0,FastMath.DEG_TO_RAD * 180f,0);

        rightHand.superMesh.node.move(4.25f,-0.75f,0.5f);

        Foot leftFoot = new Foot(n, new Vector4f(255,255,255,255));
        parts.add(leftFoot);
        leftFoot.superMesh.node.move(-0.25f,-5,0);

        Foot rightFoot = new Foot(n, new Vector4f(255,255,255,255));
        parts.add(rightFoot);
        rightFoot.superMesh.node.move(0.5f,-5,0);


        //// PROPORTIONS

        body.superMesh.node.move(0.05f,1,0);
        leftArm.superMesh.node.move(1.5f,1f,0);
        rightArm.superMesh.node.move(-1.5f,1f,0);
        leftLeg.superMesh.node.move(0.05f,3.5f,0);
        rightLeg.superMesh.node.move(-0.05f,3.5f,0);

        body.superMesh.node.scale(0.75f);
        leftArm.superMesh.node.scale(0.5f);
        rightArm.superMesh.node.scale(0.5f);
        leftLeg.superMesh.node.scale(0.5f);
        rightLeg.superMesh.node.scale(0.5f);

        leftLeg.superMesh.node.scale(1.5f,1,1);
        rightLeg.superMesh.node.scale(1.5f,1,1);

        rightHand.superMesh.node.scale(1,0.5f,1);
        leftHand.superMesh.node.scale(1,0.5f,1);

        leftFoot.superMesh.node.scale(0.5f,0.5f,2);
        rightFoot.superMesh.node.scale(0.5f,0.5f,2);

        */

        bake();
//        for (Base d: parts){
//            d.superMesh.bake();
//             node.attachChild(d.superMesh.node);
//        }
//
//        App.scene.attachChild(node);


    }

}
