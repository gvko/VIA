package MusicServer.Model;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import MusicServer.Controller.MusicPlayer;


public class MusicServer extends UnicastRemoteObject implements MusicServerInterface {

	private MusicPlayer player = new MusicPlayer();
	public static void main(String[] args)
	{
		try
		{
			//Registry reg = LocateRegistry.createRegistry(1099);
			MusicServerInterface server = new MusicServer();
			Naming.rebind("musicServer", server);
			
			System.out.println("Music Server Started.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public MusicServer() throws RemoteException
	{
		super();
	}

	/**
	 * 
	 */
	public Track searchSong(String in) throws RemoteException {
		Track res = player.searchSong(in);
		return res;
	}
	

}
