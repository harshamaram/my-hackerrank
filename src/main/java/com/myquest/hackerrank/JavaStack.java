package com.myquest.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://www.hackerrank.com/challenges/java-stack/problem
 */
public class JavaStack {

	public static void main(String[] args) {
		String str = "";
		
		System.out.println(sym);
		System.out.println(invSym);
		boolean result = check("([{}])");
		
		System.out.println(result);
	}

	static Map<Character, Character> sym = new HashMap<>();
	static Map<Character, Character> invSym = new HashMap<>();
	static {
		sym.put('{', '}');
		sym.put('(', ')');
		sym.put('[', ']');
		
		sym.forEach((a, b) -> {
			invSym.put(b, a);
		});
	}
	private static boolean check(String str) {
		
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(invSym.containsKey(c) 
					&& !st.empty() 
					&& st.peek().equals(invSym.get(c))) {
				st.pop();
			} else {
				st.push(c);
			}
		}
		
		return st.empty();
	}

}
