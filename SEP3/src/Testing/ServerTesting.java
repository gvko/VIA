package Testing;

import JokesServer.Model.JokesServer;
import MainServer.Model.MainServer;
import MusicServer.Model.MusicServer;
import ScrabbleServer.Model.ScrabbleServer;

public class ServerTesting
{
	public static void main(String[] args)
	{
		try
		{
			MainServer main = new MainServer();
			ScrabbleServer scrabble = new ScrabbleServer();
			MusicServer music = new MusicServer();
			JokesServer jokes = new JokesServer();
			main.main(args);
			scrabble.main(args);
			music.main(args);
			jokes.main(args);
		} catch(Exception e){e.printStackTrace();}
	}
}
