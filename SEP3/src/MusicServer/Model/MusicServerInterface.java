package MusicServer.Model;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface MusicServerInterface extends Remote
{
	public Track searchSong(String in) throws RemoteException;
}

