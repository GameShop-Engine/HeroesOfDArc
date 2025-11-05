package com.gameshopcorp.heroes.supermesh;

import com.gameshopcorp.heroes.animation.join.SuperJoin;
import com.gameshopcorp.heroes.graphics.SuperMesh;
import com.gameshopcorp.heroes.graphics.SuperSurface;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

import java.util.ArrayList;
import java.util.HashMap;

public class SuperCube {

    boolean debug = true;
    public SuperMesh superMesh;
    public ArrayList<SuperJoin> superJoins;
    public SuperCube(SuperSquare top, SuperSquare bottom, SuperSquare front, SuperSquare back, SuperSquare left, SuperSquare right){


        superMesh = new SuperMesh(new String[]{"top","bottom","front","back","left","right"}, new SuperSurface[]{top.superMesh.superMesh.get(top.name), bottom.superMesh.superMesh.get(bottom.name), front.superMesh.superMesh.get(front.name), back.superMesh.superMesh.get(back.name), left.superMesh.superMesh.get(left.name), right.superMesh.superMesh.get(right.name)});

        if (debug){

            superMesh.superMesh.get("top").atms.layer.drawCircle(superMesh.superMesh.get("top").atms.width/2, superMesh.superMesh.get("top").atms.height/2, superMesh.superMesh.get("top").atms.width + superMesh.superMesh.get("top").atms.height, new Vector4f(0,0,255,255));
            superMesh.superMesh.get("top").updateSimpleMeshes();
            superMesh.superMesh.get("bottom").atms.layer.drawCircle(superMesh.superMesh.get("bottom").atms.width/2, superMesh.superMesh.get("bottom").atms.height/2, superMesh.superMesh.get("bottom").atms.width + superMesh.superMesh.get("bottom").atms.height, new Vector4f(255,0,0,255));
            superMesh.superMesh.get("bottom").updateSimpleMeshes();
            superMesh.superMesh.get("front").atms.layer.drawCircle(superMesh.superMesh.get("front").atms.width/2, superMesh.superMesh.get("front").atms.height/2, superMesh.superMesh.get("front").atms.width + superMesh.superMesh.get("front").atms.height, new Vector4f(0,255,0,255));
            superMesh.superMesh.get("front").updateSimpleMeshes();
            superMesh.superMesh.get("back").atms.layer.drawCircle(superMesh.superMesh.get("back").atms.width/2, superMesh.superMesh.get("back").atms.height/2, superMesh.superMesh.get("back").atms.width + superMesh.superMesh.get("back").atms.height, new Vector4f(255,0,255,255));
            superMesh.superMesh.get("back").updateSimpleMeshes();
            superMesh.superMesh.get("left").atms.layer.drawCircle(superMesh.superMesh.get("left").atms.width/2, superMesh.superMesh.get("left").atms.height/2, superMesh.superMesh.get("left").atms.width + superMesh.superMesh.get("left").atms.height, new Vector4f(0,255,255,255));
            superMesh.superMesh.get("left").updateSimpleMeshes();
            superMesh.superMesh.get("right").atms.layer.drawCircle(superMesh.superMesh.get("right").atms.width/2, superMesh.superMesh.get("right").atms.height/2, superMesh.superMesh.get("right").atms.width + superMesh.superMesh.get("right").atms.height, new Vector4f(255,255,0,255));
            superMesh.superMesh.get("right").updateSimpleMeshes();

        }


        superJoins = new ArrayList<>();

        //y, x Or ROW, COLUMN
        SuperJoin back00 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(0,0), new Vector2f(0,0)});
        SuperJoin back01 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(0,1)});
        SuperJoin back02 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(0,2)});
        SuperJoin back03 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(0,0), new Vector2f(0,3)});

        SuperJoin back10 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,0), new Vector2f(1,0)});
        SuperJoin back11 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(1,1)});
        SuperJoin back12 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(1,2)});
        SuperJoin back13 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(1,0)});
        
        SuperJoin back20 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,0), new Vector2f(2,0)});
        SuperJoin back21 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(2,1)});
        SuperJoin back22 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(2,2)});
        SuperJoin back23 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"),superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(2,3), new Vector2f(2,0)});
        
        SuperJoin back30 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});
        SuperJoin back31 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("top")}, new Vector2f[]{ new Vector2f(3,1), new Vector2f(0,1)});
        SuperJoin back32 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("top")}, new Vector2f[]{ new Vector2f(3,2), new Vector2f(0,2)});
        SuperJoin back33 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("right"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,3), new Vector2f(3,0), new Vector2f(0,3)});
        
         
        SuperJoin front00 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(0,3), new Vector2f(3,0)});
        SuperJoin front01 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("bottom") }, new Vector2f[]{new Vector2f(0,1), new Vector2f(3,1)});
        SuperJoin front02 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(3,2)});
        SuperJoin front03 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(0,3), new Vector2f(3,3)});
        
       
        
        SuperJoin front10 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,0), new Vector2f(1,3)});
        SuperJoin front11 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(1,1)});
        SuperJoin front12 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(1,2)});
        SuperJoin front13 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(1,3)});
        
        SuperJoin front20 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,0), new Vector2f(2,3)});
        SuperJoin front21 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(2,1)});
        SuperJoin front22 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(2,2)});
        SuperJoin front23 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(2,3), new Vector2f(2,3)});;
        
        //

        SuperJoin front30 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,3), new Vector2f(3,0)});
        SuperJoin front31 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("top") }, new Vector2f[]{new Vector2f(3,1), new Vector2f(3,1)});
        SuperJoin front32 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(3,2)});
        SuperJoin front33 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,3), new Vector2f(3,3), new Vector2f(3,3)});

        //
        
        SuperJoin left00 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("back"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(0,0), new Vector2f(0,0)});;
        SuperJoin left01 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{ new Vector2f(0,1), new Vector2f(1,0)});;
        SuperJoin left02 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{ new Vector2f(0,2), new Vector2f(2,0)});;
        SuperJoin left03 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("front"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(0,0), new Vector2f(0,3)});;

        //

        SuperJoin left10 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("back") }, new Vector2f[]{new Vector2f(1,0), new Vector2f(0,1)});;
        SuperJoin left11 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,1)});;
        SuperJoin left12 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,2)});;
        SuperJoin left13 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(0,1)});;

        //

        SuperJoin left20 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("back") }, new Vector2f[]{new Vector2f(2,0), new Vector2f(0,2)});;
        SuperJoin left21 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,1)});;
        SuperJoin left22 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,2)});;
        SuperJoin left23 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(2,3), new Vector2f(0,2)});;



        SuperJoin left30 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("back"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(0,0), new Vector2f(0,3)});;
        SuperJoin left31 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{ new Vector2f(3,1), new Vector2f(1,0)});;
        SuperJoin left32 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{ new Vector2f(3,2), new Vector2f(2,0)});;
        SuperJoin left33 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("front"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,3), new Vector2f(0,0), new Vector2f(3,0)});;

         //

        SuperJoin right00 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("back"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(0,0), new Vector2f(0,3)});;
        SuperJoin right01 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{ new Vector2f(0,1), new Vector2f(1,3)});;
        SuperJoin right02 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{ new Vector2f(0,2), new Vector2f(2,3)});;
        SuperJoin right03 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("front"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(0,3), new Vector2f(3,3)});;

        //Start

        SuperJoin right10 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("back") }, new Vector2f[]{new Vector2f(1,0), new Vector2f(0,1)});;
        SuperJoin right11 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,1)});;
        SuperJoin right12 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,2)});;
        SuperJoin right13 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(0,1)});;

//        SuperJoin right10 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
//        SuperJoin right11 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
//        SuperJoin right12 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
//        SuperJoin right13 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;

        //End

        SuperJoin right20 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin right21 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin right22 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin right23 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        SuperJoin right30 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin right31 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin right32 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin right33 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        //
        
        SuperJoin top00 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top01 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top02 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top03 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        SuperJoin top10 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top11 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top12 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top13 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        SuperJoin top20 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top21 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top22 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top23 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        SuperJoin top30 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top31 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top32 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin top33 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        //
        
        SuperJoin bottom00 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom01 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom02 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom03 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        SuperJoin bottom10 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom11 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom12 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom13 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        SuperJoin bottom20 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom21 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom22 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom23 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        
        SuperJoin bottom30 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom31 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom32 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
        SuperJoin bottom33 = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(0,0)});;
         
        //
        
        superJoins.add(back00);
        superJoins.add(back01);
        superJoins.add(back02);
        superJoins.add(back03);
        
        superJoins.add(back10);
        superJoins.add(back11);
        superJoins.add(back12);
        superJoins.add(back13);
        
        superJoins.add(back20);
        superJoins.add(back21);
        superJoins.add(back22);
        superJoins.add(back23);
        
        superJoins.add(back30);
        superJoins.add(back31);
        superJoins.add(back32);
        superJoins.add(back33);
        
        superJoins.add(front00);
        superJoins.add(front01);
        superJoins.add(front02);
        superJoins.add(front03);
        
        superJoins.add(front10);
        superJoins.add(front11);
        superJoins.add(front12);
        superJoins.add(front13);

        superJoins.add(front20);
        superJoins.add(front21);
        superJoins.add(front22);
        superJoins.add(front23);

        superJoins.add(front30);
        superJoins.add(front31);
        superJoins.add(front32);
        superJoins.add(front33);

        superJoins.add(left00);
        superJoins.add(left01);
        superJoins.add(left02);
        superJoins.add(left03);

        superJoins.add(left10);
        superJoins.add(left11);
        superJoins.add(left12);
        superJoins.add(left13);

        superJoins.add(left20);
        superJoins.add(left21);
        superJoins.add(left22);
        superJoins.add(left23);

        superJoins.add(left30);
        superJoins.add(left31);
        superJoins.add(left32);
        superJoins.add(left33);

        superJoins.add(right00);
        superJoins.add(right01);
        superJoins.add(right02);
        superJoins.add(right03);

        //DEPRECATED
        /*
        SuperJoin topFrontLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(3,0), new Vector2f(3,3)});
        SuperJoin topFrontRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(3,3), new Vector2f(3,3), new Vector2f(3,3)});
        SuperJoin topBackLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(3,0), new Vector2f(3,0)});
        SuperJoin topBackRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(3,3), new Vector2f(3,0)});

        SuperJoin bottomFrontLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(3,0), new Vector2f(0,0), new Vector2f(0,3)});
        SuperJoin bottomFrontRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(3,3), new Vector2f(0,3), new Vector2f(0,3)});
        SuperJoin bottomBackLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(0,0), new Vector2f(0,0), new Vector2f(0,0)});
        SuperJoin bottomBackRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(0,3), new Vector2f(0,3), new Vector2f(0,0)});
        
        
        SuperJoin edgeTopFrontMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(3,1)});
        SuperJoin edgeTopFrontMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(3,2)});
        SuperJoin edgeBottomFrontMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(0,1)});
        SuperJoin edgeBottomFrontMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("front")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(0,2)});

        SuperJoin edgeTopBackMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(3,1)});
        SuperJoin edgeTopBackMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("top"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(3,2)});
        SuperJoin edgeBottomBackMidLeft = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(0,1)});
        SuperJoin edgeBottomBackMidRight = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("bottom"), superMesh.superMesh.get("back")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(0,2)});

        SuperJoin edgeFrontLeftMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,0), new Vector2f(2,3)});
        SuperJoin edgeFrontLeftMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,0), new Vector2f(1,3)});
        SuperJoin edgeFrontRightMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(2,3), new Vector2f(2,3)});
        SuperJoin edgeFrontRightMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("front"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(1,3)});

        SuperJoin edgeBackLeftMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(2,0), new Vector2f(2,0)});
        SuperJoin edgeBackLeftMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("left")}, new Vector2f[]{new Vector2f(1,0), new Vector2f(1,0)});
        SuperJoin edgeBackRightMidTop = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(2,3), new Vector2f(2,0)});
        SuperJoin edgeBackRightMidBottom = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("back"), superMesh.superMesh.get("right")}, new Vector2f[]{new Vector2f(1,3), new Vector2f(1,0)});

        SuperJoin edgeLeftTopMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(2,0)});
        SuperJoin edgeLeftTopMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(1,0)});
        SuperJoin edgeLeftBottomMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(2,0)});
        SuperJoin edgeLeftBottomMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("left"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(1,0)});

        SuperJoin edgeRightTopMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,2), new Vector2f(2,3)});
        SuperJoin edgeRightTopMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("top")}, new Vector2f[]{new Vector2f(3,1), new Vector2f(1,3)});
        SuperJoin edgeRightBottomMidFront = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,2), new Vector2f(2,3)});
        SuperJoin edgeRightBottomMidBack = new SuperJoin(new SuperSurface[]{superMesh.superMesh.get("right"), superMesh.superMesh.get("bottom")}, new Vector2f[]{new Vector2f(0,1), new Vector2f(1,3)});

        */

        //SuperJoin topFrontRight = new SuperJoin()
        //edgeRightBottomMidBack.moveJoin(new Vector3f( 1,-1,0));

        //DEPRECATED
        /*
        superJoins.add(topFrontLeft);
        superJoins.add(topFrontRight);
        superJoins.add(topBackLeft);
        superJoins.add(topBackRight);

        superJoins.add(bottomFrontLeft);
        superJoins.add(bottomFrontRight);
        superJoins.add( bottomBackLeft);
        superJoins.add( bottomBackRight);

        superJoins.add(edgeTopFrontMidLeft);
        superJoins.add(edgeTopFrontMidRight);
        superJoins.add(edgeBottomFrontMidLeft);
        superJoins.add(edgeBottomFrontMidRight);

        superJoins.add(edgeTopBackMidLeft);
        superJoins.add(edgeTopBackMidRight);
        superJoins.add(edgeBottomBackMidLeft);
        superJoins.add(edgeBottomBackMidRight);

        superJoins.add(edgeFrontLeftMidTop);
        superJoins.add(edgeFrontLeftMidBottom);
        superJoins.add(edgeFrontRightMidTop);
        superJoins.add(edgeFrontRightMidBottom);

        superJoins.add( edgeBackLeftMidTop);
        superJoins.add( edgeBackLeftMidBottom);
        superJoins.add( edgeBackRightMidTop);
        superJoins.add(edgeBackRightMidBottom);

        superJoins.add(edgeLeftTopMidFront);
        superJoins.add( edgeLeftTopMidBack);
        superJoins.add( edgeLeftBottomMidFront);
        superJoins.add(edgeLeftBottomMidBack);

        superJoins.add( edgeRightTopMidFront);
        superJoins.add( edgeRightTopMidBack);
        superJoins.add( edgeRightBottomMidFront);
        superJoins.add( edgeRightBottomMidBack);

        */
        superMesh.superJoins = superJoins;
    }

}
