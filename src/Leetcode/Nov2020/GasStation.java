package Leetcode.Nov2020;

import java.util.Arrays;

/**
 *  134. 加油站
 *  #贪心
 */
public class GasStation {
    /*
        在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升
        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
        你从其中的一个加油站出发，开始时油箱为空。
        如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1

        如果题目有解，该答案即为唯一答案。

        gas  = [1,2,3,4,5]
        cost = [3,4,5,1,2]
        输出: 3

        解释:
        从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
        开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
        开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
        开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
        开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
        开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
        因此，3 可为起始索引。

        输入:
        gas  = [2,3,4]
        cost = [3,4,3]
        输出: -1

        解释:
        你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
        我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
        开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
        开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
        你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
        因此，无论怎样，你都不可能绕环路行驶一周。
     */
    public int canCompleteCircuit_brute(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        // 总油量小于总路程则一定无法成行
        if(costSum > gasSum) {
            return -1;
        }
        int len = gas.length;
        int i = 0;
        while(i < len) {
            // 消耗大于加油的站点无法作为起始站
            if(gas[i] < cost[i]) {
                i++;
                continue;
            }
            int cnt = 0;
            int station = i;
            int oil = 0;
            while(cnt < len) {
                //可以走到下一站就cnt++, 检查最终是否可以走完
                oil += gas[station] - cost[station];
                if(oil >= 0) {
                    cnt++;
                    station = ++station % len;
                } else {
                    break;
                }
            }
            // 可以走完说明i是可行的
            if(cnt == len) {
                return i;
            }
            // 否则继续尝试
            i++;
        }

        // 尝试完所有站点都不可能
        return -1;
    }

    /*
      考虑进行优化:
        1. 我们首先检查第 0 个加油站，并试图判断能否环绕一周;
        2. 如果不能, 就从第一个无法到达的加油站开始继续检查。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        // 总油量小于总路程则一定无法成行
        if(costSum > gasSum) {
            return -1;
        }
        int len = gas.length;
        int i = 0;
        while(i < len) {
            // 消耗大于加油的站点无法作为起始站
            if(gas[i] < cost[i]) {
                i++;
                continue;
            }
            int cnt = 0;
            int station = i;
            int oil = 0;
            int canNotReach = -1;
            while(cnt < len) {
                //可以走到下一站就cnt++, 检查最终是否可以走完
                oil += gas[station] - cost[station];
                if(oil >= 0) {
                    cnt++;
                    station = ++station % len;
                } else {
                    canNotReach = station;
                    break;
                }
            }
            // 可以走完说明i是可行的
            if(cnt == len) {
                return i;
            }
            // 否则从无法到达的站点继续尝试
            i = canNotReach == -1 ? i + 1 : canNotReach + 1;
        }

        // 尝试完所有站点都不可能
        return -1;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        gasStation.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
    }
}
