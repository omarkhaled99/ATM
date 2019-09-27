
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ATMHome {
	Scene scene;
    ATMLogin AtmLogin;
    Stage stage;
    User client;
    DataInput datainput;
    int index =-1;
    public ATMHome(Stage stage) {
    	this.stage = stage;
    }
    public void prepareScene() {
    	
    //	Label TransactionType = new Label();
    	Label accountDataLabel = new Label();
    	Button deposit = new Button(" DEPOSIT");
    	Button withdraw = new Button("WITHDRAW");
    	Button inquire = new Button(" INQUIRE");
    	Button next = new Button("   NEXT   ");
    	Button previous = new Button(" PREVIOUS  ");
        GridPane grid = new GridPane();
       // grid.add(TransactionType, 1, 0);
        grid.add(accountDataLabel, 1, 1);
        grid.add(deposit, 0, 2);
        grid.add(withdraw, 2, 2);
        grid.add(next, 0, 3);
        grid.add(previous, 2, 3);
        grid.add(inquire, 1, 4);
        inquire.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				accountDataLabel.setText("YOUR BALANCE IS:\n"+String.format("%10.2f",client.inquiry()));
				index++;
				//TransactionType.setText("  INQUIRY");
				//System.out.println(Arrays.toString(client.history().get(transindex)));
			}
		});
        deposit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(datainput.getScene());
				//client.deposit(Double.parseDouble(datainput.getInput()));
				datainput.setTitle("deposit");
				index++;
			}
		});
        
        withdraw.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.setScene(datainput.getScene());
				datainput.setTitle("withdraw");
				index++;
				//client.withdraw(Double.parseDouble(datainput.getInput()));//always return late a time as it happen during event of clicking withdraw
			}
		});
        
        next.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
		           if(index >4)
					{System.out.println("errror");
					 index=4;}
		            else if(index<0){
		                     index=0;        	
					}
		            while(index>=client.getTranssize()-1)
					{
						index--;
					}
		          if(index!=4&&index>-1)  
				accountDataLabel.setText("HISTORY\n"+(client.history())[++index]);
					
				
			}
			
		});
        previous.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if(index <0)
				{
				index=0;
				}
			
				 while(index>client.getTranssize())
					{
						index--;
						accountDataLabel.setText("no more to show");
					}
				 if(index!=0)
				accountDataLabel.setText("HISTORY\n"+(client.history())[--index]);
				
			}
		});
        scene = new Scene(grid,400,300);
    
    }
    public Scene getScene() {
    	return this.scene;
    }
    public void setAtmLogin(ATMLogin AtmLogin) {
    	this.AtmLogin = AtmLogin;
    }
    public void setDataInput(DataInput datainput) {
    this.datainput=datainput;
    }
    public void setUser(User client) {
    	this.client=client;
    }
	
    
}
