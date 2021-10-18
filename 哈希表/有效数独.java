package 哈希表;

import java.util.*;

public class 有效数独 {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> list1 = new LinkedList<>();
        List<HashSet<Integer>> list2 = new LinkedList<>();
        List<HashSet<Integer>> list3 = new LinkedList<>();
        for(int i=0; i<9; i++){
            list1.add(new HashSet<>());
            list2.add(new HashSet<>());
            list3.add(new HashSet<>());
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.') continue;
                if(!list1.get(i).add(board[i][j]-'0')) return false;
                if(!list2.get(j).add(board[i][j]-'0')) return false;
                int p = (i/3)*3+j/3;
                if(!list3.get(p).add(board[i][j]-'0')) return false;
            }
        }
        return true;
    }
}
/*
建立三个链表，每个存放9个哈希表，分别用来检验每行、每列、每9个宫格是否存在相同的数字
 */