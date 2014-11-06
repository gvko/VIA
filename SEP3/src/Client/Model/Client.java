package Client.Model;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;

import Client.Controller.Controller;
import Client.View.HomeView;
import MainServer.Model.MainServerInterface;
import MainServer.Model.Message;

public class Client implements Serializable {
	
	private static MainServerInterface server;
	private static Message serverMessage;
	static boolean startUp = true;
	static boolean startUp2 = true;
		
	public Client() throws RemoteException
	{
		super();
		try
		{
			HomeView hView = new HomeView();
			Controller controller = new Controller(hView);
			hView.start(controller);
			hView.setVisible(true);			
		}
		catch(Exception e){ e.printStackTrace(); }
	}
	public static void main(String[] args) throws RemoteException
	{
		Client client = new Client();
	}
	public static Message sendMessage(Message message)
	{
		try
		{
			server = (MainServerInterface) Naming.lookup("rmi://localhost:1099/mainServer");
			if(startUp)
			{
				String clientName = message.getMessage();
				serverMessage = server.setClientName(clientName);
				Controller.setClientName(clientName);
				startUp = false;
			}
			else if(startUp2)
			{
				serverMessage = server.setServerName(message.getMessage());
				Controller.setServerName(message.getServerName());
				startUp2 = false;
			}
			else serverMessage = server.sendMessage(message);
		}
		catch(Exception e){ e.printStackTrace(); }
		return serverMessage;
	}
}
