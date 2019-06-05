import pkg.*;
import java.util.ArrayList;
public class hangManGame implements GameState{
	
	private EasyReader input;
	private ArrayList<String> words;
	private ArrayList<String> hints;
	private String answer;
	private String hint;
	private ArrayList<Picture> monkeyLives;
	private ArrayList<Picture> leaves;
	private ArrayList<Text> eachLetter;
	private ArrayList<String> lettersEntered;
	private ArrayList<String> letters;
	private int winCounter;
	private int loseCounter;
	private int endGameIfOne;
	private int ex;
	private int exx;
	private ArrayList<String> completedWord;
	private ArrayList<String> possibleMoves;
	private Player player;
	private Player ifLoses;
	private String Name;
	
	public hangManGame(String file, String name){
		input = new EasyReader(file);
		words = new ArrayList<String>();
		words = addWords();
		int rand = (int)(Math.random()*words.size());
		answer = words.get(rand);
		hint = hints.get(rand);
		System.out.println(hint);
		drawHangManSetup();
		lettersEntered = new ArrayList<String>();
		winCounter = 0;
		loseCounter = 0;
		endGameIfOne = 0;
		ex = 0;
		exx = 0;
		Name = name;
		player = new Player(name);
		ifLoses = new Player("Computer");
		completedWord = new ArrayList<String>();
		completedWord = new ArrayList<String>();
			for(int ii = 0; ii < answer.length(); ii++){
				completedWord.add("*");
			}
			
		possibleMoves = new ArrayList<String>();
		possibleMoves = fillList();
		
		letters = new ArrayList<String>();
		for(int c = 0; c < 26; c++){
			if(c == 0){
				letters.add("a");
			}
			if(c == 0){
				letters.add("b");
			}
			if(c == 0){
				letters.add("c");
			}
			if(c == 0){
				letters.add("d");
			}
			if(c == 0){
				letters.add("e");
			}
			if(c == 0){
				letters.add("f");
			}
			if(c == 0){
				letters.add("g");
			}
			if(c == 0){
				letters.add("h");
			}
			if(c == 0){
				letters.add("i");
			}
			if(c == 0){
				letters.add("j");
			}
			if(c == 0){
				letters.add("k");
			}
			if(c == 0){
				letters.add("l");
			}
			if(c == 0){
				letters.add("m");
			}
			if(c == 0){
				letters.add("n");
			}
			if(c == 0){
				letters.add("o");
			}
			if(c == 0){
				letters.add("p");
			}
			if(c == 0){
				letters.add("q");
			}
			if(c == 0){
				letters.add("r");
			}
			if(c == 0){
				letters.add("s");
			}
			if(c == 0){
				letters.add("t");
			}
			if(c == 0){
				letters.add("u");
			}
			if(c == 0){
				letters.add("v");
			}
			if(c == 0){
				letters.add("w");
			}
			if(c == 0){
				letters.add("x");
			}
			if(c == 0){
				letters.add("y");
			}
			if(c == 0){
				letters.add("z");
			}
		}
	}
	
	private ArrayList<String> fillList(){
		ArrayList<String> Listy = new ArrayList<String>();
		for(int i = 0; i < answer.length(); i++){
			Listy.add(answer.substring(i, i+1));
		}
		return Listy;
	}
	
	private ArrayList<String> addWords(){
		ArrayList<String> newList = new ArrayList<String>();
		hints = new ArrayList<String>();
		while(!input.eof()){
			String temp = input.readLine();
			for(int c = 0; c < temp.length(); c++){
				if(temp.substring(c,c+1).equals("/")){
					newList.add(temp.substring(0,c));
					hints.add(temp.substring(c+1,temp.length()));
				}
			}
		}
		return newList;
	}
		
		private void drawHangManSetup(){
		Picture beach = new Picture();
		beach.load("Pictures\\Beach Background.jpg");
		beach.draw();
		
		int x = 170;
		int y = 485;
		eachLetter = new ArrayList<Text>();
		for(int c = 0; c < answer.length(); c++){
			Text t = new Text(x,y,answer.substring(c,c+1));
			x = x+50;
			eachLetter.add(t);
			eachLetter.get(c).grow(10,20);
		}
		
		Text lives = new Text(30,18,"LIVES:");
		lives.grow(25,25);
		lives.draw();
		
		x = 85;
		y = 5;
		monkeyLives = new ArrayList<Picture>();
		for(int c = 0; c < 9; c++){
			Picture t = new Picture();
			t.load("Pictures\\monkey.png");
			t.translate(x,y);
			x = x+50;
			monkeyLives.add(t);
			monkeyLives.get(c).draw();
		}
		
		Text list = new Text(30,80,"WRONG LETTERS:");
		list.grow(25,15);
		list.draw();
		
		x = 20;
		y = 460;
		leaves = new ArrayList<Picture>();
		for(int c = 0; c < answer.length(); c++){
			Picture temp = new Picture();
			temp.load("Pictures\\Black Leaf.png");
			temp.grow(-130,-65);
			temp.translate(x,y);
			x = x+50;
			leaves.add(temp);
			leaves.get(c).draw();
		}
		
		Picture noose = new Picture();
		noose.load("Pictures\\noose.png");
		noose.draw();
	}
	
	private void addMistake(String s){
		loseCounter++;
		Picture pic = new Picture();
		pic.load("Pictures\\"+loseCounter+".png");
		pic.draw();
		Picture pic2 = new Picture();
		pic2.load("Pictures\\x.png");
		pic2.translate(485-ex,5);
		ex = ex+50;
		pic2.draw();
		Text wrongLetter = new Text(130+exx,73,s);
		wrongLetter.grow(5,10);
		exx = exx+20;
		wrongLetter.draw();
	}
	
	public boolean newLetterEntered(String s){
		int i = 0;
		for(int c = 0; c < lettersEntered.size(); c++){
			if(lettersEntered.get(c).equals(s)){
				i++;
			}
		}
		lettersEntered.add(s);
		if(i == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isGameOver(){
		if(endGameIfOne > 0){
			return true;
		}
		else{
			return false;
		}
	}

	public Player getWinner(){
		boolean containsThing = false;
		for(int i = 0; i < completedWord.size()-1; i++){
			if(completedWord.get(i).equals("*")){
				containsThing = true;
			}
		}
		if(isGameOver() && !containsThing){
			return player;
		}
		return ifLoses;		
	}
	
	public Player getCurrentPlayer(){
		if(endGameIfOne == 0){
			return player;
		}
		else{
			return ifLoses;
		}
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
	
	public void makeMove(String s){
		int cc = 0;
		for(int c = 0; c < answer.length(); c++){
			if(s.equals(answer.substring(c,c+1))){
				eachLetter.get(c).draw();
				winCounter++;
				cc++;
				possibleMoves.set(c, "+");
				completedWord.set(c, s);
			}
		}
		if(cc == 0){
			addMistake(s);
		}
		if(loseCounter == 6){
			Text h = new Text(240,395,"Hint: "+hint);
			h.grow(50,10);
			h.draw();
		}
		if(winCounter == answer.length()){
			Text win = new Text(350,250,"YOU WIN!");
			win.draw();
			win.setColor(Color.GREEN);
			win.grow(250,100);
			endGameIfOne++;
		}
		else if(loseCounter == 9){
			Text lose = new Text(350,250,"YOU LOSE!");
			lose.draw();
			lose.setColor(Color.RED);
			lose.grow(250,100);
			Text ans = new Text(300,550,"The word was: " + answer);
			ans.grow(100,20);
			ans.draw();
			endGameIfOne++;
		}
	}
	
	public boolean trueIfLetter(String s){
		int i = 0;
		for(int c = 0; c < letters.size(); c++){
			if(s.equals(letters.get(c))){
				i++;
			}
		}
		if(i > 0){
			return true;
		}
		else{
			return false;
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
