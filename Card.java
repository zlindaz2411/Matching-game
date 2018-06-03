package com.company;

import javax.swing.*;

public class Card extends JButton{

    private static final int TOTAL_NUMBER = 36;
    private String text;

  public Card()
  {
  }

  public String getText()
  {
      return text;
  }
  public void setText(String a)
  {
      text = a;
  }
  public String setNumber()
  {
      String a = "";
      for(int i =1; i<=TOTAL_NUMBER; i++)
      {
          a = i + "";
      }
      return a;
  }

}
