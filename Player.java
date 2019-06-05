import pkg.*;
import java.util.ArrayList;

public class Player{
	
	private String name;
	
	public Player(String aName){
		name = aName;
	}
	
	public String getName(){			
			Text winnerIs = new Text(540,360, "The winner is: "+name);
			winnerIs.setColor(Color.BLUE);
			winnerIs.grow(80,30);
			winnerIs.draw();
			
			// Text winner = new Text(540,400,name);
			// winner.grow(20,20);
			// winner.draw();
			return name;
	}
	
	public String getNextMove(GameState larry){
		return larry.getCurrentMoves().get(0);
	}
	
	public String toString(){
		return name;
	}
}
