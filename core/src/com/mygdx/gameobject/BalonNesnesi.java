package com.mygdx.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by melih on 15.05.2016.
 */
public class BalonNesnesi implements GameObject {

    private int xKord;
    private int yKord;
    private int width;
    private int height;
    private int speed;
    private int puan;
    private int rand;
    private int randX;
    private int randY;

    private TextureRegion image,image1,image2,image3,image4;
    private int colorType;
    boolean isDisposed,isTicked,myTimer;
    long myTime;
    Timer timer;


    private int ID;



    public BalonNesnesi(int xKord,int yKord,TextureRegion image ,TextureRegion image1,TextureRegion image2,TextureRegion image3,TextureRegion image4,int renk,int speed,int ID,int puan)
    {
        this.ID = ID;
        this.puan = puan;
        this.speed = speed;
        this.xKord = xKord;
        this.yKord = yKord;
        this.colorType =renk;
        width=100;
        height=100;

        this.image1=image1;
        this.image2=image2;
        this.image3=image3;
        this.image4=image4;

        myTime = TimeUtils.nanoTime();

        this.image=image;
        isTicked=false;

        rand = MathUtils.random(1,3);


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        if (!isDisposed)
            sb.draw(image,xKord,yKord,width,height);


        sb.end();
    }

    @Override
    public void update(float delta) {

        if (colorType == 1)
        {
            yKord -=speed*2/3;
            int rand = MathUtils.random(-15,15);
            xKord+=rand;

        }
        else if (colorType == 2)
        {

            if (TimeUtils.timeSinceNanos(myTime) > 1000000000) {

                    timer_tick1();

                myTime = TimeUtils.nanoTime();
            }
         }
        else if  (colorType == 3)
        {
            timer_tick2(rand);
            yKord -=speed;
            if (isTicked)
            {


                this.image =image4;
                colorType=4;
            }
        }

        else if  (colorType == 4)
        {

            timer_tick2(rand);
            yKord -= speed*4/3;
            if (isTicked)
            {
                this.image = image3;
                colorType=3;
            }
        }

    }


    public void timer_tick1()
    {
        randX = MathUtils.random(0, Gdx.graphics.getWidth()-width);
        randY = MathUtils.random(0, Gdx.graphics.getHeight()*5);
        xKord = randX;
        yKord = randY;

        if (isDisposed)
            isDisposed = false;
        else
            isDisposed=true;
    }
    public void timer_tick2(int rand) {

        isTicked=false;
        if (TimeUtils.timeSinceNanos(myTime) > 1000000000 * rand){

            isTicked= true;
            myTime = TimeUtils.nanoTime();
        }

    }

    public int getxKord() {
        return xKord;
    }

    public void setxKord(int xKord) {
        this.xKord = xKord;
    }

    public int getyKord() {
        return yKord;
    }

    public void setyKord(int yKord) {
        this.yKord = yKord;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TextureRegion getImage() {
        return image;
    }

    public void setImage(TextureRegion image) {
        this.image = image;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getColorType() {
        return colorType;
    }

    public void setColorType(int colorType) {
        this.colorType = colorType;
    }
}
