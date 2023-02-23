/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stok_takip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
* @file stok_takip.java
* @description Belirli bir şirketin stok durumunu kontrol eden program.
* @assignment Bahar Dönemi 1.Proje
* @date 17/05/2022
* @author Muhammed Mesut Bahadır - muhammed.bahadir@stu.fsm.edu.tr
*/
public class Graphic extends JFrame {

    public Graphic() {
        super("Hoşgeldiniz");
        setSize(400, 200);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(25, 50, 350, 10);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        g.drawString("Sisteme Hoşgeldiniz.", 100, 100);

        g.setColor(Color.GREEN);
        g.fillRect(25, 150, 350, 10);
    }

    public static void main(String[] args) {
        Graphic app = new Graphic();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
    }
}
