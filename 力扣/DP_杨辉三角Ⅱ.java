package 力扣;

import java.util.*;

public class DP_杨辉三角Ⅱ {
    public List<Integer> getRow(int rowIndex) {
        Integer dp[] = new Integer[rowIndex+1];
        Arrays.fill(dp, 1);
        if(rowIndex==0) return Arrays.asList(dp);
        for(int i=2; i<=rowIndex; i++){
            /*int help = dp[0];
            for(int j=1; j<i; j++){
                int temp = dp[j];
                dp[j] = help + dp[j];
                help = temp;
            }*/
            for(int j=i-1; j>0; j--){
                dp[j] = dp[j]+dp[j-1];
                //如果从前往后遍历，此时的dp[j-1]已经被改变，不再是上一层的dp[j-1]
                //因为当前状态与上一层之前的状态有关，所以要从后往前遍历
            }
        }
        return Arrays.asList(dp);
    }
}
