/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.gui;

import fit5192.assignment.repository.entities.Car;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author dy
 */
public interface CarSaleSystemGUI {
    
    void clearTextFields();
    
    void displayMessageInDialog(String message);
    
    JButton getSearchButton();
    
    JButton getDetailButton();
    
    JTable getCarTable();
    
    String getMake();
    
    String getModelName();
    
    String getModelNo();
    
    String getModelType();
    
    void displaySimpleTable(Car car);
    
    void displaySimpleTable(List<Car> car);
    
    void displayComplexTable(Car car);
    
    void displayComplexTable(List<Car> car);
    
    void displaySimpleNull();
    
    void clearTable(); 
    
    boolean isCarSelected();
    
    
    String getSelectedCarVIN();
    
}
