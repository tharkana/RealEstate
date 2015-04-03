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
 * @author Tharkana
 */

package housePackage;

import java.io.*;

public class HouseFile {

	private static BufferedReader inFile;
	private static PrintWriter outFile;
	private static boolean inFileOpen = false;
	private static boolean outFileOpen = false;
	private static String nextLine = "";

	// private FileOutputStream fout = null;
	// private ObjectOutputStream oos = null;
	// private FileInputStream fin = null;
	// private ObjectInputStream ois = null;
	// private static boolean foutOpen = false;
	// private static boolean finOpen = false;
	//
	//
	// /**
	// * write to the file
	// * @param houseList
	// */
	// public void writeToFile(Listable houseList[]) {
	//
	// try {
	//
	// fout = new FileOutputStream("./tk.ser");
	// oos = new ObjectOutputStream(fout);
	// oos.writeObject(houseList);
	//
	// } catch (IOException ex) {
	// Logger.getLogger(HouseFile.class.getName()).log(Level.SEVERE, null, ex);
	// } finally {
	// try {
	// fout.close();
	// } catch (IOException ex) {
	// Logger.getLogger(HouseFile.class.getName()).log(Level.SEVERE, null, ex);
	// }
	// }
	//
	// }
	//
	// /**
	// * read file and put the data to a List
	// * @return
	// */
	// public Listable[] readFile(Listable houseList[]) {
	//
	// try {
	//
	// if (finOpen) {
	// writeToFile(houseList);
	// fin.close();
	// }
	// fin = new FileInputStream("./tk.ser");
	// ois = new ObjectInputStream(fin);
	// houseList = (Listable[]) ois.readObject();
	//
	// } catch (IOException ex) {
	// Logger.getLogger(HouseFile.class.getName()).log(Level.SEVERE, null, ex);
	// } catch (ClassNotFoundException ex) {
	// Logger.getLogger(HouseFile.class.getName()).log(Level.SEVERE, null, ex);
	// } finally {
	// try {
	// fout.close();
	// } catch (IOException ex) {
	// Logger.getLogger(HouseFile.class.getName()).log(Level.SEVERE, null, ex);
	// }
	// }
	//
	// return houseList;
	//
	// }

	public static void reset() throws IOException {

		if (inFileOpen)
			inFile.close();
		if (outFileOpen)
			outFile.close();
		inFile = new BufferedReader(new FileReader("houses.dat"));
		inFileOpen = true;
		nextLine = inFile.readLine();
	}

	public static void rewrite() throws IOException {
		if (inFileOpen)
			inFile.close();
		if (outFileOpen)
			outFile.close();
		outFile = new PrintWriter(new FileWriter("houses.dat"));
		outFileOpen = true;
	}

	public static boolean moreHouses() {
		if (!inFileOpen || (nextLine == null))
			return false;
		else
			return true;
	}

	public static ListHouse getNextHouse() throws IOException {
		String lastName = "xxxxx";
		String firstName = "xxxxx";
		int lotNumber = 0;
		int price = 0;
		int squareFeet = 0;
		int bedRooms = 0;
		lastName = nextLine;
		firstName = inFile.readLine();
		lotNumber = Integer.parseInt(inFile.readLine());
		price = Integer.parseInt(inFile.readLine());
		squareFeet = Integer.parseInt(inFile.readLine());
		bedRooms = Integer.parseInt(inFile.readLine());
		nextLine = inFile.readLine();
		ListHouse house = new ListHouse(lastName, firstName, lotNumber, price,
				squareFeet, bedRooms);
		return house;
	}

	public static void putToFile(ListHouse house) throws IOException {
		outFile.println(house.lastName());
		outFile.println(house.firstName());
		outFile.println(house.lotNumber());
		outFile.println(house.price());
		outFile.println(house.squareFeet());
		outFile.println(house.bedRooms());
	}

	public static void close() throws IOException {
		if (inFileOpen)
			inFile.close();
		if (outFileOpen)
			outFile.close();
		inFileOpen = false;
		outFileOpen = false;
	}

	public static void main(String[] args) {

	}

}
