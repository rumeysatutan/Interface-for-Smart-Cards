package Controller;

import Model.CardInfo;
import View.FormPanel;
import View.Interface;
import sun.security.pkcs11.wrapper.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;





public class Application implements ActionListener  {

    private static PKCS11 wrapper;
    public FormPanel formPanel;

    public Interface formEnter;

    public void run()
        {
            try {

                String currentPath = new File(".").getCanonicalPath();
                String libraryPath = currentPath + "\\lib\\akisp11.dll";
                wrapper = PKCS11.getInstance(libraryPath, "C_GetFunctionList", null, false);

                CK_INFO ck_info = wrapper.C_GetInfo();

                CardInfo cardInfo = new CardInfo(String.valueOf(ck_info.cryptokiVersion), String.valueOf(ck_info.manufacturerID), String.valueOf(ck_info.libraryDescription));

                formEnter = new Interface(this);
                formEnter.setCardInfoAnswerText(cardInfo.getLibraryDescription());
                formEnter.setCryptokiVersionAnswer(cardInfo.getCryptokiVersion());
                formEnter.setManufacturerIDAnswer(cardInfo.getManufacturerID());

                System.out.println(ck_info.toString());
                System.out.println(cardInfo.getLibraryDescription());
                System.out.println(cardInfo.getCryptokiVersion());
                System.out.println(cardInfo.getManufacturerID());


            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (PKCS11Exception e) {
                throw new RuntimeException(e);
            }
        }


    public CK_TOKEN_INFO getTokenInfo(){

        try {
            long[] slotIDs = wrapper.C_GetSlotList(false);
            CK_TOKEN_INFO token_info = wrapper.C_GetTokenInfo(slotIDs[0]);
            System.out.println(token_info.toString());
            return token_info;
        } catch (PKCS11Exception e) {
            throw new RuntimeException(e);
        }

    }
    /*
        public static long login(String pin){
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            try {
                long[] slotIDs = wrapper.C_GetSlotList(true);
                long sessionHandle = wrapper.C_OpenSession(slotIDs[0], PKCS11Constants.CKF_SERIAL_SESSION |PKCS11Constants.CKF_RW_SESSION, null, null);
                wrapper.C_Login(sessionHandle, PKCS11Constants.CKU_USER, pin.toCharArray());

                logger.info("Logined");
                JOptionPane panel= new JOptionPane();
               // panel.showMessageDialog(null,"Giriş yaptınız");
                //formPanel =new FormPanel();
                cardInformation();
                return sessionHandle;
            } catch (PKCS11Exception e) {
                logger.warning("giriş yapılamadı");
                e.printStackTrace();
                JOptionPane panel= new JOptionPane();
                panel.showMessageDialog(null,"Şifre yanlış");
                return -1;
            }

        }
    */
    public long login(String pin) throws PKCS11Exception{
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        long[] slotIDs = wrapper.C_GetSlotList(false);
        long sessionHandle = wrapper.C_OpenSession(slotIDs[0], PKCS11Constants.CKF_SERIAL_SESSION |PKCS11Constants.CKF_RW_SESSION, null, null);
        wrapper.C_Login(sessionHandle, PKCS11Constants.CKU_USER, pin.toCharArray()); //burda hata veriyor
        logger.info("Logined");
        return sessionHandle;


    }
    // public static Logout(){

    // }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand()); //hangi action olduğunu kontrol ediyor
        if(e.getActionCommand().contains("btn_login_action")){
            btn_login_action();
            return;
        }
        //System.out.println(e.toString());


        System.out.println(formEnter.getPin());

    }

    protected void btn_login_action(){
        String pin = formEnter.getPin();
        try {
            login(pin);
        } catch (PKCS11Exception e) {
            JOptionPane.showMessageDialog(null,"<html><b style=\"color:blue; font-size:36px;\">pin yanlış girildi</b></html>");
            System.out.println(e.getMessage());
            return;
        }
        formEnter.dispose();
        formPanel = new FormPanel();
        cardInformation(formPanel);
    }


    public void cardInformation(FormPanel formPanel){

        formPanel.setLabelManufacturerIDCard(getTokenInfo().manufacturerID.toString());
        formPanel.setLabelModel(getTokenInfo().model.toString());
        formPanel.setLabelSerialNumber(getTokenInfo().serialNumber.toString());
    }
}