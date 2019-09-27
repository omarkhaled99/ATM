
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class User {
	private String name;
	private String cardNo="1234567812345678";
	private double balance;
	private int transindex=0;
	
	String[]trans;
	private Transaction transobject =new Transaction();
	public User() {
		trans= new String[5]; 
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void withdraw(double amount) {
		if(balance<=500)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("TAKE CARE");
			alert.setHeaderText("YOUR BALANCE IS LESS THEN 500");
			alert.setContentText("YOUR BALANCE IS LESS THEN 500");
			alert.showAndWait();
		}
		 if(amount>balance)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("ERROR WITHDRAWING");
			alert.setContentText("NOT ENOUGH BALANCE TO WITHDRAW");
			alert.showAndWait();
		}
		else {
		balance = balance - amount;
		transobject.setType("Withdraw");
		transobject.setValue(amount);
		if(transindex==5)
		{
			for(int i =0;i<4;i++)
			{
				trans[i]=trans[i+1];
			}
			trans[4]=transobject.toString();
		}else {
		trans[transindex++]=transobject.toString();
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("SUCCESSFUL OPERATION");
		alert.setHeaderText("WITHDRAWING DONE");
		alert.setContentText(" ");
		alert.showAndWait();
		}
	}

	public void deposit(double amount) {
		balance = balance + amount;
		transobject.setType("Deposit");
		transobject.setValue(amount);
		if(transindex==5)
		{
			for(int i =0;i<4;i++)
			{
				trans[i]=trans[i+1];
			}
			trans[4]=transobject.toString();
		}else {
		trans[transindex++]=transobject.toString();
		}
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("SUCCESSFUL OPERATION");
		alert.setHeaderText("DEPOSIT DONE");
		alert.setContentText(" ");
		alert.showAndWait();
	}

	public double inquiry() {
		transobject.setType("Inquiry");
		transobject.setValue(balance);
		if(transindex==5)
		{
			for(int i =0;i<4;i++)
			{
				trans[i]=trans[i+1];
			}
			trans[4]=transobject.toString();
		}else {
		trans[transindex++]=transobject.toString();
		}
		
		return balance;
	}

	public String[] history() {
		return trans;
	}

	public int getTranssize() {
		int counter = 0;
		for (int i = 0; i < trans.length; i ++)
		    if (trans[i] != null)
		        counter ++;
		return counter;
	}
	
}
