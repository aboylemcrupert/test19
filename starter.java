import pkg.*;
import java.util.ArrayList;
public class starter implements InputKeyControl 
{
	private static GameDriver game;
	
	public static void main(String args[])
	{
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		GameState g = new hangManGame("hangman list.txt", "You");
		game = new GameDriver(g);
	}
	
	public void keyPress(String s)
	{
		game.isKeyPress(s);
	}
}