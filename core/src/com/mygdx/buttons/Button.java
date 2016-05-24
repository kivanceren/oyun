package com.mygdx.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gameobject.GameObject;
import com.mygdx.imageloader.ImageLoader;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by melih on 15.05.2016.
 */
public class Button implements GameObject
{

    private TextureRegion buttonImage;
    private float xKord,yKord,width,height;

    private Rectangle btnRect;

    public Button(float xKord,float yKord,TextureRegion buttonImage,float width,float height)
    {
        this.xKord = xKord;
        this.yKord = yKord;
        this.buttonImage=buttonImage;
        this.width = width;
        this.height = height;
        btnRect = new Rectangle(xKord,yKord,width,height);
    }
    public Button()
    {

        this.buttonImage=ImageLoader.backButtonRegion;
        this.width = (Gdx.graphics.getWidth())/3;
        this.xKord = Gdx.graphics.getWidth()/12;
        this.height=(int)(width*0.2);
        this.yKord = Gdx.graphics.getHeight()-height;
        btnRect = new Rectangle(xKord,yKord,width,height);

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();

        sb.draw(buttonImage,xKord,yKord,width,height);

        sb.end();
    }

    @Override
    public void update(float delta) {

    }
    public Rectangle getBtnRect()
    {
        return btnRect;
    }
}
