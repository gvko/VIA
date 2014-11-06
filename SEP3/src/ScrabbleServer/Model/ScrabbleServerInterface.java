package ScrabbleServer.Model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ScrabbleServerInterface extends Remote {
	
	public ArrayList<String> solveScrabble(String letters) throws RemoteException;

}
