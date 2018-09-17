package com.yzy.my2018;

import java.util.Scanner;

public class WeiPinHui {

	// 查找最大的M个数
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		/*String[] temp = sc.nextLine().split(" ");
		int k = Integer.valueOf(temp[0]);
		int n = Integer.valueOf(temp[1]);
		int arr[] = new int[n * n];
		int len = 0;
		for (int i = 0; i < n; i++) {
			temp = sc.nextLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[len++] = Integer.valueOf(temp[j]);
			}
		}
		
		System.out.println(getNumber(arr, k));*/
		String[] temp = sc.nextLine().split(" ");
		System.out.println(addBinary(temp[0],temp[1]));
	}

	/*public static int getNumber(int[] arr, int k) {
		if (arr.length < 1 || arr == null) {
			return 0;
		}
		// 获取数组中的最大数
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		// 根据最大值来确定桶的个数 max+1;
		int[] bucket = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i]]++;// 数组中元素表示下标，此处计算元素出现的个数
		}
		int j = 0;
		for (int i = 0; i < bucket.length; i++)// 将桶的下标重新赋值给数组
		{
			if (bucket[i]>0) {
				if(bucket[i]>1)
				{
					j=j+bucket[i];
					if(j>=k)
						return i;
				}
				else
					j++;
				if(k==j)						
					return i;
			}

		}
		return 0;
	}*/
	//打印数组
			public static void printArray(int[] arr) {
				if (arr == null) {
					return;
				}
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			public static String addBinary(String a, String b) {
		        int alength=a.length();
		        int blength=b.length();
		        String result="";
		        int sum =0;
		        while(alength>=1||blength>=1){
		            if(alength>=1){
		                sum+=Integer.parseInt(a.substring(alength-1,alength));
		                alength--;
		            }
		            if(blength>=1){
		                sum+=Integer.parseInt(b.substring(blength-1,blength));
		                blength--;
		            }
		            if(sum==2){
		                result="0"+result;
		                sum=1;
		            }else if(sum==3){
		                result="1"+result;
		                sum=1;
		            }else{
		                result=sum+""+result;
		                sum=0;
		            }
		        }
		        if(sum==1){
		            result="1"+result;
		        }
		        return result;
		    }
}
