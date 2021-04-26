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
	public ArrayList<Point> findPath(int x, int y) {
		ArrayList <Point> path = new ArrayList<Point>();
		if(grid[x][y] == 'X') { //Base case
			grid[x][y] = 'C';
			System.out.println("Path Found" + "\nShaded blocks are the path");
			path.add(new Point(x, y));
			return path;
		}else if(grid[x][y] == '@'){
			hasCloak = true;
			grid[x][y] = '.';
			findPath(x, y);
		}else if(grid[x][y] == '.'){
			grid[x][y] = '!';
			if(canWalk(x+1, y)) {
			//	if(findPath(x+1, y)) {
					path.add(new Point(x+1, y));
					return path;
			//	}
			}  
			if(canWalk(x, y+1)) {
			//	if(findPath(x, y+1)) {
					path.add(new Point(x, y+1));
					return path;
			//	}
			} 
			if(canWalk(x-1, y)) {
			//	if(findPath(x-1, y)) {
					path.add(new Point(x-1, y));
					return path;
			//	}
			} 
			if(canWalk(x, y-1)) {
			//	if(findPath(x, y-1)) {
					path.add(new Point(x, y-1));
					return path;

			}
		}
		System.out.println(path.get(0));
		return path;
	}



	// Additional private recursive methods
	private boolean canWalk(int x, int y) {	
		if(x>=0 && x< 20 && y>=0 && y<20) {
			if(!hasCloak) {
				return grid[x][y] == '.' || grid[x][y] == 'X';
			}else {
				return grid[x][y] == '.' || grid[x][y] == 'X' || grid[x][y] == 'A';
			}
		}
		return false;
	}
}