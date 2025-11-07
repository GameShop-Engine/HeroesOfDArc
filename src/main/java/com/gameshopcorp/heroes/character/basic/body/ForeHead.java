package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.basic.body.base.Base;
import com.jme3.math.Vector4f;

public class ForeHead extends Base {
    public ForeHead(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);

        superMesh.node.scale(8,2,1);
    }
}
