package MusicServer.Controller;

import MusicServer.Model.Track;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MusicPlayer implements Serializable {
	private static ArrayList<Track> tracks = new ArrayList<Track>();
	private static ArrayList<Track> availableTracks = new ArrayList<Track>();
	
	
	public MusicPlayer()
	{
		addTrack("Kid ink", "Hell and Back", 3, 46);
		addTrack("Kid ink", "Ghost", 2, 57);
		addTrack("Kid ink", "Weekend", 3, 23);
		addTrack("T.I.", "THE KING", 4, 32);
		addTrack("T.I.", "We Do This", 4, 22);
		addTrack("The dudes", "fo shizzle", 2, 16);

	}
	
	private static String getAvailableTracks()
	{
		System.out.println("Available tracks from this artist are:");
		String out="";
		for (int i = 0; i < availableTracks.size(); i++) {
			out+=availableTracks.get(i).toString()+"\n";
		}
		return out;
	}
	/**
	 * Add a track to the available songs.
	 * 
	 * @param Artist
	 * @param songName
	 * @param minutes
	 * @param seconds
	 */
	public void addTrack(String Artist, String songName, int minutes,int seconds) {
		int length = minutes * 60 + seconds;
		tracks.add(new Track(Artist, songName, length));
	}

	/**
	 * Get the track on the corresponding index.
	 * 
	 * @param index
	 * @return
	 */
	public static Track getTrack(int index) {
		return tracks.get(index);
	}

	/**
	 * Get the track by bame
	 * 
	 * @param songName
	 * @return the Track object associated with that name.
	 */
	public static Track getTrackByName(String songName) {
		String refactoredName = songName.trim();
		refactoredName = refactoredName.replaceAll(" +", " ");
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getSongName().equalsIgnoreCase(refactoredName))
				return tracks.get(i);
		}
		return null;
	}

	/**
	 * Get the available tracks for a given artist.
	 * 
	 * @param Artist
	 * @return
	 */
	public static ArrayList<Track> getArtistsTracks(String Artist) {
		ArrayList<Track> out = new ArrayList<Track>();
		for (int i = 0; i < tracks.size(); i++) {
			String artist = tracks.get(i).getArtist();

			if (artist.toUpperCase().contains(Artist.toUpperCase()))
				out.add(tracks.get(i));
		}
		return out;
	}

	/**
	 * Search a song by name. If the user inputs the name of an artist, the
	 * method prints the available songs from that artist; Searching format:
	 * "*artist_name* - *song_name*" eller "*song_name* by *artist_name*";
	 * 
	 * @param in
	 * @return Returns null if the song isn't found, when it suggests songs it just prints the songs for the given artist.
	 */
	public static Track searchSong(String in) {
		if (in.contains("-") || in.toLowerCase().contains("by")) {
			String artist;
			String song;
			if (in.contains("-")) {
				String[] input = in.split("-");
				System.out.println(Arrays.toString(input));

				artist = input[0];
				song = input[1];
			} else {
				String[] input = in.split("by");

				artist = input[1];
				song = input[0];
			}

			if (getTrackByName(song) != null)
				return getTrackByName(song);

			else if (getArtistsTracks(artist) != null && getArtistsTracks(in).size()>0) {
				Random generator = new Random();
				System.out.println("Fetching random track on pos: ");
				ArrayList<Track> avTracks = getArtistsTracks(artist);
				int pos = generator.nextInt(avTracks.size());
				System.out.println(pos);
				return avTracks.get(pos);
				
			} else {
				System.out.println("No songs by this artist!");
				System.out.println("Track not found!");
				return null;
			}
		}

		else {
			if (getTrackByName(in) != null)
				return getTrackByName(in);
			else if (getArtistsTracks(in) != null && getArtistsTracks(in).size()>0) {
				Random generator = new Random();
				System.out.println("Fetching random track on pos: ");
				ArrayList<Track> avTracks = getArtistsTracks(in);
				int pos = generator.nextInt(avTracks.size());
				System.out.println(pos);
				return avTracks.get(pos);
				
			} else {
				System.out.println("No tracks found!");
				return null;
			}
		}
		
	}
}