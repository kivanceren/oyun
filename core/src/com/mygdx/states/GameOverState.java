package com.mygdx.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.buttons.Button;

import com.mygdx.imageloader.ImageLoader;
import com.mygdx.inputhandler.GameOverStateInput;



/**
 * Created by melih on 17.05.2016.
 */
public class GameOverState extends State{

    StateManager sm;


    boolean isWon;
    private int mapCount;
    private int puan;
    private Button newLevel;
    boolean isOver;
    private MenuState menuState;
    private Button backButton;
    private static int sonPuan;

    public GameOverState(StateManager sm,boolean isWon,int mapCount,int puan) {
        super(sm);
        this.puan=puan;

        sonPuan+=puan;
        this.isWon = isWon;
        this.sm =sm;
        this.mapCount = mapCount;
        this.mapCount+=1;
        menuState = new MenuState(sm);
        newLevel = new Button(10,Gdx.graphics.getWidth()/5*3,ImageLoader.yeniBolum,menuState.getPlayButtonWidht(),menuState.getPlayButtonHeight());
        Gdx.input.setInputProcessor(new GameOverStateInput(this));
        backButton = new Button();

    }
    @Override
    public void render(SpriteBatch sb) {

        sb.begin();

        if (mapCount!=4)
        {
            ImageLoader.font.draw(sb,"BOLUM SONU ",10,Gdx.graphics.getWidth()/5);

        }
        else {
            ImageLoader.font.draw(sb, "OYUN SONU ", 10, Gdx.graphics.getWidth() / 5);
            ImageLoader.font.draw(sb,"SON PUAN : "+this.sonPuan,10,Gdx.graphics.getWidth()/3*2);


        }
        ImageLoader.font.draw(sb," PUAN : "+puan,10,Gdx.graphics.getWidth()/5*2);

        if (!isWon)
            ImageLoader.font.draw(sb,"KAYBETTINIZ!!!\n OYUN SONU ",10,Gdx.graphics.getWidth()/5*4);

        sb.end();

        if (isWon && mapCount <4)
        newLevel.render(sb);
        else
            isOver=true;
        if (mapCount == 4)
            backButton.render(sb);
        if (!isWon)
            backButton.render(sb);

    }

    @Override
    protected void finalize() throws Throwable {
        this.sonPuan=0;
        super.finalize();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void handleInput() {

    }

    public Button getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(Button newLevel) {
        this.newLevel = newLevel;
    }

    public StateManager getSm() {
        return sm;
    }

    public void setSm(StateManager sm) {
        this.sm = sm;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public int getMapCount() {
        return mapCount;
    }

    public void setMapCount(int mapCount) {
        this.mapCount = mapCount;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }
}
