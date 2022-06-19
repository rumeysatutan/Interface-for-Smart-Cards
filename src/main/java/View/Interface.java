package View;

import Controller.Main;
import Model.CardInfo;
import sun.security.pkcs11.wrapper.CK_INFO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
//import static Controller.Main.login;
//import static Controller.Main.main;


public class Interface extends JFrame {
    private JPanel panel1;
    private JLabel lblCardInfo;
    private JLabel lblCardInfoAnswer;
    private JLabel cryptokiVersion;
    private JLabel cryptokiVersionAnswer;
    private JLabel manufacturerID;
    private JLabel manufacturerIDAnswer;
    public JTextField pinTextField;
    public JButton EnterButton;


    public Interface (ActionListener actionListener) {
        try {

            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); //yazı tarzını işetim sistemi ile aynı yapan kod, try catch yapmak gerekiyor
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        Dimension dim =Toolkit.getDefaultToolkit().getScreenSize(); //pencereyi ortada başlatmak için ekran ölçütleri
        int x = (int) ((dim.getWidth()-1000)/2); //ekran uzunluğundan penecere ekran uzunluğunu çıkarıp ikiye bölüyoruz
        int y= (int) ((dim.getHeight()-800)/2);
        setLocation(x,y);

        add(panel1);
        EnterButton.addActionListener(actionListener);
        //EnterButton.addActionListener(e -> {
        //    Main.login(pinTextField.getText());
        //});
        setSize(1000, 800);
        setVisible(true);
        setTitle("SampleInterface");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //çarpıya bastığımızda kapanmasını sağlayan kod
    }

    public void setCardInfoAnswerText(String text){lblCardInfoAnswer.setText(text);
    }
    public void setCryptokiVersionAnswer(String text){
        cryptokiVersionAnswer.setText(text);
    }
    public void setManufacturerIDAnswer(String text){manufacturerIDAnswer.setText(text);
    }
    public String getPin(){return pinTextField.getText();}



}
