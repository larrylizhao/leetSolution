package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. 钥匙和房间
 * #深度优先遍历 #广度优先遍历 #图 #临接表 #有向图遍历
 */
public class KeysAndRooms {
    boolean[] vis;
    int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.get(0) == null) {
            return true;
        }
        int len = rooms.size();
        vis = new boolean[len];
        dfs(rooms, 0);
        return count == len;
    }

    private void dfs(List<List<Integer>> rooms, int index) {
        //标记访问房间
        vis[index] = true;
        //计数访问总数
        count++;
        //取得接下来可访问房间列表
        for (Integer integer : rooms.get(index)) {
            //访问没有访问过的房间
            if(!vis[integer]) {
                dfs(rooms, integer);
            }
        }
    }

    public boolean canVisitAllRooms_bfs(List<List<Integer>> rooms) {
        if (rooms == null || rooms.get(0) == null) {
            return true;
        }

        int len = rooms.size();
        //记录访问过的房间
        boolean[] vis = new boolean[len];
        //对访问过的房间总数进行计数
        int count = 0;
        Queue<Integer> next = new LinkedList<>();
        //将根节点加入队列
        next.offer(0);

        while(!next.isEmpty()) {
            //对访问节点进行计数并标记已访问
            int room = next.poll();
            if(!vis[room]) {
                count++;
            }
            vis[room] = true;
            //取得当前节点的所有子节点并添加到队列
            List<Integer> nextRooms = rooms.get(room);
            for (Integer nextRoom : nextRooms) {
                if(!vis[nextRoom]) {
                    next.offer(nextRoom);
                }
            }
        }
        return count == len;
    }
}
