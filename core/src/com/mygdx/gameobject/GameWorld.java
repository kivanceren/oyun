package com.mygdx.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

/*
 * Created by melih on 14.05.2016.
 */
public class GameWorld implements GameObject {

    private ArrayList<BalonNesnesi> balonlarim;
    private int ranValueHeight,ranValueWidth,ranBalloon;
    public static Texture text1,text2,text3,text4;
    public static TextureRegion balonRegion,balonRegion1,balonRegion2,balonRegion3,balonRegion4;
    private int renk;
    private boolean ekleme;
    private int puan;

    boolean b1,b2,b3,b4;
    private int speed;
    private Sound sound;
    float delay;
    private int ballCount;


    public GameWorld(int speed,int ballCount)
    {
        delay=MathUtils.random(1,2);
        b1=false;
        b2=false;
        b3=false;
        b4=false;
        this.speed = speed;
        this.ballCount = ballCount;

        balonlarim = new ArrayList<BalonNesnesi>();


        sound = Gdx.audio.newSound(Gdx.files.internal("balloonPop.ogg"));


        ranBalloon = MathUtils.random(40,this.ballCount);
        text1 = new Texture(Gdx.files.internal("red.png"));
        text3 = new Texture(Gdx.files.internal("black.png"));
        text4 = new Texture(Gdx.files.internal("green.png"));
        text2 = new Texture(Gdx.files.internal("yellow.png"));

        balonRegion1 = new TextureRegion(text1, 0, 0, text1.getWidth(), text1.getHeight());
        balonRegion1.flip(false, true);

        balonRegion2 = new TextureRegion(text2, 0, 0, text2.getWidth(), text2.getHeight());
        balonRegion2.flip(false, true);

        balonRegion3 = new TextureRegion(text3, 0, 0, text3.getWidth(), text3.getHeight());
        balonRegion3.flip(false, true);

        balonRegion4 = new TextureRegion(text4, 0, 0, text4.getWidth(), text4.getHeight());
        balonRegion4.flip(false, true);

        for(int i=0;i<ranBalloon;++i) {

            ekleme=false;
            renk = MathUtils.random(1, 4);
            ranValueHeight = MathUtils.random(0,Gdx.graphics.getHeight()*5);
            ranValueWidth = MathUtils.random(0,Gdx.graphics.getWidth());

        if (renk == 1) {
            balonRegion = balonRegion1;

        }

        if (renk == 2) {

            balonRegion = balonRegion2;
        }

        if (renk == 3) {
            balonRegion = balonRegion3;

        }

        if (renk == 4) {
            balonRegion = balonRegion4;

        }
            for (int j=0;j<balonlarim.size();j++)
            {
                if (Math.abs(balonlarim.get(j).getxKord() - ranValueWidth)< balonlarim.get(j).getWidth() && Math.abs(balonlarim.get(j).getyKord() - (Gdx.graphics.getHeight()+ranValueHeight))< balonlarim.get(j).getHeight() )
                {
                    ekleme=true;
                }
            }

            if (!ekleme)
            {
                if(renk==1)
                    balonlarim.add(new BalonNesnesi(ranValueWidth, Gdx.graphics.getHeight() + ranValueHeight, balonRegion, balonRegion1, balonRegion2, balonRegion3, balonRegion4, renk, speed, i,10));
                else if(renk==2)
                    balonlarim.add(new BalonNesnesi(ranValueWidth, Gdx.graphics.getHeight() + ranValueHeight, balonRegion, balonRegion1, balonRegion2, balonRegion3, balonRegion4, renk, speed, i, 20));
                else if(renk==3)
                    balonlarim.add(new BalonNesnesi(ranValueWidth, Gdx.graphics.getHeight() + ranValueHeight, balonRegion, balonRegion1, balonRegion2, balonRegion3, balonRegion4, renk, speed, i,-10));
                else if(renk==4)
                    balonlarim.add(new BalonNesnesi(ranValueWidth, Gdx.graphics.getHeight() + ranValueHeight, balonRegion, balonRegion1, balonRegion2, balonRegion3, balonRegion4, renk, speed, i,5));

            }

        }
    }

    @Override
    public void render(SpriteBatch sb) {

//        balon.render(sb);

        for (int i=0;i<balonlarim.size();i++)
        {
            balonlarim.get(i).render(sb);
        }

    }

    @Override
    public void update(float delta) {
//        balon.update(delta);
        for (int i=0;i<balonlarim.size();i++)
        {
            balonlarim.get(i).update(delta);
        }

    }



    public void destroyBalon(int index,int type,int xKord,int yKord)
    {

        if (type == 1 ) {

            sound.play(0.1f);
            if (balonlarim.get(index).getColorType() == 1)
                b1=true;
            if (balonlarim.get(index).getColorType() == 2)
                b2=true;
            if (balonlarim.get(index).getColorType() == 3)
                b3=true;
            if (balonlarim.get(index).getColorType() == 4)
                b4=true;

            balonlarim.get(index).isDisposed = true;
            puan+=balonlarim.get(index).getPuan();

            balonlarim.remove(index);


        }
    }



    public ArrayList<BalonNesnesi> getBalonlarim() {
        return balonlarim;
    }

    public void setBalonlarim(ArrayList<BalonNesnesi> balonlarim) {
        this.balonlarim = balonlarim;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    public boolean isB3() {
        return b3;
    }

    public void setB3(boolean b3) {
        this.b3 = b3;
    }

    public boolean isB4() {
        return b4;
    }

    public void setB4(boolean b4) {
        this.b4 = b4;
    }
}
