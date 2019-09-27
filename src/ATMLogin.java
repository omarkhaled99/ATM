import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ATMLogin {
	Scene scene;
	Stage stage;
	CardNoAuthentication authentication;
    ATMHome AtmHome;
    User client;
	public ATMLogin(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene() {

		authentication = new CardNoAuthentication();
		Label textField = new Label("Enter your card number: ");
		PasswordField cardnoField = new PasswordField();
		Button submit = new Button("Submit");
		Label validationlabel = new Label();
		GridPane grid = new GridPane();
		grid.add(textField, 0, 0);
		grid.add(cardnoField, 0, 1);
		grid.add(submit, 0, 2);
		grid.add(validationlabel, 0, 3);
		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
                String cardNo=cardnoField.getText();
                boolean valid =  authentication.validate(cardNo);
                if(valid) {
                	validationlabel.setText("Welcome ,sir");
                	stage.setScene(AtmHome.getScene());
                }else
                {
                	validationlabel.setText("Wrong card number");
                	validationlabel.setFont(new Font("Arial",25));
          	
                }
			}
		});
       scene = new Scene(grid,400,300);
	}
	
	public Scene getScene() {
		return this.scene;
	}
	public void setAtmHome(ATMHome AtmHome) {
		this.AtmHome =AtmHome;
	}
	 public void setUser(User client) {
	    	this.client=client;
	    }
}

