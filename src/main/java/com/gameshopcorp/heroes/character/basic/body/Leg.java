package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.base.Base;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Leg extends Base {
    public Leg(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);

       moveRange("top", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,0.75f, 0));
       // moveRange("bottom", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,-0.25f, 0));

//        moveRange("front", new Vector2f(2,0), new Vector2f(2,3), new Vector3f(0,0.25f, 0));
//        moveRange("back", new Vector2f(2,0), new Vector2f(2,3), new Vector3f(0,0.25f, 0));
//        moveRange("left", new Vector2f(2,0), new Vector2f(2,3), new Vector3f(0,0.25f, 0));
//        moveRange("right", new Vector2f(2,0), new Vector2f(2,3), new Vector3f(0,0.25f, 0));

        moveRange("back", new Vector2f(2,1), new Vector2f(3,2), new Vector3f(0,0 , -1.5f));
        moveCorners("top", -0.75f);

        moveRange("front", new Vector2f(3,0), new Vector2f(3,3), .75f);
        moveRange("back", new Vector2f(3,0), new Vector2f(3,3), .75f);
        moveRange("top", new Vector2f(3,0), new Vector2f(3,3), .75f);
        moveRange("bottom", new Vector2f(3,0), new Vector2f(3,3), .75f);


        moveRange("front", new Vector2f(1,0), new Vector2f(1,3), -.5f);
        moveRange("back", new Vector2f(1,0), new Vector2f(1,3), -.5f);
        moveRange("top", new Vector2f(1,0), new Vector2f(1,3), -.5f);
        moveRange("bottom", new Vector2f(1,0), new Vector2f(1,3), -.5f);


        moveRange("front", new Vector2f(0,0), new Vector2f(0,3), -.75f);
        moveRange("back", new Vector2f(0,0), new Vector2f(0,3), -.75f);
        moveRange("top", new Vector2f(0,0), new Vector2f(0,3), -.75f);
        moveRange("bottom", new Vector2f(0,0), new Vector2f(0,3), -.75f);


    }


}
