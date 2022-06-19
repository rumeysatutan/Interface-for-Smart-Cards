package View;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JFrame {
    private JPanel panel1;
    private JLabel LabelManufacturerIDCardText;
    private JLabel LabelModelText;
    private JLabel LabelManufacturerIDCard;
    private JLabel LabelModel;
    private JLabel LabelSerialNumberText;
    private JLabel LabelSerialNumber;
    private JLabel LabelCardInformation;

    public FormPanel(){
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //yazı tarzını işetim sistemi ile aynı yapan kod, try catch yapmak gerekiyor
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        add(panel1);
        Dimension dim =Toolkit.getDefaultToolkit().getScreenSize(); //pencereyi ortada başlatmak için ekran ölçütleri
        int x = (int) ((dim.getWidth()-1000)/2); //ekran uzunluğundan penecere ekran uzunluğunu çıkarıp ikiye bölüyoruz
        int y= (int) ((dim.getHeight()-800)/2);
        setLocation(x,y);
        setSize(1000, 800);
        setVisible(true);
        setTitle("SampleInterface");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //çarpıya bastığımızda kapanmasını sağlayan kod
    }
    public void setLabelManufacturerIDCard(String text){
        LabelManufacturerIDCard.setText(text);
    }
    public void setLabelModel(String text){
        LabelModel.setText(text);
    }
    public void setLabelSerialNumber(String text){
        LabelSerialNumber.setText(text);
    }



}
