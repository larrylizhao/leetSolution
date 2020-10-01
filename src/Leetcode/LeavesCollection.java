package Leetcode;

/**
 * LCP 19. 秋叶收藏集
 * https://leetcode-cn.com/problems/UlBDOe/
 * #动态规划
 */
public class LeavesCollection {
    /*
        将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。
        每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。
        请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
        输入：leaves = "rrryyyrryyyrr"
        输出：2
        解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
     */
    public int minimumOperations(String leaves) {
        if(leaves==null || leaves.length() <= 1) return 0;
        //分三个状态数量（红，红黄，红黄红）
        int[][] states=new int[leaves.length()][3];
        //第一片叶必须是红色
        states[0][0]= leaves.charAt(0)=='y'?1:0;
        //遵循叶子的数量必须大于等于状态的数量
        states[0][1]=states[0][2]=states[1][2]=Integer.MAX_VALUE;
        for(int i=1;i<leaves.length();i++){
            int isYellow= leaves.charAt(i)=='y'?1:0;
            int isRed= leaves.charAt(i)=='r'?1:0;
            //全部替换成红叶的最小次数
            states[i][0]=states[i-1][0]+isYellow;
            //替换成红黄排列最小次数
            states[i][1]=Math.min(states[i-1][1],states[i-1][0])+isRed;
            if(i>=2){
                //替换成红黄红排列的最小次数
                states[i][2]=Math.min(states[i-1][1],states[i-1][2])+isYellow;
            }
        }
        return states[leaves.length()-1][2];
    }
}
