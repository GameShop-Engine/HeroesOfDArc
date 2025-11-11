package com.gameshopcorp.heroes.graphics.cloud;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.basic.Player;
import com.gameshopcorp.heroes.graphics.ATMS;
import com.gameshopcorp.heroes.graphics.SuperMesh;
import com.gameshopcorp.heroes.graphics.SuperSurface;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
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
import java.util.HashSet;
import java.util.function.IntFunction;

public class SuperMeshCloud {

    public Vector3f[] vertices;
    public Vector2f[] texCoord;

    public int[] indexes;

    ATMS atms;

//    public Vector3f[] appliedVertices;
//
//    public Vector2f[] appliedTexCoord;
//
//    public int[] appliedIndexse;
    public Mesh m;

    public Geometry geom;

    public Material mat;

    public Texture2D texture;

    public  ArrayList<Player> allPlayers;

   // public ArrayList<Registry> registry;

    public Node scene;

    //public int latestSuperMesh;
    //public int latestRegistry;
    public SuperMeshCloud(){

        //vertices = new ArrayList<>(); //200000000
        //texCoord = new ArrayList<>();//200000000
        //indexes =  new ArrayList<>();//300000000
       // registry = new ArrayList<>();//50000000
        allPlayers = new ArrayList<>();//10000
        //texture = App.defaultATMS.texture2D();
        scene = new Node("Scene");
//        latestSuperMesh = 0;
//        latestRegistry = 0;

    }


    public void makeATMS(){

        int w = 0;
        int h = 0;

        for (Player d: allPlayers){

            w += d.atms.width;
            h = d.atms.height;
        }

        atms = new ATMS("SuperMesh", w, h);
        //System.out.println("w " + w + " h " + h);
        int w1 = 0;
        int h1 = 0;

        for (Player d: allPlayers){

            //System.out.println("w1 " + w1 + " h1 " + h1);
            atms.layer.putLayer(d.atms.layer, new Vector2f(w1,h1), new Vector2f(w1 + d.atms.width,h1 + d.atms.height));
            //w1 += d.atms.width;
            w1 += d.atms.height;
        }
    }

    public void bake(){

//        for (Player d: allPlayers){
//            //d.makeATMS();
//           // d.bake();
//        }

        makeATMS();

        this.texture = atms.texture2D();

        m = new Mesh();

        // Vertex positions in space

        int totalVertices = 0;
        for (Player d: allPlayers){
            //if (sm != null){
            totalVertices += d.vertices.length;
            //}
        }
        this.vertices = new Vector3f[totalVertices];

        // Texture coordinates

        int totalIndices = 0;
        for (Player d: allPlayers){
            // if (sm != null){
            totalIndices += d.texCoord.length;
            // }
        }

        this.texCoord = new Vector2f[totalIndices];

        int totalIndexes = 0;

        for (Player d: allPlayers){
            //if (sm != null){
            totalIndexes += d.indexes.length;
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
        for (Player d : allPlayers){

            //if (sm != null) {
            for (int x = 0; x < d.vertices.length; x++) {
                vertices[x + (v)] = new Vector3f();
                vertices[x + (v)] = d.vertices[x];

            }
            v += d.vertices.length;

            for (int x = 0; x < d.texCoord.length; x++) {
                texCoord[x + (t)] = new Vector2f();
                texCoord[x + (t)] = d.texCoord[x].mult(it, 1);
            }

            t += d.texCoord.length;

            for (int x = 0; x < d.indexes.length; x++){
                indexes[x + (i)] = d.indexes[x] + i;
            }

            //indexes[i + 6] = (short) -1;

            i += d.indexes.length;
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

        scene.attachChild(geom);

        App.app.getRootNode().attachChild(scene);
    }

//    public void create(){
//
//        for (int i = 0; i < allSuperMeshes.size(); i++){
//            allSuperMeshes.get(i).bake();
//            for (int j = 0; j < allSuperMeshes.get(i).size(); j++){
//                String side = "";
//                if (j == 0){
//                    side = "front";
//                }
//                if (j == 1){
//                    side = "back";
//                }
//                if (j == 2){
//                    side = "top";
//                }
//                if (j == 3){
//                    side = "bottom";
//                }
//                if (j == 4){
//                    side = "left";
//                }
//                if (j == 5){
//                    side = "right";
//                }
//
//                //System.out.println("side");
//                for (int l = 0; l < allSuperMeshes.get(i).get(side).vertices.length / 4; l++) {
//                    //System.out.println("here");
//                    registry.add(new Registry(allSuperMeshes.get(i).get(side)));
//                    for (int k = 0; k < 4; k++) {
//                        registry.get(latestRegistry).vertices[k] = k + (4 * l);
//                        registry.get(latestRegistry).texCoord[k] = k + (4 * l);
//                    }
//                    for (int m = 0; m < 6; m++) {
//                        registry.get(latestRegistry).indexes[m] = m + (6 * l);
//
//                    }
//                    latestRegistry++;
//                }
//                //for (int k = allSuperMeshes[i].get(side).v
//
//            }
//          //  latestRegistry++;
//        }
//    }
//
//    public void applyRegistry(){
//
//        int v = 0;
//        int t = 0;
//        int in = 0;
//
//        int cr = 0;
//        for (Registry r: registry){
//
//            //System.out.println(r);
//            if (cr == latestRegistry){
//                break;
//            }
//            for (int i = 0; i < 4; i++) {
//
//                //vertices.[v] = new Vector3f();
//                vertices.add(r.superSurface.vertices[r.vertices[i]]);
//
//                //texCoord[t] = new Vector2f();
//                texCoord.add(r.superSurface.texCoord[r.texCoord[i]]);
//
//
//                v++;
//
//                t++;
//
//            }
//
//            for (int j = 0; j < 6; j++){
//
//                indexes.add(r.superSurface.indexes[r.indexes[j]]);
//            }
//
//            cr++;
//        }
//
////        for (int i = 0; i < latestSuperMesh; i++){
////           // allSuperMeshes[i].bake();
////            for (int j = 0; j < allSuperMeshes[i].size(); j++){
////                String side = "";
////                if (j == 0){
////                    side = "front";
////                }
////                if (j == 1){
////                    side = "back";
////                }
////                if (j == 2){
////                    side = "top";
////                }
////                if (j == 3){
////                    side = "bottom";
////                }
////                if (j == 4){
////                    side = "left";
////                }
////                if (j == 5){
////                    side = "right";
////                }
////             //   for (SuperSurface superSurface: allSuperMeshes[i].values()){
////
////
////
////                  //  for (int k = 0; k < latestRegistry; k++){
////
////
////                        this.vertices[v] = registry[k].vertices[0]
////                  //  }
////
////                //}
////
////                }
////            }
//
//
//
//    }
//    public void render(){
//
//        m = new Mesh();
//
//        Integer[] intbuffer = indexes.toArray(new Integer[0]);
////intbuffer.to
//        //System.out.println(Arrays.toString(this.vertices.toArray(new Vector3f[0])));
//        m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer( (this.vertices.toArray(new Vector3f[0]))));
//        m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(this.texCoord.toArray(new Vector2f[0])));
//        m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createIntBuffer(Arrays.stream(intbuffer)
//                .mapToInt(Integer::intValue) // Or .mapToInt(i -> i)
//                .toArray()));
//
//        m.updateBound();
//        this.geom = new Geometry("OurMesh", m);
//
//        // Vector3f average = new Vector3f(vertices[0].add(vertices[1]).add(vertices[2].add(vertices[3]))).divide(4);
//
//        // this.geom.move(average);
//
//        mat = new Material(App.app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.getAdditionalRenderState().setFaceCullMode(RenderState.FaceCullMode.Off);
//        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
//        mat.setTransparent(true);
//        mat.getAdditionalRenderState().setDepthTest(true);
//        mat.getAdditionalRenderState().setDepthWrite(true);
//        //mat.setColor("Color", ColorRGBA.fromRGBA255(255,255,255,255));
//        mat.setTexture("ColorMap", this.texture);
//        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
//        geom.setMaterial(mat);
//
//        scene.attachChild(geom);
//    }
//
//    public void attachToScene(){
//
//        App.app.getRootNode().attachChild(scene);
//    }
//
////    public void addSuperMesh(SuperMesh superMesh){
////
////        SuperMesh[] tmp = new SuperMesh[latestSuperMesh + 1];
////        tmp = allSuperMeshes;
////        allSuperMeshes = new SuperMesh[latestSuperMesh + 1];
////        allSuperMeshes[latestSuperMesh] = superMesh;
////        latestSuperMesh++;
////
////    }
//
//    public void deleteSuperMesh(){
//
//
//    }
}
