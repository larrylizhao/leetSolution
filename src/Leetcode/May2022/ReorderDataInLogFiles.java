package Leetcode.May2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 937. 重新排列日志文件
 * #排序 #优先队列
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitalLog = new ArrayList<>();
        int len = logs.length;
        String[] res = new String[len];
        // 按照提议对字符log进行排序
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1Break = breakString(s1);
                String[] s2Break = breakString(s2);
                return s1Break[1].equals(s2Break[1]) ? s1Break[0].compareTo(s2Break[0]) : s1Break[1].compareTo(s2Break[1]);
            }
        };
        Queue<String> pq = new PriorityQueue<>(comparator);

        for (String log : logs) {
            if (isDigital(log)) {
                digitalLog.add(log);
            } else {
                pq.add(log);
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }

        for (String s : digitalLog) {
            res[i] = s;
            i++;
        }
        return res;
    }

    public String[] reorderLogFiles_sort(String[] logs) {
        List<String> digitalLog = new ArrayList<>();
        List<String> wordLog = new ArrayList<>();
        int len = logs.length;
        List<String> res = new ArrayList<>();
        for (String log : logs) {
            if(isDigital(log)) {
                digitalLog.add(log);
            } else {
                wordLog.add(log);
            }
        }
        wordLog.sort((a,b) -> {
            String[] breakA = breakString(a);
            String[] breakB = breakString(b);
            if(breakA[1].equals(breakB[1])) {
                return breakA[0].compareTo(breakB[0]);
            }
            return breakA[1].compareTo(breakB[1]);
        });
        res.addAll(wordLog);
        res.addAll(digitalLog);

        // return res.stream().toArray(String[] ::new);
        return res.toArray(new String[0]);
    }

    //判断是否是数字log
    private boolean isDigital(String log) {
        return Character.isDigit(log.charAt(log.length() - 1));
    }

    // 在第一个' '处分割字符串便于compare
    private String[] breakString(String log) {
        int i = 0;
        while(i < log.length()) {
            if(log.charAt(i) == ' ') {
                break;
            }
            i++;
        }
        return new String[] {log.substring(0, i), log.substring(i + 1)};
    }
}
