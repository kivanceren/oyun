package com.mygdx.gameobject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by melih on 14.05.2016.
 */
public interface GameObject {

    public void render(SpriteBatch sb);

    public void update(float delta);


}
