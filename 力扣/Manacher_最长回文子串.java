package 力扣;

public class Manacher_最长回文子串 {
    public static String manacher(String s){
        /*
        Manacher算法其实就是暴力解加速的方法：
        假设最右回文半径为R，中心为C。（最右回文：回文子串的右边界在整个字符串中的索引值最大）
        用数组len[i]表示以i位置字符为中心的回文子串半径（[i,子串的右边界]）
        1、如果当前字符在最右回文半径R内，则易知最右回文的另一边必然存在与当前位置对称的点i'=2*C-R，则
        如果以i'为中心的回文子串整个都包含在在最右回文子串中，根据对称性知，len[i]=len[i']，此时必然 len[i']<i'-L=R-i（L为最右回文左边界）。
        如果以i'为中心的回文子串没有包含在最右回文子串中，即i'左边界必然越过了最右回文的左边界，则len[i]的可能最长长度为R-i，接下来暴力搜索是否还存在更长回文半径len[i]。
        2、如果当前字符不在最右回文半径内，则以i为中心的回文最长       可能为当前字符本身，回文半径为1；然后暴力搜索是否存在更长的回文半径len[i]。
         */
        char ch[] = new char[s.length()*2+1];
        int count=0;
        for(int i=0; i<ch.length; i=i+2){
            ch[i] = '#';
            if(i<ch.length-1) ch[i+1] = s.charAt(count++);
        }
        int len[] = new int[ch.length];
        int R=-1, C=-1;//最右回文的右边界R和对称中心C
        int resIndex = 0, maxLen=0;
        for(int i=0; i<ch.length; i++){
            len[i] = R>i ? Math.min(len[C*2-i], R-i) : 1;//此时的len[i]表示以i为中心的可能的最短回文半径（半径包括中心点）
            while(i+len[i]<ch.length&&i-len[i]>=0&&ch[i+len[i]]==ch[i-len[i]])//寻找最长回文半径
                len[i]++;
            if(R<i+len[i]-1){
                R = i+len[i]-1;
                C = i;
            }
            if(len[i]>maxLen){
                maxLen = len[i];
                resIndex = i;
            }
        }
        String res = new String();
        for(int i=resIndex-maxLen+2; i<=resIndex+maxLen-1; i=i+2){
            res += ch[i];
        }
        return res;
    }
    public static void main(String args[]){
        String str = "cbbd";
        System.out.println(manacher(str));
    }
}
