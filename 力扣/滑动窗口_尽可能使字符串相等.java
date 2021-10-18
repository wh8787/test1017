package 力扣;

public class 滑动窗口_尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] costs = new int[s.length()];
        for(int i=0; i<costs.length; i++){
            costs[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int left=0, right=0, sum=0, res=0;
        while(right<costs.length){
            if(sum<=maxCost){
                sum += costs[right++];
                if(sum<=maxCost) res = Math.max(res, right-left);
            } else {
                sum -= costs[left++];
            }
            if(left>right){
                right = left;
                sum = 0;
            }
        }
        return res;
    }
}
//滑动窗口