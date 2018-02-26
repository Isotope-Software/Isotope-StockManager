package com.alestrio.isotope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alestrio.isotope.materials.* ;

public class DB extends Thread{
	
	private String url = "";
	private String user = "";
	private String pswd = "";
	Connection conn;
	
	public DB(String a, String b, String c) {
		url = a;
		user = b;
		pswd = c;
	}
	
	public boolean connect() {
		try {
			conn = DriverManager.getConnection(url, user, pswd);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean getDriverState() {
		try {
			Class.forName("org.postgresql.Driver");
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getConnectionState() {
		boolean b = true;
		try {
			b = conn.isValid(MAX_PRIORITY);
		} catch (SQLException f) {
			f.printStackTrace();
			b = false;
		}
		
		if(b)
			return true;
		else
			return false;
	}
	//-------- SPOOL --------
	public boolean eraseSpool(int id) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM bobines WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean addSpool(FilamentSpool m) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO bobines (type, diameter, initialWeight, remainingWeight, color)"
					+ " VALUES (" + m.getType() + ", " + m.getDiameter() + ", "+ m.getInitialWeight() +", "
					+ m.getRemainingWeight() + ", " + m.getColor());
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
	}
	
	//-------- CYLINDERS --------
	public boolean eraseCylinder(int id) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM cylinders WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean addCylinder(Cylinder c) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO cylindres (diameter, length, color, type)"
					+ " VALUES (" + c.getDiameter() + ", "+ c.getLength() +", "
					+ c.getColor() + ", " + c.getType());
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
	}
	
	//-------- SCREWS --------
	public boolean eraseScrew(int id) {
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM visserie WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean addScrew(Screw s) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO cylindres (diameter, length, head, type)"
					+ " VALUES (" + s.getDiameter() + ", "+ s.getLength() +", " + s.getHead() + ", " + s.getType());
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
	}
	
	//-------- RECTANGULAR PIECES ---------
	public boolean eraseRectangularPiece(int id) { 
		ResultSet b;
		boolean c = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("DELETE FROM rectangles WHERE id="+id);
			c = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean addRectangularPiece(RectangularPiece r) {
		ResultSet b;
		boolean d = true;
		try {
			Statement state = conn.createStatement();
			b = state.executeQuery("INSERT INTO rectangles (length, width, thickness, type, color)"
					+ " VALUES (" + r.getLength() + ", "+ r.getWidth() +", "
					+ r.getThickness() + ", " + r.getType() + ", " + r.getColor());
			d = b.absolute(MAX_PRIORITY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
		
	}

}