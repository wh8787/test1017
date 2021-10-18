package 力扣;

import java.util.*;

public class 巧妙_格雷编码 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        int help = 1;
        list.add(0);
        for(int i=0; i<n; i++){//每次向高位加1
            for(int j=list.size()-1; j>=0; j--){//从list后往前加1，该层循环中添加的元素都有相同的位数，而且高位皆为1.
                list.add(list.get(j)+help);
            }
            help <<= 1;
        }
        return list;
    }
}
