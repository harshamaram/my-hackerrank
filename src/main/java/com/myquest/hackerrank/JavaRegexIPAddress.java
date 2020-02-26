package com.myquest.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://www.hackerrank.com/challenges/java-regex/problem?h_r=internal-search
 */
public class JavaRegexIPAddress {

	static String REGEX = 
			"^(([0-9]{1,2}|[0-1][0-9]{2}|2(?=[0-4])[0-9]{2}|2(?=5(?=[0-5]))[0-9][0-9])\\.){3}"
			+ "([0-9]{1,2}|[0-1][0-9]{2}|2(?=[0-4])[0-9]{2}|2(?=5(?=[0-5]))[0-9][0-9])$";
	
	static String REGEX2 = 
			  "(([0-1][0-9][0-9]|"
			  + "0?[0-9][0-9]|"
			  + "[0-9]|"
			  + "2[0-5][0-5]|"
			  + "2[0-4][0-9])\\.){3}"
			+  "([0-1][0-9][0-9]|0*[0-9][0-9]|[0-9]|2[0-5][0-5]|2[0-4][0-9])";
	static Pattern pattern = Pattern.compile(REGEX);
	
	public static void main(String[] args) {
		
		String positiveLookAheadRegex = "a(?=b).*"; //a follows by b
		// String positiveLookBehind = "a?<b"; // a is preceded by b
		
		Matcher matcher;
		String test1 ="ab";
		matcher = Pattern.compile(positiveLookAheadRegex).matcher(test1);
		if(matcher.matches()) {
			System.out.println("matcher passed");
		} else {
			System.out.println("matcher failed");
		}
		
		Map<String, Boolean> map = new HashMap<>();
		map.put("000.12.012.034", true);
		map.put("121.234.12.12", true);
		map.put("23.45.12.56", true);
		map.put("000.12.234.23.23", false);
		map.put("666.666.23.23", false);
		map.put("666.0666.23.23", false);
		map.put(".213.123.23.32", false);
		map.put("23.45.22.32.", false);
		map.put("267.45.22.32", false);
		map.put("65.65.24.78", true);
		map.put("249.249.249.249", true);
		map.put("0.0.0.0", true);
		map.put("333.444.555.666", false);
		map.put("256.256.256.256", false);
		map.put("023.034.045.067", true);
		map.put("I.Am.not.an.ip", false); 
		
		map.put("259.259.259.259", false);
		map.put("266.266.266.266", false);
		map.put("255.255.255.255", true);
		map.put("555.555.555.555", false);
		map.put("666.666.666.666", false);
		map.put("249.249.249.249", true);
		map.put("249.249.249.256", false);
		
		map.forEach((text, result) -> {
			if(check(text) == result) {
				//System.out.println("success: " + text + " / "+ result);
			} else {
				System.out.println(" failed: " + text + " / Expected: "+ result);
			}
		});

	}

	private static boolean check(String text) {
		Matcher matcher = pattern.matcher(text);
		return matcher.matches();
	}
	
	

}
