package ScrabbleServer.Model;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ScrabbleServer extends UnicastRemoteObject implements ScrabbleServerInterface {

	public static void main(String[] args)
	{
		try
		{
			//Registry reg = LocateRegistry.createRegistry(1099);
			ScrabbleServerInterface server = new ScrabbleServer();
			Naming.rebind("scrabbleServer", server);
			System.out.println("Scrabble Server Started.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ScrabbleServer() throws RemoteException
	{
		super();
	}

	public ArrayList<String> solveScrabble(String letters) throws RemoteException
	{
		ArrayList<String> combos = new ArrayList<String>();
		combos = ScrabbleSolver.solveEnglish(letters);
		return combos;
	}

}
