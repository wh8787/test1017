package 力扣;

public class 分治_DFS_至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length()-1, k);
    }
    public int dfs(String s, int left, int right, int k){
        if(left>right||right-left+1<k) return 0;
        int dic[] = new int[26];
        int res = 0;
        for(int i=left; i<=right; i++){
            dic[s.charAt(i)-'a']++;
        }
        int start=left, end=left;
        while(end<=right&&dic[s.charAt(end)-'a']>=k){
            end++;
        }
        if(end>right) return end-start;
        end = left;
        /*boolean flag = true;
        for(int i=0; i<26; i++){
            if(dic[i]>0&&dic[i]<k){
                flag = false;
                break;
            }
        }
        if(flag) return right-left+1;*/
        while(end<=right){
            while(start<=right&&dic[s.charAt(start)-'a']<k){
                start++;
            }
            if(start>right) break;
            end = start+1;
            while(end<=right&&dic[s.charAt(end)-'a']>=k){
                end++;
            }
            if(end-start>res){
                res = Math.max(res, dfs(s, start, end-1,k));
            }
            start = ++end;
        }
        return res;
    }
}
