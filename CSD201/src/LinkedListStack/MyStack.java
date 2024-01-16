/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListStack;

/**
 *
 * @author Luu Minh Quan
 */
public class MyStack {
    Node head;
    
    public MyStack(){
        head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void clear(){
        head = null;
    }
    public void push(Object info){
        Node node = new Node(info);
        if(isEmpty()){
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
        
        //head = new Node(info, head);
    }
    public Object pop(){
        if(isEmpty()) return null;
        else{
            Object info = head.info;
            head = head.next;
            return info;
        }
    }
    void traverse(){
        if(isEmpty()) return;
        Node p = head;
        while(p != null){
            System.out.print(p.info + ", ");
            p = p.next;
        }
        System.out.println("");
    }
    public Object peek(){
        if(isEmpty()){
            return null;
        }
        Object info = head.info;
        return info;
    }
}
