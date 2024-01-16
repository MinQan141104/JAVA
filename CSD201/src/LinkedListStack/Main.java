/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListStack;

import java.util.Scanner;

/**
 *
 * @author Luu Minh Quan
 */
public class Main {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        int choice ;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. Pop");
            System.out.println("4. Display All");
            System.out.println("5. Clear");
            System.out.println("0. Exit");
            System.out.println("    Your selection (0 -> 5): ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Push the element: ");
                    int a = sc.nextInt();
                    ms.push(a);
                    break;
                case 2:
                    System.out.println("Top element of the stack: " + ms.peek());
                    break;
                case 3: 
                    System.out.println("The stack has been popped!");
                    ms.pop();
                    break;
                case 4:
                    System.out.print("Stack: ");
                    ms.traverse();
                    break;
                case 5:
                    ms.clear();
                    System.out.println("Cleaned!");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                    
                default:
                    System.out.println("You must follow the number!!!");
                    continue;
            }
        }
    }
}
