package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class Grid {
	
	public int turncount;
	boolean[] clicked;
	
	public Grid(){}
	
	public Grid(int length, int width) {
	
	}
	
	public void clickButton(Button b, int butNum){}
	
}
