import pkg.*;
public class starter {
        public static void main(String args[])
        {
			EasyReader console = new EasyReader();
			System.out.println("Enter your name: ");
			String name = console.readLine();
			GameState playThing = new hangManGame("hangman list.txt", name);
			GameDriver maket = new GameDriver(playThing);
			maket.play();
		}
}
