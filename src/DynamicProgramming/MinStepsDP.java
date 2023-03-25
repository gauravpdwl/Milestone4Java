package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsDP {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(Solution.countMinStepsToOne(n));
    }
    
    public class Solution {
    	
    	//Below Solution is using Recursive Dynamic Programming(RDP)
    	// public static int minSteps(int n, int dp[]){
    	// 		if(n==1){
        // 			return 0;
        // 		}

    	// 		int onecount=Integer.MAX_VALUE;
    	// 		if(dp[n-1]==-1){
    	// 			onecount=countMinStepsToOne(n-1);
    	// 			dp[n-1]=onecount;
    	// 		}else{
    	// 			onecount=dp[n-1];
    	// 		}

    	// 		int twocount=Integer.MAX_VALUE;
        // 		if(n%2==0){
    	// 			if(dp[n/2]==-1){
    	// 				twocount=countMinStepsToOne(n/2);
    	// 				dp[n/2]=twocount;
    	// 			}else{
    	// 				twocount=dp[n/2];
    	// 			}
        			
    	// 		}

        // 		int threecount=Integer.MAX_VALUE;
        // 		if(n%3==0){
    	// 			if(dp[n/3]==-1){
    	// 				threecount=countMinStepsToOne(n/3);
    	// 				dp[n/3]=threecount;
    	// 			}else{
    	// 				threecount=dp[n/3];
    	// 			}
        // 		}

        // 		return 1+Math.min(onecount, Math.min(twocount, threecount));
    	// }
    	
    	//Below solution is using Iterative Dynamic Programming(IDP)
    	public static int minSteps(int n){
    		if(n==1){
    			return 0;
    		}

    		int dp[]=new int[n+1];
    		dp[0]=0;
    		dp[1]=0;
    		dp[2]=1;
    		dp[3]=1;

    		for(int i=4;i<dp.length;i++){
    			int onecount=dp[i-1];

    			int twocount=Integer.MAX_VALUE;
    			if(i%2==0){
    				twocount=dp[i/2];
    			}

    			int threecount=Integer.MAX_VALUE;
    			if(i%3==0){
    				threecount=dp[i/3];
    			}

    			dp[i]=1+Math.min(onecount, Math.min(twocount, threecount));
    		}

    		return dp[n];
    	}

    	public static int countMinStepsToOne(int n) {
    		//Your code goes here
    		// int dp[]=new int[n+1];
    		// for(int i=0;i<dp.length;i++){
    		// 	dp[i]=-1;
    		// }
    		// int output=minSteps(n, dp);
    		int output=minSteps(n);
    		return output;
    	}

    }
}