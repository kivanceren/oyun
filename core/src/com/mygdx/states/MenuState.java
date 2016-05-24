package com.mygdx.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.buttons.Button;
import com.mygdx.imageloader.ImageLoader;
import com.mygdx.inputhandler.MenuStateInput;

/**
 * Created by melih on 03.05.2016.
 */
public class MenuState extends State {

    private StateManager sm;
    private Button playButton,aboutButton,soundOnButton,soundOffButton,exitButton;
    private float playButtonWidht,playButtonHeight,smallButtonWidht,smallButtonHeight;
    private MenuStateInput menuStateInput;

    public MenuState(StateManager sm) {
        super(sm);
        this.sm = sm;
        playButtonWidht = (Gdx.graphics.getWidth()*2)/3;
        playButtonHeight = (int)(playButtonWidht*0.3);

        smallButtonWidht = Gdx.graphics.getWidth()/6;
        smallButtonHeight = Gdx.graphics.getWidth()/6;

        menuStateInput = new MenuStateInput(this);

        Gdx.input.setInputProcessor(menuStateInput);
        exitButton = new Button(Gdx.graphics.getWidth()-smallButtonWidht,0,ImageLoader.exitRegion,smallButtonWidht,smallButtonHeight);
        playButton = new Button(Gdx.graphics.getWidth()/6,(Gdx.graphics.getHeight()*1/3),ImageLoader.yeniOyunRegion,playButtonWidht,playButtonHeight);
        aboutButton = new Button(Gdx.graphics.getWidth()/6,(Gdx.graphics.getHeight()*2/3),ImageLoader.hakkindaRegion,playButtonWidht,playButtonHeight);
        soundOnButton = new Button(0,0,ImageLoader.soundOnRegion,smallButtonWidht,smallButtonHeight);
        soundOffButton = new Button(smallButtonWidht+10,0,ImageLoader.soundOffRegion,smallButtonWidht,smallButtonHeight);

    }

    @Override
    public void render(SpriteBatch sb) {

    //butonlar cizdirilecek

     sb.setProjectionMatrix(camera.combined);
     sb.begin();
     sb.draw(ImageLoader.bgRegion,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


     sb.end();
        playButton.render(sb);
        aboutButton.render(sb);
        soundOnButton.render(sb);
        soundOffButton.render(sb);
        exitButton.render(sb);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void handleInput() {

    }
    public StateManager getStateManager()
    {
        return sm;
    }


    public Button getPlayButton() {
        return playButton;
    }

    public void setPlayButton(Button playButton) {
        this.playButton = playButton;
    }

    public Button getAboutButton() {
        return aboutButton;
    }

    public void setAboutButton(Button aboutButton) {
        this.aboutButton = aboutButton;
    }

    public float getPlayButtonWidht() {
        return playButtonWidht;
    }

    public void setPlayButtonWidht(float playButtonWidht) {
        this.playButtonWidht = playButtonWidht;
    }

    public float getPlayButtonHeight() {
        return playButtonHeight;
    }

    public void setPlayButtonHeight(float playButtonHeight) {
        this.playButtonHeight = playButtonHeight;
    }

    public float getSmallButtonWidht() {
        return smallButtonWidht;
    }

    public void setSmallButtonWidht(float smallButtonWidht) {
        this.smallButtonWidht = smallButtonWidht;
    }

    public float getSmallButtonHeight() {
        return smallButtonHeight;
    }

    public void setSmallButtonHeight(float smallButtonHeight) {
        this.smallButtonHeight = smallButtonHeight;
    }

    public Button getSoundOnButton() {
        return soundOnButton;
    }

    public void setSoundOnButton(Button soundOnButton) {
        this.soundOnButton = soundOnButton;
    }

    public Button getSoundOffButton() {
        return soundOffButton;
    }

    public void setSoundOffButton(Button soundOffButton) {
        this.soundOffButton = soundOffButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public void setExitButton(Button exitButton) {
        this.exitButton = exitButton;
    }

    public MenuStateInput getMenuStateInput() {
        return menuStateInput;
    }

    public void setMenuStateInput(MenuStateInput menuStateInput) {
        this.menuStateInput = menuStateInput;
    }
}
