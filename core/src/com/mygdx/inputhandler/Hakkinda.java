package com.mygdx.inputhandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.buttons.Button;
import com.mygdx.imageloader.ImageLoader;
import com.mygdx.states.State;
import com.mygdx.states.StateManager;

/**
 * Created by melih on 15.05.2016.
 */
public class Hakkinda extends State {

    private Button backButton;
    private StateManager sm;
    public Hakkinda(StateManager sm) {
        super(sm);
        backButton = new Button();
        this.sm = sm;
        Gdx.input.setInputProcessor(new HakkindaInput(this));
    }

    @Override
    public void render(SpriteBatch sb) {
        System.out.println("Hakkinda kismi");
        sb.begin();

        ImageLoader.font.draw(sb,"120202075 -MELIH KAPTAN",10,Gdx.graphics.getHeight()/10,Gdx.graphics.getWidth(),Gdx.graphics.getWidth(),true);
        ImageLoader.font.draw(sb,"120202088 -GORKEM ARIFOGLU",10,Gdx.graphics.getHeight()/10*3,Gdx.graphics.getWidth(),Gdx.graphics.getWidth(),true);
        ImageLoader.font.draw(sb,"120202102 -SENER KUCUKNANE",10,Gdx.graphics.getHeight()/10*5,Gdx.graphics.getWidth(),Gdx.graphics.getWidth(),true);
        ImageLoader.font.draw(sb,"130202056 -MERTCAN YILMAZ",10,Gdx.graphics.getHeight()/10*7,Gdx.graphics.getWidth(),Gdx.graphics.getWidth(),true);



        sb.end();

        backButton.render(sb);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void handleInput() {

    }

    public StateManager getSm() {
        return sm;
    }

    public void setSm(StateManager sm) {
        this.sm = sm;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }
}
