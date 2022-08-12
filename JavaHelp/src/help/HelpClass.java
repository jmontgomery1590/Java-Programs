package help;

import java.io.IOException;

public class HelpClass {

	public static void main(String[] args) throws IOException {
		char choice, ignore;
		Help helpObj = new Help();
		
		for (;;) {
			do {
				helpObj.menu();
				choice = (char) System.in.read();
				
				do {
					ignore = (char) System.in.read();
				} while (ignore != '\n');
			} while (!helpObj.validChoice(choice));
		
			if (choice  == 'q')
				break;
			
			System.out.println("");
			
			helpObj.helpOn(choice);
		}	
	}
}