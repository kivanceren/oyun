package com.mygdx.inputhandler;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.gameobject.BalonNesnesi;
import com.mygdx.states.MenuState;
import com.mygdx.states.PlayState;

/**
 * Created by melih on 14.05.2016.
 */
public class PlayStateInput implements InputProcessor {

    private PlayState playState;
    private BalonNesnesi bn;
    public PlayStateInput(PlayState playState)
    {
        this.playState = playState;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        System.out.println("xKord -- >"+screenX +"yKord -->"+screenY );


        for (int i=0;i<playState.getGameWorld().getBalonlarim().size();i++){
            bn = playState.getGameWorld().getBalonlarim().get(i);
            int x = bn.getxKord();
            int y = bn.getyKord();
            int w = bn.getWidth();
            int h = bn.getHeight();

            System.out.println("xKord -- >"+x +"yKord -->"+y );



            if (screenX < (x +w) && screenX > x)
            {
                if (screenY < (y+h) && screenY > y)

                    playState.getGameWorld().destroyBalon(i,1,x,y);

            }
        }





        if (playState.getBackButton().getBtnRect().contains(screenX,screenY))
        {
            playState.getSm().popState();
            playState.getSm().pushState(new MenuState(playState.getSm()));
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
