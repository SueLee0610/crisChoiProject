package controller;

public interface GameStateListener {
	void onCharacterSelectionPerformed(String characterClass);
	void onLevelFinished();
	void onGameOver();
	
}
