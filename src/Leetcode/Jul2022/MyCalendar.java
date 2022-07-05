package Leetcode.Jul2022;

import java.util.ArrayList;
import java.util.List;

// 729. 我的日程安排表 I
class MyCalendar {
    List<List<Integer>> booked = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        for (List<Integer> integers : booked) {
            if (start >= integers.get(1) || end < integers.get(0)) {
                continue;
            }
            return false;
        }
        booked.add(List.of(start, end));
        return true;
    }
}