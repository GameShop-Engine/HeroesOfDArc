package com.gameshopcorp.heroes.character.basic.body;

import com.gameshopcorp.heroes.character.basic.body.base.Base;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

public class Eye extends Base {

    public Eye(int numPoints, Vector4f baseColor) {
        super(numPoints, baseColor);
        
        findJoin(get("front"), new Vector2f(1,3)).moveJoin(new Vector3f(0, 0, 1.0f));
//        findJoin(get("back"), new Vector2f(0,3)).moveJoin(new Vector3f(-.125f, .125f, 0f));
//        findJoin(get("back"), new Vector2f(3,0)).moveJoin(new Vector3f(.125f, -.125f, 0f));
//        findJoin(get("back"), new Vector2f(3,3)).moveJoin(new Vector3f(-.125f, -.125f, 0f));
        
    }
}
