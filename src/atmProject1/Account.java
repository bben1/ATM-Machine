package atmProject1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	
	Scanner input = new Scanner(System.in);
	DecimalFormat format = new DecimalFormat("'$'###,##0.00");
	
	private double checkingBalance = 0;
	private double savingBalance = 0;
	private int accountNumber = 0;
	private int accountPin = 0;
	
	public void setAccNumber(int accNumber) {
		this.accountNumber = accNumber;
		return;
	}
	
	public int getAccNumber() {
		return accountNumber;
	}
	
	public void setAccPin(int accPin) {
		this.accountPin = accPin;
		return;
	}
	
	public int getAccPin() {
		return accountPin;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingBalance() {
		return savingBalance;
	}
	
	public void calcCheckWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return;
	}
	
	public void calcCheckDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return;
	}

	public void calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return;
	}
	
	public void calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return;
	}
	
	public void getCheckWithdrawInput() {
		Double amount = input.nextDouble();
		if (amount <= checkingBalance) {
			calcCheckWithdraw(amount);
			System.out.println("New balance: " + format.format(getCheckingBalance()));
		}
		else {
			System.out.println("Insufficient funds, current balance: " + format.format(getCheckingBalance()));
		}
	}
	
	public void getCheckDepositInput() {
		Double amount = input.nextDouble();
		if (amount>0) {
			calcCheckDeposit(amount);
			System.out.println("New balance: " + format.format(getCheckingBalance()));
		}
		else {
			System.out.println("Please deposit a valid amount.");
		}
	}
	
	public void getSavingWithdrawInput() {
		Double amount = input.nextDouble();
		if(amount<=getSavingBalance()) {
			calcSavingWithdraw(amount);
			System.out.println("New balance: " + format.format(getSavingBalance()));
		}
		else {
			System.out.println("Insufficient funds, current balance: " + format.format(getSavingBalance()));
		}
	}
	
	public void getSavingDepositInput() {
		Double amount = input.nextDouble();
		if (amount > 0) {
			calcSavingDeposit(amount);
			System.out.println("New balance: " + format.format(getSavingBalance()));
		}
		else {
			System.out.println("Please deposit a valid amount.");
		}
		
	}

}

