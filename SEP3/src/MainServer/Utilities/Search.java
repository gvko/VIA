package MainServer.Utilities;

import java.util.ArrayList;

public class Search {
	
	public static boolean doubleGanger(String[] list, String word)
	{
		boolean found = false;
		int min, max, mid;
		min = 0;
		max = list.length - 1;
			while (min <= max)
			{
				mid = (min + max) / 2;
				if (list[mid].compareToIgnoreCase(word) == 0)
				{
					found = true;
					break;
				} 
				else if (list[mid].compareToIgnoreCase(word) < 0)
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
}
