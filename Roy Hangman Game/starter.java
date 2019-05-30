import pkg.*;
import java.util.ArrayList;
public class starter implements InputControl, InputKeyControl 
{
		private static Picture beach;
		private static String answer;
		private static ArrayList<Picture> leaves;
		private static ArrayList<Text> eachLetter;
		private static ArrayList<String> lettersEntered;
		private static int winCounter;
		private static int loseCounter;
		private static int gameOverIfOne;
        public static void main(String args[])
        {
			MouseController mC = new MouseController(Canvas.getInstance(),new starter());
			KeyController kC = new KeyController(Canvas.getInstance(),new starter());
			beach = new Picture();
			beach.load(/*"C:\\Users\\roy4k\\Desktop\\Car Test\\*/"Pictures\\Beach Background.jpg");
			beach.draw();
			answer = "chartreuse";
			int x = 160;
			int y = 475;
			eachLetter = new ArrayList<Text>();
			for(int c = 0; c < answer.length(); c++){
				Text t = new Text(x,y,answer.substring(c,c+1));
				x = x+50;
				eachLetter.add(t);
				// eachLetter.get(c).draw();
				eachLetter.get(c).grow(10,20);
				// System.out.println(eachLetter.get(c));
			}
			leaves = new ArrayList<Picture>();
			// int count = 0;
			x = 10;
			y = 450;
			// int y = 450;
			for(int c = 0; c < answer.length(); c++){
				Picture temp = new Picture();
				temp.load("Pictures\\Black Leaf.png");
				temp.grow(-130,-65);
				temp.translate(x,y);
				x = x+50;
				leaves.add(temp);
				leaves.get(c).draw();
				// count++;
				// System.out.println(count);
			}
			// answer = "chartreuse";
			// System.out.println(answer);
			lettersEntered = new ArrayList<String>();
			winCounter = 0;
			loseCounter = 0;
			gameOverIfOne = 0;
		}
		
		public void onMouseClick(double x, double y)
		{			
			
		}
		
		public void keyPress(String s)
		{
			if(gameOverIfOne == 0){
				int i = 0;
				for(int c = 0; c < lettersEntered.size(); c++){
					if(lettersEntered.get(c).equals(s)){
						i++;
					}
				}
				lettersEntered.add(s);
				if(i == 0){
					int cc = 0;
					for(int c = 0; c < answer.length(); c++){
						if(s.equals(answer.substring(c,c+1))){
							System.out.println(s+" True");
							eachLetter.get(c).draw();
							winCounter++;
							cc++;
						}
					}
					if(cc == 0){
						loseCounter++;
						System.out.println("Mistakes: "+loseCounter);
					}
					if(winCounter == answer.length()){
						System.out.println("You Win!");
						Text win = new Text(350,250,"YOU WIN!");
						win.draw();
						win.grow(250,100);
						gameOverIfOne++;
					}
					else if(loseCounter == 9){
						System.out.println("You Lose!");
						Text win = new Text(350,250,"YOU LOSE!");
						win.draw();
						win.grow(250,100);
						gameOverIfOne++;
					}
				}
			}
		}

}
