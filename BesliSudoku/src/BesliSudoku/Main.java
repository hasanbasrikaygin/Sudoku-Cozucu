/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BesliSudoku;

import com.sun.javafx.css.Style;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Background;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.plaf.synth.ColorType;
import javax.swing.text.StyleConstants;

/**
 *
 * @author OEM
 */
public class Main {

    static int sayac = 0;
    static int samuraideBulunanBoslukSayisi = 0;
    static double seconds10thread = 0;
    static int seconds10thread1 = 0;
    static double seconds5thread = 0;
    static int seconds5thread1 = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int sudoku1[][] = new int[9][9];
        int sudoku2[][] = new int[9][9];
        int sudoku3[][] = new int[9][9];
        int sudoku4[][] = new int[9][9];
        int sudoku5[][] = new int[9][9];

        int sudoku11[][] = new int[9][9];
        int sudoku22[][] = new int[9][9];
        int sudoku33[][] = new int[9][9];
        int sudoku44[][] = new int[9][9];
        int sudoku55[][] = new int[9][9];

        List<Character> tumkarakterler = new ArrayList<>();
        List<Integer> tumsayilar = new ArrayList<>();

        List<Integer> matris1sifirlar1x = new ArrayList<>();
        List<Integer> matris1sifirlar1y = new ArrayList<>();
        int matris1kacsifir = 0;

        List<Integer> matris2sifirlar1x = new ArrayList<>();
        List<Integer> matris2sifirlar1y = new ArrayList<>();
        int matris2kacsifir = 0;

        List<Integer> matris3sifirlar1x = new ArrayList<>();
        List<Integer> matris3sifirlar1y = new ArrayList<>();
        int matris3kacsifir = 0;

        List<Integer> matris4sifirlar1x = new ArrayList<>();
        List<Integer> matris4sifirlar1y = new ArrayList<>();
        int matris4kacsifir = 0;

        List<Integer> matris5sifirlar1x = new ArrayList<>();
        List<Integer> matris5sifirlar1y = new ArrayList<>();
        int matris5kacsifir = 0;
        /*
           Dosyadan Veri Okuma Islemleri
         */
        char yildiz = '*';
        char sifirdegistirme = '0';
        FileInputStream fstream;
        try {
            String filePathTemp = "C:/Users/OEM/Documents/NetBeansProjects/BesliSudoku/yazilar.txt";
            fstream = new FileInputStream(filePathTemp);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int x = 0;
            while ((strLine = br.readLine()) != null) {
                x++;

                for (int i = 0; i < strLine.length(); i++) {

                    char harf = strLine.charAt(i);
                    tumkarakterler.add(harf);
                }
            }
            System.out.println(x + " -- Satır Sayısı");
            fstream.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
    Dosayada bulunan yildizlari 0 ile degistirme    
         */
        int d = 1;
        for (int i = 0; i < tumkarakterler.size(); i++) {
            System.out.print(tumkarakterler.get(i) + " ");
            d++;
            if (d % 21 == 1) {
                System.out.println("");

            }
            if (yildiz == tumkarakterler.get(i)) {
                tumkarakterler.remove(i);
                tumkarakterler.add(i, sifirdegistirme);
            }
        }
        System.out.println("\n---------------------------------------");
        int c = 1;
        for (int i = 0; i < tumkarakterler.size(); i++) {
            int b = tumkarakterler.get(i) - '0';
            tumsayilar.add(b);
            System.out.print(tumsayilar.get(i) + " ");
            c++;
            if (c % 21 == 1) {
                System.out.println("");
            }
        }

        for (int i = 0; i < tumsayilar.size(); i++) {

            if (tumsayilar.get(i) == 0) {
                samuraideBulunanBoslukSayisi++;
            }
        }
        System.out.println("************" + samuraideBulunanBoslukSayisi + "**************");
        /*
        Dosyada bulunan formata gore 
        rakamlari matrislere atayan kod blogu 
         */
        int a = 0;
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                //İLK 6 SATIR
                if (i < 6) {
                    if (j < 9) {
                        sudoku1[i][j] = tumsayilar.get(a);
                    }
                    if (j > 8 && j < 18) {
                        sudoku2[i][j - 9] = tumsayilar.get(a);
                    }
                }
                //İLK 6 SATIR
                // 7 - 8 - 9 SATIRLAR
                if (i > 5 && i < 9) {
                    if (j < 9) {
                        sudoku1[i][j] = tumsayilar.get(a);
                    }
                    if (j > 5 && j < 15) {
                        sudoku3[i - 6][j - 6] = tumsayilar.get(a);
                    }
                    if (j > 11 && j < 21) {
                        sudoku2[i][j - 12] = tumsayilar.get(a);
                    }
                }
                // 7 - 8 - 9 SATIRLAR
                //10 - 11 - 12 SATIRLAR

                if (i > 8 && i < 12) {
                    if (j < 9) {
                        sudoku3[i - 6][j] = tumsayilar.get(a);
                    }
                }
                //10 - 11 - 12 SATIRLAR
                //13 - 14 - 15 SATIRLAR
                if (i > 11 & i < 15) {
                    if (j < 9) {
                        sudoku4[i - 12][j] = tumsayilar.get(a);
                    }
                    if (j > 5 && j < 15) {
                        sudoku3[i - 6][j - 6] = tumsayilar.get(a);
                    }
                    if (j > 11 && j < 21) {
                        sudoku5[i - 12][j - 12] = tumsayilar.get(a);

                    }
                }
                //13 - 14 - 15 SATIRLAR
                //16 - 17 - 18 - 19 - 20 - 21 SATIRLAR
                if (i > 14 && i < 21) {
                    if (j < 9) {
                        sudoku4[i - 12][j] = tumsayilar.get(a);
                    }
                    if (j > 8 && j < 18) {
                        sudoku5[i - 12][j - 9] = tumsayilar.get(a);
                    }
                }
                //16 - 17 - 18 - 19 - 20 - 21 SATIRLAR
                // ilk 6 satır
                if (i < 6 && j < 18) {
                    a++;
                }
                // 7 8 9
                if (i > 5 && i < 9) {
                    if (j < 21) {
                        a++;
                    }
                }
                //10 11 12
                if (i > 8 && i < 12) {
                    if (j < 9) {
                        a++;
                    }
                }
                //13 14 15
                if (i > 11 && i < 15) {
                    if (j < 21) {
                        a++;
                    }
                }
                //son 6 satır
                if (i > 14 && j < 18) {
                    a++;
                }
            }
        }
        /*
        Sudoku Kopyalama
        */
        System.out.println("\n1) ----------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku1[i][j] + " ");
                sudoku11[i][j] = sudoku1[i][j];
                sudoku22[i][j] = sudoku2[i][j];
                sudoku33[i][j] = sudoku3[i][j];
                sudoku44[i][j] = sudoku4[i][j];
                sudoku55[i][j] = sudoku5[i][j];
            }
        }
        System.out.println("\n2) ----------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku2[i][j] + " ");
            }
        }
        System.out.println("\n3) ----------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku3[i][j] + " ");
            }
        }
        System.out.println("\n4) ----------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku4[i][j] + " ");
            }
        }
        System.out.println("\n5) ----------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.println("");
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku5[i][j] + " ");
            }
        }
        
        ////////////////////////////////THREADS////////////////////////////////////////

        sudoku matris = new sudoku();
        matris.matris = sudoku1;
        SudokuThread sudokuthread1 = new SudokuThread(matris);
        Thread thread1 = new Thread(sudokuthread1);

        sudoku matris1 = new sudoku();
        matris1.matris = sudoku2;
        SudokuThread sudokuthread2 = new SudokuThread(matris1);
        Thread thread2 = new Thread(sudokuthread2);

        sudoku matris7 = new sudoku();
        matris7.matris = sudoku3;
        SudokuThread sudokuthread3 = new SudokuThread(matris7);
        Thread thread3 = new Thread(sudokuthread3);

        sudoku matris2 = new sudoku();
        matris2.matris = sudoku4;
        SudokuThread sudokuthread4 = new SudokuThread(matris2);
        Thread thread4 = new Thread(sudokuthread4);

        sudoku matris5 = new sudoku();
        matris5.matris = sudoku5;
        SudokuThread sudokuthread5 = new SudokuThread(matris5);
        Thread thread5 = new Thread(sudokuthread5);

        ////////////////////////////////THREADS2//////////////////////////////////
        sudoku matris10 = new sudoku();
        matris10.matris = sudoku1;
        SudokuThread sudokuthread10 = new SudokuThread(matris10);
        Thread thread10 = new Thread(sudokuthread10);

        sudoku matris11 = new sudoku();
        matris11.matris = sudoku1;
        SudokuThread sudokuthread11 = new SudokuThread(matris11);
        Thread thread11 = new Thread(sudokuthread11);
        //////////////////////////////////////////////////////////////////// //////////////////////////////////3
        sudoku matris12 = new sudoku();
        matris12.matris = sudoku2;
        SudokuThread sudokuthread12 = new SudokuThread(matris12);
        Thread thread12 = new Thread(sudokuthread12);

        sudoku matris13 = new sudoku();
        matris13.matris = sudoku2;
        SudokuThread sudokuthread13 = new SudokuThread(matris13);
        Thread thread13 = new Thread(sudokuthread13);
        //////////////////////////////////////////////////////////////////// //////////////////////////////////5
        sudoku matris14 = new sudoku();
        matris14.matris = sudoku3;
        SudokuThread sudokuthread14 = new SudokuThread(matris14);
        Thread thread14 = new Thread(sudokuthread14);

        sudoku matris15 = new sudoku();
        matris15.matris = sudoku3;
        SudokuThread sudokuthread15 = new SudokuThread(matris15);
        Thread thread15 = new Thread(sudokuthread15);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////7
        sudoku matris16 = new sudoku();
        matris16.matris = sudoku4;
        SudokuThread sudokuthread16 = new SudokuThread(matris16);
        Thread thread16 = new Thread(sudokuthread16);

        sudoku matris17 = new sudoku();
        matris17.matris = sudoku4;
        SudokuThread sudokuthread17 = new SudokuThread(matris17);
        Thread thread17 = new Thread(sudokuthread17);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////9
        sudoku matris18 = new sudoku();
        matris18.matris = sudoku5;
        SudokuThread sudokuthread18 = new SudokuThread(matris18);
        Thread thread18 = new Thread(sudokuthread18);

        sudoku matris19 = new sudoku();
        matris13.matris = sudoku5;
        SudokuThread sudokuthread19 = new SudokuThread(matris19);
        Thread thread19 = new Thread(sudokuthread19);
        ///////////////////////////////THREADS2////////////////////////////////////

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + matris.matris[i][j]);
            }
            System.out.println("");
        }

        JButton buttons1[][] = new JButton[9][9];
        JButton buttons2[][] = new JButton[9][9];
        JButton buttons3[][] = new JButton[9][9];
        JButton buttons4[][] = new JButton[9][9];
        JButton buttons5[][] = new JButton[9][9];
        JFrame f = new JFrame();
        f.setSize(1600, 1000);
        f.setLayout(null);
        JFrame frame2 = new JFrame();
        frame2.setSize(1600, 1000);
        frame2.setLayout(null);
        JFrame frame3 = new JFrame();
        frame3.setSize(1600, 1000);
        frame3.setLayout(null);
        JFrame frame4 = new JFrame();
        frame4.setSize(1600, 1000);
        frame4.setLayout(null);
        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        /*
        Ekranda gosterilecek 5 adet 9*9 Matris kutucuklari olusturma  
        */
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                int sayi = sudoku3[j][i];
                JButton btn1 = new JButton("" + sayi);
                btn1.setBounds(1090 + 45 * i, 45 * j, 45, 45);
                btn1.setFont(f1);
                btn1.setBackground(Color.LIGHT_GRAY);
                f.add(btn1);
                buttons3[i][j] = btn1;
            }
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                int sayi = sudoku1[j][i];
                JButton btn2 = new JButton("" + sayi);
                btn2.setBounds(45 * i, 45 * j, 45, 45);
                btn2.setBackground(Color.LIGHT_GRAY);

                btn2.setFont(f1);
                f.add(btn2);
                buttons1[i][j] = btn2;

            }
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                int sayi = sudoku4[j][i];
                JButton btn3 = new JButton("" + sayi);
                btn3.setBounds(45 * i, 545 + 45 * j - 5, 45, 45);
                btn3.setBackground(Color.LIGHT_GRAY);
                btn3.setFont(f1);
                f.add(btn3);
                buttons2[i][j] = btn3;
            }
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                int sayi = sudoku2[j][i];
                JButton btn4 = new JButton("" + sayi);
                btn4.setBounds(545 + 45 * i - 5, 45 * j, 45, 45);
                btn4.setBackground(Color.LIGHT_GRAY);
                btn4.setFont(f1);
                f.add(btn4);
                buttons3[i][j] = btn4;
            }
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                int sayi = sudoku5[j][i];
                JButton btn5 = new JButton("" + sayi);
                btn5.setBounds(545 + 45 * i - 5, 545 + 45 * j - 5, 45, 45);
                btn5.setBackground(Color.LIGHT_GRAY);
                btn5.setFont(f1);
                f.add(btn5);
                buttons4[i][j] = btn5;
            }
        }
        /*
        Istenilen islemlerin gerceklesmsi icin olusturulan 5 adet buton tanimlamasi
        */
        Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        JButton Sifirla = new JButton();
        JButton sifir = new JButton("5 Thread Çözümü");
        sifir.setBounds(1090, 545, 400, 50);
        sifir.setBackground(Color.GRAY);
        sifir.setFont(f2);
        f.add(sifir);
        Sifirla = sifir;

        JButton Sifirla1 = new JButton();
        JButton sifir1 = new JButton("10 Thread Çözümü");
        sifir1.setBounds(1090, 605, 400, 50);
        sifir1.setBackground(Color.GRAY);
        sifir1.setFont(f2);
        f.add(sifir1);
        Sifirla1 = sifir1;

        JButton DrawLine = new JButton();
        JButton drawLine = new JButton("Grafik Çizimi");
        drawLine.setBounds(1090, 725, 400, 50);
        drawLine.setBackground(Color.GRAY);
        drawLine.setFont(f2);
        f.add(drawLine);
        DrawLine = drawLine;

        JButton DrawThreadBaslat = new JButton();
        JButton drawThread = new JButton("Grafik Çizimi İçin Thread Başlatıcı");
        drawThread.setBounds(1090, 785, 400, 50);
        drawThread.setBackground(Color.GRAY);
        drawThread.setFont(f2);
        f.add(drawThread);
        DrawThreadBaslat = drawThread;

        JButton Basla = new JButton();
        JButton Bsl = new JButton("Thread Çözümü Göster");
        Bsl.setBounds(1090, 665, 400, 50);
        Bsl.setBackground(Color.GRAY);
        Bsl.setFont(f2);
        f.add(Bsl);
        Basla = Bsl;

        JButton Geri = new JButton();
        JButton geri = new JButton("Geri");
        geri.setBounds(1090, 545, 400, 50);
        geri.setBackground(Color.GRAY);
        geri.setFont(f2);
        frame2.add(geri);
        Geri = geri;
        /*
        Thread hizlarini karsilastirmak icin olusturulan ,
        tum threadleri baslatan kisim
        */
        drawThread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                long startTime = System.nanoTime();
                thread1.start();
                thread2.start();
                thread3.start();
                thread4.start();
                thread5.start();
                long endTime = System.nanoTime();
                long estimatedTime = endTime - startTime; // Geçen süreyi nanosaniye cinsinden elde ediyoruz
                double seconds = (double) estimatedTime / 100000; // mikrosaniyeye çevirmek için 10'a bölüyoruz.
                seconds10thread = 10 * seconds;
                System.out.println("/" + seconds10thread + "\\");
                seconds10thread1 = (int) seconds10thread;

                long startTime1 = System.nanoTime();
                thread10.start();
                thread11.start();

                thread12.start();
                thread13.start();

                thread14.start();
                thread15.start();

                thread16.start();
                thread17.start();

                thread18.start();
                thread19.start();
                long endTime1 = System.nanoTime();
                long estimatedTime1 = endTime1 - startTime1; // Geçen süreyi nanosaniye cinsinden elde ediyoruz
                double seconds1 = (double) estimatedTime1 / 100000; // miLİsaniyeye/10 çevirmek için 100000'e bölüyoruz.
                seconds5thread = 10 * seconds1;
                System.out.println("/" + seconds5thread + "\\");
                seconds5thread1 = (int) seconds5thread;
            }
        });

        drawLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                frame2.setVisible(false);
                JFrame.setDefaultLookAndFeelDecorated(true);
                JFrame frame = new JFrame("Draw Line");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBackground(Color.white);
                frame.setSize(1000, 1000);
                Grafik panel = new Grafik();
                frame.add(panel);
                frame.setVisible(true);

            }
        });
        geri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame2.setVisible(false);
                f.setVisible(true);
            }
        });
        /*
        Besli thread baslatici
        */
        sifir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                thread1.start();
                thread2.start();
                thread3.start();
                thread4.start();
                thread5.start();
            }
        });
        /*
        Onlu thread baslatici
        */
        sifir1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                thread10.start();
                thread11.start();

                thread12.start();
                thread13.start();

                thread14.start();
                thread15.start();

                thread16.start();
                thread17.start();

                thread18.start();
                thread19.start();
            }
        });
        JLabel lbl = new JLabel("0");
        lbl.setBounds(950, 100, 100, 50);
        lbl.setBackground(Color.GRAY);
        f.add(lbl);
        f.setVisible(true);
        /*
        Cozum sayfasi icin 5 adet 9*9luk buton tanimlamasi
        */
        Bsl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                f.setVisible(false);
                frame2.setVisible(true);
                sayac++;
                lbl.setText(Integer.toString(sayac));
                Font f1 = new Font(Font.SERIF, Font.PLAIN, 20);
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; j++) {
                        int sayi = sudoku3[j][i];
                        //  names[i] 
                        JButton btn1 = new JButton("" + sayi);
                        btn1.setBounds(1090 + 45 * i, 45 * j, 45, 45);
                        btn1.setBackground(Color.LIGHT_GRAY);

                        btn1.setFont(f1);
                        frame2.add(btn1);
                        buttons3[i][j] = btn1;
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; j++) {
                        int sayi = sudoku1[j][i];
                        JButton btn2 = new JButton("" + sayi);
                        btn2.setBounds(45 * i, 45 * j, 45, 45);
                        btn2.setBackground(Color.LIGHT_GRAY);
                        btn2.setFont(f1);
                        frame2.add(btn2);
                        buttons1[i][j] = btn2;
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; j++) {
                        int sayi = sudoku4[j][i];
                        JButton btn3 = new JButton("" + sayi);
                        btn3.setBounds(45 * i, 545 + 45 * j - 5, 45, 45);
                        btn3.setBackground(Color.LIGHT_GRAY);
                        btn3.setFont(f1);
                        frame2.add(btn3);
                        buttons2[i][j] = btn3;
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; j++) {
                        int sayi = sudoku2[j][i];
                        JButton btn4 = new JButton("" + sayi);
                        btn4.setBounds(545 + 45 * i - 5, 45 * j, 45, 45);
                        btn4.setBackground(Color.LIGHT_GRAY);
                        btn4.setFont(f1);
                        frame2.add(btn4);
                        buttons3[i][j] = btn4;
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; j++) {
                        int sayi = sudoku5[j][i];
                        JButton btn5 = new JButton("" + sayi);
                        btn5.setBounds(545 + 45 * i - 5, 545 + 45 * j - 5, 45, 45);
                        btn5.setBackground(Color.LIGHT_GRAY);
                        btn5.setFont(f1);
                        frame2.add(btn5);
                        buttons4[i][j] = btn5;
                    }
                }
            }
        });
      /*
      Baslangicta verilen sudokudaki yildizli kisimlari tutan liste
      Bu listedeki siralamaya gore olarak sudoku cozum basamaklari gosterilmektedir
      */
        //1   
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku11[i][j] == 0) {
                    matris1sifirlar1x.add(i);
                    matris1sifirlar1y.add(j);
                    matris1kacsifir++;
                }
            }
        }
        //2
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku22[i][j] == 0) {
                    matris2sifirlar1x.add(i);
                    matris2sifirlar1y.add(j);
                    matris2kacsifir++;
                }
            }
        }
        //3    
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku33[i][j] == 0) {
                    matris3sifirlar1x.add(i);
                    matris3sifirlar1y.add(j);
                    matris3kacsifir++;
                }
            }
        }
        //4   
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku44[i][j] == 0) {
                    matris4sifirlar1x.add(i);
                    matris4sifirlar1y.add(j);
                    matris4kacsifir++;
                }
            }
        }
        //5   
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku55[i][j] == 0) {
                    matris5sifirlar1x.add(i);
                    matris5sifirlar1y.add(j);
                    matris5kacsifir++;
                }
            }
        }
      
        sudokuCoz(sudoku11);
        sudokuCoz(sudoku22);
        sudokuCoz(sudoku33);
        sudokuCoz(sudoku44);
        sudokuCoz(sudoku55);
        System.out.println("////////////////////////////");
        
        /*
        Cozum ciktilarini belirlenen txt belgesine yazdirma
        */

        FileWriter dosyayazici = new FileWriter("C:/Users/OEM/Documents/NetBeansProjects/birlesim/sudoku1.txt");
        BufferedWriter dosyaOutput = new BufferedWriter(dosyayazici);
//1        
        dosyaOutput.write("\n1.MATRİS\n--------\n");
        for (int i = 0; i < matris1kacsifir; i++) {
            dosyaOutput.write(i + ". Adım ( " + matris1sifirlar1x.get(i) + "," + matris1sifirlar1y.get(i) + " ) Eklenen Eleman : " + sudoku11[matris1sifirlar1x.get(i)][matris1sifirlar1y.get(i)] + "\n");
        }
//2       
        dosyaOutput.write("\n2.MATRİS\n--------\n");
        for (int i = 0; i < matris2kacsifir; i++) {
            dosyaOutput.write(i + ". Adım ( " + matris2sifirlar1x.get(i) + "," + matris2sifirlar1y.get(i) + " ) Eklenen Eleman : " + sudoku22[matris2sifirlar1x.get(i)][matris2sifirlar1y.get(i)] + "\n");
        }
//3      
        dosyaOutput.write("\n3.MATRİS\n--------\n");
        for (int i = 0; i < matris3kacsifir; i++) {
            dosyaOutput.write(i + ". Adım ( " + matris3sifirlar1x.get(i) + "," + matris3sifirlar1y.get(i) + " ) Eklenen Eleman : " + sudoku33[matris3sifirlar1x.get(i)][matris3sifirlar1y.get(i)] + "\n");
        }
//4      
        dosyaOutput.write("\4.MATRİS\n--------\n");
        for (int i = 0; i < matris4kacsifir; i++) {
            dosyaOutput.write(i + ". Adım ( " + matris4sifirlar1x.get(i) + "," + matris4sifirlar1y.get(i) + " ) Eklenen Eleman : " + sudoku44[matris4sifirlar1x.get(i)][matris4sifirlar1y.get(i)] + "\n");
        }
//5      
        dosyaOutput.write("\n5.MATRİS\n--------\n");
        for (int i = 0; i < matris5kacsifir; i++) {
            dosyaOutput.write(i + ". Adım ( " + matris5sifirlar1x.get(i) + "," + matris5sifirlar1y.get(i) + " ) Eklenen Eleman : " + sudoku55[matris5sifirlar1x.get(i)][matris5sifirlar1y.get(i)] + "\n");
        }
        dosyaOutput.close();
    }
  /*
   Sudoku cozme algoritması  
  */
    static boolean uygunMu1(int[][] sudoku1, int number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (sudoku1[row][i] == number) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (sudoku1[i][column] == number) {
                return false;
            }
        }
        int rangeX = (row / 3) * 3;
        int rangeY = (column / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku1[rangeX + i][rangeY + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuCoz(int[][] sudoku1) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (sudoku1[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (uygunMu1(sudoku1, k, row, column)) {
                            sudoku1[row][column] = k;

                            if (sudokuCoz(sudoku1)) {
                                return true;
                            } else {
                                sudoku1[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}