package Controller;

import Model.CardInfo;
import View.FormPanel;
import View.Interface;
import sun.rmi.runtime.Log;
import sun.security.pkcs11.wrapper.*;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) {
        Application application=new Application();
        application.run();

    }

}
