package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class Cell {
	
	private final Button button = new Button();
    private boolean mine = true;
    private boolean revealed = false;

    public Cell(){
    	button.setText(" ");
    	this.revealed = false;
    }
	
    public boolean isRevealed() {
        return revealed;
    }
    
    public boolean hasMine() {
        return mine;
    }

    public void setRevealedTrue() {
        revealed = true;	
    }
}
