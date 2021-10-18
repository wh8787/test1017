package 力扣;

import java.util.*;

public class 二进制状态压缩_猜字谜 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));//或操作是把两个数的所有1位都组合到一起，如 101 | 011 = 111
            }
            if (Integer.bitCount(mask) <= 7) {//规定puzzles[i]长度为7
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }

            // 枚举子集方法一
            // for (int choose = 0; choose < (1 << 6); ++choose) {
            //     int mask = 0;
            //     for (int i = 0; i < 6; ++i) {
            //         if ((choose & (1 << i)) != 0) {
            //             mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
            //         }
            //     }
            //     mask |= (1 << (puzzle.charAt(0) - 'a'));
            //     if (frequency.containsKey(mask)) {
            //         total += frequency.get(mask);
            //     }
            // }

            // 枚举子集方法二
            int subset = mask;//subset表示子集
            do {//遍历puzzles[i]对应的二进制子集（且子集必须含有首字母）s：如"abfd"除去首字母的"bfd"二进制为mask=10101，其子集有10000,00100,00001,10100,10001,00101,10101
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));//在此添加首字母，是为了保证对应的words中必须含有该首字母。此时s表示完整的含有首字母的puzzles[i]子集
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;//相与是为了找到子集（子集的1位必须与puzzles[i]的二进制相同）
            } while (subset != mask);

            ans.add(total);
        }
        return ans;
    }
}
