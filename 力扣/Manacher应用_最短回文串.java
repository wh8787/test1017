package 力扣;

public class Manacher应用_最短回文串 {
    public String shortestPalindrome(String s) {//Manacher算法
        char ch[] = new char[s.length()*2+1];
        for(int i=0; i<ch.length; i=i+2){
            ch[i] = '#';
            if(i<ch.length-1) ch[i+1] = s.charAt(i/2);
        }
        int len[] = new int[ch.length];
        int R=-1, C=-1;//最右回文的右边界R和对称中心C
        int maxLen=1;
        for(int i=0; i<ch.length; i++){
            len[i] = R>i ? Math.min(len[C*2-i], R-i) : 1;//此时的len[i]表示以i为中心的可能的最短回文半径（半径包括中心点）
            while(i+len[i]<ch.length&&i-len[i]>=0&&ch[i+len[i]]==ch[i-len[i]])//寻找最长回文半径
                len[i]++;
            if(R<i+len[i]-1){
                R = i+len[i]-1;
                C = i;
            }
            if(len[i]-1==i&&len[i]-1>maxLen){
                maxLen = len[i]-1;
            }
        }
        String res = s;
        for(int i=maxLen; i<s.length(); i++){
            res = s.charAt(i)+res;
        }
        return res;
    }
}
