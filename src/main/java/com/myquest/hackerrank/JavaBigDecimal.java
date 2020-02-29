package com.myquest.hackerrank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JavaBigDecimal {
	
	public static void main(String s2[]) {
        String[] s = {
        		"-100",
        		"50",
        		"0",
        		"56.6",
        		"90",
        		"0.12",
        		".12",
        		"02.34",
        		"000.000"
        };
        
        List<String> lOne = new ArrayList<>();
        List<BigDecimal> lTwo = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
        	lOne.add(s[i]);
        	lTwo.add(new BigDecimal(s[i]));
		}
        
        int index;
        int a, b;
        BigDecimal tBigInteger;
        String tStr;
		for (int i = 0; i < s.length; i++) {
			index = i;
			for (int j = i + 1; j < s.length; j++) {
				if(lTwo.get(index).compareTo(lTwo.get(j)) < 0) {
					index = j;
				}
			}
			if(index != i) {
				//System.out.printf("swapping %d and %d\n", i, index);
				// swap: i and index
				if(index > i) {
					a = i;
					b = index;
				} else {
					a = index;
					b = i;
				}
				tBigInteger = lTwo.get(b);
				lTwo.remove(b);
				lTwo.add(a, tBigInteger);
				
				tBigInteger = lTwo.get(a + 1);
				lTwo.remove(a + 1);
				lTwo.add(b, tBigInteger);
				
				tStr = lOne.get(b);
				lOne.remove(b);
				lOne.add(a, tStr);
				
				tStr = lOne.get(a + 1);
				lOne.remove(a + 1);
				lOne.add(b, tStr);
				
				// System.out.printf("after swap: %s\n", lOne.toString());
				// System.out.printf("after swap: %s\n", lTwo.toString());
				
			}
		}
		
		//System.out.println(lOne);
		//System.out.println(lTwo);
		for (int i = 0; i < s.length; i++) {
			s[i] = lOne.get(i);
		}
		
		// Output
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
	


}
