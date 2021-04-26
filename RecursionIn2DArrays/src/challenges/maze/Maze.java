package challenges.maze;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import challenges.GridTemplate;


/*

	Represents a 2D maze.

	Coded by:
	Modified on:

*/

public class Maze extends GridTemplate {
//
	private char[][] path = grid;
	
	// Constructs an empty grid
	public Maze() {
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		super(20, 20, filename);
		
	}

	/**
	 * Attempts to find a path through the maze and returns whether a path was found or not. The path that is found
	 * need not be an optimal path, just one possible route.
	 * The maze should be marked with the path that was found, so a print-out of the grid will show the path after this method call.
	 * 
	 * @param x The x coordinate of the starting point.
	 * @param y The y coordinate of the starting point.
	 * @return true if a path to the exit was found, false if no such path exists in the maze.
	 */
	public boolean findPath(int x, int y) {
		if(grid[x][y] == 'X') { //Base case
			grid[x][y] = 'C';
			System.out.println("Path Found" + "\nShaded blocks are the path");
			return true;
		}else if(grid[x][y] == '.'){
			grid[x][y] = '!';
			if(canWalk(x+1, y)) {
				return findPath(x+1, y);
			}  
			if(canWalk(x, y+1)) {
				return findPath(x, y+1);
			} 
			if(canWalk(x-1, y)) {
				return findPath(x-1, y);
			} 
			if(canWalk(x, y-1)) {
				return findPath(x, y-1);
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