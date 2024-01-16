/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadSaveFile;

import java.util.List;
import HotelEntity.HotelInformation;

/**
 *
 * @author Luu Minh Quan
 */
public class FileFunction {
    private final FileManager fm;

    public FileFunction() {
        fm = new FileManager();
    }
    
    public boolean loadDataFromFile(List<HotelInformation> hotel ,String fName){
        return fm.loadDataFromFile(hotel, fName);
    }
   
    public boolean saveDataToFile(List<HotelInformation> hotel,String fName){
        return fm.saveDataToFile(hotel, fName, "Hotel save file successfull!");
    }

}
