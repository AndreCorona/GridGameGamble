package application;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Minesweeper extends Cell{
	// initialize the rows and columns
	private final int ROWS = 10;
	private final int COLUMNS = 10;
	// initialize the width of each grid
	private final int w = 50;
	// number of mines
	private final int mines = 10;
	
	//Grid Buttons
	Button[][] Cell = new Button[ROWS][COLUMNS];
	//keep track of the mines in the grid
	int[][] counts = new int[ROWS][COLUMNS];
	
	public Minesweeper(){
		//GridPane lays out its children within a flexible grid of rows and columns
		GridPane grid = new GridPane();
		
		for(int i = 0; i < Cell.length; i++){
			for(int j = 0; j < Cell.length; j++){
				Cell[i][j] = new Button(); //create button
				Cell[i][j].setMinSize(w, w); //default size of the button
				// Cell[i][j].setStyle("-fx-background-color: #00ff00");
				grid.add(Cell[i][j], i, j); //add button
			}
		}
		
		// set up the scene and the stage
		Scene scene1 = new Scene(grid, w * ROWS, w * COLUMNS); //500*500
		Stage stage = new Stage();
		stage.setScene(scene1);
		stage.show();
	}
	
	public void createMines(){
		
	}
	
	public static void main(String[] arg){
		// empty
	}
}
