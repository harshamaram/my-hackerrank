package com.myquest.hackerrank;

/*
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */
public class LeftRotation {
	
	public static void main(String s[]) {
		int[] a = {1,2,3,4,5};
		int d = 4;
		int[] r = rotLeft(a, d);
		
		for(int i=0; i<r.length; i++) {
			System.out.print(r[i] + " ");
		}
	}
	
	// Complete the rotLeft function below.
	// 1 2 3 4 5 
    static int[] rotLeft(int[] a, int d) {

    	int[] r = new int[a.length];
    	int index = 0;
    	for(int i=d; i<a.length; i++) {
    		r[index] = a[i];
    		index++;
    	}
    	for(int i=0; i<d; i++) {
    		r[index] = a[i];
    		index++;
    	}
    	return r;

    }

}
