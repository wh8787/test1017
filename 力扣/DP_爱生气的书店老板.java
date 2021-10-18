package 力扣;

public class DP_爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int x[] = new int[len];//未使用最大值
        int y[] = new int[len];//使用后最大值
        x[0] = grumpy[0]==0 ? customers[0] : 0;
        y[0] = customers[0];
        int sum = customers[0];//以i位置为有边界的X大小窗口的到店总人数
        for(int i=1; i<len; i++){
            if(grumpy[i]==0) x[i] += x[i-1]+customers[i];
            else x[i] = x[i-1];
            if(i<X){
                sum += customers[i];
                y[i] += y[i-1]+customers[i];
            } else {
                sum += customers[i]-customers[i-X];
                y[i] = Math.max(x[i-X]+sum, y[i-1]+x[i]-x[i-1]);
            }
        }
        return y[len-1];
    }
}
