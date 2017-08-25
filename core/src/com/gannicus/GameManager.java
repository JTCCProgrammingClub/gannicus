package com.gannicus;

/**
 *
 * @author al
 */
public class GameManager  {
    private static GameManager runningInstance = new GameManager();
    private GameState gameState;
    
    public static GameManager getInstance(){
        return runningInstance;
    }
    private GameManager() {
        gameState = GameState.START;
    }

    
    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void submitScore(int score) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void displayLeaderboard() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void displayAchievements() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void unlockAchievement(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
