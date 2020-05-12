package lt.vtmc.ems;

import java.util.Scanner;

public class AppMenu {
    private char exit;
    private Scanner input = new Scanner(System.in);

    public void mainMenu() throws Exception {
        while (exit != 'y') {
            System.out.println("Simple Java calculator ver. 1.0");
            arithmeticCalculateMenu();
            exitMenu();
        }
    }

    private void arithmeticCalculateMenu() throws Exception {
        System.out.print("First number: ");
        int x = Integer.parseInt(input.next());
        System.out.print("Second number: ");
        int y = Integer.parseInt(input.next());
        System.out.print("Operator: ");
        char op = input.next().charAt(0);

        int z = 0;

        switch(op) {
        case '+':
        	z = x + y;
        	break;
        case '-':
        	z = x - y;
        	break;
        case '*':
        	z = x * y;
        	break;
        case '/':
        	if(y != 0)
        		z = x / y;
        	else throw new IllegalArgumentException("Cannot divide by zero!");
        	break;
        default:
        	throw new Exception("Operator not recognized");
        }
        System.out.println("Result: " + z);
    }

    private void exitMenu() throws Exception{
        System.out.println("Continue (y/n): ");
        String read = input.next().toLowerCase();
        char close = read.charAt(0);
        switch (close) {
            case 'y':
                exit = 'n';
                mainMenu();
                break;
            case 'n':
                exit = 'y';
                System.out.println("Good luck!");
                break;
            default:
                System.out.println("Wrong symbol!");
                exit = 'n';
                mainMenu();
                break;
        }
    }
}
