import pkg.*;
public class GameDriver{
	private GameState state;
	EasyReader input;
	public GameDriver(GameState initial){
		state = initial;
		input = new EasyReader();
	}
	
	public void play(){
		while (!state.isGameOver()){
			System.out.println("Guess a letter:");
			String letter = input.readWord();
			if(letter.length()==1){
				state.makeMove(letter);
			}
			else{
				System.out.println("Please guess only a single letter");
			}
			// System.out.println(state);
		}
		System.out.println(state.getWinner().getName());
	}
}