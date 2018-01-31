package application;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Minesweeper {
	// initialize the rows and columns plus the width of each square
	private final int ROWS = 10;
	private final int COLUMNS = 10;
	private final int w = 20;
	
	//Grid Buttons
	Button[][] field = new Button[ROWS][COLUMNS];
	//keep track of the mines in the grid
	int[][] counts = new int[ROWS][COLUMNS];
	
	public Minesweeper(){
		//GridPane lays out its children within a flexible grid of rows and columns
		GridPane grid = new GridPane();
		grid.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
	    grid.getColumnConstraints().add(new ColumnConstraints(200)); // column 1 is 200 wide
		
		for(int i = 0; i < field.length; i++){
			for(int j = 0; j < field.length; j++){
				field[i][j] = new Button();
				grid.add(field[i][j], i, j);
			}
		}
		
		// set up the scene and the stage
				Scene scene1 = new Scene(grid, 300, 300);
				Stage stage = new Stage();
				stage.setScene(scene1);
				stage.show();
	}
	
	public void createMines(){
		
	}
	public static void main(String[] arg){
		new Minesweeper();
	}
}
