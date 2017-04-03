package com.laboon;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class MainWindow extends JFrame {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    
    private JFrame _frame = new JFrame("JBefunge");

    private MainPanel _mainPanel;

    private ButtonPanel _buttonPanel;
    

    /**
     * Constructor of MainWindow
     */
    public MainWindow() {

	_frame.setSize(WIDTH, HEIGHT);
	// Close program when window is closed
	_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// Add Main Panel and Button Panel
	
	_mainPanel = new MainPanel();

	_buttonPanel = new ButtonPanel(_mainPanel);
	
	_frame.add(_mainPanel, BorderLayout.NORTH);
	_frame.add(_buttonPanel, BorderLayout.SOUTH);
	
	_frame.setVisible(true);	
    }
    
    
}
