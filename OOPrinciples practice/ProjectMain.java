

// This is the main class of the whole project
// Please run this main method for the whole program to work

// Author: Pawel Stroka
// Date: 07/12/2022
// Class: SD2-B
// StudentNo: R00198912
import java.util.Scanner;
public class ProjectMain extends Console
{   
    
    // This main method prints the menu to the user and requests an input of a number from 1-9 inclusive.
    // If the user enters wrong number, the menu restarts
    // after any option is completed, the menu restarts again
    // The program keeps running until the user enters '9' to quit.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        char choice = displayMenu();
    
        do {
            switch (choice) {
                case '1':
                    option1();
                    break;
                case '2':
                    option2();
                    break;
                case '3':
                    option3();
                    break;
                case '4':
                    option4();
                    break;
                case '5':
                    option5();
                    break;
                case '6':
                    option6();
                    break;
                case '7':
                    option7();
                    break;
                case '8':
                    option8();
                    break;
                case '9':
                    System.out.println("Program exiting... Have a nice day!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
                
            }
            if (quit != true) {
                choice = displayMenu();
            }
        
        } while (choice != '9');
        
    }
}
