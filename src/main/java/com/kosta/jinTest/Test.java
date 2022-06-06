package com.kosta.jinTest;

import java.nio.charset.StandardCharsets;

public class Test {

	public static void main(String[] args) {

		String s = " ";
		byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
		System.out.println("ASCII Numeric Value: " + bytes[0]);
	}
}
