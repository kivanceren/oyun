package com.mygdx.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by melih on 03.05.2016.
 */
public class StateManager  {

    private Stack<State> states;


    public StateManager()
    {
        states = new Stack<State>();

    }

    public void render(SpriteBatch sb)
    {
        states.peek().render(sb);
    }

    public void update(float delta)
    {
        states.peek().update(delta);
        states.peek().handleInput();
    }

    public void pushState(State state)
    {
        states.push(state);
    }
    public void popState()
    {
        states.pop();
    }
}
