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
 */

package listPackage;

import testPackage.List;

public class SortedList 
{

	int numOfElem;
	int compareResult;
	int middlePoint;
	int firstElem = 0;
	int lastElem = numOfElem - 1;
	int[] list = new int[50];
	
	public boolean isThere (List element)
	//If element's key is equals to the item's key, returns True else returns false

	{
		
	boolean moveToNextElem = (firstElem <= lastElem);
	boolean found = false;
	while (moveToNextElem && !found)
	{
		
	middlePoint = (firstElem + lastElem) / 2;
	compareResult = element.compareTo(list[middlePoint]);
	if (compareResult == 0)
	found = true;
	else if (compareResult < 0) 
	{
	lastElem = middlePoint - 1;
	moveToNextElem = (firstElem <= lastElem);
	}
	else 
	{
		firstElem = middlePoint + 1;
	moveToNextElem = (firstElem <= lastElem);
	}
	}
	return found;
	}
	
	public List retrieve (List element)
	// Returns a copy of the list element with the same key as item
	
	{
		
	int middlePoint = (firstElem + lastElem) / 2;
	boolean found = false;
	while (!found)
	{
	middlePoint = (firstElem + lastElem) / 2;
	compareResult = element.compareTo(list[middlePoint]);
	if (compareResult == 0)
	found = true;
	else if (compareResult < 0) 
	lastElem = middlePoint - 1;
	else 
		firstElem = middlePoint + 1;
	}
	return list[middlePoint].copy();
	}
	
	public void insert (List element)
	//Insert a copy of item to this list
	{
	int location = 0;
	boolean moveToNextElem = (location < numOfElem);
	while (moveToNextElem)
	{
	if (element.compareTo(list[location]) < 0) 
	moveToNextElem = false;
	else 
	{
	location++;
	moveToNextElem = (location < numOfElem);
	}
	}
	for (int index = numOfElem; index > location; index--)
	list[index] = list[index - 1];
	list[location] = element.copy();
	numOfElem++;
	}
	
	public void delete (List element)
	//Deletes the element that equals item from this list
	{
	int location = 0;
	while (element.compareTo(list[location]) != 0)
	location++;
	for (int index = location + 1; index < numOfElem; index++)
	list[index - 1] = list[index];
	numOfElem--;
	}
	
}

