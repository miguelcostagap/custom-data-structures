package Implementations;

import Frameworks.Types.List;

public class LinkedList implements List {

    private int size = 0;  // list size
    private ListNode head = null;

    @Override
    public int getSize() {
        System.out.println(size);
        return size;
    }

    @Override
    public boolean add(Object data) {

        ListNode newNode = new ListNode(null, data); // create new node

        // if there isn't any node created yet...
        if(head == null){
            head = newNode;
        }

        // if there is one, check which one is the last one, and change null to this node's reference
        else{
            ListNode iterator = head; // create iterator node

            while(iterator.getNext() != null){

                // iterator is now the last node
                iterator = iterator.getNext();
            }

            // gives the last node the reference to the new node
            iterator.setNext(newNode);
        }

        size++; // increase list size

        System.out.println("Successfully added!");
        return true;
    }

    @Override
    public boolean remove(Object data) {

        // this will remove every data found in the list that matches the argument (in case there is repeated data)

        boolean removed = false; // if we return directly inside the methods it doesn't remove repeated data

        // if the first node has the data that we want to delete
        if(head.getData() == data){
            head = head.getNext();
            System.out.println("The data has been removed!");
            size--;
            removed = true;
        }

        ListNode iterator = head.getNext(); // iterator node, that starts one node ahead
        ListNode previous = head; // node to change next, so it doesn't lose the nodes connection

        while(iterator.getNext() != null) {
            if(iterator.getData().equals(data)){
                previous.setNext(iterator.getNext());
                size--;
                System.out.println("The data has been removed!");
                removed = true;
            }
            previous = iterator; // update the previous to the position before iterator
            iterator = iterator.getNext();  // assign to the iterator the reference of the last node checked, so we can verify it out of the loop
        }

        // if the last node's data matches the argument delete node
        if(iterator.getData() == data){
            System.out.println("The data has been removed!");
            size--; // decrease list size
            removed = true;
        }

        System.out.println("That data does not exist!");
        return removed;
    }


    @Override
    public boolean contains(Object data) {

        ListNode iterator = head; // iterator node

        while(iterator.getNext() != null) {
            if(iterator.getData().equals(data)){
                System.out.println("Yes, that data exists!");
                return true;
            }
            iterator = iterator.getNext();  // assign the iterator the reference of the last node checked so we can verify it out of the loop
        }

        // look for the last one to check if already exists
        if (iterator.getData() == data) {
            System.out.println("Yes, that data exists!");
            return true;
        }

        System.out.println("That data does not exists!");
        return false;
    }

    @Override
    public boolean isEmpty() {
        System.out.println((head == null) ? "List is empty!" : "List is not empty!");
        return head == null;
    }

    @Override
    public void clear() {
        System.out.println((head == null) ? "List is already empty!" : "List has been emptied!");
        head = null;
        size = 0;
    }

    @Override
    public Object getData(int index) {

        int indexCount= 0;

        // if index is 0 we want the data from head
        if(index == 0){
            System.out.println(head.getData().toString());
            return head.getData();
        }

        ListNode iterator = head; // iterator node

        while(iterator.getNext() != null) {

            if(index == indexCount){
                System.out.println(iterator.getData().toString());
                return iterator.getData();
            }

            indexCount++;
            iterator = iterator.getNext();  // assign the iterator the reference of the last node checked so we can verify it out of the loop
        }

        // check if the index we want is the last one
        if (indexCount + 1 == index) {
            System.out.println(iterator.getData().toString());
            return iterator.getData();
        }

        System.out.println("That index does not exists!");
        return null;
    }

    @Override
    public int indexOf(Object data) {

        int indexCount= 0;

        // if data is in head, return 0
        if(head.getData() == data){
            System.out.println("The index of that data is " + indexCount);
            return 0;
        }

        ListNode iterator = head; // iterator node

        while(iterator.getNext() != null) {

            if(iterator.getData() == data){
                System.out.println("The index of that data is " + indexCount);
                return indexCount;
            }

            indexCount++;
            iterator = iterator.getNext();  // assign the iterator the reference of the last node checked so we can verify it out of the loop
        }

        // check if the index we want is the last one
        if (iterator.getData() == data) {
            System.out.println("The index of that data is " + indexCount);
            return indexCount + 1;
        }

        System.out.println("That data does not exist!");
        return -1;
    }

    @Override
    public List listBetween(int from, int to) {
        // git discussions doubt?
        return null;
    }
}
