package MainServer.Model;

import java.io.Serializable;

public class Track implements Serializable
{
	private String Artist;
	private String songName;
	private int length;
	private int timeRemaining;
	
	/**
	 * Default constructor that sets the local fields.
	 * @param Artist - name of the artist
	 * @param songName - name of the song
	 * @param length - length of the song in seconds
	 */
	public Track(String Artist, String songName, int length)
	{
		this.Artist = Artist;
		this.songName = songName;
		this.length = length;
	}
	
	/**
	 * Get the artist performing the song.
	 * @return
	 */
	public String getArtist()
	{
		return this.Artist;
	}
	
	/**
	 *  Set the artist performing the song.
	 * @param Artist
	 */
	public void setArtist(String Artist)
	{
		this.Artist = Artist;
	}
	
	/**
	 * Get the song name.
	 * @return
	 */
	public String getSongName()
	{
		return this.songName;
	}
	
	/**
	 * Set the song name. 
	 * @param songName
	 */
	public void setSongName(String songName)
	{
		this.songName = songName;
	}
	
	/**
	 * Get the song length.
	 * @return
	 */
	public int getLength()
	{
		return this.length;
	}
	/**
	 * Get time remaining
	 * @return
	 */
	public int getTimeLeft()
	{
		return this.timeRemaining;
	}
	
	/**
	 * Get the length of the song.
	 * @param length
	 */
	public void setLength(int length)
	{
		this.length = length;
	}
	
	/**
	 * Simulates the playing of a song by showing time left from the song.
	 * 
	 */
	public void play()
	{		
		int timeLeft = getLength();
		for(int i=getLength();i>0;i--)
		{
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timeLeft--;
			this.timeRemaining = timeLeft;
		//	System.out.println(getArtist()+" - "+getSongName()+"\t\t"+printTime(timeLeft));
			
		}
	}
	
	/**
	 * Prints the times from only seconds to the "minutes:seconds" format.
	 * @param length
	 * @return
	 */
	public String printTime(int length)
	{
		String out="";
		int minutes = length/60;
		int seconds = length%60;
		if(seconds<10) return out+=minutes+":0"+seconds;
		return out+=minutes+":"+seconds;
	}
	/**
	 * Prints the stringified version of a Track object: ArtistName - SongName     minutesLeft:secondsLeft.
	 */
	public String toString()
	{
		String out="";
		out+=getArtist()+" - "+getSongName()+" "+printTime(getLength());
		return out;
	}
}

