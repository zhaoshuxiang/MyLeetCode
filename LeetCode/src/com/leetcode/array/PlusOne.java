/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.array;

/**
 *
 * @author Shuxiang
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 9};
        int[] r = (new PlusOne()).plusOne(t);

        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] r = new int[len];

        boolean t = false;
        for (int i = len - 1; i >= 0; i--) {
            int sum = i == len - 1 ? digits[i] + 1 : digits[i];
            sum = t ? sum + 1 : sum;

            if (sum >= 10) {
                r[i] = sum % 10;
                t = true;
            } else {
                r[i] = sum;
                t = false;
            }

            if (i == 0 && t) {
                int[] m = new int[len + 1];
//                System.arraycopy();
            }
        }

        return r;
    }
}
