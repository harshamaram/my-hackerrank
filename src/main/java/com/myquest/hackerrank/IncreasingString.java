package com.myquest.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.hackerrank.com/contests/cisco-hackathon/challenges/eli-and-the-string
 */
public class IncreasingString {

	static String str;
	static int[][] weight = new int[26][26];
	
	public static void main(String[] args) {

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

			int t = Integer.parseInt(bufferedReader.readLine().trim());
			str = bufferedReader.readLine().trim();
			
			String temp[];
			for(int i=0; i<26; i++) {
				temp = bufferedReader.readLine().trim().split(" ");
				for(int j=0; j<temp.length; j++) {
					weight[i][j] = Integer.parseInt(temp[j]);
				}
			}

			solve();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void solve() {
		
	}

}
