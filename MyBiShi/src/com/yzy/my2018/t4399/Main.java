package com.yzy.my2018.t4399;

import java.util.Scanner;

public class Main {
	    //查找最大的M个数
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			String[] p=sc.nextLine().split(",");
			int M=Integer.parseInt(sc.nextLine());
			int[] number=new int[p.length];
			
			for(int i=0;i<p.length;i++)
			{
				number[i]=Integer.parseInt(p[i]);
			}

			getNumber(number,M);
		}
		public static int[] getNumber(int[] arr,int M)
		{
			if(arr.length<1||arr==null)
			{
				return null;
			}
			//获取数组中的最大数
			int max=Integer.MIN_VALUE;
			for(int i=0;i<arr.length;i++)
			{
				max=Math.max(max,arr[i]);
			}
			//根据最大值来确定桶的个数 max+1;
			int[] bucket=new int[max+1];
			for(int i=0;i<arr.length;i++)
			{
				bucket[arr[i]]++;//数组中元素表示下标，此处计算元素出现的个数
			}
			int j=0;
			int []result=new int[M];
			for(int i=bucket.length-1;i>=0;i--)//从大到小，将桶的下标重新赋值给数组
			{
				if(bucket[i]>0)
				{
					result[j]=i;
					j++;
					if(j==M)
					{
						return result;
					}
				}
				
			}
			return null;
		}
}
