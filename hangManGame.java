//works as intended

import pkg.*;
import java.util.ArrayList;
public class hangManGame implements GameState {
	EasyReader input;
	ArrayList<String> words;
	public hangManGame(String file){
		input = new EasyReader(file);
		words = new ArrayList<String>();
		words = addWords();
		drawSetup("Beach Background.jpg");
	}
	
	private ArrayList<String> addWords(){
		ArrayList<String> newlist = new ArrayList<String>();
		while(!input.eof()){
			newlist.add(input.readWord());
		}
		return newlist;
	}
	
	private void drawSetup(String file){
		Picture backGround = new Picture(file);
		backGround.draw();
		int x = 275;
		int y = 250;
			Rectangle holder = new Rectangle(x,y,10,60);
				holder.fill();
			Rectangle sideHolder = new Rectangle(x,y,90,10);
				sideHolder.fill();
			Rectangle down = new Rectangle(x+80,y+10,10,210);
				down.fill();
			Rectangle base = new Rectangle(x+40,y+210,80,10);
				base.fill();
	}
	
	public boolean isGameOver(){
		
	}

	public Player getWinner(){
		
	}
	
	public Player getCurrentPlayer(){
		
	}
	
	public ArrayList<String> getCurrentMoves(){
		
	}
	
	public void makeMove(String move){
		
	}
	
	public String toString(){
		
	}
}