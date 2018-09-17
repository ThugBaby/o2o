package com.yzy.my2018;

import java.util.Scanner;

public class CVTE1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		temp=temp.trim();
		char []arr= temp.toCharArray();
		int [] sArr=new int[arr.length];
		int j=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=','&&arr[i]!='}'&&arr[i]!='{')
			{
				sArr[j]=arr[i]-'0';
				j++;
			}
		}
		int left=0;

		int right=j-1;
		int swapTime=0;

		while(left<right)
		{
			if(sArr[left]==0)
			{
				left++;

			}
			if(sArr[right]==1)
			{
				right--;

			}
			 if(sArr[left]==1&&sArr[right]==0)
			{
				swapTime++;
				left++;
				right--;

			}
		}
		System.out.println(swapTime);
	}
	//´òÓ¡Êý×é
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
