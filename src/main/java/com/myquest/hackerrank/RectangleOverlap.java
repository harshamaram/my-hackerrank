package com.myquest.hackerrank;

/*
 * https://www.hackerrank.com/contests/cisco-hackathon/challenges/rectangle-overlap
 */
public class RectangleOverlap {

	public static void main(String[] args) {
/*
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

			String[] set1 = bufferedReader.readLine().trim().split(" ");
			String[] set2 = bufferedReader.readLine().trim().split(" ");

			int x1 = Integer.parseInt(set1[0]);
			int y1 = Integer.parseInt(set1[1]);
			int x2 = Integer.parseInt(set1[2]);
			int y2 = Integer.parseInt(set1[3]);
			int x3 = Integer.parseInt(set2[0]);
			int y3 = Integer.parseInt(set2[1]);
			int x4 = Integer.parseInt(set2[2]);
			int y4 = Integer.parseInt(set2[3]);

			solve(x1, y1, x2, y2, x3, y3, x4, y4);

		} catch (Exception e) {
			e.printStackTrace();

		}
*/
		// 0 1 1 0
		// 1 1 2 0
		
		// few test cases
		overlap(0, 1, 1, 0, 1, 1, 2, 0);
		area(0, 1, 1, 0, 1, 1, 2, 0);
		overlap(-3, 1, 0, -8, 5, -8, 7, -15);
		area(-3, 1, 0, -8, 5, -8, 7, -15);
		overlap(-10, -3, -3, -7, -5, -5, -1, -6);
		area(-10, -3, -3, -7, -5, -5, -1, -6);


	}

	private static void overlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		solve(x1, y1, x2, y2, x3, y3, x4, y4);
		
		if (p1 < p2 && q1 > q2) { // validation for common area
			System.out.println("overlap");
		} else if ((p1 == p2 && q1 > q2) || (q1 == q2 && p1 < p2)) { // validation if they are touching
			System.out.println("overlap");
		} else {
			System.out.println("no overlap");
		}
	}

	private static void area(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		solve(x1, y1, x2, y2, x3, y3, x4, y4);
		
		System.out.println("area: " + Math.abs((q2-q1) * (p2-p1)));
		
	}
	
	static int p1, q1, p2, q2;

	private static void solve(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
//		int p1, q1, p2, q2;

		p1 = x1 < x3 ? x3 : x1;
		p2 = x2 < x4 ? x2 : x4;
		q1 = y1 > y3 ? y3 : y1;
		q2 = y2 > y4 ? y2 : y4;

		System.out.println(String.format("[%d, %d], [%d, %d]", p1, q1, p2, q2));

		

	}
	
	

}
