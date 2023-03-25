package DynamicProgramming;

import java.util.Scanner;

public class Fibonacci {
	
	public static int fibonacci(int n, int arr[]) {
		if(n<=1) {
			return n;
		}
		
		int ans1=arr[n-1];
		if(ans1==-1) {
			ans1=fibonacci(n-1, arr);
			arr[n-1]=ans1;
		}
		
		int ans2=arr[n-2];
		if(ans2==-1) {
			ans2=fibonacci(n-2, arr);
			arr[n-2]=ans2;
		}
		
		return ans1+ans2;
	}
	
	public static void main(String args[]) {
		System.out.println("Enter Number");
		Scanner s=new Scanner(System.in);
		int no=s.nextInt();
		int arr[]=new int[no+1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=-1;
		}
		int output=fibonacci(no, arr);
		System.out.println("Output-"+output);
	}

}
