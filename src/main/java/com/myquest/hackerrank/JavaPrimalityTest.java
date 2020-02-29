package com.myquest.hackerrank;

import java.math.BigInteger;

public class JavaPrimalityTest {

	public static void main(String[] args) {
		String s = generateRandomNumber(100);
		BigInteger num = new BigInteger(s);
		System.out.println(num);
		
		System.out.println(num.multiply(new BigInteger("2")));

	}
	
	private static String generateRandomNumber(int size) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<size; i++) {
			sb.append(String.valueOf((int)(Math.random() * 10)));
		}
		return sb.toString();
	}
	

}
