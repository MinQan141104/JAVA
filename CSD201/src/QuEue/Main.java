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
public class Main {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        mq.enqueue(4);
        mq.enqueue(5);
        mq.display();
        System.out.println(mq.dequeue());
        mq.display();
        System.out.println(mq.poll());
        mq.display();
    }
}
