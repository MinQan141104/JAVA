/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuEue;

/**
 *
 * @author Luu Minh Quan
 */
public class MyQueue {
    Node head, tail;
    
    public MyQueue(){
        head = tail = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void enqueue(Object info){
        Node node = new Node(info);
        if(isEmpty()){
            head = tail = node;
        }
        else{
        tail.next = node;
        tail = node;
        }
    }
    public Object dequeue(){
        if(isEmpty()){ 
            return null;
        }
        else{
            Object info = head.info;
            head = head.next;
            return info;
        }
    }
    //get top value but not affect it
    public Object poll(){
        if(isEmpty()){
            return null;
        }
        Object info = head.info;
        return info;
    }
    public void clear(){
        head = tail = null;
    }
    public void display(){
        Node p = head;
        if(isEmpty()) return;
        while(p != null){
            System.out.print(p.info + ", ");
            p = p.next;
        }
        System.out.println();
    }
}
