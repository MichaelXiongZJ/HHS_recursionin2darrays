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

	// Constructs an empty grid
	public Maze() {
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
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
		return false;
	}
	
	
	// Additional private recursive methods


}