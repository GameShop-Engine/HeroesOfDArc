package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.basic.body.base.Base;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Nostrils extends Base {
    public Nostrils(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);
        //moveCorners("front", 0.25f);
        //moveCorners("back", 0.25f);
        superMesh.node.scale(2, 4, 1);
    }
}
