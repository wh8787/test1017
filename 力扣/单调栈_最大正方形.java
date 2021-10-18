package 力扣;

import java.util.Stack;

public class 单调栈_最大正方形 {
    public int maximalSquare(char[][] matrix){
        int height[] = new int[matrix[0].length];
        int res = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            res = Math.max(res, subMax(height));
        }
        return res;
    }
    public static int subMax(int height[]){
        int left[] = new int[height.length];
        int right[] =new int[height.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<height.length; i++){
            while(!stack.isEmpty()&&height[stack.peek()]>=height[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i+1 : i-stack.peek();
            stack.add(i);
        }
        stack.clear();
        for(int i= height.length-1; i>=0; i--){
            while(!stack.isEmpty()&&height[stack.peek()]>=height[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? height.length-i : stack.peek()-i;
            stack.add(i);
        }
        int res = 0;
        for(int i=0; i<height.length; i++){
            //以下为求矩形面积
            // res = Math.max(res, height[i]*(left[i]+right[i]-1));
            //以下为求正方形面积
            int p = Math.min(left[i]+right[i]-1, height[i]);
            res = Math.max(res, p*p);
        }
        return res;
    }
}
