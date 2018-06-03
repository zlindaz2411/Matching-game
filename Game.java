package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel{
    private Card [][] cards;
    private Random random;
    private int numberPressed;

    public Game()
    {
        this.setLayout(new GridLayout(6,6));
        cards = new Card[6][6];
        random = new Random();
        numberPressed =0;
        populate();

    }

    public void populate()
    {


        for(int x = 0; x<6; x++){
            for(int y = 0; y<6; y++){
               cards[x][y] = new Card();
                try {
                    Image img = ImageIO.read(getClass().getResource("card.jpg"));
                    Image newimg = img.getScaledInstance(90,110,Image.SCALE_SMOOTH);
                    cards[x][y].setIcon(new ImageIcon(newimg));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            this.add(cards[x][y]);
        }
        }

    }



}
