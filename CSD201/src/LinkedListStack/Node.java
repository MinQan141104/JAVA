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
public class Node {
    Node next;
    Object info;

    public Node(Node next, Object info) {
        this.next = next;
        this.info = info;
    }

    public Node(Object info) {
        this.info = info;
    }
    
}
