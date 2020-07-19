package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game<toprow, winning>
{
    char[][] gameBoard = new char[5][5];
    String player1, player 2;

    void setGameBoard()
    {
        gameBoard = {{" ", '|', " ", '|', " "}
                {" ", '|', " ", '|', " "}
                {" ", '|', " ", '|', " "}
                {" ", '|', " ", '|', " "}
                {" ", '|', " ", '|', " "}};
    }

    public char[][] getGameBoard()
    {
        return gameBoard;
    }

    void printgameBoard()
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

    void placePiece(char[][] board, int position, char symbol)
    {
        switch (position)
        {
            case1:
            board[0][0] = symbol;
            break;
            case2:
            board[0][2] = symbol;
            break;
            case3:
            board[0][4] = symbol;
            break;
            case4:
            board[2][0] = symbol;
            break;
            case5:
            board[2][2] = symbol;
            break;
            case6:
            board[2][4] = symbol;
            break;
            case7:
            board[4][0] = symbol;
            break;
            case8:
            board[4][2] = symbol;
            break;
            case9:
            board[4][4] = symbol;
            break;
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
        winning.add(toprow)
        winning.add(middlerow);
        winning.add(bottomrow);
        winning.add(topcolumn)
        winning.add(middlecolumn);
        winning.add(bottomcolumn)
        winning.add(diagonal1);
        winning.add(diagonal2);
        for (List l : winning)
        {
            if (p1.containsAll(l))
            {
                return 10;
            } else if (p2.contains(l))
            {
                return 20;
            } else if (p1.size() + p2.size() == 9)
            {
                return 30;
            } else
            {
                return 0;
            }
        }
    }
}







