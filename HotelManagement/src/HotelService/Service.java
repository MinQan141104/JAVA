/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelService;

import Application.GUI.Menu;
import HotelEntity.HotelInformation;
import LoadSaveFile.FileFunction;
import Utils.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Luu Minh Quan
 */
public class Service implements IService {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<HotelInformation> hotelList;
    private FileFunction fi;
    private HotelInformation hi;

    public Service() {
        hotelList = new ArrayList<>();
        fi = new FileFunction();
        try {
            fi.loadDataFromFile(hotelList, "Hotel.dat");
        } catch (Exception e) {
            System.out.println("List empty");
        }

        if (hotelList.isEmpty()) {
            System.out.println("Empty list, add new one");
            addHotel();
        }
    }

    @Override
    public void addHotel() {
        String hotelId;
        String hotelName;
        int hotelRoomAvailable;
        String hotelAddress;
        String hotelPhone;
        int hotelRating;
        boolean choice = true;
        boolean choice1 = false;

        while (choice) {
            hotelId = Validation.inputHotelID(hotelList, "^H\\d{2}$");//Validation.inputHotelID(hotelList);
            //hotel_id = Validation.getString("Enter Hotel ID: ", "It cant empty and must be unique", 1, hotelList);
            hotelName = Validation.inputPattern("Enter hotel name: ", "^[a-zA-Z\\s]+$");
            hotelRoomAvailable = Validation.getInt("Enter the number of available rooms: ", 1, 1000);
            hotelPhone = Validation.inputPattern("Enter hotel phone(0XXXXXXXXX): ", "0\\d{9}");
            hotelAddress = Validation.inputPattern("Enter hotel address: ", "^[a-zA-Z0-9,/\\s]+$");
            hotelRating = Validation.getInt("Enter hotel rating(0-6): ", 0, 6);
            hotelList.add(new HotelInformation(hotelId, hotelName, hotelRoomAvailable, hotelAddress, hotelPhone, hotelRating));

            choice1 = Validation.inputYN("Do you want to write this to file? Y/N");
            if (choice1) {
                fi.saveDataToFile(hotelList, "Hotel.dat");
            }
            choice = Validation.inputYN("Do you want to continue Y/N?");
        }
    }

    @Override
    public void checkExistHotel() {
        String id = Validation.inputString("Enter ID to check: ", "ID cant be empty!!!");
        ArrayList<HotelInformation> hotel = new ArrayList<>();
        fi.loadDataFromFile(hotel, "Hotel.dat");
        //boolean check = Validation.idExist(id, hotelList);
        HotelInformation temp = Validation.SearchHotelByID(hotel, id);
        if (temp != null) {
            System.out.println("Exist Hotel");
            System.out.println(temp);
        } else {
            System.out.println("No Hotel Found!");
        }
    }

    @Override
    public void updateHotelInfomation() {
        String hotelId;
        String hotelName;
        int hotelRoomAvailable;
        String hotelAddress;
        String hotelPhone;
        int hotelRating;
        String id = Validation.inputString("Enter hotel ID: ", "ID cant blank!");
        boolean check = true;
        //fi.loadDataFromFile(hotelList, "Hotel.dat");
        HotelInformation hotel = Validation.SearchHotelByID(hotelList, id);
        if (hotel != null) {
            System.out.println("Found!!!\n" + hotel + "\nEnter new information");
            hotelName = Validation.inputHotel("Enter hotel name: ", hotel, "^[a-zA-Z\\s]+$");
            hotelRoomAvailable = Validation.getInt("Enter room available: ", 1, 1000);
            hotelAddress = Validation.inputHotel("Enter hotel address: ", hotel, "^[a-zA-Z0-9,/\\s]+$"); //^[a-zA-Z0-9\\s]+
            hotelPhone = Validation.inputHotel("Enter hotel phone: ", hotel, "0\\d{9}");
            hotelRating = Validation.getInt("Enter hotel rating(1-6): ", 1, 6);

            HotelInformation existingHotel = hotelList.get(hotelList.indexOf(hotel));

            existingHotel.setHotelAddress(hotelAddress);
            existingHotel.setHotelName(hotelName);
            existingHotel.setHotelRoomAvailable(hotelRoomAvailable);
            existingHotel.setHotelPhone(hotelPhone);
            existingHotel.setHotelRating(hotelRating);
            existingHotel.setHotelId(id);

            // Update the object in the list
            hotelList.set(hotelList.indexOf(hotel), existingHotel);
            //hotelList.set(hotelList.indexOf(hotel), new HotelInformation(id, hotelName, hotelRoomAvailable, hotelAddress, hotelPhone, hotelRating));
            System.out.println("After updating: ");
            System.out.println(hotel);
            fi.saveDataToFile(hotelList, "Hotel.dat");

        } else {
            System.out.println("Hotel does not exist");
        }
    }

    @Override
    public void deleteHotel() {
        String id = Validation.inputString("Enter ID to delete hotel: ", "ID cant empty");
        HotelInformation hotel = Validation.SearchHotelByID(hotelList, id);
        boolean check;
        boolean condition = false;
        if (hotel == null) {
            System.out.println("Cant Found ID");
        }
        while (hotel != null) {
            System.out.println("Do you ready want to delete this hotel?");
            check = Validation.inputYN("Yes or No(Y/N)?");
            if (check) {
                hotelList.remove(hotel);
                System.out.println("Removed Successfully");
                condition = true;
                break;
            } else {
                System.out.println("Failed to remove");
                break;
            }
        }
        if (condition) {
            fi.saveDataToFile(hotelList, "Hotel.dat");
        }
    }

    @Override
    public void searchHotel() {
        ArrayList<HotelInformation> arr = hotelList;
        boolean check = false;
        int choice;
        String[] op1 = {"================================", "       Searching Options     ", "    5.1 Searching by Hotel_id.(Enter 1)",
            "    5.2 Searching by Hotel_address.(Enter 2)"};
        for (String string : op1) {
            System.out.println(string);
        }
        do {
            choice = Validation.getInt("Enter option: ", 1, 3);
            switch (choice) {
                case 1:

                    String id = Validation.inputString("Enter ID to search: ", "ID cant empty");
                    //Collections.sort(arr, Comparator.comparing(HotelInformation::getHotelId).reversed());
                    for (HotelInformation tmp : arr) {
                        if (tmp.getHotelId().contains(id)) {
                            System.out.println(tmp);
                            check = true;
                        }
                    }
                    if (!check) {
                        System.out.println("Can't found hotel ID");
                    }
                    break;
                case 2:
                    String address = Validation.inputString("Enter hotel address to search: ", "Hotel address cant empty");
                    Collections.sort(arr, Comparator.comparing(HotelInformation::getHotelRoomAvailable).reversed());
                    for (HotelInformation tmp : arr) {
                        if (tmp.getHotelAddress().contains(address)) {
                            System.out.println(tmp);
                            check = true;
                        }
                    }
                    if (!check) {
                        System.out.println("Can't found hotel address");
                    }
                    break;
                default:
                    System.out.println("Bye!");
                    break;
            }
        } while (choice == 1 || choice == 2);
    }

    @Override
    public void displayHotel() {
        ArrayList<HotelInformation> temp = new ArrayList<>();
        fi.loadDataFromFile(temp, "Hotel.dat");
        Collections.sort(temp, Comparator.comparing(HotelInformation::getHotelName).reversed());
        if (temp == null) {
            System.out.println("Empty List");
        } else {
            System.out.println("__________________________________________________________________________________________________________________");
            System.out.printf("|%-9s|%-17s|%-25s|%-30s|%-11s|%-86s|\n", "Hotel_id", "Hotel_Name", "Hotel_Room_Available", "Hotel_Address", "Hotel_Phone", "Hotel_Rating");
            System.out.println("__________________________________________________________________________________________________________________");
            for (HotelInformation hotelInformation : temp) {
                System.out.print(hotelInformation);
            }
        }
    }

    public void SaveData() {
        fi.saveDataToFile(hotelList, "Hotel.dat");
    }
}
