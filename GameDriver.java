import pkg.*;

public class GameDriver{
	
	private GameState state;
	
	public GameDriver(GameState initial){
		state = initial;
	}
	
	public void isKeyPress(String s){
		s = s.toLowerCase();
		if(state.trueIfLetter(s)){
			if(!state.isGameOver()){
				if(state.newLetterEntered(s)){
					state.makeMove(s);
				}
				if(state.getCurrentMoves().size() == 0){
					state.getWinner().getName();
				}
				if(state.getCurrentPlayer().toString().equals("Computer")){
					state.getWinner().getName();
				}
			}
		}
	}
}
