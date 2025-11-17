package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.base.Base;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

public class Hand extends Base {
    public Hand(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);

        moveRange("left", new Vector2f(0,0), new Vector2f(3,3), -0.5f);
        moveRange("right", new Vector2f(0,0), new Vector2f(3,3), -1f);


    }
}
