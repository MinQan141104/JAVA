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
public class Main {
    public static void main(String[] args) {
        MyList my = new MyList();
        my.addFirst(5);
        my.addFirst(4);
        my.addFirst(3);
        my.addFirst(2);
        my.addFirst(1);
        my.addLast(6);
        my.display();
        my.addIndex(7, 6);
        my.display();
        my.addLast(8);
        my.display();
        my.deleteFirst();
        my.display();
        my.deleteLast();
        my.display();
        System.out.println("Phan tu vua bi xoa:" +my.delLast());
        System.out.println(my.get(2).value);
        my.display();
        System.out.println("phan tu dau bi xoa " + my.delFirst());
        //System.out.println(my.pos(0).value);
        my.display();
        System.out.println("Node cha cua node thu 4 la " + my.fatherIndex(4));
        System.out.println("Node cha cua node thu 3 la " + my.fatherIndex(3).value);
        System.out.println("Max :" + my.findMax().value);
        System.out.println(my.count());
        my.reverse();
        Node n = new Node(4);
        my.insertAfter(n, 0);
        my.insertNode(3, 2);
        //my.insertBefore(n, 1);
        my.display();
    }
}
