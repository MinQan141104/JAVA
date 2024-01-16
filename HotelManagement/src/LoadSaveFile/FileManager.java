/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadSaveFile;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author Luu Minh Quan
 */
public class FileManager {
    public <T> boolean saveDataToFile(List<T> list, String FName, String msg) {
        try {
            //OutputStream out = new FileOutputStream("C:\\Users\\Luu Minh Quan\\Documents\\NetBeansProjects\\HotelManagement\\Hotel.dat");
            File f = new File(FName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(fos);
            for (T item : list) {
                o.writeObject(item);
            }
            fos.close();
            o.close();
            System.out.println(msg);
            return true; // Indicates a successful save
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
   
    
    public <T> boolean loadDataFromFile(List<T> list, String FName) {
        try {
            // check file exists
            java.io.File f = new java.io.File(FName);
            if (!f.exists()) {
                return false;
            }
            // read file
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if (f.length() == 0) {
                System.err.println("File is empty");
            }
            boolean check = true;
            while (check) {
                try {
                    T c = (T) ois.readObject();
                    list.add(c);
                } catch (EOFException e) {
                    break;
                }
            }
            fis.close();
            ois.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
