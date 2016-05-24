package com.mygdx.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.buttons.Button;
import com.mygdx.gameobject.GameWorld;
import com.mygdx.inputhandler.PlayStateInput;

/**
 * Created by melih on 03.05.2016.
 */
public class PlayState extends State {

    private GameWorld gw;
    private Button backButton;
    private StateManager sm;
    float delay;
    boolean isWon;
    TextureRegion image;
    private int mapCount;
    private int puan;
    Timer timer;

    public PlayState(StateManager sm,TextureRegion image,int mapCount)
    {

         super(sm);
         this.puan = puan;
         this.mapCount = mapCount;
         this.image = image;
         isWon=false;
         this.sm = sm;
         timer = new Timer();

         switch (mapCount)
         {
             case 1 : gw = new GameWorld(5,100);break;
             case 2 : gw = new GameWorld(7,150);break;
             case 3 : gw = new GameWorld(9,200);break;

         }

         delay=30;
         backButton = new Button();

         Gdx.input.setInputProcessor(new PlayStateInput(this));

        timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                timer_tick();
            }
        },delay);
        timer.stop();

    }

    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined); //SpriteBatch kameraya göre çizilecek.

        sb.begin();

        sb.draw(image,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.end();

        gw.render(sb);
        backButton.render(sb);
    }

    public void timer_tick()
    {
        if (gw.getPuan() >= 100 )
        {
            if (gw.isB1() == true && gw.isB2() == true && gw.isB3() == true && gw.isB4() == true )
                isWon=true;
        }

        timer.stop();
        //puan+=gw.getPuan();
        sm.popState();
        sm.pushState(new GameOverState(sm,isWon,mapCount,gw.getPuan()));
    }


    public void update(float delta) {
    //    System.out.println("Play state guncelleniyor");

        gw.update(delta);

    }

    @Override
    public void handleInput() {

    }


    public GameWorld getGameWorld()
    {
        return gw;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
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
}
