package 力扣;

public class KMP_判断str2为str1的子串 {
    public static boolean KMP(String str1, String str2){
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();
        int next[] = getNext(ch2);
        int index1=0, index2=0;
        while(index1<ch1.length && index2<ch2.length){
            if(ch1[index1]==ch2[index2]){
                index1++;
                index2++;
            } else if(index2==0){
                index1++;
            } else {
                index2 = next[index2];
            }
        }
        return index2==str2.length();
    }
    public static int[] getNext(char[] ch){
        int[] next = new int[ch.length];
        next[1] = 0;
        int index1=0, index2=2;
        while(index2<next.length){
            if(ch[index2-1]==ch[index1]){
                next[index2++] = ++index1;
            } else if(index1==0) {
                index2++;
            } else {
                index1 = next[index1];
            }
        }
        return next;
    }
    public static void main(String args[]){
        String str2 = "abkababkabF";
        String str1 = "abkababkababkabF";
        System.out.println(KMP(str1,str2));
        String str = "abababcbab";
        int next[] = getNext(str.toCharArray());
        for(int i : next){
            System.out.print(i+" ");
        }
    }
}
/*
next[i]表示i的最长前缀的长度，如 "abcabcd"，'d'的最长前缀为"abc"。
最长前、后缀：从0位置开始的子串（最长前缀）==以i-1位置结束的子串（最长后缀），这两段相同的子串就是最长前、后缀（注意子串长度要小于i）。又如"aaaaac"，'c'的最长前后缀为"aaaa"。
所以在判断str2是否为str1的子串时，通过next可实现加速：
如果str1[index1]==str2[index2]，则继续往后匹配即可，index1++，index2++。
如果不等，则要重新匹配：
1）如果index2==0，则必然不存在前缀子串，str1继续后移与str2从头重新匹配，index1++。
2）如果不等于0，则只要跳到index2的最长前缀的下一位与str1的index1继续匹配，index2=next[index2]。
最后，如果index2能搜索到str2的尾部，即index2==str2.length()，则说明str2是str1的子串。
*/
