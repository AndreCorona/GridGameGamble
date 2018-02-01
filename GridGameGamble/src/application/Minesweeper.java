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
	// just a number code to show that there is a MINE
	private final int MINE = 10;

	//Grid Buttons
	Button[][] Cell = new Button[ROWS][COLUMNS];
	//keep track of the mines in the grid
	int[][] counts = new int[ROWS][COLUMNS];

	public Minesweeper(){
		//GridPane lays out its children within a flexible grid of rows and columns
		GridPane grid = new GridPane();

		// initialize the buttons
		for(int i = 0; i < Cell.length; i++){
			for(int j = 0; j < Cell.length; j++){
				Cell[i][j] = new Button(); //create button
				Cell[i][j].setMinSize(w, w); //default size of the button
				// set up eventhandler for every button
				Cell[i][j].setOnAction(new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent e) {
						setMouseEvents(e);
					}
				});
				grid.add(Cell[i][j], i, j); //add button
			}
		}
		
		// randomly set up the mines
		createMines();

		// set up the scene and the stage
		Scene scene1 = new Scene(grid, w * ROWS, w * COLUMNS); //500*500
		Stage stage = new Stage();
		stage.setScene(scene1);
		stage.show();
	}

	public void createMines(){
		// store all the positions in an arraylist
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < counts.length; i++){
			for(int j = 0; j < counts.length; j++){
				list.add(i * 100 + j);
			}
		}
		// randomly pick 10 of them
		for(int i = 0; i < 10; i++){
			//randomly select a position
			int choice = (int)(Math.random() * list.size()); 
			int r = list.get(choice) / 100; // the row
			int c = list.get(choice) % 100; // the coloumn 
			counts[r][c] = MINE; 
			list.remove(choice); // remove to avoid picking again
		}
		// initialize the neighbour count
		for(int x = 0; x < counts.length; x++){
			for(int y = 0; y < counts.length; y++){
				// check if it is a mine
				if(counts[x][y] != MINE){ 
					int neighbourcount = 0;
					//top left
					if(x > 0 && y > 0 && counts[x-1][y-1] == MINE){ 
						neighbourcount++;
					}
					//top
					if(y > 0 && counts[x][y-1] == MINE){ 
						neighbourcount++;
					}
					//top right
					if(x < counts.length - 1 && y > 0 && counts[x+1][y-1] == MINE){ 
						neighbourcount++;
					}
					//left
					if(x > 0 && counts[x-1][y] == MINE){ 
						neighbourcount++;
					}
					//right
					if(x < counts.length - 1 && counts[x+1][y] == MINE){ 
						neighbourcount++;
					}
					//bottom left
					if(x > 0 && y < counts.length - 1 && counts[x-1][y+1] == MINE){ 
						neighbourcount++;
					}
					//bottom
					if(y < counts.length - 1 && counts[x][y+1] == MINE){ 
						neighbourcount++;
					}
					//bottom right
					if(x < counts.length - 1 && y < counts.length - 1 && counts[x+1][y+1] == MINE){ 
						neighbourcount++;
					}
					counts[x][y] = neighbourcount;
				}
			}
		}
	}

	public void clear(ArrayList<Integer> toClear){
		if(toClear.size() == 0){
			return; // base case for recursion
		}else{
			int x = toClear.get(0) / 100;
			int y = toClear.get(0) % 100;
			toClear.remove(0);
			// clear the mines
			if(counts[x][y] == 0){
				//top left
				if(x > 0 && y > 0 && !Cell[x-1][y-1].isDisable()){ 
					Cell[x-1][y-1].setText(counts[x-1][y-1] + "");
					Cell[x-1][y-1].setDisable(true);
					if(counts[x-1][y-1] == 0){
						toClear.add((x-1)*100 + (y-1));
					}
				}
				//top
				if(y > 0 && !Cell[x][y-1].isDisable()){ 
					Cell[x][y-1].setText(counts[x][y-1] + "");
					Cell[x][y-1].setDisable(true);
					if(counts[x][y-1] == 0){
						toClear.add(x*100 + (y-1));
					}
				}
				//top right
				if(x < counts.length - 1 && y > 0 && !Cell[x+1][y-1].isDisable()){ 
					Cell[x+1][y-1].setText(counts[x+1][y-1] + "");
					Cell[x+1][y-1].setDisable(true);
					if(counts[x+1][y-1] == 0){
						toClear.add((x+1)*100 + (y-1));
					}
				}
				//left
				if(x > 0 && !Cell[x-1][y].isDisable()){ 
					Cell[x-1][y].setText(counts[x-1][y] + "");
					Cell[x-1][y].setDisable(true);
					if(counts[x-1][y] == 0){
						toClear.add((x-1)*100 + y);
					}
				}
				//right
				if(x < counts.length - 1 && !Cell[x+1][y].isDisable()){ 
					Cell[x+1][y].setText(counts[x+1][y] + "");
					Cell[x+1][y].setDisable(true);
					if(counts[x+1][y] == 0){
						toClear.add((x+1)*100 + y);
					}
				}
				//bottom right
				if(x > 0 && y < counts.length - 1 && !Cell[x-1][y+1].isDisable()){ 
					Cell[x-1][y+1].setText(counts[x-1][y+1] + "");
					Cell[x-1][y+1].setDisable(true);
					if(counts[x-1][y+1] == 0){
						toClear.add((x-1)*100 + (y+1));
					}
				}
				//bottom
				if(y < counts.length - 1 && !Cell[x][y+1].isDisable()){ 
					Cell[x][y+1].setText(counts[x][y+1] + "");
					Cell[x][y+1].setDisable(true);
					if(counts[x][y+1] == 0){
						toClear.add((x)*100 + (y+1));
					}
				}
				//bottom right
				if(x < counts.length - 1 && y < counts.length - 1 && !Cell[x+1][y+1].isDisable()){ 
					Cell[x+1][y+1].setText(counts[x+1][y+1] + "");
					Cell[x+1][y+1].setDisable(true);
					if(counts[x+1][y+1] == 0){
						toClear.add((x+1)*100 + (y+1));
					}
				}
			}
			// recursion, similar to induction, iterate every mines
			// I know there are other methods but this is the only way I could understand...
			clear(toClear); 
		}

	}
	// check whether you win or not
	public void isWon(){
		boolean won = true;
		for(int x = 0; x < Cell.length; x++){
			for(int y = 0; y < Cell[x].length; y++){
				// if there is still cell with no mines left, game continues
				if(counts[x][y] != MINE && !Cell[x][y].isDisabled()){
					won = false;
				}
			}
		}
		if(won){
			for(int x = 0; x < Cell.length; x++){
				for(int y = 0; y < Cell[x].length; y++){
					// disable the button since the game ends
					Cell[x][y].setDisable(true);
					// color all the mine
					if(counts[x][y] == MINE){
						Cell[x][y].setStyle("-fx-background-color: #00ff00; ");
					}
				}
			}
			System.out.println("you win");
		}
	}

	// when you click on a mine, you lost the game
	// The button freezes when the game ends
	public void lostGame(){
		for(int x = 0; x < Cell.length; x++){
			for(int y = 0; y < Cell[x].length; y++){
				if(!Cell[x][y].isDisable()){
					if(counts[x][y] != MINE){
						// if it is not a mine, shows the number of mines around it
						Cell[x][y].setText(counts[x][y] + ""); 
						// disable the button
						Cell[x][y].setDisable(true);
					}else{
						// use "X" to indicate a mine
						Cell[x][y].setText("X"); 
						// set the color of the mine to black
						Cell[x][y].setTextFill(Color.BLACK);
						// set the background of the button be red
						Cell[x][y].setStyle("-fx-background-color: #ff0000; ");
						// disable the button
						Cell[x][y].setDisable(true);
					}
				}
			}
		}
		System.out.println("You lose");
	}
	// my event handler
	public void setMouseEvents(ActionEvent event){ 
		for(int i = 0; i < Cell.length; i++){
			for(int j = 0; j < Cell[i].length; j++){
				if(event.getSource().equals(Cell[i][j])){
					// check whether the mouse click lands on a mine
					if(counts[i][j] == MINE){
						// use "X" to indicate a mine
						Cell[i][j].setText("X"); 
						// set the color of the mine to black
						Cell[i][j].setTextFill(Color.BLACK);
						// set the background of the button be red
						Cell[i][j].setStyle("-fx-background-color: #ff0000; ");
						lostGame();
					}
					// check whether all of the grid does not have the mind has been revealed
					else if(counts[i][j] == 0){
						Cell[i][j].setText(counts[i][j] + "");
						Cell[i][j].setDisable(true);
						ArrayList<Integer> toClear = new ArrayList<Integer>();
						// set up all the mind to clear
						toClear.add(i*100+j);
						// use recursion to clear the blank
						clear(toClear);
						isWon();
					}else{
						Cell[i][j].setText(counts[i][j] + ""); // switch to String for the button
						Cell[i][j].setDisable(true); // disable to click again
						isWon();
					}
				}
			}
		}
	}
	public static void main(String[] arg){
		// empty
	}
}
