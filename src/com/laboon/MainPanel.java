package com.laboon;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * The Main Panel of the program.
 * Along with the Button Panel, the entire main GUI frame.
 */

public class MainPanel extends JPanel {

    // The text area for the program itself and its scrollpane
    public JTextArea _ta = new JTextArea(1, 40);
    public JScrollPane _taSp = new JScrollPane(_ta);

    // The text area for the stack display and its scrollpane
    public JTextArea _stack = new JTextArea(1, 40);
    public JScrollPane _stackSp = new JScrollPane(_stack);

    // The text are
    public JTextArea _output = new JTextArea(10, 40);
    public JScrollPane _outputSp = new JScrollPane(_output);

    // Label for "Stack"
    public JLabel _stackLabel = new JLabel();

    // Label for "Output"
    public JLabel _outputLabel = new JLabel();

    // Middle panel of main panel (contains stack label,
    // stack text, and output label
    // This is kind of ugly, but helps us avoid using a GridBagLayout
    public JPanel _midPanel = new JPanel();


    /**
     * Get an integer from the user.
     * If the integer is unparseable in ANY way (e.g., nothing entered,
     * "poodle", "4.3"), return 0.  Otherwise, return the entered value.
     */
    
    public int getIntFromUser() {
	String inp = JOptionPane.showInputDialog("Enter an integer (if unparseable, counts as 0)");
	int toReturn = 0;
	try {
	    toReturn = Integer.parseInt(inp);
	} catch (NumberFormatException nfex) {
	    toReturn = 0;
	}
	return toReturn;
    }

    /**
     * Get a character from the user.
     * If more than one char is entered, accept the first.
     * If no character is entered, assume the null character (ASCII 0).
     */
    
    public int getCharFromUser() {
	String inp = JOptionPane.showInputDialog("Enter a single char "
							+ "(if > 1, will use first; if none, null (0) char)");
	int toReturn = 0;
	try {
	    toReturn = (int) inp.charAt(0);
	} catch (NumberFormatException nfex) {
	    toReturn = 0;
	}
	return toReturn;
	    
    }

    /**
     * Get text from the program text area, return it as a String
     * @return String the text in the text area
     */
    
    public String convertTextAreaToString() {

	String text = _ta.getText();
	return text;
    }
    
    /**
     * Run until complete
     */
    
    public void run() {
	// Clear non-program text
	_stack.setText("");
	_output.setText("");
	ProgramStack ps = new ProgramStack();
	ProgramArea pa = new ProgramArea(convertTextAreaToString());
	// System.out.println(pa.toString());
	long start = System.nanoTime();
	ProgramExecutor pe = new ProgramExecutor(this, ps, pa);
	pe.run();
	long end = System.nanoTime();
	long time = (end - start) / 1000000;
	JOptionPane.showMessageDialog(this, "Time to execute: " + time + " milliseconds");
    }


    /**
     * Print character to the output text area
     * @param c Character to print
     */

    public void print(char c) {
	String newText = _output.getText() + String.valueOf(c);
	_output.setText(newText);
    }

    /**
     * Print integer to the output text area
     * @param i int to print
     */

    
    public void printInt(int i) {
	String newText = _output.getText() + i;
	_output.setText(newText);

    }

    /**
     * Change the display of the stack text area.
     * Note that there is nothing preventing you from any other
     * string!  This is to allow us maximum flexibility if we 
     * change the display later (which is likely).
     * @param stackStr String to display
     */
    
    public void setStack(String stackStr) {
	_stack.setText(stackStr);
    }

    /**
     * Refresh the text areas
     * @param ta = should refresh text area if true
     * @param stack = should refresh stack area if true
     * @param output = should refresh output area if true
     */
    
    public void refresh(boolean ta,
			boolean stack,
			boolean output) {
	if (ta) {
	    _ta.update(_ta.getGraphics());
	}
	if (stack) {
	    _stack.update(_stack.getGraphics());
	}
	if (output) {
	    _output.update(_output.getGraphics());
	}

    }

    /**
     * Constructor for the MainPanel
     */
    
    public MainPanel() {
	super();

	Font f = new Font("monospaced", Font.PLAIN, 12);
	
	_ta.setFont(f);
	_ta.setBorder(BorderFactory.createLineBorder(Color.black));
	
	_stack.setFont(f);
	_stack.setEditable(false);
	_stack.setLineWrap(true);
	_stack.setBorder(BorderFactory.createLineBorder(Color.black));
	
	_output.setFont(f);
	_output.setEditable(false);
	_output.setBorder(BorderFactory.createLineBorder(Color.black));

	_midPanel.setLayout(new GridLayout(3, 1));
	_midPanel.add(new JLabel("Stack:"));
	_midPanel.add(_stackSp);	
	_midPanel.add(new JLabel("Output:"));
	
	this.setLayout(new GridLayout(3, 1));

	this.add(_taSp);
	this.add(_midPanel);
	this.add(_outputSp);
	    
	
	_ta.setVisible(true);
	_stack.setVisible(true);
	_output.setVisible(true);
    }
	
}
