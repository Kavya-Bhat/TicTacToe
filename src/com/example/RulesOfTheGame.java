package com.example;

public class RulesOfTheGame
{
    void printGameRules()
    {
        char[][] board = new char[5][5];
        board = new char[][]{{'1', '|','2', '|','3'},
                {'-', '+', '-', '+','-'},
                {'4', '|', '5', '|', '6'},
                {'-', '+', '-', '+', '-'},
                {'7', '|', '8', '|', '9'}};
        System.out.println(" Here are some rules before you start a game");
        System.out.println(" 1.All rules are same as that of the classic game of tic-tac-toe. ");
        System.out.println(" 2.But one  change in the below format to place their symbol on the board is the players should enter the specific numbers associated to the box.");

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("Ready to think out of the box? Press 0 to proceed.");
    }

}
