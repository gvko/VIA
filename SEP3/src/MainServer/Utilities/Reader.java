package MainServer.Utilities;

import java.util.ArrayList;

public class Reader {

	private static String[] illegalStrings = {"!", "#", "$", "%", "&", "(", ")", "*", "+", ",", "-", ".", "/",
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "=", "?", "@", "[", "]", "_", "{", "}"};
	private static String[] legalMathStrings = {"*", "+", "-", ".", "/",
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private static String[] janeNames = {"ane", "arcus", "jaane", "jame", "jane", "janee", "janne",
		"janr", "jsme", "jsne", "kane", "miss", "misses", "missi", "missie", "missy", "secretary"};
	private static String[] marcusNames = {"bro", "brotha", "brother", "homeboy", "homie", "maecus",
		"marcis", "marcu", "marcua", "marcus", "marcys", "marvus", "msrcus", "narcus", "nsrcus"};
	private static String[] calculateStrings = {"add", "adding", "addition", "calc", "calculate", "calculste", "cslc",
		"cslculate", "cslculste", "divide", "divsion", "equal", "equals", "maht", "mat", "math", "multiplication",
		"nomber", "nombers", "number", "numbers", "sub", "subtract", "substract", "subtraction", "sum"};
	private static String[] scrabbleStrings = {"scabble", "scarbble", "scraable", "scrab", "scrabb", "scrabble",
		"scrabblr", "scrable", "scrablle", "scrbble", "scrsbble", "srabble"};
	private static String[] jokesStrings = {"amuse", "amusing", "amussing", "amuze", "amuzing", "crack", "entertain",
		"entertaining", "entertainment", "fun", "funny", "funy", "giggle", "giggles", "gigle", "gigles", "hilarious",
		"hillarious", "jike", "joke", "jokea", "jokes", "jokr", "jpke", "lauf", "laugh", "laughing", "laughs"};
	private static String[] musicStrings = {"dance", "dancing", "hiphop", "jam", "jamming", "jams", "melodi", "melody",
		"muaic", "music", "musica", "musik", "musikken", "play", "playing", "plsy", "pop", "put", "radio", "rap",
		"record", "records", "sing", "singing", "song", "songs", "sound", "sounds", "trance", "tune", "tunes"};
	private static String[] bookingStrings = {"alone", "away", "book", "booking", "break", "buk", "buking",
		"buuk", "buuking", "fly", "holiday", "hotel", "leave", "plane", "relax", "relaxing", "room", "tour",
		"travel", "traveling", "trip", "vaca", "vacation", "vacsion", "visit", "vscation", "vscstion", "weekend",
		"weeknd", "wekend", "weknd", "wkend"};
	private static String[] thankYouStrings = {"10q", "10x", "t4nk", "t4nks", "tank", "tanks", "th4nk", "th4nks",
		"thank", "thanks", "thx"};
	
	public static String reader(String message)
	{
		return message;
	}
	public static String commandReader(String message)
	{
		String command = "";
		ArrayList<String> words = getWords(message);
		for(int i = 0; i < words.size(); i++)
		{
			if(Search.doubleGanger(calculateStrings, words.get(i)))
			{
				command = "calculate";
			}
			else if(Search.doubleGanger(jokesStrings, words.get(i)))
			{
				command = "jokes";
			}
			else if(Search.doubleGanger(scrabbleStrings, words.get(i)))
			{
				command = "scrabble";
			}
			else if(Search.doubleGanger(musicStrings, words.get(i)))
			{
				command = "music";
			}
			else if(Search.doubleGanger(bookingStrings, words.get(i)))
			{
				command = "booking";
			}
			else if(Search.doubleGanger(thankYouStrings, words.get(i)))
			{
				command = "thank you";
			}
		}
		return command;
	}
	
	public static String serverNameReader(String message)
	{
		String serverName = message;
		ArrayList<String> words = getWords(message);
		for(int i = 0; i < words.size(); i++)
		{
			if(Search.doubleGanger(janeNames, words.get(i)))
			{
				serverName = "Jane";
			}
			else if(Search.doubleGanger(marcusNames, words.get(i)))
			{
				serverName = "Marcus";
			}
		}
		return serverName;
	}
	public static String mathReader(String message)
	{
		String expression = "";
		for(int i = 0; i < message.length(); i++)
		{
			String letter = "";
			letter += message.charAt(i);
			if(Search.doubleGanger(legalMathStrings, letter))
			{
				expression += letter;
			}
		}
		System.out.println(expression);
		return expression;
	}
	public static String scrabbleReader(String message)
	{
		boolean illegal = false;
		String letters = "";
		for(int i = 0; i < message.length(); i++)
		{
			String letter = "";
			letter += message.charAt(i);
			if(message.charAt(i) == ' ')
			{
				illegal = true;
			}
			else if(Search.doubleGanger(illegalStrings, letter))
			{
				illegal = true;
			}
			if(!illegal)
			{
				letters += letter;
			}
			illegal = false;
		}
		return letters;
	}
	private static ArrayList<String> getWords(String message)
	{
		ArrayList<String> words = new ArrayList<String>();
		String word = "";
		for(int i = 0; i < message.length(); i++)
		{
			String letter = "";
			letter += message.charAt(i);
			if(message.charAt(i) == ' ')
			{
				words.add(word);
				word = "";
			}
			else if(Search.doubleGanger(illegalStrings, letter))
			{
				words.add(word);
				word = "";
			}
			else word += message.charAt(i);
		}
		words.add(word);
		return words;
	}

}
