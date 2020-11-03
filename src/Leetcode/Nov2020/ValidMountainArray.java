package Leetcode.Nov2020;

/**
 * 941. 有效的山脉数组
 * #数组 #双指针
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        int j = 1;
        boolean increment = true;
        while(j < A.length) {
            if(A[i] == A[j]) {
                return false;
            }

            if(A[i] < A[j] && increment) {
                i++;
                j++;
                continue;
            } else {
                increment = false;
            }

            if(A[i] > A[j]) {
                return false;
            }
        }

        return !increment;
    }

    public static void main(String[] args) {
        
    }
}
