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
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome t = new ValidPalindrome();

        boolean res = t.isPalindrome("a.b,.");
        System.out.print(res);
    }
    
    public boolean isPalindrome(String s) {
        String vS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int i = 0;
        int j = s.length() -1;
        
        while(i < j) {
            String aS = s.substring(i, i + 1).toLowerCase();
            String bS = s.substring(j, j + 1).toLowerCase();
            
            if (-1 == vS.indexOf(aS)) {
                i = i + 1;
                continue;
            }
            
            if (-1 == vS.indexOf(bS)) {
                j = j - 1;
                continue;
            }
            
            if (!bS.equals(aS)) {
                return false;
            }
            
            i = i + 1;
            j = j - 1;
        }
        
        return true;
    }
}
