package 力扣;

import java.util.*;

public class 二叉树遍历_前中后序 {

    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {//前序
        List<Integer> list = new LinkedList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {//中序
        List<Integer> list = new LinkedList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {//后序
        List<Integer> list = new LinkedList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        return list;
    }
}
