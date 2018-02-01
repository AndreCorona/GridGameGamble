package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		menu();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void menu(){
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 300, 300);
		Stage menuStage = new Stage();
		menuStage.setScene(scene);
		menuStage.show();
		
		Label label = new Label("Welcome to Andre and Patrick's\n		Minigames!");
		label.setStyle("-fx-font: 18 Arial");
		label.setLayoutX(20);
		label.setLayoutY(50);
		
		Button game1 = new Button("Play Tic Tac Toe");
		game1.setStyle("-fx-font: 18 Arial");
		game1.setLayoutX(70);
		game1.setLayoutY(150);
		
		Button game2 = new Button("Play MineSweeper");
		game2.setStyle("-fx-font: 18 Arial");
		game2.setLayoutX(62);
		game2.setLayoutY(190);
		
		pane.getChildren().addAll(label, game1, game2);

		game1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				TicTacToe tictactoe = new TicTacToe();
			}
		});
		
		game2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Minesweeper minesweeper = new Minesweeper();
			}
		});
		

	}
		
	
}