/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.gui;

import fit5192.assignment.repository.entities.Car;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dy
 */
public class TableGUIImpl extends JFrame implements CarSaleSystemGUI {
    private static final String[] SEARCHTABLE_COLUMNS={"VIN", "Manufacturer", "ModelName"};
    //private static final String[] DETAILSTABLE_COLUMNS={"VIN","ModelNo","ModelName","Manufacturer","Type","Thumbnail","Description","PreviewURL"};


    private final JButton searchButton;
    private final JButton detailsButton;
//    private final JButton closeButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    private final JPanel showPanel;
    //private final JPanel firstshowPanel;
    
    private final JLabel modelNoLabel;
    private final JLabel modelNameLabel;
    private final JLabel manufacturerLabel;
    private final JLabel typeLabel;
    
    private final JTextField modelNoTextField;
    private final JTextField modelNameTextField;
    private final JTextField manufacturerTextField;
    private final JComboBox typecomboBox;

    
    private final JTable carSearchTable;
    
    private Car car;
    private CarDetailsGUI carDetails;
    
    public TableGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener){
    
        super("Monash car sales system");
        //create buttons
        this.searchButton=new JButton("search");
        this.detailsButton=new JButton("detailsButton");
//        this.closeButton=new JButton("close");
    
        //create container
        Container container=this.getContentPane();
        
        //create labels
        this.modelNoLabel=new JLabel("ModelNo");
        this.modelNameLabel=new JLabel("ModelName");
        this.manufacturerLabel=new JLabel("Manufacturer");
        this.typeLabel=new JLabel("Type");
    
        //create textfields
        this.modelNoTextField=new JTextField();
        this.modelNameTextField=new JTextField();
        this.manufacturerTextField=new JTextField();
        
        this.typecomboBox = new JComboBox();
        this.typecomboBox.addItem("Please choose types of car:");
        this.typecomboBox.addItem("Sedan");
        this.typecomboBox.addItem("4 wheel drive");
        this.typecomboBox.addItem("Truck");
        
        
        //create table
        this.carSearchTable=new JTable(new DefaultTableModel(SEARCHTABLE_COLUMNS, 0));
        this.carSearchTable.getSelectionModel().addListSelectionListener(listSelectionListener);
        this.carSearchTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        TableColumnModel searchTableColumnModel=this.carSearchTable.getColumnModel();
        searchTableColumnModel.getColumn(0).setPreferredWidth(250);
        searchTableColumnModel.getColumn(1).setPreferredWidth(200);
        searchTableColumnModel.getColumn(2).setPreferredWidth(200);
                
        //create panels
        this.inputPanel=new JPanel();
        this.buttonPanel=new JPanel();
        this.showPanel=new JPanel();
       
        //this.firstshowPanel=new JPanel();
        //this.firstshowPane.setSize(100, 40);
        //set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(4,2));
        this.buttonPanel.setLayout(new GridLayout(1,3));
        this.showPanel.setLayout(new BorderLayout());
        
        //add action listeners
        this.searchButton.addActionListener(actionListener);
        this.detailsButton.addActionListener(actionListener);
//        this.closeButton.addActionListener(actionListener);
        
        //add components
        this.inputPanel.add(modelNoLabel);
        this.inputPanel.add(modelNoTextField);
        this.inputPanel.add(modelNameLabel);
        this.inputPanel.add(modelNameTextField);
        this.inputPanel.add(manufacturerLabel);
        this.inputPanel.add(manufacturerTextField);
        this.inputPanel.add(typeLabel);
        this.inputPanel.add(typecomboBox);
        
        //add buttons to panel
        this.buttonPanel.add(this.searchButton);
        this.buttonPanel.add(this.detailsButton);
//        this.buttonPanel.add(this.closeButton);

        this.showPanel.add(new JScrollPane(this.carSearchTable), BorderLayout.CENTER);

        
        //add panels to content pane;
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(showPanel,BorderLayout.CENTER);
        container.add(buttonPanel,BorderLayout.SOUTH);
         this.carSearchTable.getSelectionModel().addListSelectionListener(listSelectionListener);
        
        //change the default behaviour of the close button;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(650,570);
        this.setVisible(true);
    
    }

    @Override
    public void clearTextFields() {
        this.manufacturerTextField.setText("");
        this.modelNameTextField.setText("");
        this.modelNoTextField.setText("");
   //     this.descriptionTextField.setText("");
        //设置picture的panel
        this.typecomboBox.setSelectedItem("Please choose types of car: ");
    }
    
    @Override
    public void clearTable() {     
    int numberOfRow = this.carSearchTable.getModel().getRowCount();
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.carSearchTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }
    
    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }


    @Override
    public String getMake() {
        String make = this.manufacturerTextField.getText();
        if(make == null || make.isEmpty() || make.equals(""))
        {
            return null;
        }
        else
        {
            return make;
        }
    }

    @Override
    public String getModelName() {
        String modelName = this.modelNameTextField.getText();
        if(modelName == null || modelName.isEmpty() || modelName.equals(""))
        {
            return null;
        }
        else
        {
            return modelName;
        }
    }

    @Override
    public String getModelNo() {
        String modelNo = this.modelNoTextField.getText();
        if(modelNo == null || modelNo.isEmpty() || modelNo.equals(""))
        {
            return null;
        }
        else
        {
            return modelNo;
        }
    }

    @Override
    public String getModelType() {
        String modelType = this.typecomboBox.getSelectedItem().toString();
        if(modelType == null || modelType.isEmpty() || modelType.equals(""))
        {
            return null;
        }
        else
        {
            return modelType;
        }
    }
    
    
    

    @Override
    public JButton getDetailButton() {
        return detailsButton;
    }
    
    
    
    
    @Override
    public void displaySimpleTable(Car car)
    {
         this.clearTable();
        ((DefaultTableModel)this.carSearchTable.getModel()).addRow(new Object[]{car.getModelName(),car.getMake(),car.getModelNo(),"","","","",""});
    }
    
    @Override
    public void displaySimpleTable(List<Car> car)
    {
         this.clearTable();
         for (Car cars : car) {
            ((DefaultTableModel)this.carSearchTable.getModel()).addRow(new Object[]{cars.getVin(), cars.getMake(),cars.getModelName(),"","","","",""});
    
         }
    }
    
    @Override
     public void displayComplexTable(Car car)
    {
         this.clearTable();
        ((DefaultTableModel)this.carSearchTable.getModel()).addRow(new Object[]{car.getModelName(),car.getMake(),car.getModelNo(),car.getType(),car.getVin(),
            car.getColor(),car.getPrice(),car.getPreview_url()});
        
    }
    
    @Override
    public void displayComplexTable(List<Car> car)
    {
         this.clearTable();
         for(Car cars : car)
         {
            ((DefaultTableModel)this.carSearchTable.getModel()).addRow(new Object[]{cars.getModelName(),cars.getMake(),cars.getModelNo(),cars.getType(),cars.getVin(),
            cars.getColor(),cars.getPrice(),cars.getPreview_url()});
         }

    }

    @Override
    public void displaySimpleNull() {
        this.clearTable();
    }
    
    @Override
    public boolean isCarSelected() {
        return (this.carSearchTable.getSelectedRow() >= 0);
    }

    @Override
    public JTable getCarTable() {
        return carSearchTable;
    }

   
  

    @Override
    public String getSelectedCarVIN() {
        int selectedRowIndex = this.carSearchTable.getSelectedRow();
        String CarVIN = this.carSearchTable.getValueAt(selectedRowIndex, 4).toString();
        System.out.println("CarVIN=======1" + CarVIN +"2222");
        if((CarVIN == null) || (CarVIN.equals("")))
            return "1";
        else
            return CarVIN;
    }

    @Override
    public JButton getSearchButton() {
        return this.searchButton;
    }
    
 
    
    
}
