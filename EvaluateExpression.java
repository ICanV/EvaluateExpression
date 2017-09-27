import java.util.ArrayList;

import java.util.List;

import java.util.Stack;

 

public class EvaluateExpression {

 

    public static void main(String[] args) {

        String s="(3*2+(20-12))/2+(2+3)";

     

        EvaluateExpression  e=new EvaluateExpression ();

        System.out.println("计算结果为："+e.Evaluate(e. makeList(s)));

         

    }

    public List<String> makeList(String str){

        List<String> list = new ArrayList<String>();

        String temp="";

        for(int i=0;i<str.length();i++){

            char ch=str.charAt(i);

         

            //判断是否为数字

            if (Character.isDigit(ch)) {

                temp+=String.valueOf(ch);

            }else{

                if(!temp.equals("")){

                    list.add(temp);

                }

                list.add(String.valueOf(ch));

                temp="";

            }

        }

        if(!temp.equals("")){

            list.add(temp);

        }

    list.add("#");

        return list;

    }

    public  String compare(String str1,String str2){

        switch(str1){

            case "+":

                if(str2.equals("+"))

                    return ">";

                if(str2.equals("-"))

                    return ">";

                if(str2.equals("*"))

                    return "<";

                if(str2.equals("/"))

                    return "<";

                if(str2.equals("("))

                    return "<";

                if(str2.equals(")"))

                    return ">";

                if(str2.equals("#"))

                    return ">";

                break;

            case "-":

                if(str2.equals("+"))

                    return ">";

                if(str2.equals("-"))

                    return ">";

                if(str2.equals("*"))

                    return "<";

                if(str2.equals("/"))

                    return "<";

                if(str2.equals("("))

                    return "<";

                if(str2.equals(")"))

                    return ">";

                if(str2.equals("#"))

                    return ">";

                break;

            case "*":

                if(str2.equals("+"))

                    return ">";

                if(str2.equals("-"))

                    return ">";

                if(str2.equals("*"))

                    return ">";

                if(str2.equals("/"))

                    return ">";

                if(str2.equals("("))

                    return "<";

                if(str2.equals(")"))

                    return ">";

                if(str2.equals("#"))

                    return ">";

                break;

            case "/":

                if(str2.equals("+"))

                    return ">";

                if(str2.equals("-"))

                    return ">";

                if(str2.equals("*"))

                    return ">";

                if(str2.equals("/"))

                    return ">";

                if(str2.equals("("))

                    return "<";

                if(str2.equals(")"))

                    return ">";

                if(str2.equals("#"))

                    return ">";

                break;

                 

            case "(":

                if(str2.equals("+"))

                    return "<";

                if(str2.equals("-"))

                    return "<";

                if(str2.equals("*"))

                    return "<";

                if(str2.equals("/"))

                    return "<";

                if(str2.equals("("))

                    return "<";

                if(str2.equals(")"))

                    return "=";

                if(str2.equals("#"))

                    return ">";

                break;

            case ")":

                if(str2.equals("+"))

                    return ">";

                if(str2.equals("-"))

                    return ">";

                if(str2.equals("*"))

                    return ">";

                if(str2.equals("/"))

                    return ">";

                if(str2.equals(")"))

                    return ">";

                if(str2.equals("#"))

                    return ">";

                break;

            case "#":

                if(str2.equals("+"))

                    return "<";

                if(str2.equals("-"))

                    return "<";

                if(str2.equals("*"))

                    return "<";

                if(str2.equals("/"))

                    return "<";

                if(str2.equals("("))

                    return "<";

                break;

        }

        return null;

    }

    public boolean isHave(String s){

        String[] strs={"+","-","*","/","(",")","#"};

        for(int i=0;i<strs.length;i++){ 

            if(strs[i].indexOf(s)!=-1){

            return true;

            } 

            } 

            return false;

    }

     

    public String Evaluate(List<String> list){

     

    Stack<String> stack0=new Stack<String>();//运算数栈

    Stack<String> stack1=new Stack<String>();//运算符栈

    stack1.push("#");

    String  str=list.remove(0);

 

    while((!stack1.peek().equals("#")) ||  (!list.isEmpty())){

     

        if(!this.isHave(str)){

            stack0.push(str);

            str=list.remove(0);

        }else{

         

            String str1=this.compare(stack1.peek(), str);

             

            switch(str1){

                case "<":

                    stack1.push(str);

                    str=list.remove(0);

                    break;

                case "=":

                    stack1.pop();

                    str=list.remove(0);

                    break;

                case ">":

                    String ch=stack1.pop();

                    int result=0;

                    int ch1=Integer.parseInt(stack0.pop());

                    int ch0=Integer.parseInt(stack0.pop());

                    if(ch.equals("+"))

                        result=ch0+ch1;

                    if(ch.equals("-"))

                        result=ch0-ch1;

                    if(ch.equals("*"))

                        result=ch0*ch1;

                    if(ch.equals("/"))

                        result=ch0/ch1;

                    stack0.push(String.valueOf(result));    

                    break;

            }

            }

         

    }

 

    return stack0.peek();

    }

             