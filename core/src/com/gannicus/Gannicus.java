package com.gannicus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gannicus extends Game {
        private GameState currentState;
    
	@Override
	public void create () {
            AssetsManager.loadAssets();
            setScreen(new StartScreen());    
            GameState currentState = GameManager.getInstance().getGameState();

	}
        @Override
	public void render () {
            GameState nextState = GameManager.getInstance().getGameState();
            
            if(currentState != nextState){ 
                System.out.println(nextState);
                switch (nextState){
                    case START:
                        setScreen(new StartScreen());
                        break;
                    case RUNNING:
                        setScreen(new GameScreen());
                        break;
                    case OVER:
                        setScreen(new OverScreen());
                        break;
                    case ABOUT:
                        setScreen(new AboutScreen());
                        break;

                }
                currentState = nextState;
            }
            if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
        }
	@Override
	public void dispose () {
            super.dispose();
            AssetsManager.dispose();
	}
}
