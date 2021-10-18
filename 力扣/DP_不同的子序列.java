package 力扣;

public class DP_不同的子序列 {
    public int numDistinct(String s, String t) {//dfs超时
        if(s.length()<t.length()) return 0;
        count(s, t, 0, new String());
        return res;
    }
    int res = 0;
    public void count(String s, String t, int k, String str){
        if(str.equals(t)){
            res++;
            return;
        }
        int p = str.length();
        for(int i=k; i<s.length(); i++){
            if(s.charAt(i)!=t.charAt(p)) continue;
            String str1 = str+t.charAt(p);
            count(s, t, i+1, str1);
        }
    }

    public int numDistinct_1(String s, String t){ //DP
        if(s.length()<t.length()||t.length()==0) return 0;
        int[][] dp = new int[t.length()][s.length()];
        dp[0][0] = s.charAt(0)==t.charAt(0) ? 1 : 0;
        for(int i=1; i<s.length(); i++)
            dp[0][i] = s.charAt(i)==t.charAt(0) ? dp[0][i-1]+1 : dp[0][i-1];
        for(int i=1; i<t.length(); i++){
            for(int j=i; j<s.length(); j++){
                dp[i][j] = s.charAt(j)==t.charAt(i) ? dp[i-1][j-1]+dp[i][j-1] : dp[i][j-1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    /*
    dp[i][j]表示用s的0~j元素来构成t的0~i元素组成的子串的子序列数量。
    如果s[j]==t[i]，则dp[i][j]=dp[i-1][j-1]+dp[i-1][j]，表示用0~j-1的s来构成t的0~i-1子串（最后一位s[j]与t[i]匹配）+用0~j-1的s来构成t的0~i子串总和。
    如果不等，则不存在s[j]与t[i]匹配，所以s[j]在此是多余的（s的最后一位只能作为t的最后一位，如果最后一位不同，s的最后一位是多余的），即dp[i][j]=dp[i][j-1]。
     */
}
