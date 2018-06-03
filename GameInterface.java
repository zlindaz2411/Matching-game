package com.company;

import java.awt.*;
import javax.swing.*;

public class GameInterface {
    private JFrame frame;
    private JPanel playPanel, panel;
    private JButton playButton;
    private JLabel label;
    private Container container;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;

    public GameInterface() {
        makeFrame();
    }

    public void makeFrame()
    {
        frame = new JFrame();
        container = frame.getContentPane();


        makePlayPanel();

        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setVisible(true);
    }

    public void makePlayPanel()
    {
        playPanel = new JPanel();
        panel = new JPanel();
        playPanel.setLayout(new BoxLayout(playPanel,BoxLayout.Y_AXIS));

        label = new JLabel("Match all the cards!");
        label.setFont(new Font("Arial", Font.PLAIN, 25));

        playButton = new JButton("PLAY");
        playButton.setFont(new Font("Arial", Font.PLAIN, 40));
        playButton.addActionListener(e-> {play();});

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        playPanel.add(Box.createVerticalStrut(150));
        playPanel.add(label);
        playPanel.add(Box.createVerticalStrut(50));
        playPanel.add(playButton);

        panel.add(playPanel, BorderLayout.CENTER);
        container.add(panel, BorderLayout.CENTER);
    }

    public void play()
    {
        panel.removeAll();
        Game game = new Game();
        game.setSize(new Dimension(WIDTH, HEIGHT));
        panel.add(game, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
        game.requestFocusInWindow();
    }

}

