package com.myquest.hackerrank;

import java.security.MessageDigest;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-md5/forum
 */
public class JavaMd5 {
	
	public static void main(String s[]) {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            // return bytesToHex(md.digest
            byte[] digest = md.digest();
            for (byte b : digest) {
                System.out.printf("%02x", b);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
	}

}


