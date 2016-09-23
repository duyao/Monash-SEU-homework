/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment;

import fit5192.assignment.gui.CarDetailsGUI;
import fit5192.assignment.gui.CarSaleSystemGUI;
import fit5192.assignment.gui.TableGUIImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.ejb.EJB;
import fit5192.assignment.repository.CarRepository;
import fit5192.assignment.repository.entities.Car;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author dy
 */
public class CarSaleSystem implements ActionListener, ListSelectionListener {

    @EJB
    private static CarRepository carRepository;

    private String name;

    private TableGUIImpl gui;

    public CarSaleSystem(String name) {
        this.name = name;
    }

    public void initView() {
        this.gui = new TableGUIImpl(this, this);
    }

    public static void main(String[] args) {
        try {
            final CarSaleSystem agency = new CarSaleSystem("CarSaleSystem");
            //JDK 1.7
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    agency.initView();
                }
            });
//            //JDK 1.8
//            SwingUtilities.invokeLater(()-> {
//                agency.initView();
//            });
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == gui.getDetailButton()) {
            int row = gui.getCarTable().getSelectedRow();
            System.out.println("row->"+row);
            if (row == -1) {
                JOptionPane.showMessageDialog(gui, "Please select one row firsly and then view details!");
                return;
            }
            String vin = (String) gui.getCarTable().getValueAt(row, 0);
            System.out.println("vin->"+vin);
            Car car = carRepository.searchVIN(vin);
            System.out.println("select car->"+car.toString());
            CarDetailsGUI carDetailsGUI = new CarDetailsGUI(gui, "Car details", true, car);
            carDetailsGUI.setVisible(true);
        } else if (e.getSource() == gui.getSearchButton()) {
            try {
                int res = displaySimpleResult();
                if (res == 0) {
                    JOptionPane.showMessageDialog(this.gui, "No such car!");
                }
            } catch (Exception ex) {
                Logger.getLogger(CarSaleSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int displaySimpleResult() throws Exception {
        String make = gui.getMake();
        String carName = gui.getModelName();
        String carNo = gui.getModelNo();
        String type = gui.getModelType().equals("Please choose types of car:") ? null : gui.getModelType();

        System.out.println("make is :" + make);
        System.out.println("CarName is :" + carName);
        System.out.println("CarNo is :" + carNo);
        System.out.println("type is :" + type);

        List<Car> cars = this.carRepository.selectCarsByConditions(make, carName, carNo, type);
        if (cars == null || cars.isEmpty()) {
            System.out.println("No record 1");
            return 0;
        } else {
            this.gui.displaySimpleTable(cars);
            return 1;
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
    }

}
