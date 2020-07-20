package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.ClassNotFoundException;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        clrscr();

        ArrayList<Integer> p1Positions = new ArrayList<>();
        ArrayList<Integer> p2Positions = new ArrayList<>();

        Game g = new Game();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player1's name:");
        String p1 = scanner.nextLine();
        g.setPlayer1(p1);

        System.out.println("Enter player2's name:");
        String p2 = scanner.nextLine();
        g.setPlayer1(p2);

        clrscr();

        int result = 0;
        for(int i = 1; result == 0; i++)
        {
            if(i % 2 == 1)
            {
                System.out.println("It is " + p1 + "'s turn. " + p1 + ", please enter a number between 1 to 9 to position your symbol.");
                g.printBoard();
                int p1Pos = scanner.nextInt();
                while(p1Positions.contains(p1Pos) || p2Positions.contains(p1Pos) || p1Pos < 0 || p1Pos > 9)
                {
                    if(p1Pos < 0 || p1Pos > 9)
                    {
                        System.out.println("Invalid number. Please enter a new number between 1 and 9");
                        p1Pos = scanner.nextInt();
                    }
                    else
                    {
                        System.out.println("Position already taken. Enter a number such that the position which you enter is empty.");
                        p1Pos = scanner.nextInt();
                    }
                }
                p1Positions.add(p1Pos);
                g.placePiece(p1Pos, 'X');
            }
            else
            {
                System.out.println("It is " + p2 + "'s turn. " + p2 + ", please enter a number between 1 to 9 to position your symbol.");
                g.printBoard();
                int p2Pos = scanner.nextInt();
                while(p1Positions.contains(p2Pos) || p2Positions.contains(p2Pos) || p2Pos < 0 || p2Pos > 9)
                {
                    if(p2Pos < 0 || p2Pos > 9)
                    {
                        System.out.println("Invalid number. Please enter a new number between 1 and 9");
                        p2Pos = scanner.nextInt();
                    }
                    else
                    {
                        System.out.println("Position already taken. Enter a number such that the position which you enter is empty.");
                        p2Pos = scanner.nextInt();
                    }
                }
                p2Positions.add(p2Pos);
                g.placePiece(p2Pos, 'O');
            }

            clrscr();
            result = g.checkWinner(p1Positions, p2Positions);
        }

        if(result == 10)
        {
            System.out.println("Congrats " + p1 + ". You win!");
        }
        else if(result == 20)
        {
            System.out.println("Congrats " + p2 + ". You win!");
        }
        else
        {
            System.out.println("It's a tie between " + p1 + " and " + p2);
        }
    }
    public static void clrscr()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
