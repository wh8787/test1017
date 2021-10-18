package 力扣;

public class 矩形覆盖 {
    public int rectCover(int target) {
        if(target==1||target==2) return target;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=target; i++)
            dp[i] = dp[i-1]+dp[i-2];
        return dp[target];
    }
}
/*
与爬楼梯问题相似。
要用n个矩形凑成2*n矩形，则：
可以通过对用n-1个矩形凑成的2*(n-1)矩形，添加一个竖着的矩形即可得到2*n矩形。
也可以通过对n-2个矩形凑成的2*(n-2)，添加一个2*2的正方形（由两个2*1矩形横着构成）即可得到2*n矩形。
ps:第二种情况不用两个矩形竖着构成2*2正方形，因为这包含在情况一当中了
 */