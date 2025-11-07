package com.gameshopcorp.heroes.character.basic;

import com.gameshopcorp.heroes.character.basic.body.Body;
import com.gameshopcorp.heroes.character.basic.body.Eye;
import com.gameshopcorp.heroes.character.basic.body.FaceCheek;
import com.gameshopcorp.heroes.character.basic.body.ForeHead;
import com.gameshopcorp.heroes.character.basic.body.Head;
import com.gameshopcorp.heroes.character.basic.body.Neck;
import com.gameshopcorp.heroes.character.basic.body.Nose;
import com.gameshopcorp.heroes.character.basic.body.Nostrils;
import com.jme3.math.Vector4f;

import jme3tools.optimize.GeometryBatchFactory;

public class Player {

    public Player(){

//        Head head = new Head(5, new Vector4f(255,215,172,255));
//        Neck neck = new Neck(5, new Vector4f(255,215,172,255));
//        neck.superMesh.node.scale(.5f,1.5f, .5f);
//        neck.superMesh.node.move(.25f,-1f,-.25f);
//        Body body = new Body(5, new Vector4f(255,215,172,255));
//        body.superMesh.node.scale(3,1,1);
//        body.superMesh.node.move(-1f,-2,-.5f);

        int n = 7;
        Eye leftEye = new Eye(n, new Vector4f(255,255,255,255));
        leftEye.superMesh.node.move(-1.5f, 0, 0);
        Eye rightEye = new Eye(n, new Vector4f(255,255,255,255));
        rightEye.superMesh.node.move(1.5f, 0, 0);

        Nostrils nostrils = new Nostrils(n, new Vector4f(255,255,255,255));
        nostrils.superMesh.node.move(-0.5f,-2,0);

        Nose nose = new Nose(n, new Vector4f(255,255,255,255));
        nose.superMesh.node.move(-0.5f,-2,1);

        ForeHead foreHead = new ForeHead(n, new Vector4f(255,255,255,255));
        foreHead.superMesh.node.move(-3.5f,2,0);

        FaceCheek leftFaceCheek = new FaceCheek(n, new Vector4f(255,255,255,255));
        leftFaceCheek.superMesh.node.move(-1.5f,-2f,0);

        FaceCheek rightFaceCheek = new FaceCheek(n, new Vector4f(255,255,255,255));
        rightFaceCheek.superMesh.node.move(1.5f,-2f,0);

        leftEye.superMesh.bake();
        rightEye.superMesh.bake();
        nostrils.superMesh.bake();
        nose.superMesh.bake();
        foreHead.superMesh.bake();
        leftFaceCheek.superMesh.bake();
        rightFaceCheek.superMesh.bake();


    }
}
