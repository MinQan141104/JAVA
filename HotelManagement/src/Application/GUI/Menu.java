/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GUI;

import HotelService.Service;
import Utils.Validation;
import java.util.Scanner;

/**
 *
 * @author Luu Minh Quan
 */
public class Menu {

    public static String[] ops = {
        "1) Adding new Hotel.",
        "2) Checking exits Hotel.",
        "3) Updating Hotel information.",
        "4) Deleting Hotel.",
        "5) Searching Hotel.",
        "6) Displaying a hotel list(descendingly Hotel_Name).",
        "7) Save to File",
        "8) Others->Quit."
    };

    public static int getChoice() {
        //Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((ops[i]));
        }
        return Validation.getInt("Your choice: ", 1, ops.length);
    }

    public static void display() {
        Service s = new Service();
        int choice;
        do {
            System.out.println("==========Hotel Management=========");
            choice = getChoice();
            switch (choice) {
                case 1:
                    s.addHotel();
                    break;
                case 2:
                    s.checkExistHotel();
                    break;
                case 3:
                    s.updateHotelInfomation();
                    break;
                case 4:
                    s.deleteHotel();
                    break;
                case 5: 
                    s.searchHotel();
                    break;
                case 6 :
                    s.displayHotel();
                    break;
                case 7: 
                    s.SaveData();
                    break;
                default:
                    System.out.println("Bye!");
            }
        }while(choice != 8);
    
    }
}
