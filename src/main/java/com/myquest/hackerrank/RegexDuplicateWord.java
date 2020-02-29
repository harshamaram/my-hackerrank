package com.myquest.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDuplicateWord {
	public static void main(String s2[]) {
		
		
        

        List<String> list = new ArrayList<>();
        list.add("abc abc ab abcd");
        /* list.add("Goodbye bye bye world world world");
        list.add("Sam went went to to to his business");
        list.add("Reya is is the the best player in eye eye game");
        list.add("in inthe");
        list.add("Hello hello Ab aB");*/

        List<String> list2 = new ArrayList<>();
        
        list2.add("abc ab abcd");
       /* list2.add("Goodbye bye world");
        list2.add("Sam went to his business");
        list2.add("Reya is the best player in eye game");
        list2.add("in inthe");
        list2.add("Hello Ab");*/
        
        List<String> result = new ArrayList<>();

        int numSentences = list.size();
        
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        while (numSentences-- > 0) {
            String input = list.get(list.size()-numSentences-1);
            
            // Check for subsequences of input that match the compiled pattern
            Matcher m = p.matcher(input);
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }
            
            result.add(input);
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        for(int i2=0; i2< list2.size(); i2++) {
        	if(list2.get(i2).equals(result.get(i2))) {
        		
        	} else {
        		System.out.println("something went wrong with: " 
        				+ list.get(i2));
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        
	}
}
