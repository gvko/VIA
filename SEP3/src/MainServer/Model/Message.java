package MainServer.Model;

import java.io.Serializable;

public class Message implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -553673655152907648L;
	private String message;
	private String serverName;
	private boolean scrabble;
	private boolean music;
	private boolean calculate;
	
	public Message()
	{
		this.message = "";
		this.serverName = "Jane";
		this.scrabble = false;
		this.calculate = false;
		this.music = false;
	}
	public Message(String message)
	{
		this.message = message;
		this.serverName = "Jane";
		this.scrabble = false;
		this.calculate = false;
		this.music = false;
	}
	public Message(String message, String serverName, boolean scrabble, boolean calculate, boolean music)
	{
		this.message = message;
		this.serverName = serverName;
		this.scrabble = scrabble;
		this.calculate = calculate;
		this.music = music;
	}
	public boolean getMusic()
	{
		return this.music;
	}
	public void setMusic(boolean music)
	{
		this.music = music;
	}
	public boolean getScrabble()
	{
		return this.scrabble;
	}
	public void setScrabble(boolean scrabble)
	{
		this.scrabble = scrabble;
	}
	public boolean getCalculate()
	{
		return this.calculate;
	}
	public void setCalculate(boolean calculate)
	{
		this.calculate = calculate;
	}
	public String getMessage()
	{
		return this.message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getServerName()
	{
		return this.serverName;
	}
	public void setServerName(String serverName)
	{
		this.serverName = serverName;
	}
}
