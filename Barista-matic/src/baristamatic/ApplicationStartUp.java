package baristamatic;

import java.util.Scanner;

import baristamatic.process.Process;
import static baristamatic.constant.InventoryConstant.*;

public class ApplicationStartUp {

	public static void main(String[] args) {

		Process process = new Process();

		Scanner scan = new Scanner(System.in);

		String inputString = null;

		process.displayOutput();

		do {

			if(inputString != null && !inputString.trim().isEmpty()) {

				// display all drinks and Ingredients inventory data
				process.displayOutput();
			}

			inputString = scan.nextLine();

			if(inputString != null && !inputString.trim().isEmpty()) {

				inputString = inputString.trim();
				
				if(inputString.equalsIgnoreCase(RESTOCK_INPUT))
				{
					// restoring the Ingredients inventory stock
					process.restockInventry();
				}				
				else if(inputString.equalsIgnoreCase(APPLICATION_QUIT_INPUT))
				{
					break;
				}	
				else if(inputString.matches("\\d+"))
				{
					// dispensing the drink
					process.drinkDispens(inputString);
				}			
				else {
					process.invalidInputMessage(inputString);
				}
			}

		}while(true);

	}
}
