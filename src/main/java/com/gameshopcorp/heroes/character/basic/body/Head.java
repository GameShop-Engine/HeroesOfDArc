package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.base.Base;
import com.gameshopcorp.heroes.graphics.SuperLine;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Head extends Base {

    public Head(int numPoints, Vector4f baseColor){
        super(numPoints, baseColor);

       // moveCorners(new Vector3f(.5f,.5f,.5f).mult(-1f));
        //findJoin(get("bottom"), new Vector2f(0,0)).moveJoin(new Vector3f(0,0,1));

        moveRange("bottom", new Vector2f(3,0), new Vector2f(3,3), -0.25f);
        moveRange("bottom", new Vector2f(3,1), new Vector2f(3,2), new Vector3f(0,-0.5f, -0.5f));

        moveRange("top", new Vector2f(3,1), new Vector2f(3,2), new Vector3f(0,0.5f, 0));
        moveRange("top", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,1f, 0));

        moveRange("front", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,0f, 0.5f));

        moveRange("left", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(-0.25f,0f, -0.25f));
        moveRange("right", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0.25f,0f, -0.25f));

        moveRange("back", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0.5f,0f, -0.5f));
        moveRange("back", new Vector2f(3,0), new Vector2f(3,3), new Vector3f(0,0f, -0.5f));

        moveRange("back", new Vector2f(3,0), new Vector2f(3,3), -.5f);
        moveRange("back", new Vector2f(0,0), new Vector2f(3,3), -.25f);

        moveRange("left", new Vector2f(0,0), new Vector2f(3,3), -0.05f);
        moveRange("right", new Vector2f(0,0), new Vector2f(3,3), -0.05f);

        moveRange("bottom", new Vector2f(0,1), new Vector2f(1,2), new Vector3f(0,-2f, 0));

        moveRange("back", new Vector2f(3,0), new Vector2f(3,3), new Vector3f(0,0.25f, 0.25f));

        //moveCorners("back", -0.5f);

//        moveRange("front", new Vector2f(1,1), new Vector2f(1,2), -0.5f);
//        moveRange("front", new Vector2f(1,1), new Vector2f(1,2), new Vector3f(0,-0.25f,.75f));


        //draw();
        drawEyes();
    }




    public void drawEyes(){

        atms("front").layer.drawSuperLine(new SuperLine(new Vector3f[]{new Vector3f(48 + 24,24,0), new Vector3f(64 + 32,24,0), new Vector3f(64 + 32,48,0),new Vector3f(48 + 24,48,0)},8), (short) 8, new Vector4f(255,255,255,255));
        atms("front").layer.drawLine(new Vector2f(48 + 24, 24), new Vector2f( 48 + 24, 40), (short) 8, new Vector4f(255,255,255,255));
        atms("front").layer.drawCircle(80, 36, (short) 12, new Vector4f(0,0,255,255));

        atms("front").layer.drawSuperLine(new SuperLine(new Vector3f[]{new Vector3f(48 + 24,128 - 24,0), new Vector3f(64 + 32,128 -24,0), new Vector3f(64 + 32,128 -48,0),new Vector3f(48 + 24,128 -48,0)},8), (short) 8, new Vector4f(255,255,255,255));
         atms("front").layer.drawLine(new Vector2f(48 + 24, 128 -24), new Vector2f( 48 + 24, 128 -48), (short) 8, new Vector4f(255,255,255,255));
        atms("front").layer.drawCircle(80, 128 -36, (short) 12, new Vector4f(0,0,255,255));

    }
}
