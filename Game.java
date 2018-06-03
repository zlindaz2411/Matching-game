package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel{
    private ArrayList<Card> cards;
    private Random random;
    private Card left, right;
    private boolean hasLeft, hasRight;
    private int numberPressed;

    public Game()
    {
        this.setLayout(new GridLayout(6,6));
        cards = new ArrayList<>();
        random = new Random();
        populate();
        hasLeft = false;

    }

    public void populate()
    {
       String[]animals = {"dog", "cat", "fish", "lion", "bird", "tiger", "rat", "snake",
       "sheep", "pig", "chicken", "horse", "elephant", "cow", "rabbit", "monkey", "duck", "turtle"};

        for(int x = 0; x<6; x++){
            for(int y = 0; y<6; y++){
               Card card = new Card();
                try {
                    Image img = ImageIO.read(getClass().getResource("card.jpg"));
                    Image newimg = img.getScaledInstance(80,100,Image.SCALE_SMOOTH);
                    card.setIcon(new ImageIcon(newimg));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                card.setContent(animals[x]);
                this.add(card);
                cards.add(card);

                card.addActionListener(e-> {play(card);});


        }
        }

    }


    public boolean match()
    {
        if(hasLeft && hasRight)
        {
            if(left.getContent().equals(right.getContent()))
            {
                return true;
            }

        }
        return false;
    }

    public void play(Card a)
    {
        if(numberPressed !=2)
        {
            openCard(a);
        }
        else
        {
            closeCard();
        }
    }
    public void openCard(Card a)
    {

        if(numberPressed!=2) {
            if (!hasLeft) {
                for (Card card : cards) {
                    hasLeft = true;
                    left = a;
                }
                numberPressed++;
                a.setText(a.getContent());
            } else {
                hasRight = true;
                right = a;
                a.setText(a.getContent());
                numberPressed++;
                if (match()) {
                    remove(left);
                    remove(right);
                    numberPressed = 0;
                }

            }
            revalidate();
            repaint();
        }

        if(hasLeft)
        {
            System.out.println(left.getContent());
        }
        if(hasLeft && hasRight)
        {
            System.out.println(left.getContent() + " " + right.getContent());
        }
    }

    public void closeCard()
    {

            left.setText("");
            hasLeft = false;
            right.setText("");
            hasRight = false;
            numberPressed = 0;

    }



}
