package Leetcode.Sep2022;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(letters[mid] > target) {     // 找上界用>target
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right == letters.length ? letters[0] : letters[right];
    }
}
