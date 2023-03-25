package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinNumberOfSquares {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(Solution.minCount(n));
    }
    
    public class Solution {
    	
    	public static int minno(int n) {
    		if(n==0) {
    			return 0;
    		}
    		
    		int min=Integer.MAX_VALUE;
    		for(int i=1;i*i<=n;i++) {
    			int output=minno(n-i*i);
    			if(min>output) {
    				min=output;
    			}
    		}
    	    		
    		return 1+min;
    	}
    	
    	public static int minnoDP(int n, int dp[]) {
    		if(n==0) {
    			return 0;
    		}
    		
    		int min=Integer.MAX_VALUE;
    		for(int i=1;i*i<=n;i++) {
    			int output;
    			if(dp[n-i*i]==-1) {
    				output=minnoDP(n-i*i,dp);
    				dp[n-i*i]=output;
    			}else {
    				output=dp[n-i*i];
    			}
    			
    			if(min>output) {
    				min=output;
    			}
    		}
    	    		
    		return 1+min;
    	}

    	public static int minCount(int n) {
    		//Your code goes here
    		
    		int dp[]=new int[n+1];
    		for(int i=0;i<dp.length;i++) {
    			dp[i]=-1;
    		}
    		int output=minnoDP(n, dp);
    		return output;
    	}

    }
}