/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BesliSudoku;
import static BesliSudoku.Main.samuraideBulunanBoslukSayisi;
import static BesliSudoku.Main.seconds10thread;
import static BesliSudoku.Main.seconds10thread1;
import static BesliSudoku.Main.seconds5thread1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author OEM
 */
public class Grafik extends JPanel {

    public void paintComponent(Graphics g) {
        /*
        Grafik cizimi icin gerekli kod blogu
        */
        g.setColor(Color.black);
        g.drawString("Zaman (Mili Saniye / 10)", 200, 190);
        
        g.setColor(Color.black);
        g.drawString("(0,0)", 185, 815);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.black);
        g2.drawLine(200, 800, 800, 800);
        
        g.setColor(Color.black);
        g.drawString("Adım Sayısı", 800, 800);
        
        g.setColor(Color.black);
        g.drawLine(200, 800, 200, 190);
        
        g.setColor(Color.red);
        g.drawLine(200, 800, 200 + samuraideBulunanBoslukSayisi, (600 - seconds10thread1));
        g.setColor(Color.CYAN);
        g.drawLine(200, 800, 200 + samuraideBulunanBoslukSayisi, (600 - seconds5thread1));
        
        g.setColor(Color.black);
        g.drawString("Doldurulan kutucuk sayısı: "+samuraideBulunanBoslukSayisi+"", 800, 190);

        g.setColor(Color.black);
        g.drawString("10'u Thread Çözüm Süresi: "+seconds10thread1+"", 800, 210);

        g.setColor(Color.black);
        g.drawString("5'li Thread Çözüm Süresi: "+seconds5thread1+"", 800, 230);

          
        
        g.setColor(Color.CYAN);
        g.drawLine(100, 100, 300, 100);
        g.setColor(Color.CYAN);
        g.drawString("5 THREAD", 35, 103);

         g.setColor(Color.red);
        g.drawLine(500, 100, 700, 100);
        g.setColor(Color.red);
        g.drawString("10 THREAD", 430, 103);
        
        
        
        
    }//400-(int) seconds1

}
