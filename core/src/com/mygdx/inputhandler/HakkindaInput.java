package com.mygdx.inputhandler;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.states.MenuState;

/**
 * Created by melih on 15.05.2016.
 */
public class HakkindaInput implements InputProcessor {

    Hakkinda hakkinda;
    public HakkindaInput(Hakkinda hakkinda)
    {
        this.hakkinda = hakkinda;
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

        if (hakkinda.getBackButton().getBtnRect().contains(screenX,screenY))
            hakkinda.getSm().pushState(new MenuState(hakkinda.getSm()));
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
