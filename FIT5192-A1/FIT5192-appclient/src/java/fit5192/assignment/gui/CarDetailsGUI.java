/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.gui;

//import fit5042.tutex.jpa.JPAModelCarRepository;
//import fit5042.tutex.repository.entities.Car;
import fit5192.assignment.repository.entities.Car;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dy
 */
public class CarDetailsGUI extends JDialog {

    private final ImageIcon imageIcon;

    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8;
    JLabel jl11, jl22, jl33, jl44, jl55, jl66, jl77, jl88;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8,jp;

    public CarDetailsGUI(JFrame owner, String title, boolean modal, Car car) {
        super(owner, title, modal);

        jl1 = new JLabel("VIN : ");
        jl11 = new JLabel(car.getVin());
        jl2 = new JLabel("Model No : ");
        jl22 = new JLabel(car.getModelNo());
        jl3 = new JLabel("Model name : ");
        jl33 = new JLabel(car.getModelName());
        jl4 = new JLabel("Manufacturer : ");
        jl44 = new JLabel(car.getMake());
        jl5 = new JLabel("Type : ");
        jl55 = new JLabel(car.getType());
        jl6 = new JLabel("Description : ");
        jl66 = new JLabel(car.getDescription());
        jl7 = new JLabel("Preview URL : ");
        jl77 = new JLabel(car.getPreview_url());
        jl8 = new JLabel("Thumbnail : ");
        String path = "C:\\Users\\dy\\Desktop\\q\\FIT5192-web\\web\\Image\\"+car.getThumbnail();
        imageIcon = new ImageIcon(path);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        jl88 = new JLabel(imageIcon);

        jp1 = new JPanel(new GridLayout(1,2));
        jp2 = new JPanel(new GridLayout(1,2));
        jp3 = new JPanel(new GridLayout(1,2));
        jp4 = new JPanel(new GridLayout(1,2));
        jp5 = new JPanel(new GridLayout(1,2));
        jp6 = new JPanel(new GridLayout(1,2));
        jp7 = new JPanel(new GridLayout(1,2));
        jp8 = new JPanel();
        jp = new JPanel(new GridLayout(8,1));

        jp1.add(jl1);
        jp1.add(jl11);
        jp2.add(jl2);
        jp2.add(jl22);
        jp3.add(jl3);
        jp3.add(jl33);
        jp4.add(jl4);
        jp4.add(jl44);
        jp5.add(jl5);
        jp5.add(jl55);
        jp6.add(jl6);
        jp6.add(jl66);
        jp7.add(jl7);
        jp7.add(jl77);
        jp8.add(jl8);

        this.setLayout(new BorderLayout());
        

        Container container = this.getContentPane();

        jp.add(jp1);
        jp.add(jp2);
        jp.add(jp3);
        jp.add(jp4);
        jp.add(jp5);
        jp.add(jp6);
        jp.add(jp7);
        jp.add(jp8);
        this.add(jp, BorderLayout.NORTH);
        this.add(jl88, BorderLayout.CENTER);

        this.setLocation(100, 100);
        this.setSize(300, 500);

    }


}
