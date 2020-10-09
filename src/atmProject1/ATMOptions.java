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
	
	
	public void getLogin() throws IOException {
		int x = 1;
	
		do {
			try {
				data.put(12345678,1234);
				
				setAccNumber(input.nextInt());
				setAccPin(input.nextInt());
			}
			catch (Exception e) {
				System.out.println("Please enter valid values for the account.");
				x=2;
			}
			for (Entry<Integer, Integer> entry: data.entrySet()) {
				if(entry.getKey() == getAccNumber() && entry.getValue() == getAccPin()) {
					chooseAccount();
				}
			}
		}while(x==1);
	}
	
	public void chooseAccount() {
		//1 - Checking Account
		//2 - Saving Account
		//3 - Exit
		
		int choice = input.nextInt();
		
		switch(choice) {
			case 1:
				getChecking();
				break;
			case 2:
				getSaving();
				break;
			case 3:
				break;
			default:
				System.out.println("Please choose from the options");
		}
	}
	
	public void getChecking() {
		// 1 - Check balance
		// 2 - Make Withdrawal
		// 3 - Make Deposit
		// 4 - Exit
		// 5 - Make a transfer (needs to be implemented)
		
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			getCheckingBalance();
			break;
		case 2:
			getCheckWithdrawInput();
			break;
		case 3:
			getCheckDepositInput();
			break;
		case 4:
			break;
		default:
			System.out.println("Please choose a valid option");
			break;
			
		}
	}
	
	public void getSaving() {
		// 1 - Check balance
		// 2 - Make Withdrawal
		// 3 - Make Deposit
		// 4 - Exit
		// 5 - Make a transfer
		
		int choice = input.nextInt();
		
		switch(choice) {
		case 1:
			getSavingBalance();
			break;
		case 2:
			getSavingWithdrawInput();
			break;
		case 3:
			getSavingDepositInput();
			break;
		case 4:
			break;
		default:
			System.out.println("Please choose a valid option");
			break;		
		}
	}
	
}
	
