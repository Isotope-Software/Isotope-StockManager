package com.alestrio.isotope.materials;

public interface Material {
	//Screws
	public String getHead();
	
	//Tubes or cylinders / screws
	public float getDiameter();
	
	public int getLength();
	
	public int getRemainingLength();
	
	//Rectangular pieces
	public int getWidth();
	
	public int getRemainingWidth();
	
	public int getThickness();
	
	public int getRemainingThickness();
	
	//3D printers spools
	public String getType();
	
	public float getRemainingWeight();
	
	public float getInitialWeight();
	
	public String getColor();
}
