import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class MyATM extends Application {
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("ATM");
            ATMLogin AtmLogin = new ATMLogin(primaryStage);
            ATMHome AtmHome = new ATMHome(primaryStage);
            DataInput dataInput = new DataInput(primaryStage);
            User client = new User();
            //int index = client.getTransindex();
            client.setBalance(0);
            //AtmHome.setIndex(index);
            AtmLogin.prepareScene();
            AtmHome.prepareScene();
            dataInput.prepareScene();
            dataInput.setAtmHome(AtmHome);
            AtmHome.setAtmLogin(AtmLogin);
            AtmHome.setDataInput(dataInput);
            AtmLogin.setAtmHome(AtmHome);
            AtmHome.setUser(client);
            AtmLogin.setUser(client);
            dataInput.setUser(client);
            primaryStage.setScene(AtmLogin.getScene());
            primaryStage.show();
	}
}