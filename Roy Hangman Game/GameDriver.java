import pkg.*;

public class GameDriver{
	
	private GameState state;
	
	public GameDriver(GameState initial){
		state = initial;
	}
	
	// private int count;
	
	// public void play(){
		
	// }
	
	public void isKeyPress(String s){
		s = s.toLowerCase();
		if(!state.isGameOver()){
			if(state.newLetterEntered(s)){
				state.makeMove(s);
			}
		}
	}
	
	// public int getMoves(){
		// return count;
	// }
}
