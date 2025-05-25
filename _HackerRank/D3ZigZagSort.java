package _HackerRank;

import java.util.*;
public class D3ZigZagSort {
    
    public static void main (String[] args) throws java.lang.Exception {
        int[] a = {2, 3, 5, 1, 4}; // added tcs
        int n = 5;
        findZigZagSequence(a, n);
        // Scanner kb = new Scanner(System.in);
        // int test_cases = kb.nextInt();
        // for(int cs = 1; cs <= test_cases; cs++){
        //     int n = kb.nextInt();
        //      int a[] = new int[n];
        //     for(int i = 0; i < n; i++){
        //         a[i] = kb.nextInt();
        //     }
            // findZigZagSequence(a, n);
        // }

        int[] b = {1, 2, 3, 4, 5, 6, 7}; // added tcs
        n = b.length; 
        findZigZagSequence(b, n);
   }
   
    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n + 1)/2 - 1; // added - 1
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
    
        int st = mid + 1;
        int ed = n - 2; // changed from n - 1 to n - 2
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1; // changed from  ed += 1 to ed -= 1
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}



