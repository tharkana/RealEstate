/*******************************************************************************
 * Copyright (C) 2015 Team FantasticFive
 * 
 * This file is part of Project RealEstate.
 * 
 * Project RealEstate can not be copied and/or distributed without the express
 * permission of Team FantasticFive
 *******************************************************************************/

/**
 *
 * @author Kavindu
 */
package housePackage;

import java.io.*;

public class HouseFile {
	private static BufferedReader inFile;
	private static PrintWriter outFile;
	private static boolean inFileOpen = false;
	private static boolean outFileOpen = false;
	private static String inString = "";

	public static void reset() throws IOException// Reset the file(Reading)

	{
		if (inFileOpen)
			inFile.close();
		if (outFileOpen)
			outFile.close();
		inFile = new BufferedReader(new FileReader("src/houseDetails.txt"));
		inFileOpen = true;
		inString = inFile.readLine();
	}

	public static void rewrite() throws IOException // Reset file (writing)
	{
		if (inFileOpen)
			inFile.close();
		if (outFileOpen)
			outFile.close();
		outFile = new PrintWriter(new FileWriter("src/houseDetails.txt"));
		outFileOpen = true;
	}

	public static boolean moreHouses()

	{
		if (!inFileOpen || (inString == null))
			return false;
		else
			return true;
	}

	public static ListHouse getNextHouse() throws IOException

	{
		String lastName = "yyyyy";
		String firstName = "yyyyy";
		int lotNumber = 0;
		int price = 0;
		int squareFeet = 0;
		int bedRooms = 0;
		lastName = inString;
		firstName = inFile.readLine();
		lotNumber = Integer.parseInt(inFile.readLine());
		price = Integer.parseInt(inFile.readLine());
		squareFeet = Integer.parseInt(inFile.readLine());
		bedRooms = Integer.parseInt(inFile.readLine());
		inString = inFile.readLine();
		ListHouse house = new ListHouse(lastName, firstName, lotNumber, price,
				squareFeet, bedRooms);
		return house;
	}

	public static void putToFile(ListHouse house) throws IOException
	// Puts house information into the house info file

	{
		outFile.println(house.lastName());
		outFile.println(house.firstName());
		outFile.println(house.lotNumber());
		outFile.println(house.price());
		outFile.println(house.squareFeet());
		outFile.println(house.bedRooms());
	}

	public static void close() throws IOException
	// Closes house info file
	{
		if (inFileOpen)
			inFile.close();
		if (outFileOpen)
			outFile.close();
		inFileOpen = false;
		outFileOpen = false;
	}

}