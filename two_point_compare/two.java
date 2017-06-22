import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static public int[] mergeSort(int[] a) {
        if (a.length < 2)
            return a;

        int mid = a.length / 2;
        int[] left = Arrays.copyOfRange(a,0,mid);
        int[] right = Arrays.copyOfRange(a,mid, a.length);

        return merge(mergeSort(left), mergeSort(right));

    }

    static public int[] merge(int[] l, int[] r) {
        int[] result = new int[l.length + r.length];
        int idx = 0;
        int left = 0;
        int right = 0;

        while(left < l.length && right < r.length) {
            if (l[left] < r[right]) {
                result[idx] = l[left];
                left++;
            } else {
                result[idx] = r[right];
                right++;
            }
            idx++;
        }

        if (left < l.length) {
            while(left < l.length) {
                result[idx] = l[left];
                idx++;
                left++;
            }
        }

        if (right < r.length) {
            while(right < r.length) {
                result[idx] = r[right];
                idx++;
                right++;
            }
        }
        return result;
    }

    static public int[] sorting(int[] a) {
        int[] sorted = a;

        sorted = mergeSort(a);

        return sorted;
    }

    static int pairs(int[] a,int k) {
        int[] sorted;
        int count = 0;
        int i = 0;
        int j = 1;
        sorted = sorting(a);
        while(i < sorted.length && j < sorted.length) {
            if (sorted[j] - sorted[i] == k) {
                count++;
                j++;
                i++;
            } else if (sorted[j] - sorted[i] > k) {
                i++;
            } else if (sorted[j] - sorted[i] < k) {
                j++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = pairs(_a,_k);
        System.out.println(res);
    }
}
