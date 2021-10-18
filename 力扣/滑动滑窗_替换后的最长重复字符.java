package 力扣;

public class 滑动滑窗_替换后的最长重复字符 {
    public int characterReplacement(String s, int k){
        /*int left=0, right=0;
        int res = 0;
        while(right<s.length()){
            int maxCount = 0;
            int count[] = new int[26];
            for(int i=left; i<=right; i++){
                count[s.charAt(i)-'A']++;
                maxCount = Math.max(maxCount, count[s.charAt(i)-'A']);
            }
            if(right-left+1<=maxCount+k){
                res = Math.max(right-left+1, res);
                right++;
            } else {
                left++;
            }
        }
        return res;*/
        if(s.length()==0) return 0;
        int count[] = new int[26];
        int res = 0;
        int maxCount = 0, start=0, end=0;
        count[s.charAt(end)-'A']++;
        while(end<s.length()){
            maxCount = Math.max(maxCount, count[s.charAt(end)-'A']);
            if(maxCount+k>=end-start+1){
                res = Math.max(res, end-start+1);
                end++;
                if(end!=s.length()) count[s.charAt(end)-'A']++;
            } else {
                count[s.charAt(start)-'A']--;
                start++;
            }
        }
        return res;
    }
}
