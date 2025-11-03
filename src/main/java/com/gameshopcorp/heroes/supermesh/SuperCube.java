package com.gameshopcorp.heroes.supermesh;

import com.gameshopcorp.heroes.animation.join.SuperJoin;
import com.gameshopcorp.heroes.graphics.SuperMesh;
import com.gameshopcorp.heroes.graphics.SuperSurface;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

import java.util.ArrayList;
import java.util.HashMap;

public class SuperCube {

    boolean debug = false;
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


        //SuperJoin topFrontRight = new SuperJoin()
        //edgeRightBottomMidBack.moveJoin(new Vector3f( 1,-1,0));

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

        superMesh.superJoins = superJoins;
    }

}
