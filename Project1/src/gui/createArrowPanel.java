//Author: Tyler Cole
package gui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class createArrowPanel extends JPanel {
	public Color c;
	public boolean plainLine, dashedLine1, dashedLine1Bold, dashedLine2, 
				   dashedLine2Bold, solidArrow, solidArrowBold, solidArrow2, solidArrow2Bold,
				   inherit, aggregate, associate;
	
	public createArrowPanel() {
		
		// sets default line color to black
		c = Color.black;
		
		/* Line Color Block */
		JPanel lineColor = new JPanel();
		
		JLabel lineColorLabel = new JLabel("Line Color:");
		
		JButton editColor = new JButton("");
		editColor.setBackground(Color.black);
		editColor.addActionListener(new ActionListener() {
				
		@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Color newColor = JColorChooser.showDialog(null, "Choose Color", Color.black);
					editColor.setBackground(newColor);
					c = newColor;
				}
			});
		
		lineColor.add(lineColorLabel);
		lineColor.add(editColor);
		/* End of Line Color Block */
		
		
		/* Radio Button Block */
		JPanel radioButtons = new JPanel();
		radioButtons.setLayout(new BoxLayout(radioButtons, BoxLayout.PAGE_AXIS));
		
		plainLine = true;
		
		class RadioListener implements ItemListener {
			public String state;
            public void itemStateChanged(ItemEvent ev) {
                boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
                AbstractButton b1 = (AbstractButton) ev.getItemSelectable();
                String command = b1.getActionCommand();
                if (selected) 
                {
                    state = "selected";
                    
                    if(command.equals("plainLine"))
                    {
                    	plainLine = true;
                    }
                    
                    else if(command.equals("dashedLine1"))
                    {
                    	dashedLine1 = true;
                    }
                    
                    else if(command.equals("dashedLine1Bold"))
                    {
                    	dashedLine1Bold = true;
                    }
                    
                    else if(command.equals("dashedLine2"))
                    {
                    	dashedLine2 = true;
                    }
                    
                    else if(command.equals("dashedLine2Bold"))
                    {
                    	dashedLine2Bold = true;
                    }
                    
                    else if(command.equals("solidArrow"))
                    {
                    	solidArrow = true;
                    }
                    
                    else if(command.equals("solidArrowBold"))
                    {
                    	solidArrowBold = true;
                    }
                    
                    else if(command.equals("solidArrow2"))
                    {
                    	solidArrow2 = true;
                    }
                    
                    else if(command.equals("solidArrow2Bold"))
                    {
                    	solidArrow2Bold = true;
                    }
                    
                    else if(command.equals("inherit"))
                    {
                    	inherit = true;
                    }
                    
                    else if(command.equals("aggregate"))
                    {
                    	aggregate = true;
                    }
                    
                    else if(command.equals("associate"))
                    {
                    	associate = true;
                    }
                } 
                
                else 
                {
                	state = "unselected";
                	
                	if(command.equals("plainLine"))
                    {
                    	plainLine = false;
                    }
                    
                    else if(command.equals("dashedLine1"))
                    {
                    	dashedLine1 = false;
                    }
                    
                    else if(command.equals("dashedLine1Bold"))
                    {
                    	dashedLine1Bold = false;
                    }
                    
                    else if(command.equals("dashedLine2"))
                    {
                    	dashedLine2 = false;
                    }
                    
                    else if(command.equals("dashedLine2Bold"))
                    {
                    	dashedLine2Bold = false;
                    }
                    
                    else if(command.equals("solidArrow"))
                    {
                    	solidArrow = false;
                    }
                    
                    else if(command.equals("solidArrowBold"))
                    {
                    	solidArrowBold = false;
                    }
                    
                    else if(command.equals("solidArrow2"))
                    {
                    	solidArrow2 = false;
                    }
                    
                    else if(command.equals("solidArrow2Bold"))
                    {
                    	solidArrow2Bold = false;
                    }
                	
                    else if(command.equals("inherit"))
                    {
                    	inherit = false;
                    }
                	
                    else if(command.equals("aggregate"))
                    {
                    	aggregate = false;
                    }
                	
                    else if(command.equals("associate"))
                    {
                    	associate = false;
                    }
                }
            }
        }
		
		// instantiate radio item listener
		RadioListener radioListener = new RadioListener();
		
		// Buttons
		JRadioButton inheritanceButton = new JRadioButton("Inheritance");
		inheritanceButton.addItemListener(radioListener);
		inheritanceButton.setActionCommand("inherit");
		
		JRadioButton aggregateButton = new JRadioButton("Aggregation");
		aggregateButton.addItemListener(radioListener);
		aggregateButton.setActionCommand("aggregate");
		
		JRadioButton associateButton = new JRadioButton("Association");
		associateButton.addItemListener(radioListener);
		associateButton.setSelected(true);
		associateButton.setActionCommand("associate");
		
		JRadioButton plainLineButton = new JRadioButton("Plain Line");
		plainLineButton.addItemListener(radioListener);
		plainLineButton.setActionCommand("plainLine");
		
		JRadioButton dashedLine1Button = new JRadioButton("Dashed Line (with 1 arrow)");
		dashedLine1Button.addItemListener(radioListener);
		dashedLine1Button.setActionCommand("dashedLine1");
		
		JRadioButton dashedLine1BoldButton = new JRadioButton("Dashed Line (with 1 arrow, BOLD)");
		dashedLine1BoldButton.addItemListener(radioListener);
		dashedLine1BoldButton.setActionCommand("dashedLine1Bold");
		
		JRadioButton dashedLine2Button = new JRadioButton("Dashed Line (with 2 arrows)");
		dashedLine2Button.addItemListener(radioListener);
		dashedLine2Button.setActionCommand("dashedLine2");
		
		JRadioButton dashedLine2BoldButton = new JRadioButton("Dashed Line (with 2 arrows, BOLD)");
		dashedLine2BoldButton.addItemListener(radioListener);
		dashedLine2BoldButton.setActionCommand("dashedLine2Bold");
		
		JRadioButton solidArrowButton = new JRadioButton("Solid Line (with 1 arrow)");
		solidArrowButton.addItemListener(radioListener);
		solidArrowButton.setActionCommand("solidArrow");
		
		JRadioButton solidArrowBoldButton = new JRadioButton("Solid Line (with 1 arrow, BOLD)");
		solidArrowBoldButton.addItemListener(radioListener);
		solidArrowBoldButton.setActionCommand("solidArrowBold");
		
		JRadioButton solidArrow2Button = new JRadioButton("Solid Line (with 2 arrows)");
		solidArrow2Button.addItemListener(radioListener);
		solidArrow2Button.setActionCommand("solidArrow2");
		
		JRadioButton solidArrow2BoldButton = new JRadioButton("Solid Line (with 2 arrows, BOLD)");
		solidArrow2BoldButton.addItemListener(radioListener);
		solidArrow2BoldButton.setActionCommand("solidArrow2Bold");
		
		// adding buttons to button group
		ButtonGroup radioButtonsGroup = new ButtonGroup();
		radioButtonsGroup.add(inheritanceButton);
		radioButtonsGroup.add(aggregateButton);
		radioButtonsGroup.add(associateButton);
		radioButtonsGroup.add(plainLineButton);
		radioButtonsGroup.add(dashedLine1Button);
		radioButtonsGroup.add(dashedLine1BoldButton);
		radioButtonsGroup.add(dashedLine2Button);
		radioButtonsGroup.add(dashedLine2BoldButton);
		radioButtonsGroup.add(solidArrowButton);
		radioButtonsGroup.add(solidArrowBoldButton);
		radioButtonsGroup.add(solidArrow2Button);
		radioButtonsGroup.add(solidArrow2BoldButton);
		
		// adding buttons to panel
		radioButtons.add(inheritanceButton);
		radioButtons.add(aggregateButton);
		radioButtons.add(associateButton);
		radioButtons.add(new JLabel("   ")); //empty space to format
		radioButtons.add(plainLineButton);
		radioButtons.add(dashedLine1Button);
		radioButtons.add(dashedLine1BoldButton);
		radioButtons.add(dashedLine2Button);
		radioButtons.add(dashedLine2BoldButton);
		radioButtons.add(solidArrowButton);
		radioButtons.add(solidArrowBoldButton);
		radioButtons.add(solidArrow2Button);
		radioButtons.add(solidArrow2BoldButton);
		
		// adding panels to panel
		this.add(lineColor);
		this.add(radioButtons);
	}
}
