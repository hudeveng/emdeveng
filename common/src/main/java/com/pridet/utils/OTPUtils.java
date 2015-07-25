package com.pridet.utils;

public class OTPUtils {

	private static int MIN;
	private static int MAX;

	public static int getOTPindigits(int numberofdigits) {
		int i = 0;
		try {
			MIN = (int) Math.pow(10, numberofdigits - 1);
			MAX = (int) Math.pow(10, numberofdigits) - 1;
			System.out.println("AMx:" + MAX + "min" + MIN);
			do {
				i = (int) (Math.random() * Math.pow(10, numberofdigits));
				System.out.println(i);
			} while (i < MIN || i > MAX);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return i;
	}

}
