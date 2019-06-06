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
			return name;
	}
	
	public String getNextMove(GameState larry){
		return larry.getCurrentMoves().get(0);
	}
	
	public String toString(){
		return name;
	}
}
