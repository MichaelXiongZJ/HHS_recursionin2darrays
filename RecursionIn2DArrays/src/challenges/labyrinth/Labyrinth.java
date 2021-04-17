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
		return null;
	}


	// Additional private recursive methods


}