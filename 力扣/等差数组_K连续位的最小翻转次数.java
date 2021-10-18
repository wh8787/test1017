package 力扣;

public class 等差数组_K连续位的最小翻转次数 {
    public int minKBitFlips(int[] A, int K){
        int cur=0, res=0;//cur表示A[i]的翻转次数
        int diff[] = new int[A.length+1];//增加一个长度，是为了防止A.length-K位置溢出出错
        //diff[i]表示A[i]的翻转次数-A[i-1]的翻转次数，diff[i]+A[i-1]翻转次数=A[i]翻转次数
        for(int i=0; i<A.length; i++){
            cur += diff[i];//相加前cur表示A[i-1]的翻转次数，相加后表示A[i]的翻转次数
            if((cur+A[i])%2==0){
                //翻转次数cur为偶，A[i]为0时，A[i]翻转cur次还是等于本身A[i]=0;
                //翻转次数cur为奇，A[i]为1时，A[i]翻转cur次后，A[i]=0。
                //以上两种情况都要以当前位置开始的长度为K的子数组，再进行一次翻转，即cur++。
                if(i+K>A.length) return -1;//如果i位置翻转多次后为0，且i~A.length-1已经不足K个元素，则无法实现翻转，即该位置的0无法翻转为1.
                cur++;
                res++;//总翻转次数加 1.
                diff[i+K]--;//i~i+k-1位置增加了一次翻转，则A[i+K]翻转次数-A[i+K-1]翻转次数=diff[i+K]-1，即两者之差减1.
            }
        }
        return res;
    }
}
