package 力扣;

public class 逻辑思维题_表示数值的字符串 {
    public boolean isNumber(String s) {
        s = s.trim();//消除首尾空格
        if(s.length()==0||(s.length()==1&&s.charAt(0)=='.')) return false;
        return check(s, 0, false, false);
    }
    public boolean check(String s, int i, boolean flag, boolean flag1){
        if(i==s.length()) return false;
        if(s.charAt(i)=='e'||s.charAt(i)=='E') return false;//不能以'e'或'E'开头
        if(s.charAt(i)=='+'||s.charAt(i)=='-'){//正负号只能在开头或者'e'之后出现
            if(s.length()<=i+1||s.charAt(i+1)=='+'||s.charAt(i+1)=='-'||s.charAt(i+1)=='e'||s.charAt(i+1)=='E'){//'+''-'后面不能接这些符号
                return false;
            }
            i++;//消除正负号，在遇到'e'之前不能再出现正负号
        }
        while(i<s.length()){
            //if(s.charAt(i)=='+'||s.charAt(i)=='-') return false;//在遇到'e'之前不能再出现正负号
            if(flag&&s.charAt(i)=='.') return false;//flag==true表示已经出现过'.'（它在整个数字中只能出现一次）
            if(s.charAt(i)=='.') {
                if(i+1<s.length()&&(s.charAt(i+1)=='e'||s.charAt(i+1)=='E')&&i==0) return false;//特殊情况 ".e"为错，如果.之前没有
                if(i+1==s.length()&&(i>0&&s.charAt(i-1)>'9'||s.charAt(i-1)<'0')) return false;
                //"4.e3"表示4*10^3，而".e"".e3"均为无效值，e前面必须有数字（小数或整数）
                flag=true;//'.' 只能出现一次
                i++;
                continue;
            }
            if(s.charAt(i)=='e'||s.charAt(i)=='E') {//'e'只能出现一次
                if(flag1) return false;
                else return check(s, i+1, true, true);
            }
            if(s.charAt(i)>'9'||s.charAt(i)<'0') return false;//除了'.''e'和数字，其他字符均不能出现（所以循环中第一个判断正负号不要也行）
            i++;
        }
        return true;
    }
}
