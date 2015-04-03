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
 * @author Poorni
 * 
 */

package housePackage;



public class ListHouse implements Listable {
	
	//Variables
	private String lastName;
	private String firstName;
	private int lotNumber;
	private int price;
	private int squareFeet;
	private int bedRooms;

	//Information about houses
	public ListHouse(String lastName, String firstName, int lotNumber,
			int price, int squareFeet, int bedRooms) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.lotNumber = lotNumber;
		this.price = price;
		this.squareFeet = squareFeet;
		this.bedRooms = bedRooms;
	}

	public Listable copy()

	{
		ListHouse result = new ListHouse(lastName, firstName, lotNumber, price,
				squareFeet, bedRooms);
		return result;
	}

	public int compareTo(Listable otherListHouse)

	{
		ListHouse other = (ListHouse) otherListHouse;
		return (this.lotNumber - other.lotNumber);
	}
    
	public String lastName() {
		return lastName;
	}

	public String firstName() {
		return firstName;
	}

	public int lotNumber() {
		return lotNumber;
	}

	public int price() {
		return price;
	}

	public int squareFeet() {
		return squareFeet;
	}

	public int bedRooms() {
		return bedRooms;
	}

}
