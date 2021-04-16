package challenges.paintcan;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import challenges.GridTemplate;

/*

	This program paint can fills objects on a 2D grid. 

	Coded by: 
	Modified on: 

*/

public class Image extends GridTemplate {

	
	// Constructs an empty grid
	public Image () {
		super();
	}

	// Constructs the grid defined in the file specified
	public Image (String filename) {
		super(20, 20, filename);
	}
	
	/**
	 * Fills an object beginning at x,y.
	 * 
	 * @param x The x coordinate of the beginning of the paint can fill.
	 * @param y The y coordinate of the beginning of the paint can fill.
	 */
	public void paintCanFill(int x, int y) {
		if(canFill(x,y)) {
			fill(x,y);
			if(canFill(x+1, y)) {
				paintCanFill(x+1, y);
			} if(canFill(x, y+1)) {
				paintCanFill(x, y+1);
			} if(canFill(x-1, y)) {
				paintCanFill(x-1, y);
			} if(canFill(x, y-1)) {
				paintCanFill(x, y-1);
			}				
		}
	}
	
	
	// Additional private recursive methods
	public void fill(int x, int y) {
		if(grid[x][y] == '*') {
			grid[x][y] = ' ';
		}
	}

	public boolean canFill(int x, int y) {	
		if(x>=0 && x< 20 && y>=0 && y<20) {
			return grid[x][y] == '*';
		}
		return false;
	}
}