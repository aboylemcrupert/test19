//works as intended

import pkg.*;
import java.util.ArrayList;
public class hangManGame implements GameState {
		EasyReader input;
		ArrayList<String> words;
		Player player;
		Player ifLoses;
		String winningWord;
		ArrayList<String> completedWord;
		ArrayList<String> possibleMoves;
		int totalBodyParts;
		
	public hangManGame(String file, String name){
		input = new EasyReader(file);
		words = new ArrayList<String>();
		words = addWords();
		drawSetup("Beach Background.jpg");
		player = new Player(name);
		ifLoses = new Player("Computer");
		
		int i = (int)(Math.random()*words.size());
		winningWord = words.get(i);
		completedWord = new ArrayList<String>();
			for(int ii = 0; ii < winningWord.length(); ii++){
				completedWord.add("*");
			}
		possibleMoves = new ArrayList<String>();
		possibleMoves = fillList();
		totalBodyParts = 0;
		//take out after testing
		System.out.println(winningWord);
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
	
	private ArrayList<String> fillList(){
		ArrayList<String> Listy = new ArrayList<String>();
		for(int i = 0; i < winningWord.length(); i++){
			Listy.add(winningWord.substring(i, i+1));
		}
		return Listy;
	}
	
	public boolean isGameOver(){
		boolean over = true;
		for (int i = 0; i < getCurrentMoves().size(); i++){
			if (!getCurrentMoves().get(i).equals("+")){
				over = false; 
			}
		}
		if (totalBodyParts == 9 || over){
			return true;
		}
		return false;
	}

	public Player getWinner(){
		boolean containsThing = false;
		for(int i = 0; i < completedWord.size()-1; i++){
			if(completedWord.get(i).equals("*")){
				containsThing = true;
			}
		}
		System.out.print("The winner is: ");
		if(isGameOver() && !containsThing){
			return player;
		}
		return ifLoses;
	}
	
	public Player getCurrentPlayer(){
		return player;
	}
	
	public ArrayList<String> getCurrentMoves(){
		ArrayList<String> moves = new ArrayList<String>();
		for (int i = 0; i < possibleMoves.size(); i++){
			if(!possibleMoves.get(i).equals("+")){
				moves.add(possibleMoves.get(i));
			}
		}
		return moves;
	}
	
	public void makeMove(String move){
		boolean containsLetter = false;
		for (int i = 0; i < winningWord.length(); i++){	
			if (move.equals(winningWord.substring(i, i+1))){
				completedWord.set(i,move);
				possibleMoves.set(i,"+");
				containsLetter = true;
				System.out.print(completedWord.get(i));
			}
			else {
				System.out.print(completedWord.get(i));
			}
		}
		System.out.println();
		if (!containsLetter){
			totalBodyParts++;
			System.out.println(totalBodyParts);
		}
	}
	
	public String toString(){
		String finish = "";
		for(int i = 0; i < completedWord.size(); i++){
			finish = finish + completedWord.get(i);
		}
		return finish;
	}
}