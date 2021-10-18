package 力扣;

import java.util.Stack;

public class 未完成_字符串解码 {
    public static String decodeString(String s){
        Stack<Character> stack = new Stack<>();
        String res = new String();
        String help = new String();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=']'){
                stack.push(s.charAt(i));
            } else {
                String str = new String();
                while(stack.peek()!='['){
                    str = stack.pop()+str;
                }
                str += help;
                help = str;
                stack.pop();
                String count = new String();
                while(!stack.isEmpty()&&stack.peek()>='0'&&stack.peek()<='9'){
                    count = stack.pop()+count;
                }

                for(int j=1; j<Integer.valueOf(count); j++){
                    help += str;
                }

                if(stack.isEmpty()) {
                    res += help;
                    help = new String();
                }
            }
        }

        return res;
    }
    public String method2(String s){
        Stack<Character> stack = new Stack<>();
        String res = new String();
        String help = new String();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=']'){
                stack.push(s.charAt(i));
            } else {
                String str = new String();
                while(stack.peek()!='['){
                    str = stack.pop()+str;
                }
                str += help;
                help = str;
                stack.pop();
                String count = new String();
                while(!stack.isEmpty()&&stack.peek()>='0'&&stack.peek()<='9'){
                    count = stack.pop()+count;
                }

                for(int j=1; j<Integer.valueOf(count); j++){
                    help += str;
                }

                if(stack.isEmpty()) {
                    res += help;
                    help = new String();
                }
            }
        }
        help = new String();
        while(!stack.isEmpty()) help = stack.pop()+help;
        return res+help;
    }
    public static void main(String args[]){
        String str = "2[2[y]pq4[2[jk]e1[f]]]";
        System.out.println(decodeString(str));
    }
}
