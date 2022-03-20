package c1_3_DataStructures;

//Use array s[] to store N items on stack
//push(): add new item at s[N]
//pop(): remove item from s[N-1]

//要注意需要动态调整数组大小，否则不够实用

public class ArrayStackOfStrings {

    private String[] s;
    private int N;

    public ArrayStackOfStrings() {
        s = new String[1];
    }

    public void push(String items) {
        //倍数原则，每次扩容一倍
        if (N == s.length)
            resize(2 * s.length);
        s[N++] = items;
    }

    public String pop(){
        String item = s[--N];
        s[N] = null;//移除不用的项，防止游离空间的出现
        //保证数组容量在四分之一到全满
        //当检测到数组大小小于四份之一容量后，将数组容量缩小一半
        if (N > 0 && N < s.length / 4)
            resize(s.length / 2);
        //返回弹出项
        return item;
    }

    private void resize(int capacity) {
        //中介数组
        String[] copy = new String[capacity];
        //复制
        if (N >= 0)
            System.arraycopy(s, 0, copy, 0, N);
        //将调整过大小后的数组赋值给s
        s = copy;
    }
}
