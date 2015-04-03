/*******************************************************************************
 * Copyright (C) 2015 Team FantasticFive
 * 
 * This file is part of Project RealEstate.
 * 
 * Project RealEstate can not be copied and/or distributed without the express
 * permission of Team FantasticFive
 *******************************************************************************/

 package housePackage;

/**
 *
 * @author Sahitha Nelanga
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

public class RealEstate {

	private static SortedList list = new SortedList();
	
	private static JTextField lotText; 
	private static JTextField firstText; 
	private static JTextField lastText; 
	private static JTextField priceText; 
	private static JTextField ftText; 
	private static JTextField bedText; 
	
	private static JLabel statLabel; 
	

	private static void showHouse(ListHouse house) {
		lotText.setText(Integer.toString(house.lotNumber()));
		firstText.setText(house.firstName());
		lastText.setText(house.lastName());
		priceText.setText(Integer.toString(house.price()));
		ftText.setText(Integer.toString(house.squareFeet()));
		bedText.setText(Integer.toString(house.bedRooms()));
	}

	private static ListHouse getHouse() {
		String lastName;
		String firstName;
		int lotNumber;
		int price;
		int squareFeet;
		int bedRooms;
		lotNumber = Integer.parseInt(lotText.getText());
		firstName = firstText.getText();
		lastName = lastText.getText();
		price = Integer.parseInt(priceText.getText());
		squareFeet = Integer.parseInt(ftText.getText());
		bedRooms = Integer.parseInt(bedText.getText());
		ListHouse house = new ListHouse(lastName, firstName, lotNumber, price,
				squareFeet, bedRooms);
		return house;
	}

	private static void clearHouse() {
		lotText.setText("");
		firstText.setText("");
		lastText.setText("");
		priceText.setText("");
		ftText.setText("");
		bedText.setText("");
	}

	private static class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event)
		
		{
			ListHouse house;
			if (event.getActionCommand().equals("Reset")) { 
															
				list.reset();
				if (list.lengthIs() == 0)
					clearHouse();
				else {
					house = (ListHouse) list.getNextItem();
					showHouse(house);
				}
				statLabel.setText("List reset");
			} else if (event.getActionCommand().equals("Next")) { 
																	
																	
				if (list.lengthIs() == 0)
					statLabel.setText("list is empty!");
				else {
					house = (ListHouse) list.getNextItem();
					showHouse(house);
					statLabel.setText("Next house displayed");
				}
			} else if (event.getActionCommand().equals("Add")) { 
																	
				try {
					house = getHouse();
					if (list.isThere(house))
						statLabel.setText("Lot number already in use");
					else {
						list.insert(house);
						statLabel.setText("House added to list");
					}
				} catch (NumberFormatException badHouseData) {
					
					statLabel.setText("Number? " + badHouseData.getMessage());
				}
			} else if (event.getActionCommand().equals("Delete")) { 
																	
																	
				try {
					house = getHouse();
					if (list.isThere(house)) {
						list.delete(house);
						statLabel.setText("House deleted");
					} else
						statLabel.setText("Lot number not on list");
				} catch (NumberFormatException badHouseData) {
					
					statLabel.setText("Number? " + badHouseData.getMessage());
				}
			} else if (event.getActionCommand().equals("Clear")) { 
																	
																	
				clearHouse();
				statLabel.setText(list.lengthIs() + " houses on list");
			} else if (event.getActionCommand().equals("Find")) { 
																	
																	
				int lotNumber;
				try {
					lotNumber = Integer.parseInt(lotText.getText());
					house = new ListHouse("", "", lotNumber, 0, 0, 0);
					if (list.isThere(house)) {
						house = (ListHouse) list.retrieve(house);
						showHouse(house);
						statLabel.setText("House found");
					} else
						statLabel.setText("House not found");
				} catch (NumberFormatException badHouseData) {
					
					statLabel.setText("Number? " + badHouseData.getMessage());
				}
			}
		}
	}

	public static void main(String args[]) throws IOException {
		ListHouse house;
		char command;
		int length;
		JLabel blankLabel; 
		JLabel lotLabel; 
		JLabel firstLabel;
		JLabel lastLabel;
		JLabel priceLabel;
		JLabel feetLabel;
		JLabel bedLabel;
		JButton reset; 
		JButton next; 
		JButton add; 
		JButton delete; 
		JButton clear; 
		JButton find; 
		ActionHandler action; 
		
		JFrame displayFrame = new JFrame();
		displayFrame.setTitle("Real Estate Program");
		displayFrame.setSize(350, 400);
		displayFrame.addWindowListener(new WindowAdapter() 
				
				{
					public void windowClosing(WindowEvent event) {
						ListHouse house;
						displayFrame.dispose(); 
						try {
							// Save data from list file to house file
							HouseFile.rewrite();
							list.reset();
							int length = list.lengthIs();
							for (int counter = 1; counter <= length; counter++) {
								house = (ListHouse) list.getNextItem();
								HouseFile.putToFile(house);
							}
							HouseFile.close();
						} catch (IOException fileCloseProblem) {
							System.out
									.println("Exception raised concerning the house info file "
											+ "upon program termination");
						}
						System.exit(0); // Quit program
					}
				});
				
		// Instantiate content pane and information panel
		
		Container contentPane = displayFrame.getContentPane();
		JPanel infoPanel = new JPanel();
		
		// Instantiate/initialize labels, and text fields
		
		statLabel = new JLabel("", JLabel.CENTER);
		statLabel.setBorder(new LineBorder(Color.red));
		blankLabel = new JLabel("");
		lotLabel = new JLabel("Lot Number: ", JLabel.RIGHT);
		lotText = new JTextField("", 15);
		firstLabel = new JLabel("First Name: ", JLabel.RIGHT);
		firstText = new JTextField("", 15);
		lastLabel = new JLabel("Last Name: ", JLabel.RIGHT);
		lastText = new JTextField("", 15);
		priceLabel = new JLabel("Price: ", JLabel.RIGHT);
		priceText = new JTextField("", 15);
		feetLabel = new JLabel("Square Feet: ", JLabel.RIGHT);
		ftText = new JTextField("", 15);
		bedLabel = new JLabel("Number of Bedrooms: ", JLabel.RIGHT);
		bedText = new JTextField("", 15);
		
		// Instantiate/register buttons
		
		reset = new JButton("Reset");
		next = new JButton("Next");
		add = new JButton("Add");
		delete = new JButton("Delete");
		clear = new JButton("Clear");
		find = new JButton("Find");
		
		// Instantiate/register button listeners
		
		action = new ActionHandler();
		reset.addActionListener(action);
		next.addActionListener(action);
		add.addActionListener(action);
		delete.addActionListener(action);
		clear.addActionListener(action);
		find.addActionListener(action);
		
		// Load data from house file to list
		
		HouseFile.reset();
		while (HouseFile.moreHouses()) {
			house = HouseFile.getNextHouse();
			list.insert(house);
		}
		
		// If possible, insert data about first house into text fields
		
		list.reset();
		if (list.lengthIs() != 0) {
			house = (ListHouse) list.getNextItem();
			showHouse(house);
		}
		
		// Update status
		
		statLabel.setText(list.lengthIs() + " houses on list ");
		
		// Add components to frame
		
		infoPanel.setLayout(new GridLayout(10, 2));
		infoPanel.add(statLabel);
		infoPanel.add(blankLabel);
		infoPanel.add(lotLabel);
		infoPanel.add(lotText);
		infoPanel.add(firstLabel);
		infoPanel.add(firstText);
		infoPanel.add(lastLabel);
		infoPanel.add(lastText);
		infoPanel.add(priceLabel);
		infoPanel.add(priceText);
		infoPanel.add(feetLabel);
		infoPanel.add(ftText);
		infoPanel.add(bedLabel);
		infoPanel.add(bedText);
		infoPanel.add(reset);
		infoPanel.add(next);
		infoPanel.add(add);
		infoPanel.add(delete);
		infoPanel.add(clear);
		infoPanel.add(find);
		
		// Setup and showframe
		
		contentPane.add(infoPanel);
		displayFrame.show();
	}
}
