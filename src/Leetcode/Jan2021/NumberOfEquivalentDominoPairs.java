package Leetcode.Jan2021;

/**
 *  1128. 等价多米诺骨牌对的数量
 *  #数组 #字符串 #数字映射 #注意范围限制, 映射后比较会容易很多
 */
public class NumberOfEquivalentDominoPairs {
    /*
        输入: 一个二维数组, 包含长度为二的数组[a,b]，[a,b]与[b,a]形成等价对
        输出: 该二维数组中等价对的数量

        输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
        输出：1
     */

    /*
        找出相同的对的个数，有2个相同是1, 3个相同是 1 + 2, 4个相同是1+2+3
        根据每组相同的个数，计算出每组的总数，最后相加

        我们不妨直接让每一个二元对都变为指定的格式，即第一维必须不大于第二维。这样两个二元对「等价」当且仅当两个二元对完全相同。
        注意到二元对中的元素均不大于 99，因此我们可以将每一个二元对拼接成一个两位的正整数，即 (x, y) 映射到 10x + y。
        这样就无需使用哈希表统计元素数量，而直接使用长度为 100 的数组即可。
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        //使用长度为100的数组统计个数
        int[] mapped = new int[100];

        //遍历二元组, 对二元组元素排序后映射(x,y) -> 10x+y
        for (int[] domino : dominoes) {
            int getMappedValue = mapDomino(domino);
            mapped[getMappedValue]++;
        }

        //遍历统计数组并根据规律统计出总个数
        for (int value : mapped) {
            if (value > 1) {
                count += getPairCount(value);
            }
        }
        return count;
    }

    private int mapDomino(int[] domino) {
        int x = domino[0];
        int y = domino[1];

        if (x > y) {
           return 10 * y + x;
        }

        return 10 * x + y;
    }

    private int getPairCount(int value) {
        int count = 0;
        for(int i = value - 1; i > 0; i--) {
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2},{2,1},{3,4},{5,6},{2,1}};
        NumberOfEquivalentDominoPairs numberOfEquivalentDominoPairs = new NumberOfEquivalentDominoPairs();
        int count = numberOfEquivalentDominoPairs.numEquivDominoPairs(input);
        System.out.println("Count is " + count);
    }
}
