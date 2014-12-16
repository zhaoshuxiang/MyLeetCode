/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.string;

/**
 *
 * @author Shuxiang
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary t = new AddBinary();

        String res = t.addBinary("0", "0");
        System.out.print(res);
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int tag = 0;
        String res = "";

        do {

            if (i < 0 && j < 0) {
                if (0 != tag) {
                    res = "1" + res;
                    tag = 0;
                } else {
                    return res;
                }
            } else {
                int aV = i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(i))) : 0;
                int bV = j >= 0 ? Integer.parseInt(String.valueOf(b.charAt(j))) : 0;

                int sum = aV + bV + tag;
                tag = sum > 1 ? 1 : 0;
                res = sum % 2 + res;
            }

            i = i - 1;
            j = j - 1;
        } while (true);
    }
}
