package com.myquest.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class JavaDequeue {

	public static void main(String s[]) {
		/*int n = 100000;
		int m = 150;

		Deque<Integer> originalDeque = new ArrayDeque<>();
		
		int num;
		
		for (int i = 0; i < n; i++) {
			num = generateRandomNumber();
			originalDeque.addLast(num);
		}*/
		
		Deque<Integer> originalDeque = new ArrayDeque<>();
		originalDeque.addLast(1);
		originalDeque.addLast(2);
		originalDeque.addLast(3);
//		originalDeque.addLast(2);
//		originalDeque.addLast(3);
//		originalDeque.addLast(2);
		int m = 3;
		
		Deque<Integer> processDeque = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int temp;
		for (int i = 0; i < m; i++) {
			processDeque.addLast(originalDeque.pollFirst());
			temp = processDeque.peekLast();
			addToMap(temp, map);
		}
		System.out.println("processDeque: " + processDeque);
		System.out.println("         map: " + map);
		int maxCount = map.size();
		while (originalDeque.size() > 0) {
			processDeque.addLast(originalDeque.pollFirst());
			temp = processDeque.pollFirst();
			removeFromMap(temp, map);
			addToMap(processDeque.peekLast(), map);
			maxCount = map.size() > maxCount ? map.size() : maxCount;
			System.out.println("-- originalDeque.size(): " + originalDeque.size() + "--");
			System.out.println("processDeque: " + processDeque);
			System.out.println("         map: " + map);
			System.out.println("    map size: " + map.size());
			System.out.println("    maxCount: " + maxCount);
			
		}
		System.out.println(maxCount);
		
	}
	
	private static void addToMap(int num, Map<Integer, Integer> map) {
		if(map.get(num) == null) {
			map.put(num, 0);
		}
		map.put(num, map.get(num) + 1);
	}
	
	private static void removeFromMap(int num, Map<Integer, Integer> map) {
		if(map.get(num) == null) {
			map.put(num, 0);
			System.out.println("This should not print");
		}
		map.put(num, map.get(num) - 1);
		if(map.get(num) == 0) {
			map.remove(num);
		}
	}

	private static int generateRandomNumber() {
		return (int) (Math.random() * 100);
	}

}
