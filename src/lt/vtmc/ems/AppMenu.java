package lt.vtmc.ems;

import java.util.Scanner;

public class AppMenu {
    private char exit;
    private Scanner input = new Scanner(System.in);

    public void mainMenu(){
        while (exit != 'y') {
            System.out.println("Simple Java calculator ver. 1.0");
            System.out.println("Input 2 numbers");
            int x = Integer.parseInt(input.next());
            int y = Integer.parseInt(input.next());
            System.out.println("Input operator");
            char op = input.next().charAt(0);
            try{
            	System.out.println("Result: " + arithmeticCalculate(x, y, op));
            }
            catch(IllegalArgumentException e) {
            	System.out.println("Cannot divide by zero! Resetting...");
            }
            catch(Exception e) {
            	System.out.println("Operator not recognized. Resetting...");
            }
            exitMenu();
        }
    }

    private int readNumber() {
    	return Integer.parseInt(input.next());
    }
    
    private int arithmeticCalculate(int x, int y, char op) throws Exception {
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
        case '%':
        	if(y != 0)
        		z = x % y;
        	else throw new IllegalArgumentException("Cannot divide by zero!");
        	break;
        default:
        	throw new Exception("Operator not recognized");
        }
        return z;
    }

    private void exitMenu(){
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
