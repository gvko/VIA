package MainServer.Model;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import MusicServer.Model.MusicServerInterface;

public class MusicClient implements Serializable
{
	private static MusicServerInterface server;
	private static MusicServer.Model.Track track;
	public MusicClient() throws RemoteException
	{
		super();
	}
	public static MusicServer.Model.Track searchSong(String input)
	{
		try
		{
			server = (MusicServerInterface) Naming.lookup("rmi://localhost:1099/musicServer");
			track = server.searchSong(input);
		}
		catch(Exception e){ e.printStackTrace(); }
		return track;
	}
	
	public static void main(String[] args) throws RemoteException
	{
		MusicClient client = new MusicClient();
		System.out.println(client.searchSong("kid ink"));
	}
}