package ScrabbleServer.Utilities;

import java.util.ArrayList;

public class Sorting
{
	public static void main(String[] args)
	{
		System.out.println("Reading file..");
		ArrayList<String> testList = new ArrayList<String>();
		String[] test =
				TextFileReader.readFileToArray("/Users/Cortnum/Documents/workspace/ADP-Hand-Ins/src/handin2/uswords.txt");
		System.out.println("Sorting arraylist..");
		double start = System.nanoTime();
	//	bubbleSort(test);
		mergeSort(test, 0, test.length - 1);
		double end = System.nanoTime();
		double time = (end - start) / 1000000000;
		System.out.println("Printing arraylist..");
		for(int i = 0; i < test.length; i++)
		{
			testList.add(test[i]);
		}
		for(int i = 0; i < testList.size(); i++)
		{
			System.out.println(testList.get(i));
		}
		System.out.println("Array size: " + test.length);
		System.out.println("List size: " + testList.size());
		System.out.println("Time taken to sort US words in seconds: " + time);
	}
	public static void bubbleSort(ArrayList<String> list)
	{
			for(int i = 0; i < list.size(); i++)
			{
				for(int j = 0; j < ((list.size() - 1) - i); j++)
				if(list.get(j).compareToIgnoreCase(list.get(j + 1)) > 0)
				{
					String temp = list.get(j);
					list.remove(j);
					list.add(j + 1, temp);
				}
		}
	}
	public static int partition(String[] array, int min, int max)
	{
		int left;
		int right;
		String temp;
		String pivot;
		
		pivot = array[min];
		left = min;
		right = max;
		
		while(left<right)
		{
			while(array[left].compareToIgnoreCase(pivot) <= 0 && left<right)
			{
				left++;
			}
			while(array[right].compareToIgnoreCase(pivot) > 0)
			{
				right--;
			}
			
			if(left<right)
			{
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		
		temp = array[min];
		array[min] = array[right];
		array[right] = temp;
		
		return right;
	}
	public static void mergeSort(String[] array, int min, int max)
	{
		int pivot, size, left, right;
		String[] temp;
		
		if(min==max) return;
		
		size = max - min + 1;
		pivot = (min + max) / 2;
		temp = new String[size];
		
		mergeSort(array, min, pivot);
		mergeSort(array, pivot + 1, max);
		
		for(int i = 0; i < size; i++)
		{
			temp[i] = array[min + i];
		}
		left = 0;
		right = pivot - min + 1;
		for(int i = 0; i < size; i++)
		{
			if(right <= max - min)
			{
				if(left <= pivot - min)
				{
					if(temp[left].compareTo(temp[right]) > 0)
					{
						array[min + i] = temp[right++];
					}
					else array[min + i] = temp[left++];
				}
				else array[min + i] = temp[right++];
			}
			else array[min + i] = temp[left++];
		}
	}

}
