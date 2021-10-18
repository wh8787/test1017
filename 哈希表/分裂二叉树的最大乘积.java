package 哈希表;

import java.util.*;

public class 分裂二叉树的最大乘积 {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public int maxProduct(TreeNode root) {
        count(root);
        long res = 0;
        for(TreeNode node : map.keySet()){
            long p1 = node.left==null ? 0 : map.get(node.left)*(map.get(root)-map.get(node.left));
            long p2 = node.right==null ? 0 : map.get(node.right)*(map.get(root)-map.get(node.right));
            res = Math.max(Math.max(p1, p2), res);
        }
        return (int)(res%1000000007);
    }
    HashMap<TreeNode, Long> map = new HashMap<>();
    public long count(TreeNode root){
        if(root==null){
            return 0;
        }
        long res = count(root.left)+count(root.right)+root.val;
        map.put(root, res);
        return res;
    }
}
/*
该解法将所有子树节点之和都保存在哈希表中，难点在于结果要取模。
解决该难点的两个办法：
1、用long类型存放结果，最后再转为整数。(int)(res%1000000007)，注意后面取模部分要加括号，否则会先将res转为int再取模。
2、均值不等式：a+b=sum, 当a=b时，a*b的值最大。
 */