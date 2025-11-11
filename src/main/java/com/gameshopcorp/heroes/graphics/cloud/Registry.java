package com.gameshopcorp.heroes.graphics.cloud;

import com.gameshopcorp.heroes.graphics.SuperSurface;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

public class Registry {

    SuperSurface superSurface;
    public int[] vertices;
    public int[] texCoord;

    public int[] indexes;
    public Registry(SuperSurface superSurface){

        this.superSurface = superSurface;
        vertices = new int[4];
        texCoord = new int[4];
        indexes = new int[6];


    }

    @Override
    public String toString(){

        return "" + superSurface + " " + vertices + " " + texCoord + " " + indexes;
    }
}
