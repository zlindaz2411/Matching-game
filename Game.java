package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Game extends JPanel{
    private static int TOTAL_NUMBER = 36;
    private static final int ROWS = 6;
    private static final int COLS = 6;

    private ArrayList<Card> cards;
    private Random random;
    private Card left, right;
    private boolean hasLeft, hasRight;
    private int numberPressed;

    public Game()
    {
        this.setLayout(new GridLayout(ROWS,COLS));
        cards = new ArrayList<>();
        random = new Random();
        populate();
        hasLeft = false;

    }

    private void populate()
    {

        for(int x = 0; x<ROWS; x++){
            for(int y = 0; y<COLS; y++){
               Card card = new Card();
               try {
                    Image img = ImageIO.read(getClass().getResource("card.jpg"));
                    Image newimg = img.getScaledInstance(70,90,Image.SCALE_SMOOTH);
                    card.setIcon(new ImageIcon(newimg));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                cards.add(card);
                this.add(card);
                card.addActionListener(e-> {play(card);});
        }
        }
        setCardContent();

    }



    private void setCardContent() {
        String[] animal = {"dog", "cat", "fish", "lion", "bird", "tiger", "rat", "snake",
                "sheep", "pig", "chicken", "horse", "elephant", "cow", "rabbit", "monkey", "duck", "turtle"};

        ArrayList<String> animals = new ArrayList<>(Arrays.asList(animal));
        ArrayList<String>contents = new ArrayList<>();

        int index = random.nextInt(animals.size());

        for (int i = 0; i<cards.size(); i++)
        {

            cards.get(i).setContent(animals.get(index));
            contents.add(cards.get(i).getContent());
            index = random.nextInt(animals.size());

            if (containsDuplicate(contents, contents.get(i))) {

                animals.remove(contents.get(i));
                if(!animals.isEmpty())
                {
                    index = random.nextInt(animals.size());
                }


            }

        }

    }


    private boolean match()
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

    private void play(Card a)
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

    private void openCard(Card a)
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
                if (left !=right) {
                    if(match()){
                        hasLeft = false;
                        replace(right, new JButton());
                        replace(left, new JButton());


                        numberPressed = 0;
                        TOTAL_NUMBER -= 2;
                    }}

            }
        }
        revalidate();
        repaint();

        if(TOTAL_NUMBER == 0)
        {
            JOptionPane.showMessageDialog(null, "You win", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private  void closeCard()
    {
        left.setText("");
        hasLeft = false;
        right.setText("");
        hasRight = false;
        numberPressed = 0;
    }

    private void replace(Component a, Component c)
    {

        int index = getComponentZOrder(a);
        remove(a);
        add(c, index);
    }


    private boolean containsDuplicate(ArrayList<String>list, String a)
    {

        int count = Collections.frequency(list, a);
        if(count == 2){
            return true;

        }
        else
        {
            return false;
        }

    }
}

