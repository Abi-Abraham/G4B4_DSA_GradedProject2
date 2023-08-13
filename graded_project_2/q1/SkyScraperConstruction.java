package graded_project_2.q1;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SkyScraperConstruction {

	static Scanner scanner = new Scanner(System.in);

	static LinkedHashSet<Integer> input_floorSize = new LinkedHashSet<Integer>();
	
	static int no_Of_Floors;
	
	static void getInputFloorSize()
	{
		System.out.println("Enter total number of floors in the building :");

		no_Of_Floors = scanner.nextInt();

		int floor_size;

		for(int i=0; i<no_Of_Floors ;i++) 
		{
			System.out.println("Enter the floor size given on day "+(i+1)+" : ");
			floor_size = scanner.nextInt();

			if(!input_floorSize.add(floor_size)) 
			{
				System.out.println("Floor sizes must be distinct! Exiting..");
				System.exit(0);
			}

		}
	}
	
	static int getNextMaxFloor(TreeSet<Integer> set) 
	{
		if(!set.isEmpty())
			return set.pollLast();
		else
			return -1;
	}

	static void printOrderOfConstruction() 
	{
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.addAll(input_floorSize);

		int max_floor_size = getNextMaxFloor(set);

		System.out.println("The Order of Construction is as follows :");

		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

		Iterator<Integer> it =input_floorSize.iterator();
		int day =0;
		int floorSize_Given;

		while(it.hasNext()) 
		{
			System.out.println("");
			System.out.println("Day "+(++day)+" : ");

			floorSize_Given = it.next();

			if(floorSize_Given == max_floor_size)
			{
				System.out.print(floorSize_Given);

				if(!stack.isEmpty()) 
				{
					max_floor_size = getNextMaxFloor(set);

					while((!stack.isEmpty()) && (stack.peekFirst().equals(max_floor_size))) 
					{

						System.out.print(" "+stack.pop()+" ");
						max_floor_size = getNextMaxFloor(set);
					}
				}
				else 
				{
					max_floor_size = getNextMaxFloor(set);
					continue;
				}
			}
			else
			{
				stack.push(floorSize_Given);

			}

		}

	}

	public static void main(String[] args) 
	{
		getInputFloorSize();
		System.out.println();
		printOrderOfConstruction();
	}
}