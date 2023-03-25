package DynamicProgramming;

public class CoinTowerRecursive {

    // Declare constants for A and B
    public static final int A = 3;
    public static final int B = 4;

    // Declare a function FIND_WINNER() which takes an argument ‘NO_OF_COINS’,
    // representing the coins we have initially and it returns true if a player
    // starting the game with ‘NO_OF_COINS’ coins will win, otherwise, it returns false.
    public static boolean findWinner(int noOfCoins) {
        // If ‘NO_OF_COINS’ = 0, then return false, since we don’t have any coins.
    	//System.out.println("No of Coins-"+noOfCoins);
    	
        if (noOfCoins == 0) {
            return false;
        }

        // Declare a boolean variable ‘ANS’ to false.
        boolean ans = false;

        // Finally, try all three options.

        // If, ‘NO_OF_COINS >= A’, initialize ‘ANS’ to true if the value returned by
        // FIND_WINNER(NO_OF_COINS - A) is false.
        if (noOfCoins >= A && !findWinner(noOfCoins - A)) {
            ans = true;
        }

        // If ‘NO_OF_COINS’ >= ‘B’, set ‘ANS’ to true if the value returned by
        // FIND_WINNER(NO_OF_COINS - B) is false.
        if (noOfCoins >= B && !findWinner(noOfCoins - B)) {
            ans = true;
        }

        // If ‘NO_OF_COINS’ >= 1, set ‘ANS’ to true if the value returned by
        // FIND_WINNER(NO_OF_COINS - 1) is false.
        if (noOfCoins >= 1 && !findWinner(noOfCoins - 1)) {
            ans = true;
        }

        // Return the ‘ANS’.
        //System.out.println("Ans for noofcoins-"+noOfCoins+" is-"+ans);
        return ans;
    }

    public static void main(String[] args) {
        
       int noOfCoins = 10; 
//       System.out.println("The player who starts with " + noOfCoins + " coins will " + (findWinner(noOfCoins) ? "win" : "lose"));
       
       noOfCoins = 7; 
       System.out.println("The player who starts with " + noOfCoins + " coins will " + (findWinner(noOfCoins) ? "win" : "lose"));
       
//       noOfCoins = 8; 
//       System.out.println("The player who starts with " + noOfCoins + " coins will " + (findWinner(noOfCoins) ? "win" : "lose"));
//       
//       noOfCoins = 7; 
//       System.out.println("The player who starts with " + noOfCoins + " coins will " + (findWinner(noOfCoins) ? "win" : "lose"));
//       
//       noOfCoins = 6; 
//       System.out.println("The player who starts with " + noOfCoins + " coins will " + (findWinner(noOfCoins) ? "win" : "lose"));
       
    }
}