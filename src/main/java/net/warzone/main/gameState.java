package net.warzone.main;

public enum gameState {
	LOBBY,INGAME,ENDGAME;
	
	private static gameState currentState;

	public static gameState getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(gameState currentState) {
		gameState.currentState = currentState;
	}

}
