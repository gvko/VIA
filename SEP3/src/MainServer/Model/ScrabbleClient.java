package MainServer.Model;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ScrabbleServer.Model.ScrabbleServerInterface;

public class ScrabbleClient implements Serializable
{
	private static ScrabbleServerInterface server;
	private static ArrayList<String> combos;
	public ScrabbleClient() throws RemoteException
	{
		super();
	}
	public static ArrayList<String> sendMessage(String message)
	{
		try
		{
			server = (ScrabbleServerInterface) Naming.lookup("rmi://localhost:1099/scrabbleServer");
			combos = server.solveScrabble(message);
		}
		catch(Exception e){ e.printStackTrace(); }
		return combos;
	}
}