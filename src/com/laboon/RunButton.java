package com.laboon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunButton extends JButton {

    private MainPanel _m;
    
    /**
     * Constructor of RunButton
     * @param m MainPanel that RunButton is in
     */
    public RunButton(MainPanel m) {
	super("Run");
	_m = m;
	addActionListener(new RunButtonListener());
    }

    class RunButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    _m.run();
	}
    }    
    
}
