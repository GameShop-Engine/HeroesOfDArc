package com.gameshopcorp.heroes.character.basic;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.basic.body.Body;
import com.gameshopcorp.heroes.character.basic.body.Eye;
import com.gameshopcorp.heroes.character.basic.body.FaceCheek;
import com.gameshopcorp.heroes.character.basic.body.ForeHead;
import com.gameshopcorp.heroes.character.basic.body.Head;
import com.gameshopcorp.heroes.character.basic.body.Neck;
import com.gameshopcorp.heroes.character.basic.body.Nose;
import com.gameshopcorp.heroes.character.basic.body.Nostrils;
import com.gameshopcorp.heroes.character.basic.body.base.Base;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.SuperMesh;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.texture.Texture2D;
import com.jme3.util.BufferUtils;

import java.util.ArrayList;
import java.util.Arrays;

import jme3tools.optimize.GeometryBatchFactory;

public class Player {

    public Node node;
    public ArrayList<Base> parts;

    public ATMS atms;
    ////

    public Vector3f[] vertices;
    public Vector2f[] texCoord;

    public int[] indexes;
    public Mesh m;

    public Geometry geom;

    public Material mat;

    public Texture2D texture;
    public Player(){

        node = new Node("Player");
        parts = new ArrayList<>();

//        Head head = new Head(5, new Vector4f(255,215,172,255));
//        Neck neck = new Neck(5, new Vector4f(255,215,172,255));
//        neck.superMesh.node.scale(.5f,1.5f, .5f);
//        neck.superMesh.node.move(.25f,-1f,-.25f);
//        Body body = new Body(5, new Vector4f(255,215,172,255));
//        body.superMesh.node.scale(3,1,1);
//        body.superMesh.node.move(-1f,-2,-.5f);

        int n = 7;
        Eye leftEye = new Eye(n, new Vector4f(255,255,255,255));
        //leftEye.superMesh.node.move(-1.5f, 0, 0);
        leftEye.translate(new Vector3f(-1.5f,0,0));
        leftEye.superMesh.superMesh.get("front").atms.layer.drawCircle(64,64,32, new Vector4f(0,0,255,255));

        Eye rightEye = new Eye(n, new Vector4f(255,255,255,255));
        //rightEye.superMesh.node.move(1.5f, 0, 0);
        leftEye.translate(new Vector3f(1.5f,0,0));
        rightEye.superMesh.superMesh.get("front").atms.layer.drawCircle(64,64,32, new Vector4f(0,0,255,255));

        Nostrils nostrils = new Nostrils(n, new Vector4f(255,255,255,255));
        //nostrils.superMesh.node.move(-0.5f,-2,0);
        nostrils.translate(new Vector3f(-0.5f,-2,0));

        Nose nose = new Nose(n, new Vector4f(255,255,255,255));
        nose.translate(new Vector3f(-0.5f,-2,1));
        //nose.superMesh.node.move(-0.5f,-2,1);

        ForeHead foreHead = new ForeHead(n, new Vector4f(255,255,255,255));
        //foreHead.superMesh.node.move(-3.5f,2,0);
        foreHead.translate(new Vector3f(-3.5f,2,0));

        FaceCheek leftFaceCheek = new FaceCheek(n, new Vector4f(255,255,255,255));
        //leftFaceCheek.superMesh.node.move(-1.5f,-2f,0);
        leftFaceCheek.translate(new Vector3f(-1.5f,-2,0));

        FaceCheek rightFaceCheek = new FaceCheek(n, new Vector4f(255,255,255,255));
        //rightFaceCheek.superMesh.node.move(1.5f,-2f,0);
        rightFaceCheek.translate(new Vector3f(1.5f,-2,0));


        parts.add(leftEye);
        parts.add(rightEye);
        parts.add(nostrils);
        parts.add(foreHead);
        parts.add(leftFaceCheek);
        parts.add(rightFaceCheek);

        bake();

        addNode();
//        leftEye.superMesh.bake();
//        rightEye.superMesh.bake();
//        nostrils.superMesh.bake();
//        nose.superMesh.bake();
//        foreHead.superMesh.bake();
//        leftFaceCheek.superMesh.bake();
//        rightFaceCheek.superMesh.bake();

    }

    public void makeATMS(){

        int w = 0;
        int h = 0;

        for (Base d: parts){

            w = d.superMesh.atms.width;
            h += d.superMesh.atms.height;
        }

        atms = new ATMS("SuperMesh", w, h);
         //System.out.println("w " + w + " h " + h);
        int w1 = 0;
        int h1 = 0;

        for (Base d: parts){

              //System.out.println("w1 " + w1 + " h1 " + h1);
            atms.layer.putLayer(d.superMesh.atms.layer, new Vector2f(w1,h1), new Vector2f(w1 + d.superMesh.atms.width,h1 + d.superMesh.atms.height));
            //w1 += d.superMesh.atms.width;
            h1 += d.superMesh.atms.height;
        }
    }

    public void bake(){

        for (Base d: parts){
            d.superMesh.makeATMS();
            d.superMesh.bake();
        }

        makeATMS();

        this.texture = atms.texture2D();

        m = new Mesh();

        // Vertex positions in space

        int totalVertices = 0;
        for (Base d: parts){
            //if (sm != null){
                totalVertices += d.superMesh.vertices.length;
            //}
        }
        this.vertices = new Vector3f[totalVertices];

        // Texture coordinates

        int totalIndices = 0;
        for (Base d: parts){
           // if (sm != null){
                totalIndices += d.superMesh.texCoord.length;
           // }
        }

        this.texCoord = new Vector2f[totalIndices];

        int totalIndexes = 0;

        for (Base d: parts){
            //if (sm != null){
                totalIndexes += d.superMesh.indexes.length;
            //}
        }

        this.indexes = new int[totalIndexes];

        int w = 0;
        int h = 0;

        int v = 0;
        int t = 0;
        int i = 0;
        int j = 0;

        int it = 1;
        for (Base d : parts){

            //if (sm != null) {
                for (int x = 0; x < d.superMesh.vertices.length; x++) {
                    vertices[x + (v)] = new Vector3f();
                    vertices[x + (v)] = d.superMesh.vertices[x];

                }
                v += d.superMesh.vertices.length;

                for (int x = 0; x < d.superMesh.texCoord.length; x++) {
                    texCoord[x + (t)] = new Vector2f();
                    texCoord[x + (t)] = d.superMesh.texCoord[x].mult(1, it);
                }

                t += d.superMesh.texCoord.length;

                for (int x = 0; x < d.superMesh.indexes.length; x++){
                    indexes[x + (i)] = d.superMesh.indexes[x] + i;
                }

                //indexes[i + 6] = (short) -1;

                i += d.superMesh.indexes.length;
                //j += 4;
           // }
            it++;
        }


//        System.out.println("Length " + vertices.length);
//        System.out.println("Vertices " + Arrays.toString( this.vertices));
//
//        System.out.println("TexCoord " + Arrays.toString(this.texCoord));
//        System.out.println("Indexes " + Arrays.toString(this.indexes));

        // Setting buffers
        m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(this.vertices));
        m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(this.texCoord));
        m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createIntBuffer(indexes));

        m.updateBound();


        //*****RenderState*****

        // texture.setWrap(Texture.WrapMode.Repeat);
        // *************************************************************************
        // First mesh uses one solid color
        // *************************************************************************

        // Creating a geometry, and apply a single color material to it
        this.geom = new Geometry("OurMesh", m);

        // Vector3f average = new Vector3f(vertices[0].add(vertices[1]).add(vertices[2].add(vertices[3]))).divide(4);

        // this.geom.move(average);

        mat = new Material(App.app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setFaceCullMode(RenderState.FaceCullMode.Off);
        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        mat.setTransparent(true);
        mat.getAdditionalRenderState().setDepthTest(true);
        mat.getAdditionalRenderState().setDepthWrite(true);
        mat.setColor("Color", ColorRGBA.fromRGBA255(255,255,255,255));
        mat.setTexture("ColorMap", this.texture);
        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
        geom.setMaterial(mat);

        node.attachChild(geom);
    }

    public void addNode(){

//        for (Base d: parts) {
//            node.attachChild(d.superMesh.node);
//        }

       // GeometryBatchFactory.optimize(node);

        App.scene.attachChild(node);
    }
}
