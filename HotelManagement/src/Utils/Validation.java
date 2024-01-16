/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import HotelEntity.HotelInformation;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Luu Minh Quan
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    private static final String phone_valid = "0\\d{9}";
    public static int getInt(String msg, int min, int max){
        int n;
        while(true){
            try{
            System.out.println(msg);
            n = Integer.parseInt(sc.nextLine());
            if(n >= min && n <= max) break;
            throw new NumberFormatException();
            }catch(NumberFormatException e){
                System.out.println("Please insert integer number in range " + min + " -> " + max);
            }
        }
        return n;
    }
    public static String getString(String msg,String err, int mode, ArrayList<HotelInformation> hotelList){
        String s = "";
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(!s.isEmpty()){
                //Mode 
                //Neu mode la 1(add): nhap vao 1 hotel moi => ko duoc ton tai du lieu do
                //Neu mode la 2(check): hotel do phai co trong du lieu
                if(mode == 1 && !idExist(s, hotelList) || mode == 2 && idExist(s, hotelList)){
                    break;
                }
                System.err.println(err);
            }
        }
        return s;
    }
    
    public static String inputString(String msg, String err){
        String s = "";
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(!s.isEmpty()) break;
            System.err.println(err);
        }
        return s;
    }
    public static String inputHotelID(ArrayList<HotelInformation> arr, String reg) {
        String id = "";
        do {
            System.out.println("Enter id of hotel: ");
            id = sc.nextLine().toUpperCase();
            if (SearchHotelByID(arr, id) != null) {
                System.err.println("Duplicated code.Try with another one");
            } else if (id.trim().isEmpty()) {
                System.err.println("ID can not empty!");
            }else if(!id.matches(reg)){
                System.out.println("You must follow the format *HXX*!");
            }
            else {
                return id;
            }
        } while (true);
    }
    
    public static boolean idExist(String id, ArrayList<HotelInformation> hotelList){
        if(hotelList.isEmpty() || hotelList == null) return false;
        for (HotelInformation hotelInformation : hotelList) {
            if(id.equals(hotelInformation.getHotelId())){
                return true;
            }
        }
        return true;
    }
    public static boolean inputYN(String msg) {
        String choice = "";
        while(true){
            System.out.println(msg);
            choice = sc.nextLine();
            if(choice.equalsIgnoreCase("Y")){
                return true;
            }
            else if(choice.equalsIgnoreCase("N")){
                return false;
            }
            else{
                System.err.println("It must be Y or N!!!");
                //continue;
            }
        }
    }
    public static String inputPhone(String msg,HotelInformation hotel){
        String phone = "";
        Pattern pattern = Pattern.compile("0\\d{9}");
        while(true){
            System.out.println(msg);
            phone = sc.nextLine();
            if(phone.trim().isEmpty()){
                return hotel.getHotelPhone();
            }
            else if(!pattern.matcher(phone).matches()){
                System.out.println("Please enter the correct format of the phone with 10 numbers");
            }
            else{
                return phone;
            }
        }
    }
    public static String inputName(String msg, HotelInformation hotel){
        String name = "";
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");//^: start of the string
        while(true){                                               //[a-zA-Z]: bat cu chu cai nao // \\s : bao gom ca cach
            System.out.println(msg);                                //+ : lap lai theo nhieu lan //$: ket thuc 1 chu xem chu do co dat yc hay ko
            name = sc.nextLine();                           
            if(name.trim().isEmpty()){
                return hotel.getHotelName();
            }
            else if(!pattern.matcher(name).matches()){
                System.out.println("Please enter the correct format of the name");
            }
            else{
                return name;
            }
        }
    }
    public static HotelInformation SearchHotelByID(ArrayList<HotelInformation>  arr, String id){
        for (HotelInformation hotelInformation : arr) {
            if(hotelInformation.getHotelId().equals(id))
                return hotelInformation;
        }
        return null;
    }
    public static String inputHotel(String msg, HotelInformation hotel, String pt){
        String address = "";
        //Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s]+");
        while(true){
            System.out.println(msg);
            address = sc.nextLine();
            if(address.trim().isEmpty()){
                return hotel.getHotelAddress();
            }
            else if(!address.matches(pt)){
                System.out.println("Please enter the correct format of address");
            }
            else{
                return address;
            }
        }
    }

    public static String inputPattern(String msg, String pt){
        String result = "";
        //Pattern pattern = Pattern.compile(pt);
        System.out.println(msg);
        while(true){
            result = sc.nextLine();
            if(!result.trim().isEmpty() && result.matches(pt)){
                break;
            }
            else{
                System.out.println("Please correct the format!!!");
            }
        }
        return result;
    }
    
}
