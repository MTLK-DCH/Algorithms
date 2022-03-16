package c1_3_DataStructures;

import java.util.Scanner;

public class StackTest {
    public static void main(String[] args) {
        // 将StackOfStrings类实例化为stack对象
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        //使用scanner类进行标准输入
        Scanner sc = new Scanner(System.in);
        //输入字符串
        String s = sc.nextLine();
        //处理字符串使之成为字符串数组
        String[] sl = s.split(" ");
        //测试stack对象功能，如果单词就压栈，如果“-”就弹出
        //foreach: for（type x : sth）{}
        for (String word : sl) {
            if (word.equals("-")){
                System.out.println(stack.pop());
            } else {
                stack.push(word);
            }
        }
    }

}
