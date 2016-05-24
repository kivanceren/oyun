package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.imageloader.ImageLoader;
import com.mygdx.states.MenuState;
import com.mygdx.states.StateManager;


public class MyGdxGame extends Game {

	private SpriteBatch sb;
	private static StateManager sm;
	private Music music;
	private MenuState menuState;

	public void create() {


		Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1);
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		ImageLoader.load();



		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();



		sb = new SpriteBatch();
		sm = new StateManager();
		menuState = new MenuState(sm);
		sm.pushState(menuState);

	}


	public void render() {

		System.out.println(menuState.getMenuStateInput().isMusicState());
		if (menuState.getMenuStateInput().isMusicState()) {
			if (music.isLooping())
				music.play();
		}
		else
			music.pause();


		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sm.render(sb);
		sm.update(Gdx.graphics.getDeltaTime());

	}


	public void dispose() {


		ImageLoader.dispose();

		music.dispose();

	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
}
