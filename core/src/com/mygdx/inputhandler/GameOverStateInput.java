package com.mygdx.inputhandler;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.imageloader.ImageLoader;
import com.mygdx.states.GameOverState;
import com.mygdx.states.MenuState;
import com.mygdx.states.PlayState;

/**
 * Created by melih on 18.05.2016.
 */
public class GameOverStateInput implements InputProcessor {

    private GameOverState gameOverState;
    private TextureRegion image;

    public GameOverStateInput(GameOverState gameOverState)
    {
        this.gameOverState = gameOverState;

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

        if (gameOverState.getNewLevel().getBtnRect().contains(screenX,screenY)){
            if (!gameOverState.isOver()) {
                int mapCount = gameOverState.getMapCount();

                switch (mapCount) {
                    case 2:
                        image = ImageLoader.map2;
                        break;
                    case 3:
                        image = ImageLoader.map3;
                        break;

                }

                gameOverState.getSm().popState();
                gameOverState.getSm().pushState(new PlayState(gameOverState.getSm(), image, mapCount));

            }
        }
        if (gameOverState.getBackButton().getBtnRect().contains(screenX,screenY))
        {
            gameOverState.getSm().pushState(new MenuState(gameOverState.getSm()));
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
