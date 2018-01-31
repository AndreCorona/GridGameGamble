package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class Cell {
	
	private final Button button = new Button();
    private boolean mine = false;
    private boolean hidden = true;

    public Cell(){
    	button.setText(" ");
    }
	
	public Cell(int length, int width) {
		
	}
	
    public void setMine() {
        
    }

    public boolean hasMine() {
        return mine;
    }

    public void reveal() {
        
    }

    public boolean isHidden() {
        return hidden;
    }
}
