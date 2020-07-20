package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game
{
    char[][] gameBoard = new char[5][5];
    String player1, player2;

    public String getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(String player1)
    {
        this.player1 = player1;
    }

    public String getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(String player2)
    {
        this.player2 = player2;
    }

    void setGameBoard()
    {
        gameBoard = new char[][]{{' ', '|',' ', '|',' '},
                {'-', '+', '-', '+','-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
    }

    public char[][] getGameBoard()
    {
        return gameBoard;
    }

    void printBoard()
    {
        for (int i = 0; i < gameBoard.length; i++)
        {
            for (int j = 0; j < gameBoard[i].length; j++)
            {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    void placePiece(int position, char symbol)
    {
        switch (position)
        {
            case 1:
            gameBoard[0][0] = symbol;
            break;
            case 2:
            gameBoard[0][2] = symbol;
            break;
            case 3:
            gameBoard[0][4] = symbol;
            break;
            case 4:
            gameBoard[2][0] = symbol;
            break;
            case 5:
            gameBoard[2][2] = symbol;
            break;
            case 6:
            gameBoard[2][4] = symbol;
            break;
            case 7:
            gameBoard[4][0] = symbol;
            break;
            case 8:
            gameBoard[4][2] = symbol;
            break;
            case 9:
            gameBoard[4][4] = symbol;
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    int checkWinner(ArrayList<Integer> p1, ArrayList<Integer> p2)
    {
        List toprow = Arrays.asList(1, 2, 3);
        List middlerow = Arrays.asList(4, 5, 6);
        List bottomrow = Arrays.asList(7, 8, 9);
        List topcolumn = Arrays.asList(1, 4, 7);
        List middlecolumn = Arrays.asList(2, 5, 8);
        List bottomcolumn = Arrays.asList(3, 6, 9);
        List diagonal1 = Arrays.asList(1, 5, 9);
        List diagonal2 = Arrays.asList(7, 5, 3);

        ArrayList<List> winning = new ArrayList<>();

        winning.add(toprow);
        winning.add(middlerow);
        winning.add(bottomrow);
        winning.add(topcolumn);
        winning.add(middlecolumn);
        winning.add(bottomcolumn);
        winning.add(diagonal1);
        winning.add(diagonal2);

        int ref = 0;
        for (List l : winning)
        {
            if (p1.containsAll(l))
            {
                ref = 10;
                break;
            } else if (p2.containsAll(l))
            {
                ref = 20;
                break;
            } else if (p1.size() + p2.size() == 9)
            {
                ref = 30;
                break;
            } else
            {
                ref = 0;
            }
        }

        return ref;
    }
}







