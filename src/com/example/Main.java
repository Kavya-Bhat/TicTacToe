package com.example;

import javax.sound.sampled.*;
import javax.sound.sampled.TargetDataLine;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.lang.ClassNotFoundException;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        ClearScreen c = new ClearScreen();
        c.clrscr();

        Scanner scanner = new Scanner(System.in);
        Audio a = new Audio();

        Screen1 s1 = new Screen1();
        a.playAudio("E:\\Others\\UFO_Takeoff-Sonidor-1604321570.wav");
        s1.showScreen1();
        int entry = scanner.nextInt();

        while(entry != 0)
        {
            System.out.println("Please hit 0. Not anything else. Okay, You get another try. This time make sure you hit a 0. :)");
            entry = scanner.nextInt();
        }

        c.clrscr();
        RulesOfTheGame obj = new RulesOfTheGame();
        obj.printGameRules();
        int reference = scanner.nextInt();

        while(reference != 0)
        {
            System.out.println("Please hit 0. Not anything else. Okay, You get another try. This time make sure you hit a 0. :)");
            reference = scanner.nextInt();
        }

        c.clrscr();

        ArrayList<Integer> p1Positions = new ArrayList<>();
        ArrayList<Integer> p2Positions = new ArrayList<>();

        Game g = new Game();

        System.out.println("Enter player1's name:");
        scanner.nextLine();
        String p1 = scanner.nextLine();
        g.setPlayer1(p1);

        System.out.println("Enter player2's name:");
        String p2 = scanner.nextLine();
        g.setPlayer1(p2);

        c.clrscr();

        int p1Wins = 0;
        int p2Wins = 0;
        int flag = 0;

        for(int x = 1;flag == 0;x++)
        {
            c.clrscr();

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
                    System.out.println(p1 + " - X");
                    System.out.println(p2 + " - O");
                    System.out.println();
                    System.out.println();

                    if (i % 2 == 1)
                    {
                        System.out.println("It is " + p1 + "'s turn. " + p1 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p1Pos = scanner.nextInt();
                        a.playAudio("E:\\Others\\Pling-KevanGC-1485374730.wav");
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
                        g.placePiece(p1Pos, 'X');
                    }
                    else
                    {
                        System.out.println("It is " + p2 + "'s turn. " + p2 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p2Pos = scanner.nextInt();
                        a.playAudio("E:\\Others\\Pling-KevanGC-1485374730.wav");
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
                        g.placePiece(p2Pos, 'O');
                    }

                    c.clrscr();
                    result = g.checkWinner(p1Positions, p2Positions);
                }

                if(result == 10)
                {
                    g.printBoard();
                    System.out.println();
                    System.out.println("Congrats " + p1 + ". You win!");
                    p1Wins++;
                }
                else if(result == 20)
                {
                    g.printBoard();
                    System.out.println();
                    System.out.println("Congrats " + p2 + ". You win!");
                    p2Wins++;
                }
                else
                {
                    g.printBoard();
                    System.out.println();
                    System.out.println("It's a tie between " + p1 + " and " + p2);
                }
                System.out.println();
                System.out.println("The score between" + p1 + " and " + p2 + " is:\n" + p1 + " - " + p1Wins + "\n" + p2 + " - " + p2Wins);
                System.out.println("If you want to proceed to the next round, press 0. If you want to end the game, press 2");
                System.out.println("DO NOT Enter any other number other than 0 or 2. If you do so, the game will end");
                flag = scanner.nextInt();

                if(flag == 0)
                {
                    continue;
                }
                else if(flag == 2)
                {
                    a.playAudio("E:\\Others\\descending_craft-Sonidor-991848481.wav");
                    System.out.println("The Final score:");
                    System.out.println(p1 + " - " + p1Wins + "\n" + p2 + " - " + p2Wins);
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
                    System.out.println(p1 + " - O");
                    System.out.println(p2 + " - X");
                    System.out.println();
                    System.out.println();

                    if (i % 2 == 0)
                    {
                        System.out.println("It is " + p1 + "'s turn. " + p1 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p1Pos = scanner.nextInt();
                        a.playAudio("E:\\Others\\Pling-KevanGC-1485374730.wav");
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
                        System.out.println("It is " + p2 + "'s turn. " + p2 + ", please enter a number between 1 to 9 to position your symbol.");
                        System.out.println();
                        g.printBoard();
                        int p2Pos = scanner.nextInt();
                        a.playAudio("E:\\Others\\Pling-KevanGC-1485374730.wav");
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

                    c.clrscr();
                    result = g.checkWinner(p1Positions, p2Positions);
                }

                if(result == 10)
                {
                    g.printBoard();
                    System.out.println();
                    System.out.println("Congrats " + p1 + ". You win!");
                    p1Wins++;
                }
                else if(result == 20)
                {
                    g.printBoard();
                    System.out.println();
                    System.out.println("Congrats " + p2 + ". You win!");
                    p2Wins++;
                }
                else
                {
                    g.printBoard();
                    System.out.println();
                    System.out.println("It's a tie between " + p1 + " and " + p2);
                }
                System.out.println("The score between" + p1 + " and " + p2 + " is:\n" + p1 + " - " + p1Wins + "\n" + p2 + " - " + p2Wins);
                System.out.println();
                System.out.println("If you want to proceed to the next round, press 0. If you want to end the game, press 2");
                System.out.println("DO NOT Enter any other number other than 0 or 2. If you do so, the game will end");
                flag = scanner.nextInt();

                if(flag == 0)
                {
                    continue;
                }
                else if(flag == 2)
                {
                    a.playAudio("E:\\Others\\descending_craft-Sonidor-991848481.wav");
                    System.out.println("The Final score:");
                    System.out.println(p1 + " - " + p1Wins + "\n" + p2 + " - " + p2Wins);
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
}
