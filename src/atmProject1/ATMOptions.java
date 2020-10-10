package atmProject1;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ATMOptions extends Account {
	
	Scanner input = new Scanner(System.in);
	DecimalFormat format = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	//Method that allows user to log into their account
	public void getLogin() throws IOException {
		
		System.out.println("***************************************");
		System.out.println("Welcome to the start menu ");
		
		//Use x = 1 in the do while loop to switch it on and off
		int x = 1;
		
		//Do while loop to ensure that the ATM keeps running unless specified otherwise.
		do {
			try {
				data.put(12345678,1234);
				
				System.out.println("Please enter your account number: ");
				setAccNumber(input.nextInt());
				
				System.out.println("Please enter your pin number: ");
				setAccPin(input.nextInt());
			}
			catch (Exception e) {
				System.out.println("Please enter valid values for the account.");
				x=2;
			}
			//For each key value pair, check that it is a valid account (in the data HashMap)
			for (Entry<Integer, Integer> entry: data.entrySet()) {
				
				if(entry.getKey() == getAccNumber() && entry.getValue() == getAccPin()) {
					
					chooseAccount();
					
					System.out.println("Switch off?");
					System.out.println("0 - off");
					System.out.println("1 - on");
					int answer = input.nextInt();
					
					switch(answer) {
					case 0:
						x=0;
						System.out.println("Switching off...");
						break;
					case 1:
						x=1;
						break;
					default:
						x=0;
						break;
					}
				}
			}
		}
		while(x==1);
	}
	
	//Menu for user to select account
	public void chooseAccount() {
		//1 - Checking Account
		//2 - Saving Account
		//3 - Exit
		System.out.println("***************************************");
		System.out.print("Welcome to the options menu: ");
		System.out.println("Please select from the following options:");
		System.out.println("1 - Checking Account");
		System.out.println("2 - Saving Account");
		System.out.println("3 - Exit");
		
		int choice = input.nextInt();
		
		switch(choice) {
			case 1:
				getChecking();
				break;
			case 2:
				getSaving();
				break;
			case 3:
				System.out.println("Thank you for using this ATM.");
				break;
			default:
				System.out.println("Please choose from the options");
		}
	}
	
	//Menu for user to select actions on their account
	public void getChecking() {
		// 1 - Check balance
		// 2 - Make Withdrawal
		// 3 - Make Deposit
		// 4 - Exit
		// 5 - Make a transfer (needs to be implemented)
		System.out.println("***************************************");
		System.out.println("Welcome to the checking account menu ");
		System.out.println("Please select from the following options:");
		System.out.println("1 - Check balance");
		System.out.println("2 - Make withdrawal");
		System.out.println("3 - Make deposit");
		System.out.println("4 - Transfer to saving account");
		System.out.println("5 - Exit");
		
		int choice = input.nextInt();
		
		//Using switch statements to execute the correct code relating to user input 'choice'
		switch(choice) {
		case 1:
			getCheckingBalance();
			System.out.println("Balance: " + format.format(getCheckingBalance()));
			chooseAccount();
			break;
		case 2:
			getCheckWithdrawInput();
			chooseAccount();
			break;
		case 3:
			getCheckDepositInput();
			chooseAccount();
			break;
		case 4:
			transferFromChecking();
			chooseAccount();
			break;
		case 5:
			System.out.println("Thank you for using this ATM.");
			break;
		default:
			System.out.println("Please choose a valid option");
			break;
			
		}
	}
	
	//Menu for user to select actions on their savings account
	public void getSaving() {
		// 1 - Check balance
		// 2 - Make Withdrawal
		// 3 - Make Deposit
		// 4 - Exit
		// 5 - Make a transfer
		System.out.println("***************************************");
		System.out.println("Welcome to the saving account menu ");
		System.out.println("Please select from the following options:");
		System.out.println("1 - Check balance");
		System.out.println("2 - Make withdrawal");
		System.out.println("3 - Make deposit");
		System.out.println("4 - Transfer to saving account");
		System.out.println("5 - Exit");
		
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			getSavingBalance();
			System.out.println("Balance: " + format.format(getSavingBalance()));
			chooseAccount();
			break;
		case 2:
			getSavingWithdrawInput();
			chooseAccount();
			break;
		case 3:
			getSavingDepositInput();
			chooseAccount();
			break;
		case 4:
			transferFromSaving();
			chooseAccount();
			break;
		case 5:
			System.out.println("Thank you for using this ATM.");
			break;
		default:
			System.out.println("Please choose a valid option");
			break;		
		}
	}
}
	
