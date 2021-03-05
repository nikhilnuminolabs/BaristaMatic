package baristamatic;

import java.util.Scanner;

import baristamatic.process.Initializer;
import baristamatic.process.Process;


public class ApplicationStartUp {

	public static void main(String[] args) {

		Process process = new Process();

		Initializer initializer = new Initializer();

		// initializing the Process.class object with predefine values
		initializer.initializeObject(process);

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
				
				if(inputString.equalsIgnoreCase("r"))
				{
					// restoring the Ingredients inventory stock
					process.restockInventry();
				}				
				else if(inputString.equalsIgnoreCase("q"))
				{
					break;
				}	
				else if(inputString.matches("\\d+"))
				{
					// dispensing the drink
					process.drinkDispens(inputString);
				}			
				else {
					process.invalidDataMessage(inputString);
				}
			}

		}while(true);

	}
}
