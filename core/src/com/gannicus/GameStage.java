package com.gannicus;

/**
 *
 * @author roasstbeef (alex.s)
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class GameStage extends Stage implements ContactListener{
    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    
    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;
    private OrthographicCamera camera;
    //private World world;
    
    private float totalTimePassed;
    
    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, 
                VIEWPORT_HEIGHT,
        new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        setUpCamera();
        Gdx.input.setInputProcessor(this);
    }
    private void setUpWorld() {
        //world = null; //a box2d thing
        //world.setContactListener(this);
    }   
    private void setUpCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, 
                camera.viewportHeight / 2, 0f);
        camera.update();
    }
    
    @Override
    public void act(float delta) {
        super.act(delta);

        if (GameManager.getInstance().getGameState() == GameState.PAUSED) 
            return;

        if (GameManager.getInstance().getGameState() == GameState.RUNNING) {
            totalTimePassed += delta;
        }

        // Fixed timestep
        accumulator += delta;

        while (accumulator >= delta) {
            //world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }


    }
    private GameState getGameState(){
        return GameManager.getInstance().getGameState();
    }
    private void onGamePaused() {
        GameManager.getInstance().setGameState(GameState.PAUSED);
    }

    private void onGameResumed() {
        GameManager.getInstance().setGameState(GameState.RUNNING);
    }

    private void onGameOver() {
        GameManager.getInstance().setGameState(GameState.OVER);
    }

    @Override
    public boolean keyUp (int keyCode) {   
        
        //toggle pausing
        if(keyCode == Input.Keys.P){
            if( getGameState() == GameState.PAUSED){
                onGameResumed();
            }else{
                onGamePaused();
            }            
        }
        
        //esc to main menu
        if(keyCode == Input.Keys.ESCAPE){
            GameManager.getInstance().setGameState(GameState.START);
        }
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
