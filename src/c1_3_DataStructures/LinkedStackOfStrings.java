package c1_3_DataStructures;

//stack: FIFO (first in first out)
//pop & push
//isempty
//size


public class LinkedStackOfStrings {

    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
}
