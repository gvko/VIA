package MainServer.Model;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

import MainServer.Utilities.Reader;

public class MainServer extends UnicastRemoteObject implements MainServerInterface {

	private static ArrayList<String> combos = new ArrayList<String>();
	private static MusicServer.Model.Track nowPlaying;
	private Random randomNumber = new Random();
	
	private static String[] janeComebacks = {"Sorry Sir, I do not know what you mean.", "Come again Sir.",
		"What exactly do you want me to help you with?", "What do you mean by that?",
		"Excuse me Sir, but I do not know what you are trying to say.", "I cannot help you with that Sir.",
		"Can you be more specific?"};
	private static String[] janeThanks = {"You are most welcome Sir.", "Glad I could help you Sir.", "My pleasure.",
		"I am here to serve you.", "Tell me if you need help with anything else.", "What more can i do for you?",
		"You are welcome.", "No thank you Sir.", "I am glad you appriciate my assistance."};
	private static String[] marcusComebacks = {"Say what?", "Huh?", "Come again son?", "Bitch please!",
		"?", "Shit son!", "Fuck this shit!", "I don't have to listen to your shit!", "I quit!", "Stop BS'ing.",
		"Try asking for a joke?", "Maybe ask for some tunes bro.", "I can help you with scrabble too.",
		"What's your problem?", "Did you know, that I can't help you with that?", "I don't care man!",
		"What does that even mean son?", "Come at me bro!", "Try saying that ten times fast.", "GTFO"};
	private static String[] marcusThanks = {"Don't even sweat it bro!", "No problem homie.", "MOE homie!",
		"MOB!", "NP bro.", "NP", "No problem.", "Anytime bro.", "You know it!", "No sweat!", "Anything else bro?",
		"How is your mom?", "Tell your mom I said Hi.", "Just doing my part."};
	public static void main(String[] args)
	{
		try
		{
			Registry reg = LocateRegistry.createRegistry(1099);
			MainServerInterface server = new MainServer();
			Naming.rebind("mainServer", server);
			System.out.println("Main Server Started.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public MainServer() throws RemoteException
	{
		super();
	}
	@Override
	public Message sendMessage(Message message)
			throws RemoteException
	{
		boolean scrabble = message.getScrabble();
		boolean music = message.getMusic();
		boolean calculate = message.getCalculate();
		String serverMessage = message.getServerName() + ": Don't know what you mean.";
		if(message.getServerName().equals("Jane"))
		{
			int i = randomNumber.nextInt(janeComebacks.length);
			serverMessage = message.getServerName() + ": " + janeComebacks[i];
		}
		else if(message.getServerName().equals("Marcus"))
		{
			int i = randomNumber.nextInt(marcusComebacks.length);
			serverMessage = message.getServerName() + ": " + marcusComebacks[i];
		}
		String command = Reader.commandReader(message.getMessage());
		if(message.getScrabble())
		{
			String letters = Reader.scrabbleReader(message.getMessage());
			if(letters.length() > 0)
			{
				serverMessage = message.getServerName() + ": Here are the legal Enlish combinations of the letters: " +
						letters + "\n";
				combos = scrabble(letters);
				for(int i = 0; i < combos.size(); i++)
				{
					serverMessage += "\n" + combos.get(i);
				}
				scrabble = false;
			}
			else serverMessage = message.getServerName() + ": You can do better than that: " + message.getMessage() + "\n"
					+ message.getServerName() + ": Try again.";
		}
		else if(message.getCalculate())
		{
			String expresion = Reader.mathReader(message.getMessage());
			if(expresion.length() > 0)
			{
				serverMessage = message.getServerName() + ": Here is the result of " + expresion + "\n";
				double result = calculate(expresion);
				serverMessage += result;
				calculate = false;
			}
			else serverMessage = message.getServerName() + ": This is not a math problem: " + message.getMessage() + "\n"
			+ message.getServerName() + ": Try again.";
		}
		else if(message.getMusic())
		{
			serverMessage = message.getServerName() + ": Now playing" + music(message.getMessage());
			music = false;
		}
		else if(command.equals("calculate"))
		{
			serverMessage = message.getServerName() + ": What do you want to calculate?";
			if(message.getServerName().equals("Jane"))
			{
				serverMessage = message.getServerName() + ": " + "Please tell me the expresion you need me to solve Sir?";
			}
			else if(message.getServerName().equals("Marcus"))
			{
				serverMessage = message.getServerName() + ": " + "What's your math problem homie?";
			}
			calculate = true;
		}
		else if(command.equals("booking"))
		{
			serverMessage = message.getServerName() + ": " + booking(message.getMessage());
		}
		else if(command.equals("jokes"))
		{
			serverMessage = message.getServerName() + ": " + jokes();
		}
		else if(command.equals("music"))
		{
			if(nowPlaying != null)
			{
			serverMessage = message.getServerName() + ": Now playing on server: " + nowPlaying.getSongName() + " by " + 
		nowPlaying.getArtist() + "\n" + message.getServerName() + 
		": What do you wanna listen to now?";
			}
			else serverMessage = message.getServerName() + ": What do you wanna listen to?";
			music = true;
		}
		else if(command.equals("scrabble"))
		{
			serverMessage = message.getServerName() + ": What letters do you want me to solve?";
			if(message.getServerName().equals("Jane"))
			{
				serverMessage = message.getServerName() + ": " + "Please input the letters you want me to look at Sir.";
			}
			else if(message.getServerName().equals("Marcus"))
			{
				serverMessage = message.getServerName() + ": " + "What do you wanna scrabble homie?";
			}
			scrabble = true;
		}
		else if(command.equals("thank you"))
		{
			serverMessage = message.getServerName() + ": You're welcome.";
			if(message.getServerName().equals("Jane"))
			{
				int i = randomNumber.nextInt(janeThanks.length);
				serverMessage = message.getServerName() + ": " + janeThanks[i];
			}
			else if(message.getServerName().equals("Marcus"))
			{
				int i = randomNumber.nextInt(marcusThanks.length);
				serverMessage = message.getServerName() + ": " + marcusThanks[i];
			}
		}
		Message serverReply = new Message(serverMessage, message.getServerName(), scrabble, calculate, music);
		return serverReply;
	}
	@Override
	public Message setClientName(String clientName) throws RemoteException
	{
		Message serverReply = new Message("Jane: Who would you like to chat with today? Our pretty secretary Jane or Marcus, the homeboy?");
		return serverReply;
	}
	@Override
	public Message setServerName(String name) throws RemoteException 
	{
		String serverName = Reader.serverNameReader(name);
		if(serverName.equals("Jane"))
		{
			Message serverReply = new Message(serverName + ": Hello Sir, how may I serve You today?", serverName, false, false, false);
			return serverReply;
		}
		else if(serverName.equals("Marcus"))
		{
			Message serverReply = new Message(serverName + ": Wassup homie, what'chu need help fo?", serverName, false, false, false);
			return serverReply;
		}
		else
		{
			Message serverReply = new Message(serverName + ": Welcome. what do you need help with?", serverName, false, false, false);
			return serverReply;
		}
	}
	
	private static double calculate(String message)
	{
		double result;
		result = CalculatorClient.calculate(message);
		return result;
	}
	private static String booking(String message)
	{
		return ": " + "Now I am booking stuff for you";
	}
	private static String music(String message)
	{
		String track = ": ";
		nowPlaying = MusicClient.searchSong(message);
		if(nowPlaying != null)
		{
			track += nowPlaying.toString();
		}
		else track += "Nothing. Song not found.";
		return track;
	}
	private static ArrayList<String> scrabble(String message)
	{
		ArrayList<String> combos = ScrabbleClient.sendMessage(message);
		return combos;
	}
	private static String jokes()
	{
		return JokesClient.getJoke();
	}
	

}
