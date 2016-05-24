package com.mygdx.inputhandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.imageloader.ImageLoader;
import com.mygdx.states.MenuState;
import com.mygdx.states.PlayState;

/**
 * Created by melih on 15.05.2016.
 */
public class MenuStateInput implements InputProcessor {

    private MenuState menuState;
    public static boolean musicState;


    public MenuStateInput(MenuState menuState)
    {
        this.menuState = menuState;
        musicState = true;
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

        if (menuState.getPlayButton().getBtnRect().contains(screenX,screenY)){
            menuState.getStateManager().popState();
            menuState.getStateManager().pushState(new PlayState(menuState.getStateManager(), ImageLoader.gameBgRegion,1));
        }
        if (menuState.getAboutButton().getBtnRect().contains(screenX,screenY)){
            menuState.getStateManager().popState();
            menuState.getStateManager().pushState(new Hakkinda(menuState.getStateManager()));
        }
        if (menuState.getExitButton().getBtnRect().contains(screenX,screenY)){
            Gdx.app.exit();
        }
        if (menuState.getSoundOnButton().getBtnRect().contains(screenX,screenY)){
            System.out.println("Music acıldı");
            musicState = true;
        }
        if (menuState.getSoundOffButton().getBtnRect().contains(screenX,screenY)){
            System.out.println("Music kapatıldı");
            musicState = false;
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

    public boolean isMusicState() {
        return musicState;
    }

    public void setMusicState(boolean musicState) {
        this.musicState = musicState;
    }
}
