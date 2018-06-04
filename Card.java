package com.company;

import javax.swing.*;


public class Card extends JButton{

    private String content;
    private boolean hasContent;


  public Card()
  {
      content = "";
      hasContent = false;
  }


  public String getContent()
  {
      return content;
  }

  public void setContent(String a)
  {

      content = a;
  }
  public boolean getHasContent()
  {
      return hasContent;
  }
  public void setHasContent(boolean a)
  {
      hasContent = a;
  }

}
