package 力扣;

import java.util.*;

public class 文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i=0;
        List<String> res = new LinkedList<>();
        while(i<words.length){
            int count = 0, start=i;
            List<String> help = new LinkedList<>();
            while(count<maxWidth){//将字符串长度和小于最大值的字符串都放到help中
                if(count+words[i].length()<=maxWidth){
                    count += words[i].length();
                    help.add(words[i++]);
                } else {
                    break;
                }
                if(i==words.length) break;
            }
            while(count+help.size()-1>maxWidth){//相邻字符串至少有一个空格（共size-1个空格），如果加入空格长度超了，就将链尾元素去掉，直到 空格+字符串长度和<=max。
                count -= words[--i].length();
                help.remove(help.size()-1);
            }
            if(start==i-1){//如果一行只能放一个字符串，就在该字符串后面补空格，直到长度为max
                String str = words[start];
                while(str.length()<maxWidth){
                    str += " ";
                }
                res.add(str);
                continue;
            }
            if(i==words.length){//如果到了最后一行，则字符串之间只留一个空格，后面用空格补齐到max。
                String str = String.join(" ", help);
                while(str.length()<maxWidth){
                    str += " ";
                }
                res.add(str);
                break;
            }
            //其他情况如下：相邻字符串用空格隔开，尽可能均匀分配空格数量，且左侧放置的空格数要多于右侧空格数。
            int p0 = (maxWidth-count)/(help.size()-1);
            String p = new String();
            for(int k=0; k<=p0; k++){//给相邻字符串之间放最多空格
                p += " ";
            }
            StringBuilder s = new StringBuilder(String.join(p, help));
            count = 0;
            int p2 = i-1;
            while(s.length()>maxWidth){//如果添加空格后长度超过max，则从最后空格往前，每个空格区间删除一个空格，直到长度等于max。
                count += words[p2].length();
                int p1 = s.length()-1-(i-1-p2)*p0-count;
                s.deleteCharAt(p1);
                p2--;
            }
            res.add(s.toString());
        }
        return res;
    }
}
