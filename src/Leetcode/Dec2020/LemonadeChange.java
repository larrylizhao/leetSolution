package Leetcode.Dec2020;

import java.util.HashMap;
import java.util.Map;

/**
 *  860. 柠檬水找零
 */
public class LemonadeChange {
    /*
        在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

        顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

        每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

        注意，一开始你手头没有任何零钱。

        如果你能给每位顾客正确找零，返回 true，否则返回 false。

        输入：[5,5,5,10,20]
        输出：true

        输入：[5,5,10,10,20]
        输出：false
     */
    /*
        维护一个零钱列表，收到的钱放入零钱中，需要找零时从零钱列表中查看是否可以找零
        遍历到bills都可以找零则为true
     */
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> changes = new HashMap<>();
        for (int bill : bills) {
            int change_5 = changes.getOrDefault(5, 0);
            if(bill == 5) {
                change_5++;
                changes.put(5, change_5);
                continue;
            }

            int change_10 = changes.getOrDefault(10, 0);
            if(bill == 10) {
                if(change_5 == 0) {
                    return false;
                }
                change_5--;
                changes.put(5, change_5);
                change_10++;
                changes.put(10, change_10);
                continue;
            }

            if(bill == 20) {
                if(change_10 >= 1 && change_5 >=1){
                    change_10--;
                    change_5--;
                    changes.put(10, change_10);
                    changes.put(5, change_5);
                    continue;
                }

                if(change_5 >= 3) {
                    change_5 -= 3;
                    changes.put(5, change_5);
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] arr = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        lemonadeChange.lemonadeChange(arr);

    }
}
