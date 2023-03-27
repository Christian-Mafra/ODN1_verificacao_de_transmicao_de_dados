package org.example;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.Scanner;

public class Main {
    private static Robot robo;
    static {
        try {
            robo = new Robot();
        } catch (AWTException e){
            throw new RuntimeException(e);
        }
    }
    private static void Copiar() {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_C);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_C);
        robo.delay(500);
    }
    private static void Colar() {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);
        robo.delay(500);
    }
    public static void Click(int i){
        while (i != 0){
            robo.delay(10);
            robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            --i;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = 18;
        String input;

        for(int i = 0; i < 13; i++){

            //Mover mouse para barra de busca por palavra-chava (Crl + G)
            robo.mouseMove(70, 230);
            Click(2);
            robo.delay(600);
            Colar();
            robo.keyPress(KeyEvent.VK_ENTER);
            robo.keyRelease(KeyEvent.VK_ENTER);
            robo.delay(2300);
            robo.mouseMove(900, 700);                         //Clicando no excel
            Click(1);
            input = scanner.nextLine();
            if(Objects.equals(input, "")){
                //Colando no excel
                robo.mouseMove(900, 180);                         //Clicando no excel
                Click(1);
                robo.keyPress(KeyEvent.VK_RIGHT);
                robo.keyRelease(KeyEvent.VK_RIGHT);
                robo.keyPress(KeyEvent.VK_UP);
                robo.keyRelease(KeyEvent.VK_UP);
                Copiar();
                robo.keyPress(KeyEvent.VK_DOWN);
                robo.keyRelease(KeyEvent.VK_DOWN);
                Colar();
                robo.delay(500);

                //voltando
                robo.keyPress(KeyEvent.VK_LEFT);
                robo.keyRelease(KeyEvent.VK_LEFT);
                robo.delay(200);
                robo.keyPress(KeyEvent.VK_DOWN);
                robo.keyRelease(KeyEvent.VK_DOWN);
                Copiar();
                robo.delay(500);

            } else {
                System.out.println("Deu break");
                break;
            }
        }
    }
}