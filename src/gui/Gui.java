package gui;
//import java.awt.event.ActionEvent;
import java.awt.Color;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui {
 //0000000000000000000000000000000000000000000000000
    private String name;

    public Gui(String name) {
        this.name = name;
    }

    protected String getJson2() {
        return name;
    }
 //0000000000000000000000000000000000000000000000000


    public void gui() {
            JFrame a = new JFrame("结果显示页面");
            a.setLocation(100, 100);
            a.setSize(500, 400);
            a.setLayout(null);
            
            JLabel b = new JLabel(getJson2());
            b.setForeground(Color.red);
            b.setBounds(10,10,480,380);
            
            a.add(b);
            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            a.setVisible(true);

    }
    
}
