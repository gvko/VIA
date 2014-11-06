package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Model.Client;
import Client.View.HomeView;
import MainServer.Model.Message;

public class Controller implements ActionListener {

	private static HomeView hView;
	private static String clientName = "Client";
	private static Message message;
	private static String serverName = "Jane";

	public Controller(HomeView hView)
	{
		this.hView = hView;
		this.message = new Message();
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if ((e.getSource() instanceof JButton))
		{

			if (((JButton) e.getSource()).getText().equals("Send Message"))
			{
				sendMessage();
			}
			else if (((JButton) e.getSource()).getText().equals("Calculate Shit!"))
			{
				calculate("calculate");
			}
			else if (((JButton) e.getSource()).getText().equals("Hear Some Jokes."))
			{
				jokes("jokes");
			}
			else if (((JButton) e.getSource()).getText().equals("Book Some Stuff."))
			{
				booking("booking");
			}
			else if (((JButton) e.getSource()).getText().equals("Play Musica."))
			{
				music("music");
			}
			else if (((JButton) e.getSource()).getText().equals("Scrabble Help."))
			{
				scrabble("scrabble");
			}
		}
	}
	public static void sendMessage()
	{
		String clientMessage = hView.chatWindow.getText();
		message.setMessage(clientMessage);
		hView.chatWindow.setText("");
		hView.messageWindow.setText(hView.messageWindow.getText() + "\n" + clientName + ": " + message.getMessage());
		message = Client.sendMessage(message);
		hView.messageWindow.setText(hView.messageWindow.getText() + "\n" + message.getMessage());
	}
	public static void calculate(String clientMessage)
	{
		message.setMessage(clientMessage);
		message = Client.sendMessage(message);
		hView.messageWindow.setText(hView.messageWindow.getText() + "\n" + message.getMessage());
	}
	public static void booking(String clientMessage)
	{
		message.setMessage(clientMessage);
		message = Client.sendMessage(message);
		hView.messageWindow.setText(hView.messageWindow.getText() + "\n" + message.getMessage());
	}
	public static void music(String clientMessage)
	{
		message.setMessage(clientMessage);
		message = Client.sendMessage(message);
		hView.messageWindow.setText(hView.messageWindow.getText() + "\n" + message.getMessage());
	}
	public static void scrabble(String clientMessage)
	{
		message.setMessage(clientMessage);
		message = Client.sendMessage(message);
		hView.messageWindow.setText(hView.messageWindow.getText() + "\n" + message.getMessage());
	}
	public static void jokes(String clientMessage)
	{
		message.setMessage(clientMessage);
		message = Client.sendMessage(message);
		hView.messageWindow.setText(hView.messageWindow.getText() + "\n" + message.getMessage());
	}
	public static void setClientName(String name)
	{
		clientName = name;
	}
	public static void setServerName(String name)
	{
		serverName = name;
	}
}
