package Leetcode;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * #树 #DFS
 */
public class PopulatingNextRightPointersInEachNodeII {
    /*
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
        如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     */
    public Tnode connect(Tnode root) {
        // head存储每一层的首节点
        Tnode head = root;
        // 退出条件是整层子节点为空，表示到达二叉树底部
        while (head != null) {
            Tnode current = head;
            Tnode temp = null;
            head = null;
            // 遍历每一层的子节点，并使用temp遍历并添加每一层的后继关系
            while(current != null) {
                // 在左右子节点中找到第一个非空节点作为层首节点
                // 并用temp.next指向该层的后继节点
                if(current.left != null) {
                    if(temp == null) {
                        temp = current.left;
                        // 将head赋值为层首节点
                        head = current.left;
                    } else {
                        temp.next = current.left;
                        temp = temp.next;
                    }
                }
                if(current.right != null) {
                    if(temp == null) {
                        temp = current.right;
                        // 将head赋值为层首节点
                        head = current.right;
                    } else {
                        temp.next = current.right;
                        temp = temp.next;
                    }
                }
                // 使用current遍历所有父节点，并依照父节点后继关系找出存在的子节点后继
                current = current.next;
            }
        }
        return root;
    }
}

class Tnode {
    public int val;
    public Tnode left;
    public Tnode right;
    public Tnode next;

    public Tnode() {}

    public Tnode(int _val) {
        val = _val;
    }

    public Tnode(int _val, Tnode _left, Tnode _right, Tnode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
