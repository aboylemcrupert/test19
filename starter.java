import pkg.*;
import java.util.ArrayList;
public class starter implements InputKeyControl 
{
	private static GameDriver game;
	
	public static void main(String args[])
	{
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		GameState g = new hangManGame("hangman list.txt", "Student");
		game = new GameDriver(g);
	}
	
	public void keyPress(String s)
	{
		game.isKeyPress(s);
	}
}

	// private static Picture beach;
	// private static String answer;
	// private static ArrayList<Picture> monkeyLives;
	// private static ArrayList<Picture> leaves;
	// private static ArrayList<Text> eachLetter;
	// private static ArrayList<String> lettersEntered;
	// private static int winCounter;
	// private static int loseCounter;
	// private static int gameOverIfOne;
	// private static int ex;
	// private static int exx;
	
	// public static void main(String args[])
	// {
		// KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		
		// EasyReader read = new EasyReader("hangman list.txt");
		// ArrayList<String> words = new ArrayList<String>();
		// while(!read.eof()){
			// words.add(read.readWord());
		// }
		// int rand = (int)(Math.random()*words.size());
		// answer = words.get(rand);
		// System.out.println(answer);
		
		// beach = new Picture();
		// beach.load("Pictures\\Beach Background.jpg");
		// beach.draw();
		
		// int x = 170;
		// int y = 485;
		// eachLetter = new ArrayList<Text>();
		// for(int c = 0; c < answer.length(); c++){
			// Text t = new Text(x,y,answer.substring(c,c+1));
			// x = x+50;
			// eachLetter.add(t);
			// eachLetter.get(c).grow(10,20);
		// }
		
		// Text lives = new Text(30,18,"LIVES:");
		// lives.grow(25,25);
		// lives.draw();
		
		// x = 85;
		// y = 5;
		// monkeyLives = new ArrayList<Picture>();
		// for(int c = 0; c < 9; c++){
			// Picture t = new Picture();
			// t.load("Pictures\\monkey.png");
			// t.translate(x,y);
			// x = x+50;
			// monkeyLives.add(t);
			// monkeyLives.get(c).draw();
		// }
		
		// Text list = new Text(30,80,"WRONG LETTERS:");
		// list.grow(25,15);
		// list.draw();
		
		// x = 20;
		// y = 460;
		// leaves = new ArrayList<Picture>();
		// for(int c = 0; c < answer.length(); c++){
			// Picture temp = new Picture();
			// temp.load("Pictures\\Black Leaf.png");
			// temp.grow(-130,-65);
			// temp.translate(x,y);
			// x = x+50;
			// leaves.add(temp);
			// leaves.get(c).draw();
		// }
		
		// Picture noose = new Picture();
		// noose.load("Pictures\\noose.png");
		// noose.draw();
		
		// lettersEntered = new ArrayList<String>();
		// winCounter = 0;
		// loseCounter = 0;
		// gameOverIfOne = 0;
		// ex = 0;
		// exx = 0;
	// }
	
	// public void keyPress(String s)
	// {
		// s = s.toLowerCase();
		// if(gameOverIfOne == 0){
			// int i = 0;
			// for(int c = 0; c < lettersEntered.size(); c++){
				// if(lettersEntered.get(c).equals(s)){
					// i++;
				// }
			// }
			// lettersEntered.add(s);
			// if(i == 0){
				// int cc = 0;
				// for(int c = 0; c < answer.length(); c++){
					// if(s.equals(answer.substring(c,c+1))){
						// System.out.println(s+" True");
						// eachLetter.get(c).draw();
						// winCounter++;
						// cc++;
					// }
				// }
				// if(cc == 0){
					// loseCounter++;
					// System.out.println("Mistakes: "+loseCounter);
					// Picture pic = new Picture();
					// pic.load("Pictures\\"+loseCounter+".png");
					// pic.draw();
					// Picture pic2 = new Picture();
					// pic2.load("Pictures\\x.png");
					// pic2.translate(485-ex,5);
					// ex = ex+50;
					// pic2.draw();
					// Text wrongLetter = new Text(130+exx,73,s);
					// wrongLetter.grow(5,10);
					// exx = exx+20;
					// wrongLetter.draw();
				// }
				// if(winCounter == answer.length()){
					// System.out.println("You Win!");
					// Text win = new Text(350,250,"YOU WIN!");
					// win.draw();
					// win.setColor(Color.GREEN);
					// win.grow(250,100);
					// gameOverIfOne++;
				// }
				// else if(loseCounter == 9){
					// System.out.println("You Lose!");
					// Text lose = new Text(350,250,"YOU LOSE!");
					// lose.draw();
					// lose.setColor(Color.RED);
					// lose.grow(250,100);
					// Text ans = new Text(300,550,"The word was: "+answer);
					// ans.grow(100,20);
					// ans.draw();
					// gameOverIfOne++;
				// }
			// }
		// }
	// }
// }
