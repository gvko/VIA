/******************************************************************
* Author: Mikkel Cortnum
* Date: 15-11-2012
* 
* 
* 
* 
* NOTE: Maximum of 8 letters due to memory problem.
* 
* -----------------------------------------------------------------
* Changes:
* 
* 
******************************************************************/

package ScrabbleServer.Model;

import java.util.ArrayList;

import ScrabbleServer.Utilities.*;

public class ScrabbleSolver
{
	private static String letters;
	private static ArrayList<String> allCombos, USDictionary, DanishDictionary, bible;
	private static ArrayList<String> allLegalCombos;
	private static ArrayList<String> allDanishCombos;
	private static ArrayList<String> allHolyCombos;
	private static ArrayList<String> allHolyCombosNoDoubles;
	private static ArrayList<String> allLegalCombosNoDoubles;
	private static ArrayList<String> allDanishCombosNoDoubles;

	public ScrabbleSolver(String letters)
	{
		this.letters = letters;
		allCombos = new ArrayList<String>();
		allHolyCombosNoDoubles = new ArrayList<String>();
		allLegalCombosNoDoubles = new ArrayList<String>();
		allDanishCombosNoDoubles = new ArrayList<String>();
		allLegalCombos = new ArrayList<String>();
		allDanishCombos = new ArrayList<String>();
		allHolyCombos = new ArrayList<String>();
	}
	public static ArrayList<String> solveDanish(String letters)
	{
		ScrabbleSolver scrabble = new ScrabbleSolver(letters);
		scrabble.run();
		return scrabble.allDanishCombosNoDoubles;
	}
	public static ArrayList<String> solveEnglish(String letters)
	{
		ScrabbleSolver scrabble = new ScrabbleSolver(letters);
		scrabble.run();
		return scrabble.allLegalCombosNoDoubles;
	}
	public static ArrayList<String> solveBible(String letters)
	{
		ScrabbleSolver scrabble = new ScrabbleSolver(letters);
		scrabble.run();
		return scrabble.allHolyCombosNoDoubles;
	}
	private static void run()
	{
		initializeDictionaries();
		findCombos(letters);
		findLegalCombos();
		cleanUp(allLegalCombos, allLegalCombosNoDoubles);
	//	cleanUp(allHolyCombos, allHolyCombosNoDoubles);
	//	cleanUp(allDanishCombos, allDanishCombosNoDoubles);
	}
	private static void findLegalCombos()
	{
		for(int i = 0; i < allCombos.size(); i++)
		{
			findLegalCombos(USDictionary, allLegalCombos, allCombos.get(i));
			findLegalCombos(DanishDictionary, allDanishCombos, allCombos.get(i));
			findLegalCombos(bible, allHolyCombos, allCombos.get(i));
		}
	}
	private static void findLegalCombos(ArrayList<String> dict, ArrayList<String> comboList, String word)
	{
		int min, max, mid;
		min = 0;
		max = dict.size() - 1;
			while (min <= max)
			{
				mid = (min + max) / 2;
				if (dict.get(mid).compareToIgnoreCase(word) == 0)
				{
					comboList.add(word);
					return;
				} 
				else if (dict.get(mid).compareToIgnoreCase(word) < 0)
				{
					min = mid + 1;
				}
				else
				{
					max = mid - 1;
				}
            }
	}
	private static void findCombos(String string)
	{
		int length = string.length();
		if(length > 8) length = 8;
		char[] result = new char[length];
		char[] stringArray = new char[length];
		boolean[] used = new boolean[length];
		for(int i = 0; i < length; i++)
		{
			stringArray[i] = string.charAt(i);
		}
		
		findCombos(0, stringArray, used, result);
	}
	private static void findCombos(int position, char[] string, boolean[] used, char[] result)
	{
		if(position == result.length)
		{
			String combo = "";
			combo += result[0];
			for(int i = 1; i < result.length; i++)
			{
				combo += result[i];
				allCombos.add(combo);
			}
		}
		else
		{
			for(int i = 0; i < used.length; i++)
			{
				if(!used[i])
				{
					used[i] = true;
					result[position] = string[i];
					
					findCombos(position + 1, string, used, result);
					
					used[i] = false;
				}
			}
		}
	}
	private static boolean doubleGanger(ArrayList<String> list, String word)
	{
		boolean found = false;
		int min, max, mid;
		min = 0;
		max = list.size() - 1;
			while (min <= max)
			{
				mid = (min + max) / 2;
				if (list.get(mid).compareToIgnoreCase(word) == 0)
				{
					found = true;
					break;
				} 
				else if (list.get(mid).compareToIgnoreCase(word) < 0)
				{
					min = mid + 1;
				}
				else
				{
					max = mid - 1;
				}
            }
			return found;
	}
	private static void cleanUp(ArrayList<String> list, ArrayList<String> newList)
	{
		String[] array = new String[list.size()];
		list.toArray(array);
		Sorting.mergeSort(array, 0, array.length - 1);
		boolean doubleGanger = false;
		for(int i = 0; i < array.length; i++)
		{
			list.add(i, array[i]);
		}
		for(int i = 1; i < list.size(); i++)
		{
			doubleGanger = doubleGanger(newList, list.get(i));
			if(!doubleGanger)
			{
				newList.add(list.get(i));
			}
		}
	}
	private void printCombos()
	{
		for(int i = 0; i < allLegalCombosNoDoubles.size(); i++)
		{
			System.out.println(allLegalCombosNoDoubles.get(i));
		}
		System.out.println("Possible US Combos: " + allLegalCombosNoDoubles.size());
		
		for(int i = 0; i < allDanishCombosNoDoubles.size(); i++)
		{
			System.out.println(allDanishCombosNoDoubles.get(i));
		}
		System.out.println("Possible Danish Combos: " + allDanishCombosNoDoubles.size());
		
		for(int i = 0; i < allHolyCombosNoDoubles.size(); i++)
		{
			System.out.println(allHolyCombosNoDoubles.get(i));
		}
		System.out.println("Possible Holy Combos: " + allHolyCombosNoDoubles.size());
	}
	private static void initializeDictionaries()
	{
		USDictionary = TextFileReader.readFile
				("/Users/Cortnum/Documents/workspace/SEP3/src/ScrabbleServer/txt/AlphabeticalUSWords.txt");
		DanishDictionary = TextFileReader.readFile
				("/Users/Cortnum/Documents/workspace/SEP3/src/ScrabbleServer/txt/AlphabeticalDanishWords.txt");
		bible = TextFileReader.readFile
				("/Users/Cortnum/Documents/workspace/SEP3/src/ScrabbleServer/txt/AlphabeticalBibleWords.txt");
	}
}
