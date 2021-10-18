package 力扣;

import java.util.*;
public class 栈_计算器 {
    public int calculate(String s) {
        Stack<Integer> s1 = new Stack<>();//记录数字，最后s1只存加减数
        Stack<Character> s2 = new Stack<>();//记录加减
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)==' ') i++;
            else if(s.charAt(i)=='+'||s.charAt(i)=='-') s2.push(s.charAt(i++));
            else if(s.charAt(i)=='*'){//遇到乘除，直接乘除计算，将结果存到s1
                i++;
                while(i<s.length()&&s.charAt(i)==' '){
                    i++;
                }
                String str = new String();
                while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    str += s.charAt(i++);
                }
                s1.push(Integer.valueOf(str)*s1.pop());
            } else if(s.charAt(i)=='/'){
                i++;
                while(i<s.length()&&s.charAt(i)==' '){
                    i++;
                }
                String str = new String();
                while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    str += s.charAt(i++);
                }
                s1.push(s1.pop()/Integer.valueOf(str));
            } else {
                String str = new String();
                while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    str += s.charAt(i++);
                }
                s1.push(Integer.valueOf(str));
            }
        }
        int res = 0;
        while(!s1.isEmpty()){
            if(s2.isEmpty()) res+=s1.pop();//如果首个数字为正，则s1的size就比s2多一个
            else if(s2.pop()=='+') res+=s1.pop();
            else res-=s1.pop();
        }
        return res;
    }
}
