/*
package challenges.labyrinth;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import challenges.GridTemplate;

import java.util.ArrayList;

/*

	Coded by:
	Modified on:

*/
/*
public class Labyrinth extends GridTemplate {

	private boolean hasCloak = false;
	// Constructs an empty grid
	public Labyrinth() {

	}

	// Constructs the grid defined in the file specified
	public Labyrinth(String filename) {
		super(20, 20, filename);
	}

	/**
	* Solves the labyrinth in the smallest number of moves.
	* 
	* @param x The x coordinate of the starting point.
	* @param y The y coordinate of the starting point.
	* @return An ArrayList containing the coordinates of all locations on the shortest path to the exit, where the first 
	* element is the location of the starting point and the last element is the location of the exit, or null if no path can be found.
	*/
/*
	public ArrayList<Point> findPath(int x, int y) {
		ArrayList <Point> path = new ArrayList<Point>();
		/*
		if(!canWalk(x,y)) {
			//do nothing
		}else if(grid[x][y] == 'X') {	//goal
			path.add(new Point(x,y));
			return path;
		}else if(hasCloak) {
			if(grid[x][y] == '.' || grid[x][y] == 'A') {
			//next four directions
				findPath(x+1, y);

				findPath(x-1, y);
				
				findPath(x, y+1);
				
				findPath(x, y-1);
				
			}
		}else if(grid[x][y] == '.') {
			findPath(x+1, y);

			findPath(x-1, y);
			
			findPath(x, y+1);
			
			findPath(x, y-1);
			
		}else if(grid[x][y] == '@') {
			hasCloak = true;
			grid[x][y] = '.';
			return findPath(x,y);
		}
	//	return path;*/
/*
		if(grid[x][y] == 'X') { //Base case
			grid[x][y] = 'C';
			System.out.println("Path Found" + "\nShaded blocks are the path");
			path.add(new Point(x, y));
			return path;
		}else if(grid[x][y] == '@'){
			hasCloak = true;
			grid[x][y] = '.';
			return findPath(x, y);
		}else if(canWalk(x,y)) {
			grid[x][y] = '!';
			if(canWalk(x+1, y)) {
				path.add(new Point(x+1, y));
				findPath(x+1, y);
			}  
			if(canWalk(x, y+1)) {
				path.add(new Point(x, y+1));
				findPath(x, y+1);
			} 
			if(canWalk(x-1, y)) {
				path.add(new Point(x-1, y));
				findPath(x-1, y);
			} 
			if(canWalk(x, y-1)) {
				path.add(new Point(x, y-1));
				findPath(x, y-1);
			}
		}
		return path;
	}



	// Additional private recursive methods
	private boolean canWalk(int x, int y) {	
		if(x>=0 && x< 20 && y>=0 && y<20) {
			if(hasCloak) {
				return grid[x][y] == '.' || grid[x][y] == 'X' || grid[x][y] == '@' || grid[x][y] == 'A';
			}else {
				return grid[x][y] == '.' || grid[x][y] == 'X' || grid[x][y] == '@';
			}
		}
		return false;
	}
	
}

*/
package challenges.labyrinth;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import challenges.GridTemplate;

import java.util.ArrayList;

/*

	Coded by:
	Modified on:

*/

public class Labyrinth extends GridTemplate {

	// Constructs an empty grid
	public Labyrinth() {

	}

	// Constructs the grid defined in the file specified
	public Labyrinth(String filename) {

	}

	/**
	* Solves the labyrinth in the smallest number of moves.
	* 
	* @param x The x coordinate of the starting point.
	* @param y The y coordinate of the starting point.
	* @return An ArrayList containing the coordinates of all locations on the shortest path to the exit, where the first 
	* element is the location of the starting point and the last element is the location of the exit, or null if no path can be found.
	*/
	public ArrayList<Point> findPath(int x, int y) {

		return findPath(x, y, false);

	}
	
	
	
	
	/**
	 * @param x The current x location of the path-finder
	 * @param y The current y location of the path-finder
	 * @param hasCloak Whether the path-finder has picked up the cloak yet or not
	 * @return An ArrayList of Point objects describing the route that the path-finder has taken.
	 */
	private ArrayList<Point> findPath(int x, int y, boolean hasCloak) {
		
		// BASE CASES (bad stuff)
		// Are you out of the grid bounds?
			// Return a null ArrayList
		// Are you in a wall?
			// Return a null ArrayList
		// Are you somewhere you have been before, while holding the cloak?
			// Return a null ArrayList
		// Are you somewhere you have been before, while not holding the cloak, and you don't current have the cloak?
			// Return a null ArrayList
		// Are you at a monster, and you don't current have the cloak?
			// Return a null ArrayList
		
		// BASE CASES (good stuff)
		// Are you at the exit?
			// Create a new ArrayList of Points. 
			// Add this location to the list, then return it.
		
		// RECURSIVE CASE
		// Save the character at grid location x,y in a local variable for later use
		
		// If this is the spot with the cloak, switch the hasCloak boolean to true
		
		// Add a "breadcrumb" character to the grid at x,y. Use 2 different breadcrumb characters depending on whether hasCloak is true or not.
		
		// Recursively call findPath() 4 times - once in each of the 4 fundamental directions (one space up, down, left, and right). Save the ArrayList that is returned by each.
		// Of the 4 ArrayLists that are returned, find the ArrayList that is not null and has the smallest size.
		
		// Put the original saved character back into the grid at x,y (to remove the breadcrumb and prevent any permanent modification to the grid)
		
		// If all 4 of the ArrayLists returned by the recursive calls are null:
			// Return a null ArrayList
		
		// If you have found the smallest non-null ArrayList:
			// Add this location to the beginning of the list, then return it. 
		
		
	}




}

