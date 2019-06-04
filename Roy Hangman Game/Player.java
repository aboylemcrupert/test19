import pkg.*;
import java.util.ArrayList;

public class Player{
	
	private String name;
	
	public Player(String aName){
		name = aName;
	}
	
	public String getName(){
		return name;
	}
	
	// public int getNextMove(GameState state){
		// ArrayList<Integer> moves = state.getCurrentMoves();
		// if(moves.isEmpty()){
		  // return -1;
		// }
		// else{
		  // return moves.get((int)(Math.random()*moves.size()));
		// }
	// }

}
