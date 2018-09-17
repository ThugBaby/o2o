package com.yzy.my2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int n=Integer.valueOf(temp);
		int m=n;
		int [] arr=new int[n];
		boolean []flag=new boolean[n];
		int i=0;
		while(i!=n-1)
		{
			arr[i]=sc.nextInt();
			flag[i]=false;
			i++;
		}
		int [] tempArray=new int[3];
		
		for(int a=0;a<n;a++)
			flag[a]=true;
			for(int b=0;b<n;b++)
			{
				if(flag[b]==false)
				{
					
				}
				for(int c=0;c<n-2;c++);
			}
				
		System.out.println();
	}
}
