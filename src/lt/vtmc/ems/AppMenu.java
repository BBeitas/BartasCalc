package lt.vtmc.ems;

import java.util.Scanner;

public class AppMenu {
    private char exit;
    private Scanner input = new Scanner(System.in);

    public void mainMenu() throws Exception {
        // TODO
        while (exit != 'y') {
            System.out.println("Simple Java calculator ver. 1.0");
            arithmeticCalculateMenu();
            exitMenu();
        }
    }

    private void arithmeticCalculateMenu() throws Exception {
        // TODO
        System.out.print("First number: ");
        int x = Integer.parseInt(input.next());
        System.out.print("Second number: ");
        int y = Integer.parseInt(input.next());
        System.out.print("Operator: ");
        char op = input.next().charAt(0);

        int z = 0;

        if (op == '+') {
            z = x + y;
        } else if (op == '-') {
            z = x - y;
        } else if (op == '*') {
            z = x * y;
        } else if (op == '/') {
            z = x / y;
        } else {
            throw new Exception("Operator not recognized");
        }
        System.out.println("Result: " + z);
    }

    private void exitMenu() throws Exception{
        // TODO
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
