package Leetcode;

/**
 * 回文对
 * https://leetcode-cn.com/problems/palindrome-pairs/
 */
//public class LC336 {
//    public List<List<Integer>> palindromePairs(String[] words) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < words.length - 2; i++) {
//            String word = words[i];
//            for (int j = i+1; j < words.length - 1; j++) {
//                String test = words[j];
//                if(isPalindrome(word, test)) {
//                    Integer[] palindromes = {i, j};
//                    res.add(Arrays.asList(palindromes));
//                }
//            }
//        }
//        return res;
//    }
//    //判断s1，s2能否组成回文串
//    private boolean isPalindrome(String s1, String s2) {
//        String s3 = s1.concat(s2);
//        int i = 0, j = s3.length() - 1;
//        while (i<j) {
//            if()
//        }
//    }
//}
