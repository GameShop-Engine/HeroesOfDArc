package com.gameshopcorp.heroes.graphics.cloud;

import com.gameshopcorp.heroes.app.App;
import com.gameshopcorp.heroes.character.base.Player;
import com.gameshopcorp.heroes.graphics.ATMS;
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

public class PlayerCloud {

    public Node node;
    public ArrayList<Player> players;

    public ATMS atms;
    /// /

    public Vector3f[] vertices;
    public Vector2f[] texCoord;

    public int[] indexes;
    public Mesh m;

    public Geometry geom;

    public Material mat;

    public Texture2D texture;

    public PlayerCloud() {

        node = new Node();
        players = new ArrayList<>();

    }


    public void makeATMS() {

        int w = 0;
        int h = 0;

        for (Player d : players) {

            if (d != null) {
                w = d.atms.width * players.size();
                h = d.atms.height;
                break;
            }
            //break;
        }


        atms = new ATMS("SuperMesh", w, h);
        // System.out.println("w " + w + " h " + h);
        int w1 = 0;
        int h1 = 0;

        for (Player d : players) {

            if (d != null) {
                //  System.out.println("w1 " + w1 + " h1 " + h1);
                atms.layer.putLayer(d.atms.layer, new Vector2f(w1, h1), new Vector2f(w1 + d.atms.width, h1 + d.atms.height));
                w1 += d.atms.height;
            }
            //h = superSurface.atms.height;
        }
    }


    public void bake() {

//        for (SuperSurface superSurface: superMesh.values()){
//
//            superSurface.bake();
//        }

        for (Player d : players) {
            if (d != null) {
                d.bake();
                node.attachChild(d.node);
            }
        }


        makeATMS();

        this.texture = atms.texture2D();

        m = new Mesh();

        // Vertex positions in space

        int totalVertices = 0;
        for (Player sm : players) {
            if (sm != null) {
                totalVertices += sm.vertices.length;
            }
        }
        this.vertices = new Vector3f[totalVertices];

        // Texture coordinates

        int totalIndices = 0;
        for (Player sm : players) {
            if (sm != null) {
                totalIndices += sm.texCoord.length;
            }
        }

        this.texCoord = new Vector2f[totalIndices];

        int totalIndexes = 0;

        for (Player sm : players) {
            if (sm != null) {
                totalIndexes += sm.indexes.length;
            }
        }

        this.indexes = new int[totalIndexes];// + (((superMesh.size()) * 6))];

        int w = 0;
        int h = 0;

        int v = 0;
        int t = 0;
        int i = 0;
        int j = 0;

        int it = 0;

        int y = 0;

        for (Player sm : players) {

            if (sm != null) {
                for (int x = 0; x < sm.vertices.length; x++) {
                    vertices[x + (v)] = new Vector3f();
                    vertices[x + (v)] = sm.vertices[x];
                    //System.out.println("V " + v);
                }
                v += sm.vertices.length;

                for (int x = 0; x < sm.texCoord.length; x++) {

                    texCoord[x + (t)] = new Vector2f();//sm.texCoord[x].mult(it, 1);
                    Vector2f finalTexCoord = sm.texCoord[x].add(new Vector2f(it, 0));
                    texCoord[x + (t)] = new Vector2f(finalTexCoord.x/players.size(), finalTexCoord.y );
                }

                t += sm.texCoord.length;

                for (int x = 0; x < sm.indexes.length; x++) {

                    indexes[x + (i)] = sm.indexes[x] + (y);// + (i);


                }
                y += sm.vertices.length;

                //indexes[i + 6] = (short) -1;

                i += (sm.indexes.length);


            }
            it++;
        }

        //System.out.println("INDICES: " + Arrays.toString(indexes));

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

        //node.detachAllChildren();

        node.attachChild(geom);

        // App.scene.attachChild(node);
        App.scene.attachChild(node);

    }

//    public void bake(){


}