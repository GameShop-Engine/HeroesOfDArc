package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.basic.body.base.Base;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Nose extends Base {
    public Nose(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);

        superMesh.node.scale(2, 4, 1);
        moveRange("front", new Vector2f(0,0), new Vector2f(3,3), -.75f);
        moveRange("front", new Vector2f(0,0), new Vector2f(3,3), new Vector3f(0,-0.25f,.25f));


    }
}
