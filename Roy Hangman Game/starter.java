import pkg.*;
import java.util.ArrayList;
public class starter implements InputControl, InputKeyControl 
{
		private static Picture beach;
		private static String answer;
		private static ArrayList<Picture> leaves;
        public static void main(String args[])
        {
			MouseController mC = new MouseController(Canvas.getInstance(),new starter());
			KeyController kC = new KeyController(Canvas.getInstance(),new starter());
			beach = new Picture();
			beach.load(/*"C:\\Users\\roy4k\\Desktop\\Car Test\\*/"Pictures\\Beach Background.jpg");
			beach.draw();
			answer = "chartreuse";
			leaves = new ArrayList<Picture>();
			int count = 0;
			int x = 10;
			int y = 450;
			for(int c = 0; c < answer.length(); c++){
				Picture temp = new Picture();
				temp.load("Pictures\\Black Leaf.png");
				temp.grow(-130,-65);
				temp.translate(x,y);
				x = x+50;
				leaves.add(temp);
				leaves.get(c).draw();
				count++;
				System.out.println(count);
			}
			// answer = "chartreuse";
			System.out.println(answer);
		}
		
		public void onMouseClick(double x, double y)
		{			
			
		}
		
		public void keyPress(String s)
		{
			int cc = 0;
			for(int c = 0; c < answer.length(); c++){
				if(s.equals(answer.substring(c,c+1))){
					System.out.println(s+" True");
					break;
				}
				else if(cc == answer.length()-1){
					System.out.println(s+" False");
				}
				cc++;
			}
		}

}
