import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DataInput {
     String title;
     Scene scene;
     String input="0";
     Stage stage;
     ATMHome AtmHome;
     User client;
    public DataInput(Stage stage) {
    	this.stage=stage;
    }
    public void prepareScene() {
    	Label amount = new Label("Enter the amount of money");
    	TextField moneyAmount = new TextField();
    	Button save = new Button("SAVE");
    	GridPane grid = new GridPane();
    	grid.add(amount, 0, 0);
    	grid.add(moneyAmount, 0, 1);
    	grid.add(save, 0, 2);	
        save.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
              input = moneyAmount.getText();
              boolean isDouble = Pattern.matches("\\d+(\\.\\d+)?", input);
              if(isDouble)
              {
              if(title.equalsIgnoreCase("withdraw"))
              client.withdraw(Double.parseDouble(input));
		      else if(title.equalsIgnoreCase("deposit"))
	              client.deposit(Double.parseDouble(input));
              }
              else 
              {
            	Alert alert = new Alert(AlertType.WARNING);
      			alert.setTitle("Warning");
      			alert.setHeaderText("ERROR IN INPUT");
      			alert.setContentText("INVALID INPUT");
      			alert.showAndWait();
              }
              stage.setScene(AtmHome.getScene());
              
		}
	});
       
     scene = new Scene(grid,300,200);
    }
    public Scene getScene() {
    	return this.scene;
    }
    public void setAtmHome(ATMHome AtmHome) {
    	this.AtmHome = AtmHome;
    }
	public String getInput() {
		return this.input;
	}
	 public void setUser(User client) {
	    	this.client=client;
	    }
	public void setTitle(String title) {
		this.title = title;
	}
    
}