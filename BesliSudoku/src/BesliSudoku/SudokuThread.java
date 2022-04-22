/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BesliSudoku;
/**
 *
 * @author OEM
 */

public class SudokuThread implements Runnable  {
     sudoku matris;

    public SudokuThread(sudoku matris) {
        this.matris = matris;
    }

    public void run() {
         synchronized(matris.matris){
        sudokuCoz(matris.matris);      
     }
      
    }
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
class sudoku {

    int[][] matris;
}
