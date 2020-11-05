package Leetcode.Nov2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 127. 单词接龙
 * #字符串 #回溯 #递归
 */
public class WordLadder {
    /*
        给定两个单词（beginWord 和 endWord）和一个word数组
        找到从beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
        1. 每次转换只能改变一个字母。
        2. 转换过程中的中间单词必须是字典中的单词。

        说明:
        如果不存在这样的转换序列，返回 0。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

        示例:
            输入:
            beginWord = "hit",
            endWord = "cog",
            wordList = ["hot","dot","dog","lot","log","cog"]
            输出: 5
            解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。

     */

    int len = 0;
    public int ladderLength_backtrack(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Stack<String> path = new Stack<>();

        backtrack(beginWord, endWord, wordList, path);

        return len;
    }

    private void backtrack(String beginWord, String endWord, List<String> wordList, Stack<String> path) {
        if(beginWord.equals(endWord)) {
            len = len == 0 ? path.size() + 1 : Math.min(len, path.size() + 1);
            return;
        }

        for (String s : wordList) {
            if(!path.contains(s) && nextWord(beginWord, s)) {
                path.push(s);
                backtrack(s, endWord, wordList, path);
                path.pop();
            }
        }
    }

    private boolean nextWord(String prev, String next) {
        int len = prev.length();
        int diffCount = 0;
        char[] prevChars = prev.toCharArray();
        char[] nextChars = next.toCharArray();

        if(len != next.length()) {
            return false;
        }

        while(--len > -1) {
            if(diffCount > 1) {
                return false;
            }
            if(prevChars[len] != nextChars[len]) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }

    public static void main(String[] args) {
        String beginword = "hot";
        String endword = "dog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));
        WordLadder wordLadder = new WordLadder();
        Stack<String> path = new Stack<>();
        int res = wordLadder.ladderLength_backtrack(beginword, endword, wordList);
        System.out.println(res);

    }
}
