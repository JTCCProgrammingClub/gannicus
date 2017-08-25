package com.gannicus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 *
 * @author roasstbeef (alex.s)
 */
public class StartStage extends Stage implements ContactListener{
    private Texture texture;

    public StartStage(){
        Gdx.input.setInputProcessor(this);
        texture = new Texture(Gdx.files.internal("main.png"));
        Image menuDisplay = new Image(texture);    
        addActor(menuDisplay);
    }

    @Override
    public boolean keyUp (int keyCode) {   
        
        GameManager.getInstance().setGameState(GameState.RUNNING);
        return super.keyUp(keyCode);
       
    }
        
    @Override
    public void beginContact(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void endContact(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
