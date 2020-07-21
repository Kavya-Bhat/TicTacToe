package com.example;

public class Screen1
{
    private char[][] primeBoard = {{'T', '|', 'I', '|', 'C'},
            {'-', '+', '-', '+', '-'},
            {'T', '|', 'A', '|', 'C'},
            {'-', '+', '-', '+', '-'},
            {'T', '|', 'O', '|', 'E'}};
    void showScreen1()
    {
        System.out.println();

        System.out.println("WELCOME TO");

        System.out.println();
        System.out.println();
        System.out.println();

        for(int i = 0; i < primeBoard.length; i++)
        {
            for(int j = 0; j < primeBoard[i].length; j++)
            {
                System.out.print(primeBoard[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Hit the 0 key to start off the game");
    }
}
