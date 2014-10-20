package com.leetcode.ReverseWords;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		String res = s.reverseWords("the sky is blue");

		output(res);
	}

	public static void output(String s) {
		System.out.println(s);
	}

	public static void output(int i) {
		System.out.println(Integer.toString(i));
	}

	public String reverseWords(String s) {
		s = s.trim();
		int len = s.length();
		String world = "";
		String res = "";

		for (int i = 0; i < len; i++) {
			char curChar = s.charAt(i);

			if (curChar != ' ') {
				world = world + String.valueOf(curChar);
			} else {
				if (world != "") {
					res = world + " " + res;
					world = "";
				}
			}

			if (i == len - 1) {
				res = world + " " + res;
			}
		}

		return res.trim();
	}
}
