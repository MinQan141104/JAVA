/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.algorithms;

/**
 *
 * @author Luu Minh Quan
 */
public class MainDynamic {
    public static void main(String[] args){
        DynamicArray dynamicArray = new DynamicArray(5);
        
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("F");
        
        dynamicArray.delete("F");
        dynamicArray.delete("B");
        dynamicArray.delete("D");
        
        System.out.println(dynamicArray);
        System.out.println("size: "+dynamicArray.size);
        System.out.println("capacity: "+dynamicArray.capacity);
    }
}
