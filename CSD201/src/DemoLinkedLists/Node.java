/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoLinkedLists;

/**
 *
 * @author Luu Minh Quan
 */
public class Node {
    int value;
    Node next;
    
    public Node(){
        
    }

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    
}
