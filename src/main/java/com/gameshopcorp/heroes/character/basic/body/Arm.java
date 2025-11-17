package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.base.Base;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Arm extends Base {
    public Arm(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);

        moveRange("right", new Vector2f(0,0), new Vector2f(3,3), 0.75f);
        moveRange("right", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(0.5f,0,0));

        moveCorners("right",-0.5f);

        moveOne("top", new Vector2f(0,2), new Vector3f(0,0, -0.25f));
        moveOne("bottom", new Vector2f(0,2), new Vector3f(0,0, -0.25f));
        moveOne("front", new Vector2f(0,2), new Vector3f(0,0, -0.25f));
        moveOne("back", new Vector2f(0,2), new Vector3f(0,0, -0.25f));

        moveOne("top", new Vector2f(0,1), new Vector3f(0,0, -0.25f));
        moveOne("bottom", new Vector2f(0,1), new Vector3f(0,0, -0.25f));
        moveOne("front", new Vector2f(0,1), new Vector3f(0,0, -0.25f));
        moveOne("back", new Vector2f(0,1), new Vector3f(0,0, -0.25f));

        moveOne("top", new Vector2f(0,0), new Vector3f(0,0, -0.25f));
        moveOne("bottom", new Vector2f(0,0), new Vector3f(0,0, -0.25f));
        moveOne("front", new Vector2f(0,0), new Vector3f(0,0, -0.25f));
        moveOne("back", new Vector2f(0,0), new Vector3f(0,0, -0.25f));


        moveRange("top", new Vector2f(0,2), new Vector2f(3,2), -0.75f);
        moveRange("bottom", new Vector2f(0,2), new Vector2f(3,2), -0.75f);
        moveRange("front", new Vector2f(0,2), new Vector2f(3,2), -0.75f);
        moveRange("back", new Vector2f(0,2), new Vector2f(3,2), -0.75f);

        moveRange("top", new Vector2f(0,1), new Vector2f(3,1), -1f);
        moveRange("bottom", new Vector2f(0,1), new Vector2f(3,1), -1f);
        moveRange("front", new Vector2f(0,1), new Vector2f(3,1), -1f);
        moveRange("back", new Vector2f(0,1), new Vector2f(3,1), -1f);

        moveRange("top", new Vector2f(0,0), new Vector2f(3,0), -1f);
        moveRange("bottom", new Vector2f(0,0), new Vector2f(3,0), -1f);
        moveRange("front", new Vector2f(0,0), new Vector2f(3,0), -1f);
        moveRange("back", new Vector2f(0,0), new Vector2f(3,0), -1f);

        moveRange("left", new Vector2f(1,1), new Vector2f(2,2), new Vector3f(-.25f,0,0));

        moveCorners("left", -0.25f);
    }


}
