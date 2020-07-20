package com.example;

import java.io.IOException;
import java.util.*;
import java.lang.ClassNotFoundException;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        clrscr();

        ArrayList<Integer> p1Positions = new ArrayList<>();
        ArrayList<Integer> p2Positions = new ArrayList<>();

        Game g = new Game();
        RulesOfTheGame obj = new RulesOfTheGame();
        obj.printGameRules();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player1's name:");
        String player1 = scanner.nextLine();
        g.setPlayer1(player1);

        System.out.println("Enter player2's name:");
        String player2 = scanner.nextLine();
        g.setPlayer1(player2);


        clrscr();
        int p1Wins = 0;
        int p2Wins = 0;
        int flag = 0;

        for(int x = 1; flag == 0; x++)
        {
            clrscr();
            p1Positions.clear();
            p2Positions.clear();

            System.out.println("Welcome to round " + x);
            System.out.println();
            g.setGameBoard();
            if(x % 2 == 1)
            {
                int result = 0;
                for (int i = 1; result == 0; i++)
                {
                    System.out.println(player1 + " - X");
                    System.out.println(player2 + " - O");
                    System.out.println();
                    System.out.println();

                    if (i % 2 == 1)
                    {
                        System.out.println("It is " + player1 + "'s turn. " + player1 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p1Position = scanner.nextInt();
                        while (p1Positions.contains(p1Position) || p2Positions.contains(p1Position) || p1Position < 0 || p1Position > 9)
                        {
                            if (p1Position < 0 || p1Position > 9)
                            {
                                System.out.println("Invalid number. Please enter a new number between 1 and 9");
                                p1Position = scanner.nextInt();
                            }
                            else
                            {
                                System.out.println("Position already taken. Enter a number such that the position which you enter is empty.");
                                p1Position = scanner.nextInt();
                            }
                        }
                        p1Positions.add(p1Position);
                        g.placePiece(p1Position, 'X');
                    }
                    else
                    {
                        System.out.println("It is " + player2 + "'s turn. " + player2 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p2Position = scanner.nextInt();
                        while (p2Positions.contains(p2Position) || p2Positions.contains(p2Position) || p2Position < 0 || p2Position > 9)
                        {
                            if (p2Position < 0 || p2Position > 9)
                            {
                                System.out.println("Invalid number. Please enter a new number between 1 and 9");
                                p2Position = scanner.nextInt();
                            } else
                            {
                                System.out.println("Position already taken. Enter a number such that the position which you enter is empty.");
                                p2Position = scanner.nextInt();
                            }
                        }
                        p2Positions.add(p2Position);
                        g.placePiece(p2Position, 'O');
                    }

                    clrscr();
                    result = g.checkWinner(p1Positions, p2Positions);
                }

                if(result == 10)
                {
                    System.out.println("Congrats " + player1 + ". You win!");
                    p1Wins++;
                }
                else if(result == 20)
                {
                    System.out.println("Congrats " + player2 + ". You win!");
                    p2Wins++;
                }
                else
                {
                    System.out.println("It's a tie between " + player1 + " and " + player2);
                }
                System.out.println();
                System.out.println("If you want to proceed to the next round, press 0. Else if you wanna start a new game, press 1. If you want to end the game, press 2");
                System.out.println("DO NOT Enter any other number other than 0 or 1 or 2. If you do so, the game will end");
                flag = scanner.nextInt();

                if(flag == 0)
                {
                    continue;
                }
                else if(flag == 2)
                {
                    System.out.println("The Final score:");
                    System.out.println(player1 + " - " + p1Wins + "\n" + player2 + " - " + p2Wins);
                    System.out.println();
                    System.out.println("Thank you for playing this game! :)");
                    System.exit(0);
                }
                //else if(flag == 1)
                else
                {
                    System.out.println("Invalid input. Please enter 0 or 1 or 2.");
                    System.exit(0);
                }

            }
            else
            {
                int result = 0;
                for (int i = 1; result == 0; i++)
                {
                    System.out.println(player1 + " - O");
                    System.out.println(player2 + " - X");
                    System.out.println();
                    System.out.println();

                    if (i % 2 == 0)
                    {
                        System.out.println("It is " + player1 + "'s turn. " + player1 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p1Pos = scanner.nextInt();
                        while (p1Positions.contains(p1Pos) || p2Positions.contains(p1Pos) || p1Pos < 0 || p1Pos > 9)
                        {
                            if (p1Pos < 0 || p1Pos > 9)
                            {
                                System.out.println("Invalid number. Please enter a new number between 1 and 9");
                                p1Pos = scanner.nextInt();
                            } else
                            {
                                System.out.println("Position already taken. Enter a number such that the position which you enter is empty.");
                                p1Pos = scanner.nextInt();
                            }
                        }
                        p1Positions.add(p1Pos);
                        g.placePiece(p1Pos, 'O');
                    }
                    else
                    {
                        System.out.println("It is " + player2 + "'s turn. " + player2 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p2Pos = scanner.nextInt();
                        while (p1Positions.contains(p2Pos) || p2Positions.contains(p2Pos) || p2Pos < 0 || p2Pos > 9)
                        {
                            if (p2Pos < 0 || p2Pos > 9)
                            {
                                System.out.println("Invalid number. Please enter a new number between 1 and 9");
                                p2Pos = scanner.nextInt();
                            } else
                            {
                                System.out.println("Position already taken. Enter a number such that the position which you enter is empty.");
                                p2Pos = scanner.nextInt();
                            }
                        }
                        p2Positions.add(p2Pos);
                        g.placePiece(p2Pos, 'X');
                    }

                    clrscr();
                    result = g.checkWinner(p1Positions, p2Positions);
                }

                if(result == 10)
                {
                    g.printBoard();
                    System.out.println("Congrats " + player1 + ". You win!");
                    p1Wins++;
                }
                else if(result == 20)
                {
                    g.printBoard();
                    System.out.println("Congrats " + player2 + ". You win!");
                    p2Wins++;
                }
                else
                {
                    g.printBoard();
                    System.out.println("It's a tie between " + player1 + " and " + player2);
                }
                System.out.println("The score between" + player1 + " and " + player2 + " is:\n" + player1 + " - " + p1Wins + "\n" + player2 + " - " + p2Wins);
                System.out.println();
                System.out.println("If you want to proceed to the next round, press 0. Else if you wanna start a new game, press 1. If you want to end the game, press 2");
                System.out.println("DO NOT Enter any other number other than 0 or 1 or 2. If you do so, the game will end");
                flag = scanner.nextInt();

                if(flag == 0)
                {
                    continue;
                }
                else if(flag == 2)
                {
                    System.out.println("The Final score:");
                    System.out.println(player1 + " - " + p1Wins + "\n" + player2 + " - " + p2Wins);
                    System.out.println();
                    System.out.println("Thank you for playing this game! :)");
                    System.exit(0);
                }
                //else if(flag == 1)
                else
                {
                    System.out.println("Invalid input. Please enter 0 or 1 or 2.");
                    System.exit(0);
                }

            }
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
