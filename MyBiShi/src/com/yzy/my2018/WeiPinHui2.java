package com.yzy.my2018;

import java.util.Scanner;

public class WeiPinHui2 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String[] temp = sc.nextLine().split(" ");
		System.out.println(addBinary(temp[0], temp[1]));
	}

	public static String addBinary(String a, String b) {
		int alength = a.length();
		int blength = b.length();
		String result = "";
		int sum = 0;
		while (alength >= 1 || blength >= 1) {
			if (alength >= 1) {
				sum += Integer.parseInt(a.substring(alength - 1, alength));
				alength--;
			}
			if (blength >= 1) {
				sum += Integer.parseInt(b.substring(blength - 1, blength));
				blength--;
			}
			if (sum == 2) {
				result = "0" + result;
				sum = 1;
			} else if (sum == 3) {
				result = "1" + result;
				sum = 1;
			} else {
				result = sum + "" + result;
				sum = 0;
			}
		}
		if (sum == 1) {
			result = "1" + result;
		}
		return result;
	}
}
