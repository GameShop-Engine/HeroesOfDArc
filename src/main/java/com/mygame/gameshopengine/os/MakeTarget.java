/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.gameshopengine.os;

/**
 *
 * @author alyndenjayevans
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mygame.gameshopengine.os;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl;
import com.jme3.scene.shape.Box;
import com.gameshopcorp.heroes.app.App;

/**
 *
 * @author alyndenjayevans
 */
public class MakeTarget {
    
    public MakeTarget(){
    
           Box b = new Box(0.1f, 0.1f, 0.1f);
        Geometry g = new Geometry("TargetMesh", b);
        Geometry gLeft = new Geometry("TargetMesh", b);
        Geometry gRight = new Geometry("TargetMesh", b);
        Geometry gUp = new Geometry("TargetMesh", b);
        Geometry gDown = new Geometry("TargetMesh", b);

        Material m = new Material(App.app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");

        m.setColor("Color", ColorRGBA.fromRGBA255(0,0,0,255));
        g.setMaterial(m);
        gLeft.setMaterial(m);
        gRight.setMaterial(m);
        gUp.setMaterial(m);
        gDown.setMaterial(m);

        Node xAxisLeftTarget = new Node("xAxisLeftTarget");
        Node xAxisRightTarget = new Node("xAxisRightTarget");
        Node yAxisUpTarget = new Node("yAxisUpTarget");
        Node yAxisDownTarget = new Node("yAxisDownTarget");

        xAxisLeftTarget.attachChild(gLeft);
        xAxisRightTarget.attachChild(gRight);
        yAxisUpTarget.attachChild(gUp);
        yAxisDownTarget.attachChild(gDown);

        xAxisLeftTarget.move(-0.25f, 0f, 0f);
        xAxisRightTarget.move(0.25f, 0, 0);
        yAxisUpTarget.move(0f, 0.25f, 0);
        yAxisDownTarget.move(0f, -0.25f, 0);

        Node target = new Node("target");
        target.attachChild(xAxisLeftTarget);
        target.attachChild(xAxisRightTarget);
        target.attachChild(yAxisUpTarget);
        target.attachChild(yAxisDownTarget);

        target.attachChild(g);
        App.app.getRootNode().attachChild(target);
//create the camera Node
        CameraNode camNode = new CameraNode("Camera Node", App.app.getCamera());
//This mode means that camera copies the movements of the target:
        camNode.setControlDir(CameraControl.ControlDirection.SpatialToCamera);
//Attach the camNode to the target:
        target.attachChild(camNode);
//Move camNode, e.g. behind and above the target:
        camNode.setLocalTranslation(new Vector3f(0, 0, -10));
//Rotate the camNode to look at the target:
        camNode.lookAt(target.getWorldTranslation(), Vector3f.UNIT_Y);

        App.target = target;
        App.camNode = camNode;
        
        App.xAxisLeftTarget = xAxisLeftTarget;
        App.xAxisRightTarget =  xAxisRightTarget;
        App.yAxisUpTarget =  yAxisUpTarget;
        App.yAxisDownTarget =  yAxisDownTarget;
    }
}
