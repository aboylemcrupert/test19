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
	private int winCounter;
	private int loseCounter;
	private int endGameIfOne;
	private int ex;
	private int exx;
	
	public hangManGame(String file){
		input = new EasyReader(file);
		words = new ArrayList<String>();
		words = addWords();
		int rand = (int)(Math.random()*words.size());
		answer = words.get(rand);
		hint = hints.get(rand);
		//System.out.println(hint);
		drawHangManSetup();
		lettersEntered = new ArrayList<String>();
		winCounter = 0;
		loseCounter = 0;
		endGameIfOne = 0;
		ex = 0;
		exx = 0;
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
	
	public void drawHangManSetup(){
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
	
	public void addMistake(String s){
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

	// public Player getWinner(){
		
	// }
	
	// public Player getCurrentPlayer(){
		
	// }
	
	// public ArrayList<String> getCurrentMoves(){
		
	// }
	
	public void makeMove(String s){
		int cc = 0;
		for(int c = 0; c < answer.length(); c++){
			if(s.equals(answer.substring(c,c+1))){
				eachLetter.get(c).draw();
				winCounter++;
				cc++;
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
			Text ans = new Text(300,550,"The word was: "+answer);
			ans.grow(100,20);
			ans.draw();
			endGameIfOne++;
		}
	}
	
	public String toString(){
		return "hi";
	}
}
// abruptly
// abyss
// affix
// askew
// avenue
// awkward
// bagpipes
// bandwagon
// banjo
// beekeeper
// bikini
// blitz
// blizzard
// boggle
// bookworm
// boxcar
// buckaroo
// buffalo
// buffoon
// buzzard
// buzzing
// chartreuse
// cobweb
// cockiness
// croquet
// crypt
// cycle
// dizzying
// duplex
// dwarves
// embezzle
// equip
// espionage
// exodus
// faking
// fishhook
// fixable
// fjord
// flapjack
// flopping
// fluffiness
// foxglove
// frazzled
// frizzled
// fuchsia
// funny
// galaxy
// gazebo
// gizmo
// glowworm
// glyph
// gnarly
// gossip
// grogginess
// haiku
// haphazard
// hyphen
// icebox
// injury
// ivory
// jackpot
// jawbreaker
// jaywalk
// jazziest
// jazzy
// jelly
// jigsaw
// jinx
// jockey
// jogging
// joking
// jovial
// joyful
// juicy
// jukebox
// jumbo
// kayak
// kazoo
// keyhole
// khaki
// kilobyte
// kiosk
// kiwi
// klutz
// knapsack
// larynx
// lengths
// lucky
// luxury
// lymph
// matrix
// microwave
// mystify
// nightclub
// nymph
// oxidize
// oxygen
// pajama
// peekaboo
// phlegm
// pixel
// pizazz
// pneumonia
// polka
// psyche
// puppy
// puzzling
// quartz
// queue
// quiz
// quizzes
// rhubarb
// rhythm
// rickshaw
// schnapps
// scratch
// snazzy
// sphinx
// squawk
// staff
// strength
// stretch
// stronghold
// subway
// swivel
// syndrome
// thriftless
// thumbscrew
// thyme
// topaz
// transcript
// transgress
// transplant
// twelfth
// unknown
// unworthy
// unzip
// uptown
// vaporize
// vodka
// voodoo
// vortex
// walkway
// waltz
// wave
// wavy
// waxy
// wheezy
// whiskey
// whizzing
// whomever
// wimpy
// witchcraft
// wizard
// woozy
// wristwatch
// xylophone
// yachtsman
// yippee
// yoked
// youthful
// yummy
// zephyr
// zigzag
// zigzagging
// zipper
// zodiac
// zombie