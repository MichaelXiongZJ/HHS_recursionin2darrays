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
	
	private ArrayList <Point> path = new ArrayList<Point>();

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
	public ArrayList<Point> findPath(int x, int y) {
		if(!canWalk(x ,y)) {
			
		}else if(grid[x][y] == 'X') { //Base case
			grid[x][y] = 'C';
			System.out.println("Path Found" + "\nShaded blocks are the path");
		}else if(grid[x][y] == '.'){
			grid[x][y] = '!';
			if(canWalk(x+1, y)) {
				if(findPath(x+1, y)) {
					path.add(new Point(x+1, y));
					return findPath(x+1, y);
				}
			}  
			if(canWalk(x, y+1)) {
				if(findPath(x, y+1)) {
					return findPath(x, y+1);
				}
			} 
			if(canWalk(x-1, y)) {
				if(findPath(x-1, y)) {
					return findPath(x-1, y);
				}
			} 
			if(canWalk(x, y-1)) {
				if(findPath(x, y-1)) {
					return findPath(x, y-1);
				}
			}
		}
		return false;
	}



	// Additional private recursive methods
	private boolean canWalk(int x, int y) {	
		if(x>=0 && x< 20 && y>=0 && y<20) {
			return grid[x][y] == '.' || grid[x][y] == 'X';
		}
		return false;
	}
	

}