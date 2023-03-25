package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class staricase {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(Solution.staircase(n));
            System.out.println(Solution.countWays(n));
    }
    
    
	
	public class Solution {

//		public static long staircase(int n) {
//			//Your code goes here
//	        
//			long steps[] = new long[n + 1];
//			steps[0]=1;
//			if(n>0)
//				steps[1]=1;
//			if(n>1)
//				steps[2]=2;
//			if(n>2)
//				steps[3]=4;
//			for(int i=4;i<=n;i++){
//				long count1,count2 = 0, count3 = 0;
//				count1 = steps[i-1]; 
//				count2 = steps[i-2]; 
//				count3 = steps[i-3];  
//				steps[i] = count1+count2+count3;
//			}
//			return steps[n];
//	        
//		}
		
		public static long countWays(int n)
	    {
	        long[] res = new long[n + 1];
	        res[0] = 1;
	        res[1] = 1;
	        res[2] = 2;
	 
	        for (int i = 3; i <= n; i++)
	            res[i] = res[i - 1] + res[i - 2] + res[i - 3];
	 
	        return res[n];
	    }
		
		//my version of solution which is not accepted by test case....
		public static long calculate(int n, long dp[]){

			if(n==0){
				return 1;
			}

			if(n<0){
				return 0;
			}

			long one;
			if(n-1>=0){
				one=dp[n-1];
				if(one==-1){
					one=calculate(n-1, dp);
					dp[n-1]=one;
				}
			}else{
				one=calculate(n-1, dp);
			}
			
			long two;
			if(n-2>=0){
				two=dp[n-2];
				if(two==-1){
					two=calculate(n-2, dp);
					dp[n-2]=two;
				}
			}else{
				two=calculate(n-2,dp);
			}
			
			long three;
			if(n-3>=0){
				three=dp[n-3];
				if(three==-1){
					three=calculate(n-3, dp);
					dp[n-3]=three;
				}
			}else{
				three=calculate(n-3, dp);
			}

			return one+two+three;
		}

		 public static long staircase(int n) {
		 	//Your code goes here
			

		 	long dp[]=new long[n+1];
		 	for(int i=0;i<dp.length;i++){
		 		dp[i]=-1;
		 	}
		 	long output=(int)calculate(n, dp);

		 	return output;
		 }

	}
}
