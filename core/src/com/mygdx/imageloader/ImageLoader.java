package com.mygdx.imageloader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by melih on 03.05.2016.
 */
public class ImageLoader {

    public static Texture text,text2,textGameBg,textYeniOyun,textHakkinda,textMap2,textMap3,textBack,textYeniBolum;
    public static TextureRegion bgRegion,gameBgRegion,balonRegion,yeniOyunRegion,hakkindaRegion,backButtonRegion;
    public static TextureRegion map2,map3,yeniBolum;

    public static Texture soundOn,soundOff,exit;
    public static TextureRegion soundOnRegion,soundOffRegion,exitRegion;


    public static BitmapFont font;
    public static Texture fontText;

    public static void load()
    {

        soundOn = new Texture(Gdx.files.internal("soundOn.png"));
        soundOff = new Texture(Gdx.files.internal("soundOff.png"));
        exit = new Texture(Gdx.files.internal("exit.png"));

        exitRegion = new TextureRegion(exit,0,0,exit.getWidth(),exit.getHeight());
        exitRegion.flip(false,true);

        soundOnRegion = new TextureRegion(soundOn,0,0,soundOn.getWidth(),soundOn.getHeight());
        soundOnRegion.flip(false,true);

        soundOffRegion = new TextureRegion(soundOff,0,0,soundOff.getWidth(),soundOff.getHeight());
        soundOffRegion.flip(false,true);


        font = new BitmapFont(Gdx.files.internal("yazi.fnt"),true);

        fontText = new Texture(Gdx.files.internal("yazi.png"));
        fontText.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        textYeniBolum=new Texture(Gdx.files.internal("btnYeniBolum.png"));
        textBack=new Texture(Gdx.files.internal("btnGeri.png"));
        textMap2 = new Texture(Gdx.files.internal("map2.jpg"));
        textMap3 = new Texture(Gdx.files.internal("map3.jpg"));
        backButtonRegion=new TextureRegion(textBack,0,0,textBack.getWidth(),textBack.getHeight());
        backButtonRegion.flip(false,true);
        yeniBolum=new TextureRegion(textYeniBolum,0,0,textYeniBolum.getWidth(),textYeniBolum.getHeight());
        yeniBolum.flip(false,true);
        map2 = new TextureRegion(textMap2,0,0,textMap2.getWidth(),textMap2.getHeight());
        map2.flip(false,true);
        map3 = new TextureRegion(textMap3,0,0,textMap3.getWidth(),textMap3.getHeight());
        map3.flip(false,true);

        textYeniOyun = new Texture(Gdx.files.internal("btnYeniOyun.png"));
        textHakkinda = new Texture(Gdx.files.internal("btnHakkinda.png"));
        text = new Texture(Gdx.files.internal("background.jpg"));
        textGameBg = new Texture(Gdx.files.internal("gokyuzu.jpg"));
        text2 = new Texture(Gdx.files.internal("kirmizi.jpg"));
        bgRegion = new TextureRegion(text,0,0,text.getWidth(),text.getHeight());
        bgRegion.flip(false,true);

        balonRegion = new TextureRegion(text,480,2,50,50);
        balonRegion.flip(false,true);


        gameBgRegion = new TextureRegion(textGameBg,0,0,textGameBg.getWidth(),textGameBg.getHeight());
        gameBgRegion.flip(false,true);


        balonRegion = new TextureRegion(text2,0,0,text2.getWidth(),text2.getHeight());
        balonRegion.flip(false,true);

        yeniOyunRegion = new TextureRegion(textYeniOyun,textYeniOyun.getWidth(),textYeniOyun.getHeight());
        yeniOyunRegion.flip(false,true);

        hakkindaRegion = new TextureRegion(textHakkinda,textHakkinda.getWidth(),textHakkinda.getHeight());
        hakkindaRegion.flip(false,true);

    }
    public static void dispose()
    {
        text.dispose();
        font.dispose();
        fontText.dispose();
    }
}
