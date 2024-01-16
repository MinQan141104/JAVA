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
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int value) {
        //ktra xem nếu value là số nguyên tố -> do nothing

        Node node = new Node(value);
        //if(checkPrime(value)) return;
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    boolean checkPrime(int value) {
        if (value < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        System.out.println("");
    }

    void addIndex(int value, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node cur = head;
            int fatherIndex = 0;
            while (cur != null) {
                if (index - 1 == fatherIndex) {
                    break;
                }
                cur = cur.next;
                fatherIndex++;
            }
            //if(cur == null) return; se ko gan duoc cai tail vao neu minh goi ham addLast()
            if (cur.next == null) {
                addLast(value);
            } else {
                Node node = new Node(value);
                node.next = cur.next;
                cur.next = node;
            }
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        } else {
            head = head.next;
        }
    }

    int delFirst() {
        if (isEmpty()) {
            return -1;
        } else {
            Node cur = head;
            head = cur.next;
            int value = cur.value;
            return value;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            return;
        } else {
            Node cur = head;
            while (cur.next != tail) {
                cur = cur.next;
            }
            cur.next = null;
            tail = cur;
        }
    }

    int delLast() { //doi voi truong hop mang chi co 1 phan tu, khi delLast se bi loi con delFirst ko bi
        if (isEmpty()) {
            return -1;
        }
        int value;
        if(head == tail){
            value = head.value;
            head = null;
            tail = null;
            return value;
        }
        else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            value = cur.next.value;
            cur.next = null;
            tail = cur;
            return value;
        }
    }

    public Node get(int k) {
        Node cur = head;
        int c = 0;
        while (cur != null && c < k) {
            c++;
            cur = cur.next;
        }
        return cur;
    }

    public Node search(int x) {
        Node p = head;
        while (p != null && p.value != x) {
            p = p.next;
        }
        return p;
    }

    public void deleteNode(Node y) {
        if (head == null || y == null) {
            return;
        }
        Node cur = head;
        while (!cur.equals(y)) {
            cur = cur.next;
        }
        Node next = cur.next.next;
        cur.next = next;
    }

    void insertAfter(Node q, int x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node cur = head;
        while(cur.next != null && cur != q){
            cur = cur.next;
        }
        if(cur.next == null) return;
        if(cur == tail) addLast(x);
        Node node = new Node(x);
        node.next = cur.next;
        cur.next = node;
    }
    
    void insertBefore(Node q, int x){
        if(isEmpty() || q == null){
            return;
        }
        if(q == head){
            addFirst(x);
            return;
        }
        Node f = head;
        while(f != null && f.next != q){
            f = f.next;
        }
        if(f == null) return; //q ko co trong list
        insertAfter(f, x);
    }
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }
    public void insertNode(int x, int k){
        
        Node newNode = new Node(x);
        Node q = get(k);
        Node temp = q.next;
        q.next = newNode;
        newNode.next = temp;
        
    }
    Node fatherIndex(int k){
        Node cur = head;
        int pos = 0;
        if(k <= 0) return null;
        while(cur.next != null){
            if(k - 1 == pos) break;
            pos++;
            cur = cur.next;
        }
        if(cur.next == null) return null; //index qua lon
        return cur;
    }
    int delIndex(int index){
        if(index < 0) return -1;
        if(index == 0) return delFirst();
        Node cur = fatherIndex(index);
        if(cur == null) return -1;
        else{
            int value = cur.next.value;
            cur.next = cur.next.next;
            return value;
        }
    }
    Node findMax(){
        Node p = head;
        int x = p.value;
        for(Node i = head; i != null; i = i.next){
            if(i.value > x){
                x = i.value;
            }
        }
        Node node = new Node(x);
        return node;
    }
    Node findMin(){
        Node p = head;
        int x = p.value;
        for(Node i = head; i != null; i = i.next){
            if(i.value < x){
                x = i.value;
            }
        }
        Node min = new Node(x);
        return min;
    }
    void swap(Node a, Node b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
    public int count(){
        if(isEmpty()) return 0;
        Node cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void reverse(){
        int a = 0;
        int b = count() - 1;
        while(a < b){
            Node start = get(a);
            Node end = get(b);
            swap(start, end);
            a++;
            b--;
        }
    }
}
