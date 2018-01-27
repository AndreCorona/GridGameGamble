package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe extends Grid{

	public int turnCount;
	public boolean[] clicked = new boolean[9];
	public int[] buttonStatus = new int[9];		//1 is x, 2 is o

	public TicTacToe() {

		Button b1 = new Button("");
		Button b2 = new Button("");
		Button b3 = new Button("");
		Button b4 = new Button("");
		Button b5 = new Button("");
		Button b6 = new Button("");
		Button b7 = new Button("");
		Button b8 = new Button("");
		Button b9 = new Button("");

		b1.setMinSize(100, 100);
		b2.setMinSize(100, 100); 
		b3.setMinSize(100, 100);
		b4.setMinSize(100, 100);
		b5.setMinSize(100, 100);
		b6.setMinSize(100, 100);
		b7.setMinSize(100, 100);
		b8.setMinSize(100, 100);
		b9.setMinSize(100, 100);

		GridPane grid = new GridPane();

		grid.add(b1, 0, 1);
		grid.add(b2, 0, 2);
		grid.add(b3, 0, 3);
		grid.add(b4, 1, 1);
		grid.add(b5, 1, 2);
		grid.add(b6, 1, 3);
		grid.add(b7, 2, 1);
		grid.add(b8, 2, 2);
		grid.add(b9, 2, 3);


		b1.setStyle("-fx-font: 48 Arial");
		b2.setStyle("-fx-font: 48 Arial");
		b3.setStyle("-fx-font: 48 Arial");
		b4.setStyle("-fx-font: 48 Arial");
		b5.setStyle("-fx-font: 48 Arial");
		b6.setStyle("-fx-font: 48 Arial");
		b7.setStyle("-fx-font: 48 Arial");
		b8.setStyle("-fx-font: 48 Arial");
		b9.setStyle("-fx-font: 48 Arial");

		Scene scene1 = new Scene(grid, 300, 400);
		Stage stage = new Stage();
		stage.setScene(scene1);
		stage.show();

		Label turn = new Label("X's turn");
		turn.setStyle("-fx-font: 20 Arial");
		turn.setMinSize(100, 100);
		grid.add(turn, 0, 4);
		
		Label win = new Label("");
		win.setStyle("-fx-font: 20 Arial");
		win.setMinSize(100, 100);
		grid.add(win, 2, 4);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b1, 0, turn, win);
			}
		});

		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b2, 1, turn, win);
			}
		});

		b3.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b3, 2, turn, win);
			}
		});

		b4.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b4, 3, turn, win);
			}
		});

		b5.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b5, 4, turn, win);
			}
		});

		b6.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b6, 5, turn, win);
			}
		});

		b7.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b7, 6, turn, win);
			}
		});

		b8.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b8, 7, turn, win);
			}
		});

		b9.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b9, 8, turn, win);		
			}
		});

	}

	@Override
	public void clickButton(Button b, int butNum, Label turn, Label win) {
		Button but = b;

		if (clicked[butNum] == false) {
			if(turnCount % 2 == 0) {
				b.setTextFill(Color.RED);
				b.setText("x");
				buttonStatus[butNum] = 1;
				turn.setText("O's Turn");
			}
			else {
				b.setTextFill(Color.BLUE);
				b.setText("o");
				buttonStatus[butNum] = 2;
				turn.setText("X's Turn");
			}
			turnCount++;
			clicked[butNum] = true;
			hasWon(win);	
		}


	}


	public void hasWon(Label win){	//This if statement includes all 8 winning conditions in Tic Tac Toe
		if(buttonStatus[0] == buttonStatus[1] && buttonStatus[1] == buttonStatus[2] && buttonStatus[0] != 0
				|| buttonStatus[3] == buttonStatus[4] && buttonStatus[4] == buttonStatus[5] && buttonStatus[3] != 0
				|| buttonStatus[6] == buttonStatus[7] && buttonStatus[7] == buttonStatus[8] && buttonStatus[6] != 0
				|| buttonStatus[0] == buttonStatus[3] && buttonStatus[3] == buttonStatus[6] && buttonStatus[0] != 0
				|| buttonStatus[1] == buttonStatus[4] && buttonStatus[4] == buttonStatus[7] && buttonStatus[1] != 0
				|| buttonStatus[2] == buttonStatus[5] && buttonStatus[5] == buttonStatus[8] && buttonStatus[2] != 0
				|| buttonStatus[0] == buttonStatus[4] && buttonStatus[4] == buttonStatus[8] && buttonStatus[0] != 0
				|| buttonStatus[2] == buttonStatus[4] && buttonStatus[4] == buttonStatus[6] && buttonStatus[2] != 0) {

			if(turnCount % 2 == 0){
				win.setText("O Wins");
				
			}
			else{
				win.setText("X Wins");
			}
			for(int i = 0; i < clicked.length; i++) {	//Sets all buttons to "clicked" so no more moves can be made
				clicked[i] = true;
			}
			
			
		}

	}
	
}