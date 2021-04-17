package challenges;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

public abstract class GridTemplate {

	/** Add a field to represent the grid. This time, make it a 2D array of characters. **/
	
	protected char[][] grid;
	
	
	/**
	 * Construct an empty 2D array with some default dimensions.
	 */
	public GridTemplate() {
		grid = new char[20][20];
	}
	
	
	/**
	 * Construct an empty 2D array with dimensions width and height, then fill it with data from the file filename.
	 * 
	 * @param width The width of the grid.
	 * @param height The height of the grid.
	 * @param filename The text file to read from.
	 */
	public GridTemplate(int width, int height, String filename) {
		grid = new char[height][width];
		this.readData(filename, grid);
	}
	
	
	/**
	 * 
	 * Code a toString() method that nicely prints the grid to the commandline.
	 * 
	 */
	public String toString() {
		String output = "";
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				output += grid[i][j];
			}
			output += "\n";
		}
		return output;
	}
	
	
	/**
	 * (Graphical UI)
	 * Draws the grid on a PApplet.
	 * The specific way the grid is depicted is up to the coder.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '*' || grid[i][j] == '.') {
					marker.fill(255); //White
				}else if(grid[i][j] == '#'){
					marker.fill(50); //Black
				}else if(grid[i][j] == '!'){
					marker.fill(200); //Light Grey
				}else if(grid[i][j] == 'X') {
					marker.fill(255, 255, 50); //Bright Yellow
				}else if(grid[i][j] == 'C') {
					marker.fill(190, 190, 50); //Dark Yellow
				}else {
					marker.fill(150); //Dark Grey
				}
				float rectWidth = width/grid[0].length;
				float rectHeight = height/grid.length;
				float rectX = x + rectWidth*j;
				float rectY = y + rectHeight*i;
				marker.rect(rectX, rectY, rectWidth, rectHeight);
			}
		}	
	}
	
	
	/**
	 * (Graphical UI)
	 * Determines which element of the grid matches with a particular pixel coordinate.
	 * This supports interaction with the grid using mouse clicks in the window.
	 * 
	 * @param p A Point object containing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the grid, or null if the pixel coordinate
	 * falls completely outside of the grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		int i = (int) ((p.y - y)*grid.length/height);
		int j = (int) ((p.x - y)*grid[0].length/width);
		Point coordinates = new Point(i, j);
		return coordinates;
	}
	


	public void readData (String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					
					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (count < gameData.length && i < gameData[count].length)
								gameData[count][i] = line.charAt(i);

						count++;
					}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
}
