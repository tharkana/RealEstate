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
 * @author Dilina Namal
 */
package housePackage;

public interface Listable {

	public abstract int compareTo(Listable other);

	public abstract Listable copy();

}
