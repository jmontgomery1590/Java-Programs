package help;

public class Help {
	
	void helpOn(int choice) {
		switch (choice) {
			case '1' -> {
				System.out.println("The if:\n");
				System.out.println("if(condition) statement;");
				System.out.println("else statement;");
			}
			case '2' -> {
				System.out.println("The traditional switch:\n");
				System.out.println("Switch(expression) {");
				System.out.println("  case constant:");
				System.out.println("    statement sequence");
				System.out.println("    break;");
				System.out.println("  // ...");
				System.out.println("}");
			}
			case '3' -> {
				System.out.println("The for:\n");
				System.out.println("for(init; condition; iteration)");
				System.out.println("  statement;");
			}
			case '4' -> {
				System.out.println("The while:\n");
				System.out.println("while(condition) statement;");
			}
			case '5' -> {
				System.out.println("The do-while:\n");
				System.out.println("do {");
				System.out.println("  statement;");
				System.out.println("} while (condition);");
			}
			case '6' -> {
				System.out.println("The break:\n");
				System.out.println("break; or break label;");
			}
			case '7' -> {
				System.out.println("The continue:\n");
				System.out.println("continue; or continue label;");
			}
		}
		System.out.println();
	}
	
	void menu() {
		System.out.println("Help on: ");
		System.out.println("1. if");
		System.out.println("2. switch");
		System.out.println("3. for");
		System.out.println("4. while");
		System.out.println("5. do-while");
		System.out.println("6. break");
		System.out.println("7. continue\n");
		System.out.println("Choose one (q to quit): ");
	}
	
	boolean validChoice(int ch) {
		if (ch < '1' | ch > '7' & ch != 'q')
			return false;
		else return true;
	}
}