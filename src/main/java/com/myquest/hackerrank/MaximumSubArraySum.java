package com.myquest.hackerrank;

public class MaximumSubArraySum {

	public static void main(String[] args) {

		// long a[] = { 5, 7, 9, 3, 7, 9, 23, 47, 6, 32, 29 };
		// long a[] = { 3, 3, 9, 9, 5 };
		long a[] = new long[100000];
		generateRandomNumbers(a);
		long m = generateRandomNumber();
		System.out.println("m: " + m);
//		System.out.println(maximumSumBruteForce(a, m));
		System.out.println(maximumSum(a, m));
	}

	private static long maximumSum(long[] a, long m) {
		
		long start = System.nanoTime();
		// preparing sumIndex
		long[] sumIndex = new long[a.length];
		long prev = 0;
		for(int i=0; i<a.length; i++) {
			prev = (prev + a[i]) % m;
			sumIndex[i] = prev;
		}
		// end preparation
		long elapsed = System.nanoTime() - start;
		System.out.println("step 1: " + elapsed);
		start = System.nanoTime();
		// brute force again on the sumIndex array
		long maxModVal = 0;
		for(int i=0; i<sumIndex.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				maxModVal = max(maxModVal, (sumIndex[i] - sumIndex[j] + m) % m);
			}
			maxModVal = max(maxModVal, sumIndex[i]);
			if(i % 1000 == 0) {
				elapsed = System.nanoTime() - start;
				System.out.printf("sub size: %d, time: %d, maxModVal: %d\n", i, elapsed, maxModVal);
			}
		}
		
		return maxModVal;
	}

	private static long max(long a, long b) {
		return a > b ? a : b;
	}

	static double d;
	static long l;

	private static void generateRandomNumbers(long[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = generateRandomNumber();
		}
	}

	private static long generateRandomNumber() {
		d = Math.random() * 100000 / 99991;
		l = (long) (d * 100000);
		return l;
	}

	// Complete the maximumSum function below.
	static long maximumSumBruteForce(long[] a, long m) {

		long maxModSum = 0;
		long temp;
		long milli;
		// i - size of the sub array
		for (int i = 0; i < a.length; i++) {
			// sub array from p to q
			milli = System.currentTimeMillis();
			for (int p = 0; p < a.length - i; p++) {
				temp = sumMod(a, p, p + i + 1, m);
				maxModSum = maxModSum < temp ? temp : maxModSum;
			}
			milli = System.currentTimeMillis() - milli;
			System.out.printf("sub size: %d, time: %d\n", i, milli);

		}
		return maxModSum;

	}

	static long sumMod(long[] a, int p, int q, long m) {
		long sum = 0;
		for (int i = p; i < q; i++) {
			sum = (a[i] % m + sum) % m;
		}
		return sum % m;
	}

}
