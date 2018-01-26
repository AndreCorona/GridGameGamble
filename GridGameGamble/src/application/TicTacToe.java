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

		Scene scene1 = new Scene(grid);
		Stage stage = new Stage();
		stage.setScene(scene1);
		stage.show();


		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b1, 0);
			}
		});

		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b2, 1);
			}
		});

		b3.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b3, 2);
			}
		});

		b4.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b4, 3);
			}
		});

		b5.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b5, 4);
			}
		});

		b6.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b6, 5);
			}
		});

		b7.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b7, 6);
			}
		});

		b8.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b8, 7);
			}
		});

		b9.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				clickButton(b9, 8);		
			}
		});


	}

	@Override
	public void clickButton(Button b, int butNum) {
		Button but = b;

		if (clicked[butNum] == false) {
			if(turnCount % 2 == 0) {
				b.setTextFill(Color.RED);
				b.setText("x");
				buttonStatus[butNum] = 1;
			}
			else {
				b.setTextFill(Color.BLUE);
				b.setText("o");
				buttonStatus[butNum] = 2;
			}
			turnCount++;
			clicked[butNum] = true;
			hasWon();
			
		}


	}


	public void hasWon(){	//This if statement includes all 8 winning conditions in Tic Tac Toe
		if(buttonStatus[0] == buttonStatus[1] && buttonStatus[1] == buttonStatus[2] && buttonStatus[0] != 0
				|| buttonStatus[3] == buttonStatus[4] && buttonStatus[4] == buttonStatus[5] && buttonStatus[3] != 0
				|| buttonStatus[6] == buttonStatus[7] && buttonStatus[7] == buttonStatus[8] && buttonStatus[6] != 0
				|| buttonStatus[0] == buttonStatus[3] && buttonStatus[3] == buttonStatus[6] && buttonStatus[0] != 0
				|| buttonStatus[1] == buttonStatus[4] && buttonStatus[4] == buttonStatus[7] && buttonStatus[1] != 0
				|| buttonStatus[2] == buttonStatus[5] && buttonStatus[5] == buttonStatus[8] && buttonStatus[2] != 0
				|| buttonStatus[0] == buttonStatus[4] && buttonStatus[4] == buttonStatus[8] && buttonStatus[0] != 0
				|| buttonStatus[2] == buttonStatus[4] && buttonStatus[4] == buttonStatus[6] && buttonStatus[2] != 0) {

			if(turnCount % 2 == 0){
				System.out.println("O Wins");
			}
			else{
				System.out.println("X Wins");
			}
		}

	}
	
}