import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int numOfGames = 0, ComputerWins = 0, UserWins = 0, Ties = 0;     //variable declarations

        System.out.println("How many times would you like to play Rock, Paper, Scissors?");

        /*While loop will run infinitely, outputting a string requesting
        an integer, until user enters an integer. Gets new input from user
        and checks if its int after each iteration. */
        while(true) {                                                                                    
            System.out.print("Please enter an integer: ");

            if (sc.hasNextInt()) {
                numOfGames = sc.nextInt();
                sc.nextLine();   //skips to next line to continue flow of requests after this.
                break;
            }
            sc.next();
        }


        for (int i = 0; i < numOfGames; i++) {    
            String usersMove = usersMove(sc);       //passes result of classes to a set String 
            String computersMove = computersMove(); //to retain the same result.

            System.out.println("\nYou chose: " + usersMove);
            System.out.println("Computer chose: " + computersMove);  //Gives the user both moves

            String result = decideWinner(usersMove, computersMove);
            System.out.println(result);                              //calls class to decide winner and displays result.

            if (result.equals("\nComputer wins")) {       
                ComputerWins++;                                    
            }

            else if (result.equals("\nYou win!")) {        
                UserWins++;
            }

            else {
                Ties++;
            }                                                      //if else statements to keep track of every result.
        }
        sc.close();

        System.out.println("\nComputers wins: " + ComputerWins + "\nYour wins: " + UserWins + "\nTies: " + Ties); //output final results.
    }

    /*Similar to number of games request, this class just runs a while loop until user
     * inputs rock, paper or scissors. If they dont, it declares their input invalid
     * and requests another input.Once input equals rock, paper or scisors it returns input.
     */
    public static String usersMove(Scanner sc) {
        String userchoice;  

        while (true) {
            System.out.print("\nRock, Paper or Scissors? Enter your choice: ");
            userchoice = sc.nextLine().toLowerCase(); //lowercase to prevent .equals() issues

            if (userchoice.equals("rock") || userchoice.equals("paper") || userchoice.equals("scissors")){
                return userchoice;
            }

            else {
                System.out.println("Invalid. Please only write either rock, paper, or scissors");
            }
        }
    }

    /*declares a random between 0 and 2 inclusive, and a switch statment to
    assign rock, paper, scissors to the values 0, 1, 2. It then returns the random
    numbers corresponding string.
     */
    public static String computersMove() {
        Random random = new Random();
        int randomValue = random.nextInt(3);

        switch (randomValue) {   
            case 0:
                return "rock";
            case 1:  
                return "paper";
            case 2: 
                return "scissors";
            default:       
                break;
        }
        return "";  //fulfill class return requirement
    }

    /*Tskes in the users and computers moves from the previous, corresponding classes. 
    Checks every possible avenue of victory for the computer, and returns String computer wins 
    if any are true. It then does the same for a Tie. Finally, if neither of these are true, 
    it will return the only other possible result; the users victory. 
     */
    public static String decideWinner(String usersMove, String computersMove) {

       if (usersMove.equals("rock") && computersMove.equals("paper") ||
        usersMove.equals("paper") && computersMove.equals("scissors") ||
        usersMove.equals("scissors") && computersMove.equals("rock")) 
        {
        return "\nComputer wins";
       }

       else if (usersMove.equals(computersMove)) {
        return "\nIt's a draw";
       }

       else {
        return "\nYou win!";
       }
    }
}




