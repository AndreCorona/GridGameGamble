package application;
import java.util.*;

public class Minesweeper {
	// initialize the rows and columns
	private final int ROWS = 10;
	private final int COLUMNS = 10;
	
	//keep track of the mines in the grid
	int[][] counts = new int[ROWS][COLUMNS];
	
	public Minesweeper(){
		
	}
	
	public void create(){
		System.out.println();
	}
	public static void main(String[] arg){
		new Minesweeper();
	}
}
