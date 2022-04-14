package Leetcode.April2022;

/**
 *  1672. 最富有客户的资产总量
 *  #数组
 */
public class RichestCustomerWealth {
    /*
        给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的资产总量 。
        输入：accounts = [[1,5],[7,3],[3,5]]
        输出：10
        解释：
        第 1 位客户的资产总量 = 6
        第 2 位客户的资产总量 = 10
        第 3 位客户的资产总量 = 8
        第 2 位客户是最富有的，资产总量是 10
     */
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        if(accounts.length == 0) {
            return maxWealth;
        }
        for (int[] account : accounts) {
            int wealth = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                wealth += account[j];
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}
