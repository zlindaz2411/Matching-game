package com.company;

import javax.swing.*;

public class Card extends JButton{

    private String content;

  public Card()
  {
      content = "";
  }


  public String getContent()
  {
      return content;
  }

  public void setContent(String a )
  {
     content = a;
  }

}
