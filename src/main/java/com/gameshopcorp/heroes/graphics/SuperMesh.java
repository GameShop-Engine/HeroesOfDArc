package com.gameshopcorp.heroes.graphics;

import com.gameshopcorp.heroes.animation.join.SuperJoin;
import com.gameshopcorp.heroes.app.App;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.texture.Texture2D;
import com.jme3.util.BufferUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SuperMesh {

    public HashMap<String, SuperSurface> superMesh;
    public ArrayList<SuperJoin> superJoins;
    public Node node;


    ATMS atms;
    ////

    public Vector3f[] vertices;
    public Vector2f[] texCoord;

    public int[] indexes;
    public Mesh m;

    public Geometry geom;

    public Material mat;

    public Texture2D texture;
    public SuperMesh(String[] names, SuperSurface[] superSurfaces){

        superMesh = new HashMap<>();
        superJoins = new ArrayList<>();
//        linkNames = new HashMap<>();
//        linkValues = new HashMap<>();

        node = new Node("SuperMesh");



        int i = 0;
        for (String s: names){


            superMesh.put(s, superSurfaces[i]);
            //node.attachChild(superSurfaces[i].node);
            i++;

        }

       // makeATMS();

        //App.app.getRootNode().attachChild(node);


    }

    public SuperJoin findJoin(SuperSurface superSurface, Vector2f point){

//        for (SuperJoin sj: superJoins){
//            for (SuperSurface ss: sj.superSurfaces){
//                if (ss.equals(superSurface)){
//                    for (Vector2f p: sj.points){
//                        if (p.equals(point)){
//                            return sj;
//                        }
//                    }
//                }
//            }
//        }

        for (SuperJoin sj: superJoins){
        
            int i = 0;
            for (SuperSurface ss: sj.superSurfaces){
            
                if (ss.equals(superSurface)){
                
                    if (sj.points[i].equals(point)){
                    
                        return sj;
                    }
                }
                i++;
            }
            
        }
        return null;
    }

    public void makeATMS(){

        int w = 0;
        int h = 0;

        for (SuperSurface superSurface: superMesh.values()){

            w += superSurface.atms.width;
            h = superSurface.atms.height;
        }

        atms = new ATMS("SuperMesh", w, h);
       // System.out.println("w " + w + " h " + h);
        int w1 = 0;
        int h1 = 0;

        for (SuperSurface superSurface: superMesh.values()){

          //  System.out.println("w1 " + w1 + " h1 " + h1);
            atms.layer.putLayer(superSurface.atms.layer, new Vector2f(w1,h1), new Vector2f(w1 + superSurface.atms.width,h1 + superSurface.atms.height));
            w1 += superSurface.atms.width;
            //h = superSurface.atms.height;
        }
    }
    public void bake(){
        for (SuperSurface superSurface: superMesh.values()){

            superSurface.bake();
        }


        this.texture = atms.texture2D();

        m = new Mesh();

        // Vertex positions in space

        int totalVertices = 0;
        for (SuperSurface sm: superMesh.values()){
            if (sm != null){
                totalVertices += sm.vertices.length;
            }
        }
        this.vertices = new Vector3f[totalVertices];

        // Texture coordinates

        int totalIndices = 0;
        for (SuperSurface sm: superMesh.values()){
            if (sm != null){
                totalIndices += sm.texCoord.length;
            }
        }

        this.texCoord = new Vector2f[totalIndices];

        int totalIndexes = 0;

        for (SuperSurface sm: superMesh.values()){
            if (sm != null){
                totalIndexes += sm.indexes.length;
            }
        }

        this.indexes = new int[totalIndexes];

        int w = 0;
        int h = 0;

        int v = 0;
        int t = 0;
        int i = 0;
        int j = 0;

        int it = 1;
        for (SuperSurface sm : superMesh.values()){

            if (sm != null) {
                for (int x = 0; x < sm.vertices.length; x++) {
                    vertices[x + (v)] = sm.vertices[x];

                }
                v += sm.vertices.length;

                for (int x = 0; x < sm.texCoord.length; x++) {
                    texCoord[x + (t)] = sm.texCoord[x].mult(it, 1);
                }

                t += sm.texCoord.length;

                for (int x = 0; x < sm.indexes.length; x++){
                   indexes[x + (i)] = sm.indexes[x] + i;
                }

                //indexes[i + 6] = (short) -1;

                i += sm.indexes.length;
                //j += 4;
            }
            it++;
        }


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
        //mat.setColor("Color", ColorRGBA.fromRGBA255(255,255,255,255));
        mat.setTexture("ColorMap", this.texture);
        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
        geom.setMaterial(mat);

        node.attachChild(geom);
    }

     

}
