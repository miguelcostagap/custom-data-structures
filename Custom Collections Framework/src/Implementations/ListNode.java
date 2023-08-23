package Implementations;

import Frameworks.Types.List;

public class ListNode {

    private Object data;
    private ListNode next;

    public ListNode(ListNode next,Object data){
        this.data = data;
        this.next = next;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public Object getData(){
        return data;
    }

}

