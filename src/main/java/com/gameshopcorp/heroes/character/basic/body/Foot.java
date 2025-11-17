package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.base.Base;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Foot extends Base {
    public Foot(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);

        moveRange("back", new Vector2f(0,0), new Vector2f(3,3), new Vector3f(0,0,0.125f));
        moveRange("back", new Vector2f(0,1), new Vector2f(1,2), new Vector3f(0,0,-0.25f));
        moveRange("back", new Vector2f(0,1), new Vector2f(1,2),  -0.25f);
        //moveRange("back", new Vector2f(0,0), new Vector2f(3,0),  new Vector3f(.125f, 0f, .125f ));
        moveRange("front", new Vector2f(0,0), new Vector2f(3,3), -0.5f);

    }
}
