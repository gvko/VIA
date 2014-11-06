package MainServer.Model;

import java.rmi.*;

public interface MainServerInterface extends Remote {
	
	Message sendMessage(Message message)
			throws RemoteException;
	Message setServerName(String serverName) throws RemoteException;
	Message setClientName(String serverName) throws RemoteException;
	
}
