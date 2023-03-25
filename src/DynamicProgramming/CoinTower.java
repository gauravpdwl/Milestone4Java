package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinTower {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            String[] strNums = br.readLine().trim().split("\\s");
            int n = Integer.parseInt(strNums[0]);
            int x = Integer.parseInt(strNums[1]);
            int y = Integer.parseInt(strNums[2]);

            System.out.println(Solution.findWinner(n, x, y));
    }
    
    public class Solution {

    	public static String findWinner(int n, int x, int y) {
    		//Your code goes here
            
    		boolean output=winner(n,x,y);
    		if(output==true) {
    			return "Player1-Beerus";
    		}else {
    			return "Player2-Whis";
    		}
            
    	}
    	
    	public static boolean winner(int n, int x, int y) {
    		if(n==0) {
    			return false;
    		}
    		
    		boolean ans=false;
    		
    		if(n>=x && !winner(n-x,x,y)) {
    			ans=true;
    		}
    		
    		if(n>=y && !winner(n-y,x,y)) {
    			ans=true;
    		}
    		
    		if(n>=1 && !winner(n-1,x,y)) {
    			ans=true;
    		}
    		
    		return ans;
    	}
    }
}