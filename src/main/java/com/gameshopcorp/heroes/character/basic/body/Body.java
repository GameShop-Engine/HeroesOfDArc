package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.base.Base;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Body extends Base {

    public Body(int numPoints, Vector4f baseColor ){
        super(numPoints, baseColor);

        moveRange("bottom", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,-0.25f, 0));

        moveRange("left", new Vector2f(1,0), new Vector2f(2,3), new Vector3f(-0.25f,0, 0));
        moveRange("right", new Vector2f(1,0), new Vector2f(2,3), new Vector3f(0.25f,0, 0));

        moveRange("left", new Vector2f(3,0), new Vector2f(3,3), new Vector3f(-1.5f,0, 0));
        moveRange("right", new Vector2f(3,0), new Vector2f(3,3), new Vector3f(1.5f,0, 0));

        moveRange("top", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,0.25f, 0));

        moveRange("front", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,.25f, 1f));
        moveRange("front", new Vector2f(1,1), new Vector2f(1,2), 0.5f);
        moveRange("front", new Vector2f(2,1), new Vector2f(2,2), 0.5f);

        moveRange("back", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0,0, -1.25f));
        moveRange("back", new Vector2f(1,1), new Vector2f(1,2), -0.5f);
        moveRange("back", new Vector2f(2,1), new Vector2f(2,2), -0.5f);

        moveRange("back", new Vector2f(1,1), new Vector2f(1,2), new Vector3f(0,-.25f, 0));
        moveRange("back", new Vector2f(2,1), new Vector2f(2,2), new Vector3f(0,.25f, 0));

        moveCorners("top", -0.25f);

        draw();
    }



}
