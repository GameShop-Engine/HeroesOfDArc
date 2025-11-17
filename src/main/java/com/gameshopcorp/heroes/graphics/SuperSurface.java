package com.gameshopcorp.heroes.graphics;

import com.gameshopcorp.heroes.app.App;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture2D;
import com.jme3.util.BufferUtils;

import java.util.Random;

public class SuperSurface {

    public SuperLine[] vInfinitesimals;
    public SimpleMesh[] simpleMeshes;

    public SuperLine[] currencyLines;
    public float width;
    public float height;

    public float dim;

    //SimpleApplication app;

    public ATMS atms;
    //Texture2D texture;
    public Node node;

    ////

    public Vector3f[] vertices;
    public Vector2f[] texCoord;

    public int[] indexes;
    public Mesh m;

    public Geometry geom;

    public Material mat;

    public Texture2D texture;

    public SuperSurface(SuperLine[] currencyLines, ATMS atms, Node node){

        //this.app = app;
        this.currencyLines = currencyLines;
        //this.texture = texture;
        this.atms = atms;
        this.node = node;

        setDimensions();
        setImageArray();
       drawSimpleMeshes();

        //bake();

    }

//    public void updateTexture(Texture2D texture){
//        this.texture = texture;
//    }

//    public void rotate90(){
//
//    }
    public SimpleMesh getMeshFromValue(int x, int y){

        return  simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * x) + y];
    }

    public void setSuperLine(byte line, byte point, Vector3f newPoint){
        this.currencyLines[line].setSuperLine(point, newPoint);
        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i].setSuperLine((byte) 0, currencyLines[0].infinitesimals[i]); ;//= new CurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);
            this.vInfinitesimals[i].setSuperLine((byte) 1, currencyLines[1].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 2, currencyLines[2].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 3, currencyLines[3].infinitesimals[i]);
        }
        updateSimpleMeshes();
    }

    public void moveSuperLine(byte line, byte point, Vector3f movePoint){
        //return;

        this.currencyLines[line].moveSuperLine(point, movePoint);
        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i].setSuperLine((byte) 0, currencyLines[0].infinitesimals[i]); ;//= new CurrencyLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)16);
            this.vInfinitesimals[i].setSuperLine((byte) 1, currencyLines[1].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 2, currencyLines[2].infinitesimals[i]);
            this.vInfinitesimals[i].setSuperLine((byte) 3, currencyLines[3].infinitesimals[i]);
        }
        updateSimpleMeshes();
    }

    public void updateSimpleMeshes(){

        //return;

        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
        int maxY = this.vInfinitesimals.length - 1;
        for (int y = 0; y < maxY; y++){
            for (int x = 0; x < maxX; x++){

                Vector3f[] simpleMesh = new Vector3f[4];

                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];
                Vector2f[] texCoord = new Vector2f[4];

//                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
//                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);

//                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
//                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
//                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
//                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);

                texCoord[0] = new Vector2f((float) x /maxX, (float) y /maxY);
                texCoord[1] = new Vector2f((float) x /maxX, (float) (y + 1) /maxY);
                texCoord[2] = new Vector2f((float) (x + 1) /maxX, (float) y /maxY);
                texCoord[3] = new Vector2f((float) (x + 1) /maxX, (float) (y + 1) /maxY);

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord = texCoord;
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices = simpleMesh;

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].vertices));
                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].texCoord));
                //m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createShortBuffer(indexes));

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].m.updateBound();

                //simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].mat.setTexture("ColorMap", new Texture2D(atms.makeATMS()));
                //simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].geom.setMaterial(simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].mat);

                //simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x].geom.updateModelBound();




            }
        }


    }

    public void setDimensions(){

        this.dim = 3;

        width = currencyLines[0].points[currencyLines[0].points.length - 1].x - currencyLines[0].points[0].x;
        height = currencyLines[currencyLines.length - 1].points[0].y - currencyLines[0].points[0].y;
        this.vInfinitesimals = new SuperLine[currencyLines[0].infinitesimals.length];

        for (int i = 0; i < this.vInfinitesimals.length; i++){

            this.vInfinitesimals[i] = new SuperLine(new Vector3f[]{currencyLines[0].infinitesimals[i], currencyLines[1].infinitesimals[i], currencyLines[2].infinitesimals[i], currencyLines[3].infinitesimals[i]}, (byte)vInfinitesimals.length - 1);

        }
    }

    public void setImageArray(){
        int imageArray = 1;

        width = this.vInfinitesimals.length;
        height = this.vInfinitesimals[0].infinitesimals.length;

        imageArray = (int)width * (int)height;

        simpleMeshes = new SimpleMesh[imageArray];

    }
    public void drawSimpleMeshes(){
        int maxX = this.vInfinitesimals[0].infinitesimals.length - 1;
        int maxY = this.vInfinitesimals.length - 1;
        for (int y = 0; y < maxY; y++){
            for (int x = 0; x < maxX; x++){

                Vector3f[] simpleMesh = new Vector3f[4];

                simpleMesh[0] = this.vInfinitesimals[y].infinitesimals[x];
                simpleMesh[1] = this.vInfinitesimals[y + 1].infinitesimals[x];
                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];

//                simpleMesh[0] = this.vInfinitesimals[y + 1].infinitesimals[x];
//                simpleMesh[1] = this.vInfinitesimals[y].infinitesimals[x];
//                simpleMesh[2] = this.vInfinitesimals[y].infinitesimals[x + 1];
//                simpleMesh[3] = this.vInfinitesimals[y + 1].infinitesimals[x + 1];




                Vector2f[] texCoord = new Vector2f[4];

                /*
                Vector2f distance = new Vector2f(((this.vInfinitesimals[maxY].infinitesimals[maxX].x) - (this.vInfinitesimals[0].infinitesimals[0].x)), ((this.vInfinitesimals[maxY].infinitesimals[maxX].y) - (this.vInfinitesimals[0].infinitesimals[0].y)));
                Vector2f base = new Vector2f(this.vInfinitesimals[0].infinitesimals[0].x, this.vInfinitesimals[0].infinitesimals[0].y);

                texCoord[0] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x].y - base.y)/distance.y)); // new Vector2f(0,0);
                texCoord[1] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x].x) - base.x) / distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x].y - base.y )/distance.y));//new Vector2f(1,0);
                texCoord[2] = new Vector2f( new Vector2f(((this.vInfinitesimals[y].infinitesimals[x + 1].x) - base.x) / distance.x,(this.vInfinitesimals[y].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(0,1);
                texCoord[3] = new Vector2f( new Vector2f(((this.vInfinitesimals[y + 1].infinitesimals[x + 1].x) - base.x)/distance.x,(this.vInfinitesimals[y + 1].infinitesimals[x + 1].y - base.y)/distance.y));//new Vector2f(1,1);

                */
                texCoord[0] = new Vector2f((float) x /maxX, (float) y /maxY);
                texCoord[1] = new Vector2f((float) x /maxX, (float) (y + 1) /maxY);
                texCoord[2] = new Vector2f((float) (x + 1) /maxX, (float) y /maxY);
                texCoord[3] = new Vector2f((float) (x + 1) /maxX, (float) (y + 1) /maxY);

                simpleMeshes[(this.vInfinitesimals[0].infinitesimals.length * y) + x] = new SimpleMesh(simpleMesh, texCoord, new Texture2D(atms.makeATMS()), node);

            }
        }
    }

    public void bake(){

        //node.detachChild(geom);

        this.texture = new Texture2D(atms.makeATMS());

        m = new Mesh();

        // Vertex positions in space

        int totalVertices = 0;
        for (SimpleMesh sm: simpleMeshes){
            if (sm != null){
                totalVertices += 4;
            }
        }
        this.vertices = new Vector3f[totalVertices];

        // Texture coordinates

        int totalIndices = 0;
        for (SimpleMesh sm: simpleMeshes){
            if (sm != null){
                totalIndices += 4;
            }
        }

        this.texCoord = new Vector2f[totalIndices];

        int totalIndexes = 0;

        for (SimpleMesh sm: simpleMeshes){
            if (sm != null){
                totalIndexes += 6;
            }
        }

        this.indexes = new int[totalIndexes];

        int w = 0;
        int h = 0;

        int v = 0;
        int t = 0;
        int i = 0;
        int j = 0;

        for (SimpleMesh sm : simpleMeshes){

            if (sm != null) {
                vertices[v] = sm.vertices[0];
                vertices[v + 1] = sm.vertices[1];
                vertices[v + 2] = sm.vertices[2];
                vertices[v + 3] = sm.vertices[3];

                v += 4;

                texCoord[t] = sm.texCoord[0];
                texCoord[t + 1] = sm.texCoord[1];
                texCoord[t + 2] = sm.texCoord[2];
                texCoord[t + 3] = sm.texCoord[3];

                t += 4;

                indexes[i] = (short) ((short) j + 2);
                indexes[i + 1] = (short) j;
                indexes[i + 2] = (short) ((short) j + 1);
                indexes[i + 3] = (short) ((short) j + 1);
                indexes[i + 4] = (short) ((short) j + 3);
                indexes[i + 5] = (short) ((short) j + 2);
                //indexes[i + 6] = (short) -1;

                i += 6;
                j += 4;
            }
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

       // node.attachChild(geom);


        //App.scene.attachChild(node);
    }
}
